package com.bjut.MB.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/11/30 0030.
 */
@Controller
public class HomePageController {
    private static final Logger logger = LoggerFactory.getLogger(HomePageController.class);

    @RequestMapping(path = {"/homepage"})
    public String homepage( ){
        return "homepage";
    }
}
