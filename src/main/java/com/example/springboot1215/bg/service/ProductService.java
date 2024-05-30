package com.example.springboot1215.bg.service;


import com.example.springboot1215.bg.pojo.Product;
import com.example.springboot1215.utils.Message;

public interface ProductService {
    public Message queryAll();
    public Message save(Product product);
}
