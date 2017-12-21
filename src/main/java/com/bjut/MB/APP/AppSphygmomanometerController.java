package com.bjut.MB.APP;

import com.bjut.MB.model.Sphygmomanometer;
import com.bjut.MB.service.OrderService;
import com.bjut.MB.service.SphygmomanometerService;
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
public class AppSphygmomanometerController {
    private static final Logger logger = LoggerFactory.getLogger(AppSphygmomanometerController.class);

    @Autowired
    private SphygmomanometerService sphygmomanometerService;

    @RequestMapping(value = "/sphygmomanometer/selectall")
    public List<Sphygmomanometer> selectAll(@RequestParam(value = "orderNum") String orderNum) {
        List<Sphygmomanometer> list = new LinkedList<>();
        list = sphygmomanometerService.selectSphygmomanometer(orderNum);
        return list;
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
        map = sphygmomanometerService.updateSphygmomanometer(orderNum,process,data,result,ps);
        return map;
    }
}