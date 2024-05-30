package com.example.springboot1215.bg.mapper;

import com.example.springboot1215.bg.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public int reg(User user);
    public int queryUserByName(String name);
    public int queryUserByPhone(String phone);
}
