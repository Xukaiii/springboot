package com.example.springboot1215;

import com.example.springboot1215.utils.MD5Util;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot1215ApplicationTests {

    @Test
    void contextLoads() {
        try {
            String new_password=MD5Util.getEncryptedPwd("123456");
            System.out.println(new_password);
            // 密码是否一致
            Boolean flag=MD5Util.validPassword("123456",new_password);
            System.out.println(flag);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
