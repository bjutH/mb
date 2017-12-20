package com.bjut.MB.APP;

import com.bjut.MB.service.OrderService;
import com.bjut.MB.service.PerformTestService;
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
public class AppPerformTestController {
    private static final Logger logger = LoggerFactory.getLogger(AppPerformTestController.class);

    @Autowired
    private PerformTestService performTestService;

    @RequestMapping(value = "/performTest/select")
    public List<String> select(@RequestParam(value = "orderNum") String orderNum) {
        List<String> list = new LinkedList<>();
        list = performTestService.selectPerformTestProcess(orderNum);
        return list;
    }

    @RequestMapping(value = "/performTest/update")
    public Map<String,String> select(@RequestParam(value = "orderNum") String orderNum,@RequestParam(value = "process") String process,
                              @RequestParam(value = "data") String data,@RequestParam(value = "result") String result,
                              @RequestParam(value = "ps") String ps) {
        Map<String,String> map = new HashMap<>();
        map = performTestService.updatePerformTest(orderNum,process,data,result,ps);
        return map;
    }
}
