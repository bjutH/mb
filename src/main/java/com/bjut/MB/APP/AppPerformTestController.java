package com.bjut.MB.APP;

import com.bjut.MB.Utils.Base64Utils;
import com.bjut.MB.Utils.ExcelUtils;
import com.bjut.MB.Utils.HeadUtils;
import com.bjut.MB.model.Header;
import com.bjut.MB.model.PerformTest;
import com.bjut.MB.service.HeaderService;
import com.bjut.MB.service.OrderService;
import com.bjut.MB.service.PerformTestService;
import com.bjut.MB.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    @Autowired
    private TaskService taskService;
    @Autowired
    private ExcelUtils excelUtils;

    @RequestMapping(value = "/performtest/selectall")
    public List<PerformTest> selectAll(@RequestParam(value = "orderNum") String orderNum,HttpSession session) {
        List<PerformTest> list = new LinkedList<>();
        List<PerformTest> list1 = new LinkedList<>();
        List<String> listtask = new LinkedList<>();
        list = performTestService.selectPerformTest(orderNum);
        String name = session.getAttribute("appname").toString();
        listtask = taskService.queryTask(name);

        for(PerformTest performTest:list){
            if(listtask.contains(performTest.getProcess())){
                list1.add(performTest);
            }
        }
        return list1;
    }

    @RequestMapping(value = "/performtest/selectone")
    public PerformTest selectOne(@RequestParam(value = "orderNum") String orderNum,@RequestParam(value = "process") String process) {
        PerformTest performTest = new PerformTest();
        performTest = performTestService.selectPerformTest(orderNum,process);
        return performTest;
    }

    @RequestMapping(value = "/performtest/update")
    public Map<String,String> select(@RequestParam(value = "orderNum") String orderNum,@RequestParam(value = "process") String process,
                              @RequestParam(value = "data") String data,@RequestParam(value = "result") String result,
                              @RequestParam(value = "ps") String ps) {
        Map<String,String> map = new HashMap<>();
        try {
            performTestService.updatePerformTest(orderNum,process,data,result,ps);
            PerformTest performTest = new PerformTest();
            performTest.setData(data);
            performTest.setResult(result);
            performTest.setPs(ps);
            String path = performTestService.selectPath(orderNum);
            excelUtils.replaceExcel(path,"性能要求检验单", process, performTest);
            map.put("code","0");
        }catch (Exception e){
            map.put("code","1");
            map.put("code","更新失败！");
        }
        return map;
    }
    @RequestMapping(value = "/performtest/updatehead")
    public Map<String,String> select(@RequestParam(value = "productNum") String productNum, @RequestParam(value = "excelType") String excelType,
                                     @RequestParam(value = "productType") String productType,@RequestParam(value = "checker") String checker,
                                     @RequestParam(value = "checkDate") Date checkDate,@RequestParam(value = "checker2") String checker2,
                                     @RequestParam(value = "checkDate2") Date checkDate2,
                                     @RequestParam(value = "debugConclusion") String debugConclusion, @RequestParam(value = "debuger") String debuger,
                                     @RequestParam(value = "debugeDate") Date debugeDate, @RequestParam(value = "environmentTemperature") String environmentTemperature,
                                     @RequestParam(value = "relative_humidity") String relative_humidity, @RequestParam(value = "power") String power,
                                     @RequestParam(value = "is_groud") String is_groud,
                                     @RequestParam(value = "checkMachineName1") String checkMachineName1, @RequestParam(value = "checkMachineType1") String checkMachineType1, @RequestParam(value = "checkMachineNum1") String checkMachineNum1,
                                     @RequestParam(value = "checkMachineName2") String checkMachineName2, @RequestParam(value = "checkMachineType2") String checkMachineType2, @RequestParam(value = "checkMachineNum2") String checkMachineNum2,
                                     @RequestParam(value = "checkMachineName3") String checkMachineName3, @RequestParam(value = "checkMachineType3") String checkMachineType3, @RequestParam(value = "checkMachineNum3") String checkMachineNum3,
                                     HttpServletRequest request) {
        Map<String,String> map = new HashMap<>();
        String name = UUID.randomUUID().toString();
        String jpgPath = request.getSession().getServletContext().getRealPath("/sign/" + name + ".jpg");
        String name2 = UUID.randomUUID().toString();
        String jpgPath2 = request.getSession().getServletContext().getRealPath("/sign/" + name2 + ".jpg");
        String name3 = UUID.randomUUID().toString();
        String jpgPath3 = request.getSession().getServletContext().getRealPath("/sign/" + name3 + ".jpg");
        try {
            Base64Utils.decodeJpg(debuger,jpgPath);
            Base64Utils.decodeJpg(checker,jpgPath2);
            Base64Utils.decodeJpg(checker2,jpgPath3);
            headerService.updateHeader(productNum,excelType,null,productType,null,debugConclusion,debuger,
                    debugeDate,environmentTemperature,relative_humidity,power,is_groud,
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
                    checker,checkDate,checker2,checkDate2);
            String path = performTestService.selectPath(productNum);
            Header header = HeadUtils.setHead(productNum,excelType,null,productType,null,debugConclusion,debuger,
                    debugeDate,environmentTemperature,relative_humidity,power,is_groud,
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
                    checker,checkDate,checker2,checkDate2);
            excelUtils.replaceExcel(path,"性能要求检验单", null, header);
            map.put("code","0");
        }catch (Exception e){
            logger.error(e.getMessage());
            map.put("code","1");
            map.put("msg",e.getMessage());
        }
        return map;
    }
}
