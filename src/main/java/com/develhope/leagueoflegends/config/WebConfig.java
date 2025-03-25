package com.develhope.leagueoflegends.config;

import com.develhope.leagueoflegends.filter.LoggingFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {


    @Bean
    public FilterRegistrationBean<LoggingFilter> loggingFilter() {

        FilterRegistrationBean<LoggingFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new LoggingFilter());
        registration.addUrlPatterns("/*");

        return registration;

    }

}
