package com.bjut.MB.controller;

import com.bjut.MB.dao.SoundDao;
import com.bjut.MB.model.SoundRecording;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Cheng on 2017/12/8.
 */
@Controller
public class SoundManageController {

    @Autowired
    private SoundDao soundDao;

    @RequestMapping(path = "homepage/recordmanagement")
    public String index(){
        return "recordmanagement";
    }

    @RequestMapping(path = "homepage/recordmanagement/updatesound")
    public String updateSound(@RequestParam(value = "id")String id, @RequestParam(value = "sound") String sound, ModelMap model){
        try {
            soundDao.updatePassword(sound, id);
            model.addAttribute("msg","成功！");
        }catch (Exception e){
            model.addAttribute("msg","错误！");
        }
        return "redirect:/homepage/recordmanagement";
    }

    @RequestMapping(path = "homepage/recordmanagement/selectsound")

    public String selectSound(@RequestParam(value = "id")int id,ModelMap model){
        try {
            SoundRecording soundRecording = soundDao.selectById(id);
            model.addAttribute("msg",soundRecording.getSound());
        }catch (Exception e){
            model.addAttribute("msg","错误！");
        }
        return "redirect:/homepage/recordmanagement";
    }
}
