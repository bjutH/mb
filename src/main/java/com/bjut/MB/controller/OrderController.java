package com.bjut.MB.controller;

import com.bjut.MB.Utils.ExcelUtils;
import com.bjut.MB.dao.OrderDao;
import com.bjut.MB.model.Memo;
import com.bjut.MB.model.Order;
import com.bjut.MB.service.*;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
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

@Controller
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private ExcelUtils excelUtils;

    @Autowired
    private OrderService orderService;
    @Autowired
    private MemoService memoService;
    @Autowired
    private RemadeSercice remadeSercice;
    @Autowired
    private AgingService agingService;
    @Autowired
    private PackService packService;
    @Autowired
    private DebugService debugService;
    @Autowired
    private ProcessTestService processTestService;
    @Autowired
    private MachineTestService machineTestService;
    @Autowired
    private ProductTestService productTestService;
    @Autowired
    private SphygmomanometerService sphygmomanometerService;
    @Autowired
    private PerformTestService performTestService;
    @Autowired
    private FinalTestService finalTestService;
    @Autowired
    private HeaderService headerService;

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
        Map<String,String> map = new HashMap<>();
        List<MultipartFile> files = request.getFiles("uploadfile");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    String name = UUID.randomUUID().toString();
                    String path = request.getSession().getServletContext().getRealPath("/excel/" + name + ".xlsx");
                    stream = new BufferedOutputStream(new FileOutputStream(new File(path)));
                    stream.write(bytes);
                    stream.close();
                    String orderType = request.getSession().getAttribute("orderType").toString();
                    excelUtils.importExcel(path, number,orderType);
                } catch (Exception e) {
                    stream = null;
                    logger.error("文件上传失败：" + e.getMessage());
                    return "文件 " + i + "上传失败 " + e.getMessage();

                }
            } else {
                return "文件 " + i + " 为空，上传失败";
            }
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
        session.setAttribute("orderNum",orderNum);
        return "ordermanagement";
    }

    /**
     * pageoffice显示EXCEL
     * @param session
     * @return
     */
    @RequestMapping(path = "/show")
    public String selectOrder(HttpSession session){
        String user = session.getAttribute("name").toString();
        String path = null;
        if(user.equals("admin"))
            session.setAttribute("OpenModeType" , "OpenModeType.xlsNormalEdit");
        else
            session.setAttribute("OpenModeType" , "OpenModeType.xlsReadOnly");
        String orderType = session.getAttribute("orderType").toString();
        if(StringUtils.isBlank(orderType))
            orderType = "order";
        String orderNum = session.getAttribute("orderNum").toString();
        switch (orderType){
            case "order":
                path = orderService.selectPath(orderNum);
                break;
            case  "memo":
                path = memoService.selectPath(orderNum);
                break;
            case  "remade":
                path = remadeSercice.selectPath(orderNum);
                break;
            case "aging":
                path = agingService.selectPath(orderNum);
                break;
            case "pack":
                path = packService.selectPath(orderNum);
                break;
            case "debug":
                path = debugService.selectPath(orderNum);
                break;
            case "processTest":
                path = processTestService.selectPath(orderNum);
                break;
            case "machineTest":
                path = machineTestService.selectPath(orderNum);
                break;
            case "productTest":
                path = productTestService.selectPath(orderNum);
                break;
            case "sphygmomanometer":
                path = sphygmomanometerService.selectPath(orderNum);
                break;
            case "performTest":
                path = performTestService.selectPath(orderNum);
                break;
            case "finalTest":
                path = finalTestService.selectPath(orderNum);
                break;
        }
        session.setAttribute("path",path);
        return "word";
    }

    /**
     * 删除单个随工单
     * @param orderNum  随工单编号
     * @param session
     * @return
     */
    @RequestMapping(path = "/deleteorderone")
    public String deleteOrderOne(@RequestParam(value = "name") String orderNum, HttpSession session){
        Map<String,String> map = new HashMap<>();
        try {
            String orderType = session.getAttribute("orderType").toString();
            if(StringUtils.isBlank(orderType))
                orderType = "order";
            switch (orderType){
                case "order":
                    map = orderService.deleteOrder(orderNum);
                    break;
                case  "memo":
                    map = memoService.deleteMemo(orderNum);
                    break;
                case  "remade":
                    map = remadeSercice.deleteRemade(orderNum);
                    break;
                case "aging":
                    map = agingService.deleteAging(orderNum);
                    break;
                case "pack":
                    map = packService.deletePack(orderNum);
                    break;
                case "debug":
                    map = debugService.deleteDebug(orderNum);
                    break;
                case "processTest":
                    map = processTestService.deleteProcessTest(orderNum);
                    break;
                case "machineTest":
                    map = machineTestService.deleteMachineTest(orderNum);
                    break;
                case "productTest":
                    map = productTestService.deleteProductTest(orderNum);
                    break;
                case "sphygmomanometer":
                    map = sphygmomanometerService.deleteSphygmomanometer(orderNum);
                    break;
                case "performTest":
                    map = performTestService.deletePerformTest(orderNum);
                    break;
                case "finalTest":
                    map = finalTestService.deleteFinalTest(orderNum);
                    break;
            }
        } catch (Exception e) {
            logger.error("删除随工单异常" + e.getMessage());
            map.put("code","3");
        }
        return "ordermanagement";
    }

    /**
     * 删除全部随工单
     * @param orderNum  随工单编号
     * @return
     */
    @RequestMapping(path = "/deleteorderall")
    @Transactional(propagation= Propagation.REQUIRED )
    public String deleteOrderAll(@RequestParam(value = "name") String orderNum){
        Map<String,String> map = new HashMap<>();
        try {
                orderService.deleteOrder(orderNum);
                memoService.deleteMemo(orderNum);
                remadeSercice.deleteRemade(orderNum);
                agingService.deleteAging(orderNum);
                packService.deletePack(orderNum);
                debugService.deleteDebug(orderNum);
                processTestService.deleteProcessTest(orderNum);
                machineTestService.deleteMachineTest(orderNum);
                productTestService.deleteProductTest(orderNum);
                sphygmomanometerService.deleteSphygmomanometer(orderNum);
                performTestService.deletePerformTest(orderNum);
                finalTestService.deleteFinalTest(orderNum);
            }
         catch (Exception e) {
            logger.error("删除随工单异常" + e.getMessage());
            map.put("code","3");
        }
        return "ordermanagement";
    }

    /**
     * 选择随工单类型
     * @param orderType 随工单类型
     * @param session
     * @return
     */
    @RequestMapping(path = "/selectordertype")
    public String selectOrderType(@RequestParam(value = "orderType") String orderType, HttpSession session){
        session.setAttribute("orderType", orderType);
        return "ordermanagement";
    }
}
