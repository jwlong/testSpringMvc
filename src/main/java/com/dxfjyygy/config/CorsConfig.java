package com.dxfjyygy.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Configuration
public class CorsConfig {

    private CorsConfiguration buildConfig() {
        //1.添加CORS配置信息
        List list = new ArrayList();
        list.add("*");
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOriginPatterns(list);
        //放行哪些原始域
       /* config.addAllowedOrigin("*");*/
        //是否发送Cookie信息
        config.setAllowCredentials(true);
        //放行哪些原始域(请求方式)
        config.addAllowedMethod("*");
        //放行哪些原始域(头部信息)
        config.addAllowedHeader("*");
        //暴露哪些头部信息(因为跨域访问默认不能获取全部头部信息)
        config.addExposedHeader("*");
        return config;
    }
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        log.info("跨域设置。。。。");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // 5 对接口配置跨域设置
        source.registerCorsConfiguration("/**", buildConfig());
        //有多个filter时此处设置改CorsFilter的优先执行顺序
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }

}
