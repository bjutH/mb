package com.bjut.MB.controller;


import com.bjut.MB.model.HostHolder;
import com.bjut.MB.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/22 0022.
 */

@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private HostHolder hostHolder;

    @RequestMapping(path = {"/index"})
    public String index( ){
        return "login01";
    }

    /**
     * 登陆
     * @param name              用户名
     * @param password          密码
     * @param rememberme        是否自动登陆
     */
    @RequestMapping(path = {"/login"})
    public String login(@RequestParam("name") String name, @RequestParam("password") String password, @RequestParam(value = "rememberme" ,
                        defaultValue = "off") String rememberme, HttpSession session, HttpServletResponse response, RedirectAttributes redirectAttributes)
                        throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Map<String,String> map = new HashMap<>();
        if(StringUtils.isBlank(name)){
            redirectAttributes.addFlashAttribute("msg","用户名不能为空!");
            return "redirect:/index";
        }
        if(StringUtils.isBlank(password)){
            redirectAttributes.addFlashAttribute("msg","用户名不能为空!");
            return "redirect:/index";
        }
        try {
            map = userService.login(name,password);
            if (map.containsKey("ticket")) {
                Cookie cookie = new Cookie("ticket", map.get("ticket").toString());
                cookie.setPath("/");
                if (rememberme.equals("on")) {
                    cookie.setMaxAge(3600 * 24 * 7);
                }
                response.addCookie(cookie);
            }
            else {
                redirectAttributes.addFlashAttribute("msg","用户名或密码错误!");
                return "redirect:/index";
            }
        }catch (Exception e){
            logger.error("登陆异常" + e.getMessage());
            redirectAttributes.addFlashAttribute(map);
            return "redirect:/index";
        }
        return "redirect:/homepage";
    }

    /**
     * 注册
     * @param name          用户名
     * @param password      密码
     * @param rememberme    是否自动登陆
     */
    @RequestMapping(path = {"/reg"})
    public String reg(@RequestParam("name") String name, @RequestParam("password") String password, @RequestParam(value = "rememberme" ,
            defaultValue = "false") boolean rememberme, HttpServletResponse response, RedirectAttributes redirectAttributes)
            throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Map<String,String> map = new HashMap<>();
        if(StringUtils.isBlank(name)){
            redirectAttributes.addFlashAttribute("msg","用户名不能为空!");
            return "redirect:/index";
        }
        if(StringUtils.isBlank(password)){
            redirectAttributes.addFlashAttribute("msg","密码不能为空!");
            return "redirect:/index";
        }
        try {
            map = userService.reg(name,password);
            if(map.get("code").equals("1")){
                redirectAttributes.addFlashAttribute("msg",map.get("msg"));
                return "redirect:/index";
            }
            if (map.containsKey("ticket")) {
                Cookie cookie = new Cookie("ticket", map.get("ticket").toString());
                cookie.setPath("/");
                if (rememberme) {
                    cookie.setMaxAge(3600 * 24 * 5);
                }
                response.addCookie(cookie);
            }
        }catch (Exception e){
            logger.error("注册异常" + e.getMessage());
            redirectAttributes.addFlashAttribute("msg","注册异常!");
            return "redirect:/index";
        }
        return "redirect:/homepage";
    }
}
