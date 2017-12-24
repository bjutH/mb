package com.bjut.MB.controller;

import com.bjut.MB.dao.UserDao;
import com.bjut.MB.model.*;
import com.bjut.MB.service.*;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Cheng on 2017/12/6.
 */
@Controller
public class UserManageController {
    private static final Logger logger = LoggerFactory.getLogger(UserManageController.class);

    @Autowired
    private UserDao userDao;

    @RequestMapping(path = "/homepage/staffmanagement")
    public String index(){
        return "staffmanagement";
    }

    @RequestMapping(path = "/homepage/staffmanagement/updatepower")
    public String updatePower(@RequestParam(value = "name")String name, @RequestParam(value = "power") String power){
        userDao.updatePower(power, name);
        return "redirect:/homepage/staffmanagement";
    }
    @RequestMapping(path = "/homepage/staffmanagement/updatepassword")
    public String updatePassword(@RequestParam(value = "name") String name, @RequestParam(value = "pass") String pass){
        userDao.updatePassword(pass, name);
        return "redirect:/homepage/staffmanagement";
    }
    @RequestMapping(path = "/homepage/staffmanagement/deleteuser")
    public String deleteUser(@RequestParam(value = "name") String name){
        userDao.deleteAll(name);
        return "redirect:/homepage/staffmanagement";
    }

    @RequestMapping(path = "/homepage/staffmanagement/query")
    public String selectUser(@RequestParam(value = "num") String num){
        userDao.selectOne(num);
        return "redirect:/homepage/staffmanagement";
    }

    @RequestMapping(path = "/homepage/staffmanagement/queryall")
    @ResponseBody
    public List<User> selectUser(){
        List<User> list= userDao.selectAll();
        return list;
    }

    @RequestMapping(path = "/homepage/staffmanagement/add")
    public String addUser(@RequestParam(value = "num") String num, @RequestParam(value = "name") String name, @RequestParam(value = "password") String password, @RequestParam(value = "salt") String salt, @RequestParam(value = "power") String power){
        userDao.addUser(num, name, password, salt, power);
        return "redirect:/homepage/staffmanagement";
    }



}
