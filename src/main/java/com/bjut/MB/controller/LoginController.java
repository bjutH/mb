package com.bjut.MB.controller;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/22 0022.
 */

@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(path = {"/"})
    public String index( ){
        return "login01";
    }

    @RequestMapping(path = {"/login"})
    public String login(@RequestParam("name") String name, @RequestParam("password") String password, @RequestParam(value = "remerberme" ,
                        defaultValue = "0") int remerberme, HttpSession session, ModelMap model){
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

        session.setAttribute("name",name);
        session.setAttribute("orderType","选择表类型");
        return "homepage";
    }


}
