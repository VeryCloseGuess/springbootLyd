package com.lyd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author:Lyd
 * @Date 2019/12/18 9:31
 * @Description
 */
@Controller
public class MyController2 {
    @RequestMapping(value="/ape/v1/test")
    public Object test(){
        return "index";
    }
    @RequestMapping(value="/fileH5")
    public Object fileUpdate(){
        return "fileUpdate";
    }
}
