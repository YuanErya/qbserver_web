package com.yuaner.qbserver.common.utils;

import com.yuaner.qbserver.mapper.UserMapper;
import com.yuaner.qbserver.model.enity.Message;
import com.yuaner.qbserver.model.enity.User;
import com.yuaner.qbserver.websocket.WebSocket;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


public class InstructionHandler {
    private static ConcurrentHashMap<String, WebSocket> webSocketMap;

    private static UserMapper mapper;

    /**
     * 指令处理器的处理方法
     * @param user
     * @param message
     * @return
     */
    public Message toAnswer(String user, String message){
        if(message.contains("/help")){
            return new Message(user,null,"Hi!欢迎光临qb聊天室！\n" +
                    "以下是特殊指令消息：\n" +
                    "/help 获取指令帮助\n" +
                    "/q 离开聊天室\n" +
                    "直接发送消息就是普通的聊天室群聊哦！\n");
        }
        if(message.equals("/q")){
            return  null;
        }
        return new Message(user,null,"无效指令!");
    }

    public InstructionHandler(ConcurrentHashMap<String, WebSocket> webSocketMap,UserMapper mapper) {
        this.webSocketMap = webSocketMap;
        this.mapper=mapper;
    }
}
