package com.lyd.controller;

import com.lyd.pojo.JsonDate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author:Lyd
 * @Date 2019/12/19 10:02
 * @Description
 */
@RestController
@PropertySource("classpath:application.properties")
public class FileController {
    @Value("${web.file.path}")
    private  String filePath;

    @RequestMapping("/fileUpdate")
    public JsonDate fileUpdate(@RequestParam("head_img") MultipartFile file, HttpServletRequest request){
        String name=request.getParameter("name");
        System.out.println("用户名："+name);
        System.out.println("热部署测试");
        long l=file.getSize();
        boolean flag=file.isEmpty();
        System.out.println("图片大小："+l+"图片是否为空："+flag);
        //获取文件名
        String filename=file.getOriginalFilename();
        System.out.println("上传的文件名为："+filename);
        // 获取文件的后缀名,比如图片的jpeg,png
        String suffixName = filename.substring(filename.lastIndexOf("."));
        System.out.println("上传的后缀名为：" + suffixName);
        // 文件上传后的路径
        filename = UUID.randomUUID() + suffixName;
        System.out.println("转换后的名称:"+filename);

        File dest = new File(filePath + filename);
        try {
            file.transferTo(dest);
            return new JsonDate("0",filename,"上传成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JsonDate("-1",null,"上传失败");
    }

}
