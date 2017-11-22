package com.bjut.MB.config;

import com.bjut.MB.MbApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author:hanxiao
 * @Description:
 * @Modified By:
 * Created by Administrator on 2017/11/22.
 */
@Configuration
public class MyMvcConfig extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MbApplication.class);
    }
    @Bean
    public ServletRegistrationBean restServlet(){
        //注解扫描上下文
        AnnotationConfigWebApplicationContext applicationContext
                = new AnnotationConfigWebApplicationContext();
        //base package
        applicationContext.scan("com.bjut.MB.controller");
        //通过构造函数指定dispatcherServlet的上下文
        com.zhuozhengsoft.pageoffice.poserver.Server server = new com.zhuozhengsoft.pageoffice.poserver.Server();
        //用ServletRegistrationBean包装servlet
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(server);
        //指定name，如果不指定默认为dispatcherServlet
        registrationBean.setName("poServer");
        //指定urlmapping
        registrationBean.addUrlMappings("/po");
        registrationBean.addUrlMappings("/poServer");
        registrationBean.addUrlMappings("/pageoffice.cab");
        registrationBean.addUrlMappings("/popdf.cab");
        registrationBean.addUrlMappings("/sealsetup.exe");
        registrationBean.addUrlMappings("/posetup.exe");

        registrationBean.addUrlMappings("/poserver.zz");
        registrationBean.addUrlMappings("/pageoffice.js");
        registrationBean.addUrlMappings("/jquery.min.js");
        registrationBean.addUrlMappings("/pobstyle.css");

        return registrationBean;
    }


}
