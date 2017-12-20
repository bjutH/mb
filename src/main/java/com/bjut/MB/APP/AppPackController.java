package com.bjut.MB.APP;

import com.bjut.MB.model.Pack;
import com.bjut.MB.service.OrderService;
import com.bjut.MB.service.PackService;
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
public class AppPackController {
    private static final Logger logger = LoggerFactory.getLogger(AppPackController.class);

    @Autowired
    private PackService packService;

    @RequestMapping(value = "/pack/selectall")
    public List<Pack> selectAll(@RequestParam(value = "orderNum") String orderNum) {
        List<Pack> list = new LinkedList<>();
        list = packService.selectPack(orderNum);
        return list;
    }

    @RequestMapping(value = "/pack/selectone")
    public Pack selectOne(@RequestParam(value = "orderNum") String orderNum,@RequestParam(value = "process") String process) {
        Pack pack = new Pack();
        pack = packService.selectPack(orderNum,process);
        return pack;
    }

    @RequestMapping(value = "/pack/update")
    public Map<String,String> select(@RequestParam(value = "orderNum") String orderNum,@RequestParam(value = "process") String process,
                              @RequestParam(value = "check") String check,@RequestParam(value = "result") String result,
                              @RequestParam(value = "operater") String operater) {
        Map<String,String> map = new HashMap<>();
        map = packService.updatePack(orderNum,process,check,result,operater);
        return map;
    }
}
