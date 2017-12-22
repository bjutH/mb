package com.bjut.MB.APP;

import com.bjut.MB.model.PerformTest;
import com.bjut.MB.service.HeaderService;
import com.bjut.MB.service.OrderService;
import com.bjut.MB.service.PerformTestService;
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
public class AppPerformTestController {
    private static final Logger logger = LoggerFactory.getLogger(AppPerformTestController.class);

    @Autowired
    private PerformTestService performTestService;
    @Autowired
    private HeaderService headerService;

    @RequestMapping(value = "/performTest/selectall")
    public List<PerformTest> selectAll(@RequestParam(value = "orderNum") String orderNum) {
        List<PerformTest> list = new LinkedList<>();
        list = performTestService.selectPerformTest(orderNum);
        return list;
    }

    @RequestMapping(value = "/performTest/selectone")
    public PerformTest selectOne(@RequestParam(value = "orderNum") String orderNum,@RequestParam(value = "process") String process) {
        PerformTest performTest = new PerformTest();
        performTest = performTestService.selectPerformTest(orderNum,process);
        return performTest;
    }

    @RequestMapping(value = "/performTest/update")
    public Map<String,String> select(@RequestParam(value = "orderNum") String orderNum,@RequestParam(value = "process") String process,
                              @RequestParam(value = "data") String data,@RequestParam(value = "result") String result,
                              @RequestParam(value = "ps") String ps) {
        Map<String,String> map = new HashMap<>();
        map = performTestService.updatePerformTest(orderNum,process,data,result,ps);
        return map;
    }
    @RequestMapping(value = "/performtest/updatehead")
    public Map<String,String> select(@RequestParam(value = "productNum") String productNum, @RequestParam(value = "excelType") String excelType,
                                     @RequestParam(value = "productType") String productType, @RequestParam(value = "innerLabel") String innerLabel,
                                     @RequestParam(value = "debugConclusion") String debugConclusion, @RequestParam(value = "debuger") String debuger,
                                     @RequestParam(value = "debugeDate") Date debugeDate, @RequestParam(value = "environmentTemperature") String environmentTemperature,
                                     @RequestParam(value = "relative_humidity") String relative_humidity, @RequestParam(value = "power") String power,
                                     @RequestParam(value = "is_groud") String is_groud,
                                     @RequestParam(value = "checkMachineName1") String checkMachineName1, @RequestParam(value = "checkMachineType1") String checkMachineType1, @RequestParam(value = "checkMachineNum1") String checkMachineNum1,
                                     @RequestParam(value = "checkMachineName2") String checkMachineName2, @RequestParam(value = "checkMachineType2") String checkMachineType2, @RequestParam(value = "checkMachineNum2") String checkMachineNum2,
                                     @RequestParam(value = "checkMachineName3") String checkMachineName3, @RequestParam(value = "checkMachineType3") String checkMachineType3, @RequestParam(value = "checkMachineNum3") String checkMachineNum3 ) {
        Map<String,String> map = new HashMap<>();
        map = headerService.updateHeader(productNum,excelType,null,productType,innerLabel,debugConclusion,debuger,
                null,environmentTemperature,relative_humidity,null,is_groud,
                checkMachineName1,checkMachineType1,checkMachineNum1,
                checkMachineName2,checkMachineType2,checkMachineNum2,
                checkMachineName3,checkMachineType3,checkMachineNum3,
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
