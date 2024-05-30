package com.example.springboot1215.bg.pojo;

import lombok.Data;

@Data
public class Category {
    private int id;
    private String categoryName;
    private String categoryDescription;
    private int categoryParentId;
    private String createTime;
}
