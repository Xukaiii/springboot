package com.example.springboot1215.bg.controller;

import com.example.springboot1215.bg.pojo.Product;
import com.example.springboot1215.bg.service.ProductService;
import com.example.springboot1215.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

@RestController
@RequestMapping("/bg/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping("/delete")
    private Message delete(@RequestBody Product product){
        System.out.println(product);
        return null;
    }
    @RequestMapping("/save")
    private Message addProduct(@RequestBody Product product){
        System.out.println(product);
        return productService.save(product);
    }
    @RequestMapping("/queryAll")
    private Message queryAll(){
        return productService.queryAll();
    }
    @RequestMapping("/upload")
    private String ImageUpload(@RequestParam MultipartFile file, HttpServletRequest request)throws Exception{

        // 综合考虑：两个位置都上传文件
        //2. 指定文件上传的目录(target/classes/xxx)
        //2.1 /D:/softtools/workspace/workspace_idea/springboot_1213_01/target/classes/static/upload/
        //2.2 文件存储到此位置，可以提供页面的访问（当时target中的内容不会打包上传到服务器上）
        String path_target = ClassUtils.getDefaultClassLoader().getResource("static").getPath()+"/upload/";
        //String path_target = "D:/softtools/taoyitao/taoyitao/target/classes/static/upload/";
        //2. 指定文件上传的目录(当前项目的src/main/resources/static/upload 下)
        //2.1 文件存储到此位置，可以保存上传的图片，并打包上传到服务器上（在项目中执行 install 就可以生成target中的所有内容）
        String path = System.getProperty("user.dir")+"/src/main/resources/static/upload";
        //String path = "D:/softtools/taoyitao/taoyitao/src/main/resources/static/upload";
        //3. 判断此目录是否存在
        File fileDir_target = new File(path_target);
        if(!fileDir_target.exists()){
            fileDir_target.mkdirs();
        }
        File fileDir = new File(path);
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }
        //4. 生成新的名字
        String oldName = file.getOriginalFilename();
        String newName = UUID.randomUUID().toString().replaceAll("-","")+oldName.substring(oldName.lastIndexOf("."),oldName.length());
        //5. 指定生成的文件
        File file_target = new File(fileDir_target.getAbsolutePath()+File.separator+newName);
        File file_1 = new File(fileDir.getAbsolutePath()+File.separator+newName);
        //6. 文件的生成
        file.transferTo(file_1);
        FileCopyUtils.copy(file_1,file_target);
        //7. 生成http的访问路径
        String httpPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/"
                + request.getContextPath()+"upload/"+newName;
        //String httpPath = "http://localhost:8080/upload/"+newName;

        System.out.println("path:"+path);
        System.out.println("path_target:"+path_target);
        System.out.println("httpPath:"+httpPath);

        return httpPath;
    }
}
