package com.example.springboot1215.bg.service.impl;

import com.example.springboot1215.bg.mapper.ProvinceMapper;
import com.example.springboot1215.bg.pojo.Province;
import com.example.springboot1215.bg.service.ProvinceService;
import com.example.springboot1215.utils.Message;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceMapper provinceMapper;
    @Override
    public Message queryAllProvince(int pageNum,int pageSize) {
        //分页显示
        //pageNum:第几页
        //pageSize：显示几个
        PageHelper.startPage(pageNum,pageSize);
        List<Province> provinces = provinceMapper.queryAllProvince();
        PageInfo<Province> pageInfo=new PageInfo<>(provinces);
        return Message.success("查询成功",pageInfo);
    }
}
