package com.bjut.MB.service;

import com.bjut.MB.dao.UserDao;
import com.bjut.MB.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/6.
 */
@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;

    public Map<String,String> addUser(String name, String password, String salt, String power){
        Map<String,String> map = new HashMap<>();
        try {
            userDao.addUser(null,name,password,salt,power);
            map.put("code","0");
        }catch (Exception e){
            map.put("code","1");
        }
        return map;
    }

    public boolean selectUserByName(String name, String password){
        List<User> list =  userDao.selectByName(name,password);
        if(list.size() >0){
            return true;
        }
        else
            return false;
    }
}
