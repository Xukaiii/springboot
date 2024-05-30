package com.example.springboot1215.bg.mapper;

import com.example.springboot1215.bg.pojo.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    public List<Product> queryAll();
    public int save(Product product);
}
