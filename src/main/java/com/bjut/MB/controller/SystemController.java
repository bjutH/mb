package com.bjut.MB.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/12/8.
 */
@Controller
public class SystemController {
    private static final Logger logger = LoggerFactory.getLogger(SystemController.class);

    @RequestMapping(path = {"/systemmanagement"})
    public String index( ){
        return "systemmanagement";
    }
}
