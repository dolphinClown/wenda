package com.wenda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * @Discription:
 * @Author: yanghao
 * @Date: 2018/3/1
 */
@SpringBootApplication
public class WendaApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(WendaApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(WendaApplication.class, args);
    }
}
