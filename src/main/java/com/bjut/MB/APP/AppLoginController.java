package com.bjut.MB.APP;

import com.bjut.MB.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/20.
 */
@RestController
@RequestMapping(value = "/app")
public class AppLoginController {
    private static final Logger logger = LoggerFactory.getLogger(AppLoginController.class);

    @Autowired
    private UserService userService;
    @RequestMapping(value = "/login")
    public Map<String,String> login(@RequestParam("name") String name, @RequestParam("password") String password) {
        Map<String,String> map = new HashMap<>();
        map =userService.login(name,password);
        return map;
    }
}
