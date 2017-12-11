package com.bjut.MB.service;

import com.bjut.MB.Utils.PasswordUtils;
import com.bjut.MB.dao.LoginTicketDAO;
import com.bjut.MB.dao.UserDao;
import com.bjut.MB.model.LoginTicket;
import com.bjut.MB.model.User;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Administrator on 2017/12/6.
 */
@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private LoginTicketDAO loginTicketDAO;

    public Map<String,String> reg(String name, String password){
        Map<String,String> map = new HashMap<>();
        if(StringUtils.isBlank(name)){
            map.put("code","1");
            map.put("msg","用户名不能为空!");
            return map;
        }
        if(StringUtils.isBlank(password)){
            map.put("code","1");
            map.put("msg","密码不能为空!");
            return map;
        }
        User user = userDao.selectByName(name);
        if (user != null) {
            map.put("code","1");
            map.put("msg", "用户名已存在");
            return map;
        }
        String salt = UUID.randomUUID().toString().substring(0, 5);
        password = PasswordUtils.MD5(password+salt);
        try {
            userDao.addUser(null,name,password,salt,"游客");
            user = userDao.selectByName(name);
            map.put("code","0");
            String ticket = addLoginTicket(user.getId());
            map.put("ticket", ticket);
        }catch (Exception e){
            logger.error("注册DAO异常" + e.getMessage());
            map.put("code","1");
        }
        return map;
    }

    public Map<String,String> login(String name, String password){
        Map<String,String>  map = new HashMap<>();
        if(StringUtils.isBlank(name)){
            map.put("code","1");
            map.put("msg","用户名不能为空!");
            return map;
        }
        if(StringUtils.isBlank(password)){
            map.put("code","1");
            map.put("msg","密码不能为空!");
            return map;
        }
        User user = userDao.selectByName(name);
        if (user == null) {
            map.put("code","1");
            map.put("msg", "用户名不存在");
            return map;
        }
        if (!PasswordUtils.MD5(password+user.getSalt()).equals(user.getPassword())) {
            map.put("code","1");
            map.put("msg", "密码不正确");
            return map;
        }
        String ticket = addLoginTicket(user.getId());
        map.put("ticket", ticket);
        return map;
    }

    private String addLoginTicket(int userId) {
        LoginTicket ticket = new LoginTicket();
        ticket.setNum(userId);
        Date date = new Date();
        date.setTime(date.getTime() + 1000*3600*24*7);
        ticket.setDate(date);
        ticket.setStatus(0);
        ticket.setTicket(UUID.randomUUID().toString().replaceAll("-", ""));
        loginTicketDAO.addTicket(ticket);
        return ticket.getTicket();
    }

    public void logout(String tikcet){
        loginTicketDAO.updateStatus(tikcet,1);
    }
}
