package com.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: hokitlee
 * @description:
 * @create: 2018-09-27 13:27
 **/
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new CustomDateConverter());
    }

}
