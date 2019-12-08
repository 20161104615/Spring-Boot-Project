package com.ys.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import java.util.Map;

//@ResponseBody//这个类得所有的方法返回的数据直接写给浏览器（如果是对象转为json数据）
//@Controller
//@RestController = @ResponseBody + @Controller
@Controller
@RequestMapping("/user")
public class UserController {

    @PostMapping(value = "/login")
    public String userLogin(@RequestParam("user_email") String user_email,
                             @RequestParam("user_password") String user_password,
                             Map<String,Object> map) {
        if(!StringUtils.isEmpty(user_email) && "123".equals(user_password)){
            //登录成功,防止二次提交表单
            return "redirect:/index.html";
        } else{
            //登录失败
            map.put("emsg","用户名或密码错误");
            return "signin.html";
        }
    }
}
