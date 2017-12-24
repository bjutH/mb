package com.bjut.MB.APP;

import com.bjut.MB.Utils.Base64Utils;
import com.bjut.MB.Utils.ExcelUtils;
import com.bjut.MB.model.Pack;
import com.bjut.MB.service.HeaderService;
import com.bjut.MB.service.OrderService;
import com.bjut.MB.service.PackService;
import com.bjut.MB.service.TaskService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    @Autowired
    private HeaderService headerService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private ExcelUtils excelUtils;

    @RequestMapping(value = "/pack/selectall")
    public List<Pack> selectAll(@RequestParam(value = "orderNum") String orderNum,HttpSession session) {
        List<Pack> list = new LinkedList<>();
        List<Pack> list1 = new LinkedList<>();
        List<String> listtask = new LinkedList<>();
        list = packService.selectPack(orderNum);
        String name = session.getAttribute("appname").toString();
        listtask = taskService.queryTask(name);

        for(Pack pack:list){
            String path = pack.getPackager();
            if(!StringUtils.isBlank(path)) {
                String operater = Base64Utils.encode(path);
                pack.setPackager(operater);
            }
            if(listtask.contains(pack.getProcess())){
                list1.add(pack);
            }
        }
        return list1;
    }

    @RequestMapping(value = "/pack/selectone")
    public Pack selectOne(@RequestParam(value = "orderNum") String orderNum,@RequestParam(value = "process") String process) {
        Pack pack = new Pack();
        pack = packService.selectPack(orderNum,process);
        String path = pack.getPackager();
        if(!StringUtils.isBlank(path)) {
            String operater = Base64Utils.encode(path);
            pack.setPackager(operater);
        }
        return pack;
    }

    @RequestMapping(value = "/pack/update")
    public Map<String,String> select(@RequestParam(value = "orderNum") String orderNum,@RequestParam(value = "process") String process,
                              @RequestParam(value = "check") String check,@RequestParam(value = "result") String result,
                              @RequestParam(value = "operater") String operater, HttpServletRequest request) {
        Map<String,String> map = new HashMap<>();
        String name = UUID.randomUUID().toString();
        String jpgPath = request.getSession().getServletContext().getRealPath("/sign/" + name + ".jpg");
        if(Base64Utils.decodeJpg(operater,jpgPath)) {
            try {
                packService.updatePack(orderNum,process,check,result,operater);
                Pack pack = new Pack();
                pack.setCheck(check);
                pack.setResult(result);
                pack.setPackager(operater);
                String path = packService.selectPath(orderNum);
                excelUtils.replaceExcel(path,"装箱记录单", process, pack);
                map.put("code","0");
            }catch (Exception e){
                map.put("code","1");
                map.put("code","更新失败！");
            }
        }else {
            map.put("code","1");
            map.put("code","更新失败！");
        }
        return map;
    }

//    @RequestMapping(value = "/pack/updatehead")
//    public Map<String,String> select( @RequestParam(value = "excelType") String excelType,@RequestParam(value = "productNum") String productNum,
//                                      @RequestParam(value = "productType") String productType,@RequestParam(value = "innerLabel") String innerLabel,
//                                      @RequestParam(value = "productName") String productName) {
//        Map<String,String> map = new HashMap<>();
//        map = headerService.updateHeader(productNum,excelType,productName,productType,innerLabel,null,null,
//                null,null,null,null,null,
//                null,null,null,
//                null,null,null,
//                null,null,null,
//                null,null,null,
//                null,null,null,
//                null,null,null,
//                null,null,null,
//                null,null,null,
//                null,null,null,
//                null,null,null,
//                null,null,null,
//                null,null,null,
//                null,null,null,null);
//        return map;
//    }
}
