package com.bjut.MB.APP;

import com.bjut.MB.model.ProductTest;
import com.bjut.MB.service.HeaderService;
import com.bjut.MB.service.OrderService;
import com.bjut.MB.service.ProductTestService;
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
public class AppProductTestController {
    private static final Logger logger = LoggerFactory.getLogger(AppProductTestController.class);

    @Autowired
    private ProductTestService productTestService;
    @Autowired
    private HeaderService headerService;

    @RequestMapping(value = "/producttest/selectall")
    public List<ProductTest> selectAll(@RequestParam(value = "orderNum") String orderNum) {
        List<ProductTest> list = new LinkedList<>();
        list = productTestService.selectProductTest(orderNum);
        return list;
    }

    @RequestMapping(value = "/producttest/selectone")
    public ProductTest selectOne(@RequestParam(value = "orderNum") String orderNum,@RequestParam(value = "process") String process) {
        ProductTest productTest = new ProductTest();
        productTest = productTestService.selectProductTest(orderNum,process);
        return productTest;
    }

    @RequestMapping(value = "/producttest/update")
    public Map<String,String> select(@RequestParam(value = "orderNum") String orderNum,@RequestParam(value = "process") String process,
                              @RequestParam(value = "data") String data,@RequestParam(value = "result") String result,
                              @RequestParam(value = "ps") String ps) {
        Map<String,String> map = new HashMap<>();
        map = productTestService.updateProductTest(orderNum,process,data,result,ps);
        return map;
    }

    @RequestMapping(value = "/producttest/updatehead")
    public Map<String,String> select(@RequestParam(value = "productNum") String productNum, @RequestParam(value = "excelType") String excelType,
                                     @RequestParam(value = "productType") String productType, @RequestParam(value = "innerLabel") String innerLabel,
                                     @RequestParam(value = "debugConclusion") String debugConclusion, @RequestParam(value = "debuger") String debuger,
                                     @RequestParam(value = "debugeDate") Date debugeDate, @RequestParam(value = "environmentTemperature") String environmentTemperature,
                                     @RequestParam(value = "relative_humidity") String relative_humidity, @RequestParam(value = "power") String power,
                                     @RequestParam(value = "is_groud") String is_groud,
                                     @RequestParam(value = "checkMachineName1") String checkMachineName1, @RequestParam(value = "checkMachineType1") String checkMachineType1, @RequestParam(value = "checkMachineNum1") String checkMachineNum1,
                                     @RequestParam(value = "checkMachineName2") String checkMachineName2, @RequestParam(value = "checkMachineType2") String checkMachineType2, @RequestParam(value = "checkMachineNum2") String checkMachineNum2,
                                     @RequestParam(value = "checkMachineName3") String checkMachineName3, @RequestParam(value = "checkMachineType3") String checkMachineType3, @RequestParam(value = "checkMachineNum3") String checkMachineNum3,
                                     @RequestParam(value = "checkMachineName4") String checkMachineName4, @RequestParam(value = "checkMachineType4") String checkMachineType4, @RequestParam(value = "checkMachineNum4") String checkMachineNum4,
                                     @RequestParam(value = "checkMachineName5") String checkMachineName5, @RequestParam(value = "checkMachineType5") String checkMachineType5, @RequestParam(value = "checkMachineNum5") String checkMachineNum5,
                                     @RequestParam(value = "checkMachineName6") String checkMachineName6, @RequestParam(value = "checkMachineType6") String checkMachineType6, @RequestParam(value = "checkMachineNum6") String checkMachineNum6,
                                     @RequestParam(value = "checkMachineName7") String checkMachineName7, @RequestParam(value = "checkMachineType7") String checkMachineType7, @RequestParam(value = "checkMachineNum7") String checkMachineNum7,
                                     @RequestParam(value = "checkMachineName8") String checkMachineName8, @RequestParam(value = "checkMachineType8") String checkMachineType8, @RequestParam(value = "checkMachineNum8") String checkMachineNum8,
                                     @RequestParam(value = "checkMachineName9") String checkMachineName9, @RequestParam(value = "checkMachineType9") String checkMachineType9, @RequestParam(value = "checkMachineNum1") String checkMachineNum9,
                                     @RequestParam(value = "checkMachineName10") String checkMachineName10, @RequestParam(value = "checkMachineType10") String checkMachineType10, @RequestParam(value = "checkMachineNum2") String checkMachineNum10,
                                     @RequestParam(value = "checkMachineName11") String checkMachineName11, @RequestParam(value = "checkMachineType11") String checkMachineType11, @RequestParam(value = "checkMachineNum3") String checkMachineNum11,
                                     @RequestParam(value = "checkMachineName12") String checkMachineName12, @RequestParam(value = "checkMachineType12") String checkMachineType12, @RequestParam(value = "checkMachineNum4") String checkMachineNum12) {
        Map<String,String> map = new HashMap<>();
        map = headerService.updateHeader(productNum,excelType,null,productType,innerLabel,debugConclusion,debuger,
                null,environmentTemperature,relative_humidity,null,is_groud,
                checkMachineName1,checkMachineType1,checkMachineNum1,
                checkMachineName2,checkMachineType2,checkMachineNum2,
                checkMachineName3,checkMachineType3,checkMachineNum3,
                checkMachineName4,checkMachineType4,checkMachineNum4,
                checkMachineName5,checkMachineType5,checkMachineNum5,
                checkMachineName6,checkMachineType6,checkMachineNum6,
                checkMachineName7,checkMachineType7,checkMachineNum7,
                checkMachineName8,checkMachineType8,checkMachineNum8,
                checkMachineName9,checkMachineType9,checkMachineNum9,
                checkMachineName10,checkMachineType10,checkMachineNum10,
                checkMachineName11,checkMachineType11,checkMachineNum11,
                checkMachineName12,checkMachineType12,checkMachineNum12,
                null,debugeDate);
        return map;
    }
}
