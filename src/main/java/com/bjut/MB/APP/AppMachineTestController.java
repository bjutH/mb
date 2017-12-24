package com.bjut.MB.APP;

import com.bjut.MB.Utils.Base64Utils;
import com.bjut.MB.Utils.ExcelUtils;
import com.bjut.MB.Utils.HeadUtils;
import com.bjut.MB.model.Header;
import com.bjut.MB.model.MachineTest;
import com.bjut.MB.service.HeaderService;
import com.bjut.MB.service.MachineTestService;
import com.bjut.MB.service.OrderService;
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
public class AppMachineTestController {
    private static final Logger logger = LoggerFactory.getLogger(AppMachineTestController.class);

    @Autowired
    private MachineTestService machineTestService;
    @Autowired
    private HeaderService headerService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private ExcelUtils excelUtils;

    @RequestMapping(value = "/machinetest/selectall")
    public List<MachineTest> selectAll(@RequestParam(value = "orderNum") String orderNum,HttpSession session) {
        List<MachineTest> list = new LinkedList<>();
        List<MachineTest> list1 = new LinkedList<>();
        List<String> listtask = new LinkedList<>();
        list = machineTestService.selectMachineTest(orderNum);
        String name = session.getAttribute("appname").toString();
        listtask = taskService.queryTask(name);

        for(MachineTest machineTest:list){
            if(listtask.contains(machineTest.getProcess())){
                list1.add(machineTest);
            }
        }
        return list1;
    }

    @RequestMapping(value = "/machinetest/selectone")
    public MachineTest selectOne(@RequestParam(value = "orderNum") String orderNum,@RequestParam(value = "process") String process) {
        MachineTest machineTest = new MachineTest();
        machineTest = machineTestService.selectMachineTest(orderNum,process);
        return machineTest;
    }

    @RequestMapping(value = "/machinetest/update")
    public Map<String,String> select(@RequestParam(value = "orderNum") String orderNum,@RequestParam(value = "process") String process,
                              @RequestParam(value = "data") String data,@RequestParam(value = "result") String result,
                              @RequestParam(value = "ps") String ps) {
        Map<String,String> map = new HashMap<>();
        try {
            machineTestService.updateMachineTest(orderNum,process,data,result,ps);
            MachineTest machineTest = new MachineTest();
            machineTest.setData(data);
            machineTest.setResult(result);
            machineTest.setPs(ps);
            String path = machineTestService.selectPath(orderNum);
            excelUtils.replaceExcel(path,"整机检验报告单", process, machineTest);
            map.put("code","0");
        }catch (Exception e){
            map.put("code","1");
            map.put("code","更新失败！");
        }
        return map;
    }
    @RequestMapping(value = "/machinetest/updatehead")
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
                                     HttpServletRequest request) {
        Map<String,String> map = new HashMap<>();
        String name = UUID.randomUUID().toString();
        String jpgPath = request.getSession().getServletContext().getRealPath("/sign/" + name + ".jpg");
        try {
            Base64Utils.decodeJpg(debuger,jpgPath);
            headerService.updateHeader(productNum,excelType,null,productType,innerLabel,debugConclusion,debuger,
                    debugeDate,environmentTemperature,relative_humidity,null,is_groud,
                    checkMachineName1,checkMachineType1,checkMachineNum1,
                    checkMachineName2,checkMachineType2,checkMachineNum2,
                    checkMachineName3,checkMachineType3,checkMachineNum3,
                    checkMachineName4,checkMachineType4,checkMachineNum4,
                    null,null,null,
                    null,null,null,
                    null,null,null,
                    null,null,null,
                    null,null,null,
                    null,null,null,
                    null,null,null,
                    null,null,null,
                    null,null,null,null);
            String path = machineTestService.selectPath(productNum);
            Header header = HeadUtils.setHead(productNum,excelType,null,productType,innerLabel,debugConclusion,debuger,
                    debugeDate,environmentTemperature,relative_humidity,null,is_groud,
                    checkMachineName1,checkMachineType1,checkMachineNum1,
                    checkMachineName2,checkMachineType2,checkMachineNum2,
                    checkMachineName3,checkMachineType3,checkMachineNum3,
                    checkMachineName4,checkMachineType4,checkMachineNum4,
                    null,null,null,
                    null,null,null,
                    null,null,null,
                    null,null,null,
                    null,null,null,
                    null,null,null,
                    null,null,null,
                    null,null,null,
                    null,null,null,null);
            excelUtils.replaceExcel(path,"整机检验报告单", null, header);
            map.put("code","0");
        }catch (Exception e){
            logger.error(e.getMessage());
            map.put("code","1");
            map.put("msg",e.getMessage());
        }
        return map;
    }
}
