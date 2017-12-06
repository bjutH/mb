package com.bjut.MB.controller;

import com.bjut.MB.service.OrderService;
import com.sun.deploy.net.HttpResponse;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;

/**
 * Created by Administrator on 2017/11/22 0022.
 */

@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(path = {"/index"})
    public String index( ){
        return "login01";
    }

    @RequestMapping(path = {"/login"})
    public String login(@RequestParam("name") String name, @RequestParam("password") String password, @RequestParam(value = "remerberme" ,
                        defaultValue = "0") int remerberme){
        if(StringUtils.isBlank(name)){

        }
        return "homepage";
    }


}
