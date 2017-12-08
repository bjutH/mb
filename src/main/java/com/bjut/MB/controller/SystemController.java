package com.bjut.MB.controller;

import com.bjut.MB.model.HostHolder;
import com.bjut.MB.service.SystemService;
import com.bjut.MB.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2017/12/8.
 */
@Controller
public class SystemController {
    private static final Logger logger = LoggerFactory.getLogger(SystemController.class);

    @Autowired
    private SystemService systemService;

    @Autowired
    private HostHolder hostHolder;

    @Autowired
    private UserService userService;

    @RequestMapping(path = {"/systemmanagement"})
    public String index( ){
        return "systemmanagement";
    }

    @RequestMapping(path = {"/updatepassword"})
    public String updatePassword(@RequestParam("oldPassword") String oldPassword, @RequestParam("newpassword") String newPassword,
                                 ModelMap modelMap){
        systemService.UpdatePassword(hostHolder.getUser().getName(),oldPassword,newPassword);
        return "systemmanagement";
    }

    @RequestMapping(path = {"/logout"})
    public String logout(@CookieValue("ticket") String ticket){
        userService.logout(ticket);
        return "login01";
    }
}
