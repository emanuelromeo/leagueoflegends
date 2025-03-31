package com.develhope.leagueoflegends.config;

import com.develhope.leagueoflegends.filter.RoleFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {


    @Bean
    public FilterRegistrationBean<RoleFilter> getRoleFilter() {

        FilterRegistrationBean<RoleFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new RoleFilter());
        registration.addUrlPatterns("/champions/find-by-role");

        return registration;

    }

}
