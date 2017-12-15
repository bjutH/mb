package com.bjut.MB.controller;

import com.bjut.MB.dao.SoundDao;
import com.bjut.MB.model.SoundRecording;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String updateSound(@RequestParam(value = "id")String id, @RequestParam(value = "sound") String sound, RedirectAttributes redirectAttributes){
        try {
            soundDao.updatePassword(sound, id);
            redirectAttributes.addFlashAttribute("msg","更新成功！");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("msg","更新失败！");
        }
        return "redirect:/homepage/recordmanagement";
    }

    @RequestMapping(path = "homepage/recordmanagement/selectsound")

    public String selectSound(@RequestParam(value = "id")int id,RedirectAttributes redirectAttributes){
        try {
            SoundRecording soundRecording = soundDao.selectById(id);
            redirectAttributes.addFlashAttribute("msg",soundRecording.getSound());
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("msg","查询失败！");
        }
        return "redirect:/homepage/recordmanagement";
    }
}
