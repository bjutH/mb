package com.bjut.MB.APP;

import com.bjut.MB.model.ProductTest;
import com.bjut.MB.service.OrderService;
import com.bjut.MB.service.ProductTestService;
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
public class AppProductTestController {
    private static final Logger logger = LoggerFactory.getLogger(AppProductTestController.class);

    @Autowired
    private ProductTestService productTestService;

    @RequestMapping(value = "/productTest/selectall")
    public List<ProductTest> selectAll(@RequestParam(value = "orderNum") String orderNum) {
        List<ProductTest> list = new LinkedList<>();
        list = productTestService.selectProductTest(orderNum);
        return list;
    }

    @RequestMapping(value = "/productTest/selectone")
    public ProductTest selectOne(@RequestParam(value = "orderNum") String orderNum,@RequestParam(value = "process") String process) {
        ProductTest productTest = new ProductTest();
        productTest = productTestService.selectProductTest(orderNum,process);
        return productTest;
    }

    @RequestMapping(value = "/productTest/update")
    public Map<String,String> select(@RequestParam(value = "orderNum") String orderNum,@RequestParam(value = "process") String process,
                              @RequestParam(value = "data") String data,@RequestParam(value = "result") String result,
                              @RequestParam(value = "ps") String ps) {
        Map<String,String> map = new HashMap<>();
        map = productTestService.updateProductTest(orderNum,process,data,result,ps);
        return map;
    }
}
