package com.bjut.MB.controller;


import com.bjut.MB.Utils.PasswordUtils;
import com.bjut.MB.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Administrator on 2017/11/22 0022.
 */

@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(path = {"/"})
    public String index( ){
        return "login01";
    }

    @RequestMapping(path = {"/login"})
    public String login(@RequestParam("name") String name, @RequestParam("password") String password, @RequestParam(value = "remerberme" ,
                        defaultValue = "0") int remerberme, HttpSession session, ModelMap model) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Map<String,String> map = new HashMap<>();
        if(StringUtils.isBlank(name)){
            map.put("code","1");
            map.put("msg","用户名不能为空!");
            model.addAttribute(map);
            return "login01";
        }
        if(StringUtils.isBlank(password)){
            map.put("code","1");
            map.put("msg","密码不能为空!");
            model.addAttribute(map);
            return "login01";
        }
        try {

            map.put("code","0");
        }catch (Exception e){
            map.put("code","1");
            model.addAttribute(map);
            return "login01";
        }
        session.setAttribute("name",name);
        session.setAttribute("orderType","选择表类型");
        return "homepage";
    }


}
