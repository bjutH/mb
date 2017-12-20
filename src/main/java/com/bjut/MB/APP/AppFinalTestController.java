package com.bjut.MB.APP;

import com.bjut.MB.model.FinalTest;
import com.bjut.MB.service.FinalTestService;
import com.bjut.MB.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/finalTest/selectall")
    public List<FinalTest> selectAll(@RequestParam(value = "orderNum") String orderNum) {
        List<FinalTest> list = new LinkedList<>();
        list = finalTestService.selectFinalTest(orderNum);
        return list;
    }

    @RequestMapping(value = "/finalTest/selectone")
    public FinalTest selectOne(@RequestParam(value = "orderNum") String orderNum,@RequestParam(value = "process") String process) {
        FinalTest finalTest = new FinalTest();
        finalTest = finalTestService.selectFinalTest(orderNum,process);
        return finalTest;
    }

    @RequestMapping(value = "/finalTest/update")
    public Map<String,String> select(@RequestParam(value = "orderNum") String orderNum,@RequestParam(value = "process") String process,
                              @RequestParam(value = "result") String result) {
        Map<String,String> map = new HashMap<>();
        map = finalTestService.updateFinalTest(orderNum,process,result);
        return map;
    }
}
