package com.example.springboot1215.bg.mapper;

import com.example.springboot1215.bg.pojo.Province;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ProvinceMapper {
    public List<Province> queryAllProvince();
}
