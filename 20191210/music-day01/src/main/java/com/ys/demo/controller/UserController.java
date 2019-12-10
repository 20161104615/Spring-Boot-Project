package com.ys.demo.controller;

import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

//@ResponseBody//这个类得所有的方法返回的数据直接写给浏览器（如果是对象转为json数据）
//@Controller
//@RestController = @ResponseBody + @Controller
@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping(value = "/login")
    public void userLogin(@RequestParam("user_email") String user_email,
                          @RequestParam("user_password") String user_password,
                          Map<String, Object> map, HttpSession session,
                          HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        JSONObject jsonObject;
        System.out.println("进入函数userLogin");
        System.out.println("用户邮箱："+user_email+"用户密码："+user_password);
        if (!StringUtils.isEmpty(user_email) && "123".equals(user_password)) {
            //登录成功,防止二次提交表单
            System.out.println("密码正确");
            request.getSession().setAttribute("loginUser", user_email);
            jsonObject = JSONObject.fromObject(map);
            response.getWriter().print(jsonObject);
        } else {
            //登录失败
            System.out.println("密码错误");
            map.put("stat","0");
            jsonObject = JSONObject.fromObject(map);
            response.getWriter().print(jsonObject);
        }
    }

    @PostMapping("/profile")
    public String userProfileShow(){

        return "redirect:/music/profile";
    }
}
