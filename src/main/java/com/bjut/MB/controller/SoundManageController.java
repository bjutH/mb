package com.bjut.MB.controller;

import com.bjut.MB.dao.SoundDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Cheng on 2017/12/8.
 */
@Controller
public class SoundManageController {

    @Autowired
    private SoundDao soundDao;

    @RequestMapping(path = "/soundmanagement")
    public String index(){
        return "soundmanagement";
    }

    @RequestMapping(path = "/updatesound")
    public String updateSound(@RequestParam(value = "id")String id, @RequestParam(value = "sound") String sound){
        soundDao.updatePassword(sound, id);
        return "soundmanagement";
    }

    @RequestMapping(path = "/selectsound")

    public String updateSound(@RequestParam(value = "id")int id){
        soundDao.selectById(id);
        return "soundmanagement";
    }
}
