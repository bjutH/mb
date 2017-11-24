package com.bjut.MB.controller;

import com.sun.deploy.net.HttpResponse;
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
    @RequestMapping(path = {"/login"})
    public String login(){
        return "login01";
    }

    @RequestMapping(path = {"/homepage"})
    public String homepage(@RequestParam(value = "name") String user, @RequestParam(value = "password") String password, HttpSession session){
        session.setAttribute("name",user);
        return "homepage";
    }
}
