package com.bjut.MB.config;

import com.bjut.MB.interceptor.LoginInterceptor;
import com.bjut.MB.interceptor.PassportInterceptor;
import com.bjut.MB.interceptor.TaskManageInterceptor;
import com.bjut.MB.interceptor.UserManageInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Administrator on 2017/12/8.
 */
@Component
public class InterceptorConfig extends WebMvcConfigurerAdapter{
    @Autowired
    private PassportInterceptor passportInterceptor;

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Autowired
    private UserManageInterceptor userManageInterceptor;

    @Autowired
    private TaskManageInterceptor taskManageInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(passportInterceptor);
        registry.addInterceptor(loginInterceptor).addPathPatterns("/homepage/*");
        registry.addInterceptor(userManageInterceptor).addPathPatterns("/homepage/staffmanagement");
        registry.addInterceptor(userManageInterceptor).addPathPatterns("/homepage/recordmanagement");
        registry.addInterceptor(taskManageInterceptor).addPathPatterns("/homepage/taskmanagement");
        super.addInterceptors(registry);
    }
}
