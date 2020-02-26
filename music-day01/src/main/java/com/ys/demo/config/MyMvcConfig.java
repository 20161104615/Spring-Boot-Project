package com.ys.demo.config;

import com.ys.demo.component.LoginHandlerInterceptor;
import com.ys.demo.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Bean//将组件注册在容器中
    public WebMvcConfigurer webMvcConfigurer() {
        WebMvcConfigurer adapter = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/index.html").setViewName("index");
                registry.addViewController("/index").setViewName("index");
                registry.addViewController("/signin.html").setViewName("signin");
                registry.addViewController("/signup.html").setViewName("signup");
                registry.addViewController("/modal.lockme.html").setViewName("signin");
                registry.addViewController("/profile").setViewName("profile");
                registry.addViewController("/profile.html").setViewName("profile");
                registry.addViewController("/index2.html").setViewName("index2");
                registry.addViewController("/singer.html").setViewName("singer");
                registry.addViewController("/singer_list.html").setViewName("singer_list");
                registry.addViewController("/404.html").setViewName("404");
                registry.addViewController("/listen.html").setViewName("listen");
                registry.addViewController("/OLDlisten.html").setViewName("OLDlisten");
                registry.addViewController("/listendemo02.html").setViewName("listendemo02");
                registry.addViewController("/testMusicPlayer.html").setViewName("testMusicPlayer");
                registry.addViewController("/listen2.html").setViewName("listen2");
                registry.addViewController("/list.html").setViewName("list");
                registry.addViewController("/fileupload.html").setViewName("fileupload");
            }

            //拦截器注册
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/404.html").
                        excludePathPatterns("/","/signin.html",
                                "/user/login",
                                "/modal.lockme.html",
                                "/signup.html",
                                "/genres.html",
                                "/index2.html",
                                "/singer.html",
                                "/singer_list",
                                "/listen.html",
                                "/404.html",
                                "/listendemo02.html",
                                "/testMusicPlayer.html",
                                "/listen2.html",
                                "/list.html",
                                "/fileupload.html",
                                "/OLDlisten.html");
            }
        };
        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }

    /**
     * 资源映射路径
     * addResourceHandler：访问映射路径
     * addResourceLocations：资源绝对路径
     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/asserts/media/**").addResourceLocations("file:D:/PythonProgram/PythonProgram");
//    }

}
