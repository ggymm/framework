package com.cloud.framework.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author gongym
 * @version 创建时间: 2021-11-02 23:13
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 设置默认返回值类型
     *
     * @param configurer 配置项
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.APPLICATION_JSON);
    }
}
