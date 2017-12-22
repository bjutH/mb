package com.bjut.MB.APP;

import com.bjut.MB.model.ProcessTest;
import com.bjut.MB.service.HeaderService;
import com.bjut.MB.service.OrderService;
import com.bjut.MB.service.ProcessTestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Created by Administrator on 2017/12/20.
 */
@RestController
@RequestMapping(value = "/app")
public class AppProcessTestController {
    private static final Logger logger = LoggerFactory.getLogger(AppProcessTestController.class);

    @Autowired
    private ProcessTestService processTestService;
    @Autowired
    private HeaderService headerService;

    @RequestMapping(value = "/processtest/selectall")
    public List<ProcessTest> selectAll(@RequestParam(value = "orderNum") String orderNum) {
        List<ProcessTest> list = new LinkedList<>();
        list = processTestService.selectProcessTest(orderNum);
        return list;
    }

    @RequestMapping(value = "/processtest/selectone")
    public ProcessTest selectOne(@RequestParam(value = "orderNum") String orderNum,@RequestParam(value = "process") String process) {
        ProcessTest processTest = new ProcessTest();
        processTest = processTestService.selectProcessTest(orderNum,process);
        return processTest;
    }

    @RequestMapping(value = "/processtest/update")
    public Map<String,String> select(@RequestParam(value = "orderNum") String orderNum,@RequestParam(value = "process") String process,
                                     @RequestParam(value = "data") String data,@RequestParam(value = "result") String result,
                                     @RequestParam(value = "detectionDevice") String detectionDevice,@RequestParam(value = "deviceType") String deviceType,
                                     @RequestParam(value = "deviceNum") String deviceNum,@RequestParam(value = "ps") String ps) {
        Map<String,String> map = new HashMap<>();
        map = processTestService.updateProcessTest(orderNum,process,data,result,detectionDevice,deviceType,deviceNum,ps);
        return map;
    }
    @RequestMapping(value = "/processtest/updatehead")
    public Map<String,String> select(@RequestParam(value = "productNum") String productNum, @RequestParam(value = "excelType") String excelType,
                                     @RequestParam(value = "productType") String productType, @RequestParam(value = "innerLabel") String innerLabel,
                                     @RequestParam(value = "debugConclusion") String debugConclusion, @RequestParam(value = "debuger") String debuger,
                                     @RequestParam(value = "debugeDate") Date debugeDate, @RequestParam(value = "environmentTemperature") String environmentTemperature,
                                     @RequestParam(value = "relative_humidity") String relative_humidity, @RequestParam(value = "power") String power,
                                     @RequestParam(value = "is_groud") String is_groud ) {
        Map<String,String> map = new HashMap<>();
        map = headerService.updateHeader(productNum,excelType,null,productType,innerLabel,debugConclusion,debuger,
                null,environmentTemperature,relative_humidity,null,is_groud,
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
                null,debugeDate);
        return map;
    }
}
