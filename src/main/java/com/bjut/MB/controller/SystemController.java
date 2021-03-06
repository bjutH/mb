package com.bjut.MB.controller;

import com.bjut.MB.model.HostHolder;
import com.bjut.MB.service.SystemService;
import com.bjut.MB.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    @RequestMapping(path = {"/homepage/updatepassword"})
    public String updatePassword(@RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword") String newPassword,
                                 @RequestParam("renewPassword") String renewPassword, RedirectAttributes redirectAttributes){
        if(newPassword.equals(renewPassword)) {
            systemService.UpdatePassword(hostHolder.getUser().getName(), oldPassword, newPassword);
        }
        else {
            redirectAttributes.addFlashAttribute("msg","两次新密码不一致！");
        }
        return "redirect:/homepage";
    }

    @RequestMapping(path = {"/homepage/logout"})
    public String logout(@CookieValue("ticket") String ticket, HttpServletRequest httpServletRequest) throws IOException {
        userService.logout(ticket,httpServletRequest);
        return "redirect:/index";
    }
}
