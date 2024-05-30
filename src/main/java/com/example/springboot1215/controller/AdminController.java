package com.example.springboot1215.controller;

import com.example.springboot1215.utils.Message;
import com.example.springboot1215.pojo.Admin;
import com.example.springboot1215.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @RequestMapping("/login")
    public Message login(@RequestBody Admin admin){
        return adminService.login(admin);
    }
}
