package com.example.springboot1215.pojo;

import lombok.Data;

@Data
public class Admin {
    private int id;
    private String adminName;
    private String adminPassword;
    private String createTime;
}
