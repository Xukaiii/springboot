package com.example.springboot1215.bg.mapper;

import com.example.springboot1215.bg.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CategoryMapper {
    public List<Category> queryAll();
}
