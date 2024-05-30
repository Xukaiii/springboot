package com.example.springboot1215.utils;

import lombok.Data;

@Data
public class Message {
    private int code;//状态码
    private String message;//返回信息
    private Object data;//数据

    //成功:查询
    public static Message success(String message,Object data){
        Message res_message=new Message();
        res_message.setCode(200);
        res_message.setMessage(message);
        res_message.setData(data);
        return res_message;
    }

    //成功:删除，修改，添加 等
    public static Message success(String message){
        Message res_message=new Message();
        res_message.setCode(200);
        res_message.setMessage(message);
        return res_message;
    }

    //失败
    public static Message fail(int code,String message){
        Message res_message=new Message();
        res_message.setCode(code);
        res_message.setMessage(message);
        return res_message;
    }

    public static Message fail(String message){
        Message res_message=new Message();
        res_message.setMessage(message);
        return res_message;
    }
}
