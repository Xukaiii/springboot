package com.example.springboot1215.bg.service.impl;

import com.example.springboot1215.bg.mapper.UserMapper;
import com.example.springboot1215.bg.service.UserService;
import com.example.springboot1215.bg.pojo.User;
import com.example.springboot1215.utils.MD5Util;
import com.example.springboot1215.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Message reg(User user) {
        String username=user.getUserName();
        int res=userMapper.queryUserByName(username);
        if(res>0){
            return Message.fail(404,"注册失败，你输入的用户名已存在");
        }else{
            // 判断手机号是否存在
            String phone=user.getUserPhone();
            res=userMapper.queryUserByPhone(phone);
            if(res>0){
                return Message.fail(404,"注册失败，你输入的手机号已存在");
            }else{
                try{
                    String old_password=user.getUserPassword();
                    String new_password=MD5Util.getEncryptedPwd(old_password);
                    user.setUserPassword(new_password);
                    user.setUserStatus(0);
                    user.setUserType(0);
                    res=userMapper.reg(user);
                    if(res>0){
                        return Message.success("恭喜你注册成功");
                    }else{
                        return Message.fail(404,"注册失败");
                    }
                }catch (Exception ex){
                    ex.printStackTrace();
                    return Message.fail(404,"注册失败");
                }
            }
        }
    }
}
