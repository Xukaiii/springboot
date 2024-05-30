package com.example.springboot1215.bg.service.impl;

import com.example.springboot1215.bg.mapper.ProductMapper;
import com.example.springboot1215.bg.pojo.Product;
import com.example.springboot1215.bg.service.ProductService;
import com.example.springboot1215.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public Message queryAll() {
        return Message.success("查询成功",productMapper.queryAll());
    }

    @Override
    public Message save(Product product) {
        int res = productMapper.save(product);
        if(res>0){
            return Message.success("保存成功");
        }else{
            return Message.fail("保存失败");
        }
    }
}
