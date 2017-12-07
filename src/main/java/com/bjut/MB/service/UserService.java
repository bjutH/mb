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

    public Map<String,String> addUser(String name, String password, String salt, String power){
        Map<String,String> map = new HashMap<>();
        try {
            userDao.addUser(null,name,password,salt,power);
            map.put("code","0");
        }catch (Exception e){
            map.put("code","1");
        }
        return map;
    }

    public Map<String,String> selectUserByName(String name, String password){
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
            map.put("msg", "密码不正确");
            return map;
        }
        String ticket = addLoginTicket(user.getNum());
        map.put("ticket", ticket);
        return map;
    }

    private String addLoginTicket(int userId) {
        LoginTicket ticket = new LoginTicket();
        ticket.setNum(userId);
        Date date = new Date();
        date.setTime(date.getTime() + 1000*3600*24);
        ticket.setDate(date);
        ticket.setStatus(0);
        ticket.setTicket(UUID.randomUUID().toString().replaceAll("-", ""));
        loginTicketDAO.addTicket(ticket);
        return ticket.getTicket();
    }
}
