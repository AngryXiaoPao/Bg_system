package cn.pawn.ratel.web.controller.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName MyWebMvcConfigurer
 * @Description TODO
 * @Author zengyejun
 * @Date 2019-07-17 16:35:32
 **/
@Configuration
//@EnableWebMvc
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/**").addResourceLocations("classpath:/templates/");
    }

    /***
     * @Author zengyejun
     * @Description 页面路由配置
     * @Date 2019-07-18 11:47:51
     * @Param [registry]
     * @return void
     **/
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("").setViewName("login");
        registry.addViewController("/error").setViewName("error/404");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/error/LoginFailed").setViewName("error/LoginFailed");

    }

}
