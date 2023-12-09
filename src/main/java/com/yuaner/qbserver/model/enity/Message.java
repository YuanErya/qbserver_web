package com.yuaner.qbserver.model.enity;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 消息包装类
 */
public class Message {
    String to;
    String from;
    String message;

    Date time;

    public Message(String to, String from, String message) {
        this.to = to;
        this.from = from;
        this.message = message;
        this.time=new Date(System.currentTimeMillis());
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }

    public static Message error(String errorMessage) {
        return new Message("error", "error",errorMessage);
    }
}
