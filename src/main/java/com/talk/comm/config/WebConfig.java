package com.talk.comm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {

    // view에서 사용할 경로
    private String resourcePath = "/upload/**"; 

    //실제 경로
    private String savePath = "file:///C:/development/";

    //정석 리소스 핸들러를 추가하는 메서드
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        //upload/** 경로로 들어오는 모든 요청을 처리하기 위한 리소스 핸들러 등록
        registry.addResourceHandler(resourcePath)
                //실제 이미지를 찾을 경로 설정
                .addResourceLocations(savePath);
    }
}
