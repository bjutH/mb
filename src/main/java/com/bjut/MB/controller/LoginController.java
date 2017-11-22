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
    public String home(){
        return "login";
    }
    @RequestMapping(path = {"/word"})
    public String add(@RequestParam(value = "user") String user, HttpSession session){
        session.setAttribute("path","E:\\work\\mb\\src\\main\\resources\\EXCEL\\随工单.xlsx");
        if(user.equals("admin"))
            session.setAttribute("OpenModeType" , "OpenModeType.xlsNormalEdit");
        else
            session.setAttribute("OpenModeType" , "OpenModeType.xlsReadOnly");
        return "word";
    }
}
