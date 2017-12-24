package com.bjut.MB.APP;

import com.bjut.MB.Utils.ExcelUtils;
import com.bjut.MB.model.Sphygmomanometer;
import com.bjut.MB.service.HeaderService;
import com.bjut.MB.service.OrderService;
import com.bjut.MB.service.SphygmomanometerService;
import com.bjut.MB.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by Administrator on 2017/12/20.
 */
@RestController
@RequestMapping(value = "/app")
public class AppSphygmomanometerController {
    private static final Logger logger = LoggerFactory.getLogger(AppSphygmomanometerController.class);

    @Autowired
    private SphygmomanometerService sphygmomanometerService;
    @Autowired
    private HeaderService headerService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private ExcelUtils excelUtils;

    @RequestMapping(value = "/sphygmomanometer/selectall")
    public List<Sphygmomanometer> selectAll(@RequestParam(value = "orderNum") String orderNum,HttpSession session) {
        List<Sphygmomanometer> list = new LinkedList<>();
        List<Sphygmomanometer> list1 = new LinkedList<>();
        List<String> listtask = new LinkedList<>();
        list = sphygmomanometerService.selectSphygmomanometer(orderNum);
        String name = session.getAttribute("appname").toString();
        listtask = taskService.queryTask(name);

        for(Sphygmomanometer sphygmomanometer:list){
            if(listtask.contains(sphygmomanometer.getProcess())){
                list1.add(sphygmomanometer);
            }
        }
        return list1;
    }

    @RequestMapping(value = "/sphygmomanometer/selectone")
    public Sphygmomanometer selectOne(@RequestParam(value = "orderNum") String orderNum,@RequestParam(value = "process") String process) {
        Sphygmomanometer sphygmomanometer = new Sphygmomanometer();
        sphygmomanometer = sphygmomanometerService.selectSphygmomanometer(orderNum,process);
        return sphygmomanometer;
    }

    @RequestMapping(value = "/sphygmomanometer/update")
    public Map<String,String> select(@RequestParam(value = "orderNum") String orderNum,@RequestParam(value = "process") String process,
                              @RequestParam(value = "data") String data,@RequestParam(value = "result") String result,
                              @RequestParam(value = "ps") String ps) {
        Map<String,String> map = new HashMap<>();
        try {
            sphygmomanometerService.updateSphygmomanometer(orderNum,process,data,result,ps);
            Sphygmomanometer sphygmomanometer = new Sphygmomanometer();
            sphygmomanometer.setData(data);
            sphygmomanometer.setResult(result);
            sphygmomanometer.setPs(ps);
            String path = sphygmomanometerService.selectPath(orderNum);
            excelUtils.replaceExcel(path,"血压计检定报告单", process, sphygmomanometer);
            map.put("code","0");
        }catch (Exception e){
            map.put("code","1");
            map.put("code","更新失败！");
        }
        return map;
    }

    @RequestMapping(value = "/sphygmomanometer/updatehead")
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
