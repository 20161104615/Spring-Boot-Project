package com.ys.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody//这个类得所有的方法返回的数据直接写给浏览器（如果是对象转为json数据）
//@Controller
//@RestController = @ResponseBody + @Controller
@RestController
public class HelloController {


    @RequestMapping("/hello")
    public String hello (){
        return "hello world quick!";
    }
}
