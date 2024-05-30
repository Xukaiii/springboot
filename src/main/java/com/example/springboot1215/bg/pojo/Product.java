package com.example.springboot1215.bg.pojo;

import lombok.Data;

@Data
public class Product {
    private int id;
    private String productName;
    private String productDescription;
    private Double generalPrice;
    private Double superPrice;
    private Double costPrice;
    private int stock;
    private String productPath;
    private int categoryId;
    private String shelvesState;
    private String createTime;
}
