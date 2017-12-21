package com.bjut.MB.APP;

import com.bjut.MB.Utils.Base64Utils;
import com.bjut.MB.model.Pack;
import com.bjut.MB.service.OrderService;
import com.bjut.MB.service.PackService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;

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
        for(Pack pack:list){
            String path = pack.getOperater();
            if(!StringUtils.isBlank(path)) {
                String operater = Base64Utils.encode(path);
                pack.setOperater(operater);
            }
        }
        return list;
    }

    @RequestMapping(value = "/pack/selectone")
    public Pack selectOne(@RequestParam(value = "orderNum") String orderNum,@RequestParam(value = "process") String process) {
        Pack pack = new Pack();
        pack = packService.selectPack(orderNum,process);
        String path = pack.getOperater();
        if(!StringUtils.isBlank(path)) {
            String operater = Base64Utils.encode(path);
            pack.setOperater(operater);
        }
        return pack;
    }

    @RequestMapping(value = "/pack/update")
    public Map<String,String> select(@RequestParam(value = "orderNum") String orderNum,@RequestParam(value = "process") String process,
                              @RequestParam(value = "check") String check,@RequestParam(value = "result") String result,
                              @RequestParam(value = "operater") String operater, HttpServletRequest request) {
        Map<String,String> map = new HashMap<>();
        String name = UUID.randomUUID().toString();
        path = request.getSession().getServletContext().getRealPath("/sign/" + name + ".gif");
        if(Base64Utils.decode(operater,path)) {
            map = packService.updatePack(orderNum,process,check,result,operater);
        }else {
            map.put("code","1");
            map.put("code","更新失败！");
        }
        return map;
    }
}
