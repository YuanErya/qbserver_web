package com.yuaner.qbserver;

import com.yuaner.qbserver.mapper.UserMapper;
import com.yuaner.qbserver.model.enity.SimpleUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.annotation.Resource;


@SpringBootTest

class YuanerCommunityApplicationTests {
    @MockBean
    private ServerEndpointExporter serverEndpointExporter;
    @Resource
    UserMapper userMapper;
    void  addUser(){
        SimpleUser simpleUser = new SimpleUser(null,"43gsd","asf","asfasf",null);
        userMapper.addUser(simpleUser);
    }

}
