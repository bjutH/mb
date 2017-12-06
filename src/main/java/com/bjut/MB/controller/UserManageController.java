package com.bjut.MB.controller;

import com.bjut.MB.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Cheng on 2017/12/6.
 */
@Controller
public class UserManageController {
    @Autowired
    private UserDao userDao;

    @RequestMapping(path = "/updatepower")
    public String updatePower(@RequestParam(value = "num")String num, @RequestParam(value = "power") String power){
        userDao.updatePower(power, num);
        return "manageUser";
    }
    @RequestMapping(path = "/updatepassword")
    public String updatePassword(@RequestParam(value = "num") String num, @RequestParam(value = "pass") String pass){
        userDao.updatePassword(pass, num);
        return "manageUser";
    }
    @RequestMapping(path = "/deleteuser")
    public String deleteUser(@RequestParam(value = "num") String num){
        userDao.deleteAll(num);
        return "manageUser";
    }

    @RequestMapping(path = "/query")
    public String addUser(@RequestParam(value = "num") String num){
        userDao.selectOne(num);
        return "manageUser";
    }


}
