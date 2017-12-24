package com.bjut.MB.APP;

import com.bjut.MB.Utils.ExcelUtils;
import com.bjut.MB.model.FinalTest;
import com.bjut.MB.service.FinalTestService;
import com.bjut.MB.service.HeaderService;
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
public class AppFinalTestController {
    private static final Logger logger = LoggerFactory.getLogger(AppFinalTestController.class);

    @Autowired
    private FinalTestService finalTestService;
    @Autowired
    private HeaderService headerService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private ExcelUtils excelUtils;

    @RequestMapping(value = "/finaltest/selectall")
    public List<FinalTest> selectAll(@RequestParam(value = "orderNum") String orderNum,HttpSession session) {
        List<FinalTest> list = new LinkedList<>();
        List<FinalTest> list1 = new LinkedList<>();
        List<String> listtask = new LinkedList<>();
        list = finalTestService.selectFinalTest(orderNum);
        String name = session.getAttribute("appname").toString();
        listtask = taskService.queryTask(name);

        for(FinalTest finalTest:list){
            if(listtask.contains(finalTest.getProcess())){
                list1.add(finalTest);
            }
        }
        return list1;
    }

    @RequestMapping(value = "/finaltest/selectone")
    public FinalTest selectOne(@RequestParam(value = "orderNum") String orderNum,@RequestParam(value = "process") String process) {
        FinalTest finalTest = new FinalTest();
        finalTest = finalTestService.selectFinalTest(orderNum,process);
        return finalTest;
    }

    @RequestMapping(value = "/finaltest/update")
    public Map<String,String> select(@RequestParam(value = "orderNum") String orderNum,@RequestParam(value = "process") String process,
                              @RequestParam(value = "result") String result) {
        Map<String,String> map = new HashMap<>();
        try {
            finalTestService.updateFinalTest(orderNum,process,result);
            FinalTest finalTest = new FinalTest();
            finalTest.setResult(result);
            String path = finalTestService.selectPath(orderNum);
            excelUtils.replaceExcel(path,"最终检验报告单", process, finalTest);
            map.put("code","0");
        }catch (Exception e){
            map.put("code","1");
            map.put("code","更新失败！");
        }
        return map;
    }

    @RequestMapping(value = "/finaltest/updatehead")
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
