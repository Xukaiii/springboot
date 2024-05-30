package com.example.springboot1215.bg.pojo;

import lombok.Data;

@Data
public class User {
    private int id;
    private String userName;
    private String userPassword;
    private String userPhone;
    private int userStatus;
    private int userType;
    private String createTime;
}
