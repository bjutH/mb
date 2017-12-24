package com.bjut.MB.controller;

import com.bjut.MB.dao.SoundDao;
import com.bjut.MB.model.SoundRecording;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.print.DocFlavor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by Cheng on 2017/12/8.
 */
@Controller
public class SoundManageController {

    @Autowired
    private SoundDao soundDao;

    @RequestMapping(path = "/homepage/recordmanagement")
    public String index(HttpSession session, Model model){
        try {
            session.getAttribute("soundNum").toString();
        }catch (Exception e) {
            session.setAttribute("soundNum", "请选择录音编号");
        }
        return "recordmanagement";
    }

    @RequestMapping(path = "/homepage/recordmanagement/updatesound")
    public String updateSound(@RequestParam(value = "num")String num, @RequestParam(value = "sound") String sound, RedirectAttributes redirectAttributes){
        try {
            soundDao.updatePassword(sound,Integer.valueOf(num));
            redirectAttributes.addFlashAttribute("msg","更新成功！");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("msg","更新失败！");
        }
        return "redirect:/homepage/recordmanagement";
    }

    @RequestMapping(path = "/homepage/recordmanagement/selectsound")
    public String selectSound(@RequestParam(value = "num")String num, HttpSession session, RedirectAttributes redirectAttributes){
        session.setAttribute("soundNum",num);
        try {
            SoundRecording soundRecording = soundDao.selectByNum(Integer.valueOf(num));
            redirectAttributes.addFlashAttribute("msg1",soundRecording.getSound());
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("msg","查询失败！");
        }
        return "redirect:/homepage/recordmanagement";
    }

    @RequestMapping(path = "/homepage/recordmanagement/selectall")
    @ResponseBody
    public List<SoundRecording> selectUser(){
        List<SoundRecording> list= soundDao.selectAll();
        return list;
    }
}

