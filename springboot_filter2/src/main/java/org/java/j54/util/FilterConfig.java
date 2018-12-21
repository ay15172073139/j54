package org.java.j54.util;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig  {
    @Bean
    public FilterRegistrationBean regFilter(){
        System.out.println("###############");
        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean(new EncodingFilter());
        filterRegistrationBean.addUrlPatterns("/*");
       return filterRegistrationBean;
    }
}
