package com.bjut.MB.interceptor;

import com.bjut.MB.dao.LoginTicketDAO;
import com.bjut.MB.dao.UserDao;
import com.bjut.MB.model.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/12/8.
 */
@Component
public class LoginInterceptor implements HandlerInterceptor{

    @Autowired
    private LoginTicketDAO loginTicketDAO;

    @Autowired
    private UserDao userDao;

    @Autowired
    private HostHolder hostHolder;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        if(hostHolder.getUser() ==null){
            httpServletResponse.sendRedirect("/index");
            return false;
        }
        if(httpServletRequest.getSession().getAttribute("orderType") ==null){
            httpServletRequest.getSession().setAttribute("orderType","请选择随工单类型");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
