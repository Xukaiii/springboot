package com.example.springboot1215.service.impl;

import com.example.springboot1215.mapper.AdminMapper;
import com.example.springboot1215.utils.Message;
import com.example.springboot1215.pojo.Admin;
import com.example.springboot1215.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Message login(Admin admin) {
        Admin login_admin = adminMapper.login(admin);
        if(login_admin==null){
            return Message.fail(400,"登录失败");
        }else{
            return Message.success("登录成功",login_admin);
        }
    }
}
