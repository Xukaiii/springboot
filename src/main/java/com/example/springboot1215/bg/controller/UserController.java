package com.example.springboot1215.bg.controller;

import com.example.springboot1215.bg.mapper.UserMapper;
import com.example.springboot1215.bg.pojo.User;
import com.example.springboot1215.bg.service.UserService;
import com.example.springboot1215.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bg/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/reg")
    private Message reg(@RequestBody User user){
        return userService.reg(user);
    }
}
