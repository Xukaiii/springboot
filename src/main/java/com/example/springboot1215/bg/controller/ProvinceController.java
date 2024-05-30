package com.example.springboot1215.bg.controller;

import com.example.springboot1215.bg.service.ProvinceService;
import com.example.springboot1215.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bg/province")
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;
    @RequestMapping("/queryAllProvince")
    private Message queryAllProvince(int pageNum,int pageSize){
        return provinceService.queryAllProvince(pageNum,pageSize);
    }
}
