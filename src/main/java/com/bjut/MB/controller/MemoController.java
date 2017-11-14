package com.bjut.MB.controller;

import com.bjut.MB.model.Memo;
import com.bjut.MB.service.MemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/3.
 */

//仪器备忘录
@Controller
public class MemoController {
    private static final Logger logger = LoggerFactory.getLogger(MemoController.class);

    @Autowired
    private MemoService memoService;

    @RequestMapping(value = "/addmemo")
    @ResponseBody
    public String addMemo(@RequestParam(value = "orderNum") String orderNum, @RequestParam(value = "name") String name){
        Map<String,String> map = new HashMap<>();
        try {
            map = memoService.addMemo(orderNum, name);
        }
        catch (Exception e){
            logger.error("添加备忘录异常" + e.getMessage());
            map.put("code","3");
        }
        return map.toString();
    }
    @RequestMapping(value = "/updatememo")
    @ResponseBody
    public String updateMemo(@RequestParam(value = "orderNum") String orderNum, @RequestParam(value = "name") String name,
                              @RequestParam(value = "number") String number, @RequestParam(value = "boardNum") String boardNum,
                              @RequestParam(value = "weld") String weld, @RequestParam(value = "debug") String debug,
                              @RequestParam(value = "test") String test, @RequestParam(value = "version") String version,
                              @RequestParam(value = "ps") String ps){
        Map<String,String> map = new HashMap<>();
        try {
            map = memoService.updateMemo(orderNum, name, number, boardNum, weld, debug, test, version, ps);
        }
        catch (Exception e){
            logger.error("更新备忘录异常" + e.getMessage());
            map.put("code","3");
        }
        return map.toString();
    }
    @RequestMapping(value = "/selectmemo")
    @ResponseBody
    public String selectMemo(Model model, @RequestParam(value = "orderNum") String orderNum){
        List<Memo> memoList = memoService.selectMemo(orderNum);
        return null;
    }

    @RequestMapping(value = "/deletememo")
    @ResponseBody
    public String deleteMemo(@RequestParam(value = "orderNum") String orderNum){
        Map<String,String> map = new HashMap<>();
        try {
            map = memoService.deleteMemo(orderNum);
        } catch (Exception e) {
            logger.error("删除备忘录异常" + e.getMessage());
            map.put("code","3");
        }
        return map.toString();
    }
}
