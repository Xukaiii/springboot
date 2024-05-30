package com.example.springboot1215.mapper;

import com.example.springboot1215.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
    public Admin login(Admin admin);
}
