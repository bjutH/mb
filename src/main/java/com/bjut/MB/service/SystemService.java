package com.bjut.MB.service;

import com.bjut.MB.Utils.PasswordUtils;
import com.bjut.MB.dao.UserDao;
import com.bjut.MB.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/8.
 */
@Service
public class SystemService {
    private static final Logger logger = LoggerFactory.getLogger(SystemService.class);

    @Autowired
    private UserDao userDao;

    public Map<String,String> UpdatePassword(String name,String oldPassword,String newPassword){
        Map<String,String> map = new HashMap<>();
        User user = userDao.selectByName(name);
        String salt = user.getSalt();
        if (!PasswordUtils.MD5(oldPassword+user.getSalt()).equals(user.getPassword())) {
            map.put("code","1");
            map.put("msg", "密码不正确");
            return map;
        }
        else {
            try {
                userDao.updatePassword(PasswordUtils.MD5(newPassword+user.getSalt()),user.getNum());
                map.put("code","0");
            }catch (Exception e){
                logger.error("注册DAO异常" + e.getMessage());
                map.put("code","1");
            }
            return map;
        }
    }
}

