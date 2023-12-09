package com.yuaner.qbserver.interceptor;
import com.yuaner.qbserver.common.utils.UserHolder;
import com.yuaner.qbserver.model.enity.User;
import com.yuaner.qbserver.websocket.WebSocket;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class TokenInterceptor implements HandlerInterceptor {
    private static final PathMatcher pathMatcher = new AntPathMatcher();
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws IOException {
        try {
            if(isProtectedUrl(request)) {
                if(!request.getMethod().equals("OPTIONS")) {
                    String token=request.getHeader("Authorization");
                    User user = WebSocket.getUserByToken(token);
                    if(user!=null)UserHolder.saveUser(user);
                    else{
                        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                        return false;
                    }
                }
            }
            return true;
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        // System.out.println("处理请求完成后视图渲染之前的处理操作");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        // System.out.println("视图渲染之后的操作");
    }

    private boolean isProtectedUrl(HttpServletRequest request) {
        List<String> unProtectedPaths = new ArrayList<String>();
        //向list中添加不需要保护拦截的请求
        unProtectedPaths.add("/api/qbserver/user/register");
        unProtectedPaths.add("/api/qbserver/user/login/password");
        unProtectedPaths.add("/api/qbserver/user/login/code");
        unProtectedPaths.add("/qbserver/api/sentEmailCode");
        boolean bFind = true;
        for( String passedPath : unProtectedPaths ) {
            bFind = !pathMatcher.match(passedPath, request.getServletPath());
            if( !bFind ) {
                break;
            }
        }
        return bFind;
    }
}
