package com.yancy.springboot;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

/**
 * 配置fastjson
 * Created by yancy on 2017/11/7.
 */
@SpringBootApplication
public class FastJsonApp extends WebMvcConfigurerAdapter{

    //第一种方式，重写ConfigurerAdapter，并将FatJsonConverter设置系统中
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        converter.setFeatures(SerializerFeature.PrettyFormat);
        converters.add(converter);
        super.configureMessageConverters(converters);
    }

    //第二种方式：注入
//    @Bean
//    public HttpMessageConverters faMessageConverters(){
//        return new HttpMessageConverters(new FastJsonHttpMessageConverter());
//    }

    public static void main(String[] args){
        SpringApplication.run(App.class, args);
    }
}
