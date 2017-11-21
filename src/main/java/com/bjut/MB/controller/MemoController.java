package com.bjut.MB.controller;

import com.bjut.MB.Utils.ExcelUtils;
import com.bjut.MB.model.Memo;
import com.bjut.MB.service.MemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
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
    private ExcelUtils excelUtils;
    @Autowired
    private MemoService memoService;

    @RequestMapping(path = "/addmemo")
    @ResponseBody
    @Transactional(propagation= Propagation.REQUIRED)
    public String addMemo(@RequestParam(value = "path") String path, @RequestParam(value = "number") String number){
        Map<String,String> map = new HashMap<>();
        try {
            excelUtils.importExcel(path, number,"memo");
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("添加备忘录异常" + e.getMessage());
            map.put("code","3");
        }
        return map.toString();
    }

    @RequestMapping(path = "/updatememo")
    @ResponseBody
    public String updateMemo(@RequestParam(value = "orderNum") String orderNum, @RequestParam(value = "process") String process,
                              @RequestParam(value = "number") String number, @RequestParam(value = "boardNum") String boardNum,
                              @RequestParam(value = "weld") String weld, @RequestParam(value = "debug") String debug,
                              @RequestParam(value = "test") String test, @RequestParam(value = "version") String version,
                              @RequestParam(value = "ps") String ps){
        Map<String,String> map = new HashMap<>();
        try {
            String path = memoService.selectPath(orderNum);
            Memo memo = new Memo();
            memo.setNumber(number);
            memo.setBoardNum(boardNum);
            memo.setWeld(weld);
            memo.setDebug(debug);
            memo.setTest(test);
            memo.setVersion(version);
            memo.setPs(ps);
            if (path == null) {
                map.put("code", "2");
                map.put("msg", "不存在");
                return map.toString();
            }
            map = excelUtils.replaceExcel(path, "memo", process, memo);
        }
        catch (Exception e){
            logger.error("更新备忘录异常" + e.getMessage());
            map.put("code","3");
        }
        return map.toString();
    }

    @RequestMapping(path = "/selectmemo")
    @ResponseBody
    public String selectMemo(Model model, @RequestParam(value = "orderNum") String orderNum){
        String path = memoService.selectPath(orderNum);
        return path;
    }

    @RequestMapping(path = "/deletememo")
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
