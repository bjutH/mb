package com.bjut.MB.APP;

import com.bjut.MB.Utils.Base64Utils;
import com.bjut.MB.model.Aging;
import com.bjut.MB.service.AgingService;
import com.bjut.MB.service.OrderService;
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
public class AppAgingController {
    private static final Logger logger = LoggerFactory.getLogger(AppAgingController.class);

    @Autowired
    private AgingService agingService;

    @RequestMapping(value = "/aging/selectall")
    public List<Aging> selectAll(@RequestParam(value = "orderNum") String orderNum) {
        List<Aging> list = new LinkedList<>();
        list = agingService.selectAging(orderNum);
        for(Aging aging:list){
            String path = aging.getOperater();
            if(!StringUtils.isBlank(path)) {
                String operater = Base64Utils.encode(path);
                aging.setOperater(operater);
            }
        }
        return list;
    }

    @RequestMapping(value = "/aging/selectone")
    public Aging selectOne(@RequestParam(value = "orderNum") String orderNum,@RequestParam(value = "process") String process) {
        Aging aging = new Aging();
        aging = agingService.selectAging(orderNum,process);
        String path = aging.getOperater();
        if(!StringUtils.isBlank(path)) {
            String operater = Base64Utils.encode(path);
            aging.setOperater(operater);
        }
        return aging;
    }

    @RequestMapping(value = "/aging/update")
    public Map<String,String> select(@RequestParam(value = "orderNum") String orderNum,@RequestParam(value = "process") String process,
                                     @RequestParam(value = "result") String result,@RequestParam(value = "date") Date date,
                                     @RequestParam(value = "phenomenon") String phenomenon,@RequestParam(value = "handle") String handle,
                                     @RequestParam(value = "ps") String ps,@RequestParam(value = "operater") String operater,
                                     HttpServletRequest request) {
        Map<String,String> map = new HashMap<>();
        String name = UUID.randomUUID().toString();
        path = request.getSession().getServletContext().getRealPath("/sign/" + name + ".gif");
        if(Base64Utils.decode(operater,path)) {
            map = agingService.updateAging(orderNum,process,result,date,phenomenon,handle,ps,operater);
        }else {
            map.put("code","1");
            map.put("code","更新失败！");
        }
        return map;
    }
}
