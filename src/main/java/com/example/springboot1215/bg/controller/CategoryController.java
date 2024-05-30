package com.example.springboot1215.bg.controller;

import com.example.springboot1215.bg.service.CategoryService;
import com.example.springboot1215.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bg/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @RequestMapping("/queryAll")
    public Message queryAll(){
        return categoryService.queryAll();
    }
}
