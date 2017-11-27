package com.bjut.MB.controller;

import com.bjut.MB.Utils.ExcelUtils;
import com.bjut.MB.dao.OrderDao;
import com.bjut.MB.model.Order;
import com.bjut.MB.service.OrderService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;

/**
 * Created by Administrator on 2017/10/31.
 */

//随工单表
@Controller
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private ExcelUtils excelUtils;

    @Autowired
    private OrderService orderService;

    /**
     * 模拟平板上传的页面
     * @return
     */
    @RequestMapping(path = {"/test"})
    public String test(){
        return "updateexcel";
    }

    /**
     * 随工单管理主页面
     * @return
     */
    @RequestMapping(path = {"/ordermanagement"})
    public String homepage(){
        return "ordermanagement";
    }

    /**
     * 添加随工单
     * @param request
     * @param number        随工单编号
     * @return
     * @throws IOException
     */
    @RequestMapping(path = "/addorder" , method = RequestMethod.POST)
    @Transactional(propagation= Propagation.REQUIRED )
    public String addOrder(MultipartHttpServletRequest request, @RequestParam(value = "number") String number) throws IOException {
        List<MultipartFile> files = request.getFiles("uploadfile");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    String name = UUID.randomUUID().toString();
                    String path = request.getSession().getServletContext().getRealPath("/excel/" + name);
                    stream = new BufferedOutputStream(new FileOutputStream(new File(path)));
                    stream.write(bytes);
                    stream.close();
                } catch (Exception e) {
                    stream = null;
                    return "文件 " + i + "上传失败 " + e.getMessage();
                }
            } else {
                return "文件 " + i + " 为空，上传失败";
            }
        }
        Map<String,String> map = new HashMap<>();
        try {
            excelUtils.importExcel(path, number,"order");
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("添加随工单异常" + e.getMessage());
            map.put("code","3");
        }
        return "ordermanagement";
    }

    /**
     * 模拟平板上传
     * @param orderNum
     * @param process
     * @param operater
     * @param other
     * @param ps
     * @return
     */
    @RequestMapping(path = "/updateorder")
    @ResponseBody
    public String updateOrder(@RequestParam(value = "orderNum") String orderNum, @RequestParam(value = "process") String process,
                               @RequestParam(value = "operater") String operater, @RequestParam(value = "other") String other,
                               @RequestParam(value = "ps") String ps){
        Map<String,String> map = new HashMap<>();
        try {
            String path =orderService.selectPath(orderNum);
            Order order = new Order();
            order.setOperater(operater);
            order.setOther(other);
            order.setPs(ps);
            if(path == null){
                map.put("code","2");
                map.put("msg","不存在");
                return map.toString();
            }
            map = excelUtils.replaceExcel(path,"order", process, order);
            orderService.updateOrder(orderNum,process,operater,other,ps);
        }
        catch (Exception e) {
            logger.error("更新随工单异常" + e.getMessage());
            map.put("code","3");
        }
        return "succes";
    }

    @RequestMapping(path = "/searchorder")
    public String selectOrder(@RequestParam(value = "orderNum") String orderNum, HttpSession session){
//        String user = session.getAttribute("name").toString();
//        if(user.equals("admin"))
//            session.setAttribute("OpenModeType" , "OpenModeType.xlsNormalEdit");
//        else
//            session.setAttribute("OpenModeType" , "OpenModeType.xlsReadOnly");
//        String path = orderService.selectPath(orderNum);
//        session.setAttribute("path",path);
        session.setAttribute("orderNum",orderNum);
        return "ordermanagement";
    }

    @RequestMapping(path = "/show")
    public String selectOrder(HttpSession session){
        String user = session.getAttribute("name").toString();
        if(user.equals("admin"))
            session.setAttribute("OpenModeType" , "OpenModeType.xlsNormalEdit");
        else
            session.setAttribute("OpenModeType" , "OpenModeType.xlsReadOnly");
        String path = orderService.selectPath(session.getAttribute("orderNum").toString());
        session.setAttribute("path",path);
        return "word";
    }


    @RequestMapping(path = "/deleteorder")
    public String deleteOrder(@RequestParam(value = "name") String orderNum){
        Map<String,String> map = new HashMap<>();
        try {
            map = orderService.deleteOrder(orderNum);
        } catch (Exception e) {
            logger.error("删除随工单异常" + e.getMessage());
            map.put("code","3");
        }
        return "ordermanagement";
    }

    @RequestMapping(path = "/selectordertype")
    public String selectOrderType(@RequestParam(value = "orderType") String orderType, HttpSession session){
        session.setAttribute("orderType", orderType);
        return "ordermanagement";
    }
}
