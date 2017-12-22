package com.bjut.MB.APP;

import com.bjut.MB.model.Memo;
import com.bjut.MB.service.HeaderService;
import com.bjut.MB.service.MemoService;
import com.bjut.MB.service.OrderService;
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
public class AppMemoController {
    private static final Logger logger = LoggerFactory.getLogger(AppMemoController.class);

    @Autowired
    private MemoService memoService;
    @Autowired
    private HeaderService headerService;

    @RequestMapping(value = "/memo/selectall")
    public List<Memo> selectAll(@RequestParam(value = "orderNum") String orderNum) {
        List<Memo> list = new LinkedList<>();
        list = memoService.selectMemo(orderNum);
        return list;
    }

    @RequestMapping(value = "/memo/selectone")
    public Memo selectOne(@RequestParam(value = "orderNum") String orderNum,@RequestParam(value = "process") String process) {
        Memo memo = new Memo();
        memo = memoService.selectMemo(orderNum,process);
        return memo;
    }

    @RequestMapping(value = "/memo/update")
    public Map<String,String> select(@RequestParam(value = "orderNum") String orderNum,@RequestParam(value = "process") String process,
                                     @RequestParam(value = "number") String number,@RequestParam(value = "boardNum") String boardNum,
                                     @RequestParam(value = "weld") String weld,@RequestParam(value = "debug") String debug,
                                     @RequestParam(value = "test") String test,@RequestParam(value = "version") String version,
                                     @RequestParam(value = "ps") String ps) {
        Map<String,String> map = new HashMap<>();
        map = memoService.updateMemo(orderNum,process,number,boardNum,weld,debug,test,version,ps);
        return map;
    }

    @RequestMapping(value = "/memo/updatehead")
    public Map<String,String> select( @RequestParam(value = "excelType") String excelType,@RequestParam(value = "productNum") String productNum,
                                      @RequestParam(value = "productType") String productType,@RequestParam(value = "innerLabel") String innerLabel,
                                      @RequestParam(value = "productName") String productName) {
        Map<String,String> map = new HashMap<>();
        map = headerService.updateHeader(productNum,excelType,productName,productType,innerLabel,null,null,
                null,null,null,null,null,
                null,null,null,
                null,null,null,
                null,null,null,
                null,null,null,
                null,null,null,
                null,null,null,
                null,null,null,
                null,null,null,
                null,null,null,
                null,null,null,
                null,null,null,
                null,null,null,
                null,null);
        return map;
    }
}
