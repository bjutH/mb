package com.bjut.MB.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/10/31.
 */
@Controller
public class test {
    @RequestMapping(value = "/test")
    @ResponseBody
    public String test(){
        return "HELLO   WORLD!!!";
    }
}