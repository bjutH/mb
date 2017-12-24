package com.bjut.MB.APP;

import com.bjut.MB.Utils.ExcelUtils;
import com.bjut.MB.model.Memo;
import com.bjut.MB.service.HeaderService;
import com.bjut.MB.service.MemoService;
import com.bjut.MB.service.OrderService;
import com.bjut.MB.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/20.
 */
@RestController
@RequestMapping(value = "/app")
public class AppMemoController {
    private static final Logger logger = LoggerFactory.getLogger(AppMemoController.class);

    @Autowired
    private MemoService memoService;
    @Autowired
    private HeaderService headerService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private ExcelUtils excelUtils;

    @RequestMapping(value = "/memo/selectall")
    public List<Memo> selectAll(@RequestParam(value = "orderNum") String orderNum,HttpSession session) {
        List<Memo> list = new LinkedList<>();
        List<Memo> list1 = new LinkedList<>();
        List<String> listtask = new LinkedList<>();
        list = memoService.selectMemo(orderNum);
        String name = session.getAttribute("appname").toString();
        listtask = taskService.queryTask(name);

        for(Memo memo:list){
            if(listtask.contains(memo.getProcess())){
                list1.add(memo);
            }
        }
        return list1;
    }

    @RequestMapping(value = "/memo/selectone")
    public Memo selectOne(@RequestParam(value = "orderNum") String orderNum,@RequestParam(value = "process") String process) {
        Memo memo = new Memo();
        memo = memoService.selectMemo(orderNum,process);
        return memo;
    }

    @RequestMapping(value = "/memo/update")
    public Map<String,String> select(@RequestParam(value = "orderNum") String orderNum,@RequestParam(value = "process") String process,
                                     @RequestParam(value = "number") String number,@RequestParam(value = "boardNum") String boardNum,
                                     @RequestParam(value = "weld") String weld,@RequestParam(value = "debug") String debug,
                                     @RequestParam(value = "test") String test,@RequestParam(value = "version") String version,
                                     @RequestParam(value = "ps") String ps) {
        Map<String,String> map = new HashMap<>();
        try {
            memoService.updateMemo(orderNum,process,number,boardNum,weld,debug,test,version,ps);
            Memo memo = new Memo();
            memo.setNumber(number);
            memo.setBoardNum(boardNum);
            memo.setWeld(weld);
            memo.setDebug(debug);
            memo.setTest(test);
            memo.setVersion(version);
            memo.setPs(ps);
            String path = memoService.selectPath(orderNum);
            excelUtils.replaceExcel(path,"仪器备忘录", process, memo);
            map.put("code","0");
        }catch (Exception e){
            map.put("code","1");
            map.put("code","更新失败！");
        }
        return map;
    }

    @RequestMapping(value = "/memo/updatehead")
    public Map<String,String> select( @RequestParam(value = "excelType") String excelType,@RequestParam(value = "productNum") String productNum,
                                      @RequestParam(value = "productType") String productType,@RequestParam(value = "innerLabel") String innerLabel,
                                      @RequestParam(value = "productName") String productName) {
        Map<String,String> map = new HashMap<>();
        map = headerService.updateHeader(productNum,excelType,productName,productType,innerLabel,null,null,
                null,null,null,null,null,
                null,null,null,
                null,null,null,
                null,null,null,
                null,null,null,
                null,null,null,
                null,null,null,
                null,null,null,
                null,null,null,
                null,null,null,
                null,null,null,
                null,null,null,
                null,null,null,
                null,null);
        return map;
    }
}
