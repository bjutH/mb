package com.bjut.MB.controller;

import com.bjut.MB.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/11/30 0030.
 */
@Controller
public class HomePageController {
    private static final Logger logger = LoggerFactory.getLogger(HomePageController.class);

    @RequestMapping(path = {"/homepage"})
    public String homepage(@RequestParam(value = "name") String user, @RequestParam(value = "password") String password, HttpSession session){
        session.setAttribute("name",user);
        session.setAttribute("orderType","选择表类型");
        return "homepage";
    }
}
