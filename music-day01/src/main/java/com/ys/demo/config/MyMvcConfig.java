package com.ys.demo.config;

import com.ys.demo.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Bean//将组件注册在容器中
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer adapter = new WebMvcConfigurer() {
          @Override
          public void addViewControllers(ViewControllerRegistry registry){
              registry.addViewController("/index.html").setViewName("index");
              registry.addViewController("/index").setViewName("index");
              registry.addViewController("/signin.html").setViewName("signin");
              registry.addViewController("/signup.html").setViewName("signup");
              registry.addViewController("/modal.lockme.html").setViewName("signin");
          }
        };
        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
