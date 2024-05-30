package com.example.springboot1215.bg.service.impl;

import com.example.springboot1215.bg.mapper.CategoryMapper;
import com.example.springboot1215.bg.service.CategoryService;
import com.example.springboot1215.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Message queryAll() {
        return Message.success("查询成功",categoryMapper.queryAll());
    }
}
