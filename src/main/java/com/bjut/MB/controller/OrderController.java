package com.bjut.MB.controller;

import com.bjut.MB.Utils.ExcelUtils;
import com.bjut.MB.model.Order;
import com.bjut.MB.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
    @RequestMapping(path = {"/homepage/ordermanagement"})
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
    @RequestMapping(path = "/homepage/ordermanagement/addorder" , method = RequestMethod.POST)
    @Transactional(propagation= Propagation.REQUIRED )
    public String addOrder(MultipartHttpServletRequest request, @RequestParam(value = "number") String number, ModelMap model) throws IOException {
        String orderType = (request.getSession().getAttribute("orderType").toString());
        if(orderType =="选择表类型")
            return "ordermanagement";
        Map<String,String> map = new HashMap<>();
        switch (orderType) {
            case "随工单":
                if (orderService.selectOrder(number).size() != 0) {
                    map.put("code","1");
                    map.put("msg", "已存在！");
                    model.addAllAttributes(map);
                    request.getSession().setAttribute("msg","已存在！");
                    return "ordermanagement";
                }
                break;
            case  "仪器备忘录":
                if (memoService.selectMemo(number).size() != 0) {
                    map.put("code","1");
                    map.put("msg", "已存在！");
                    model.addAllAttributes(map);
                    return "ordermanagement";
                }
                break;
            case  "返工记录表":
                if (remadeSercice.selectRemade(number).size() != 0) {
                    map.put("code","1");
                    map.put("msg", "已存在！");
                    model.addAllAttributes(map);
                    return "ordermanagement";
                }
                break;
            case "老化观测表":
                if (agingService.selectAging(number).size() != 0) {
                    map.put("code","1");
                    map.put("msg", "已存在！");
                    model.addAllAttributes(map);
                    return "ordermanagement";
                }
                break;
            case "装箱记录单":
                if (packService.selectPack(number).size() != 0) {
                    map.put("code","1");
                    map.put("msg", "已存在！");
                    model.addAllAttributes(map);
                    return "ordermanagement";
                }
                break;
            case "整机调试报告单":
                if (debugService.selectDebug(number).size() != 0) {
                    map.put("code","1");
                    map.put("msg", "已存在！");
                    model.addAllAttributes(map);
                    return "ordermanagement";
                }
                break;
            case "工序检验报告单":
                if (processTestService.selectProcessTest(number).size() != 0) {
                    map.put("code","1");
                    map.put("msg", "已存在！");
                    model.addAllAttributes(map);
                    return "ordermanagement";
                }
                break;
            case "整机检验报告单":
                if (machineTestService.selectMachineTest(number).size() != 0) {
                    map.put("code","1");
                    map.put("msg", "已存在！");
                    model.addAllAttributes(map);
                    return "ordermanagement";
                }
                break;
            case "成品检验报告单":
                if (productTestService.selectProductTest(number).size() != 0) {
                    map.put("code","1");
                    map.put("msg", "已存在！");
                    model.addAllAttributes(map);
                    return "ordermanagement";
                }
                break;
            case "血压计检定报告单":
                if (sphygmomanometerService.selectSphygmomanometer(number).size() != 0) {
                    map.put("code","1");
                    map.put("msg", "已存在！");
                    model.addAllAttributes(map);
                    return "ordermanagement";
                }
                break;
            case "性能要求检验单":
                if (performTestService.selectPerformTest(number).size() != 0) {
                    map.put("code","1");
                    map.put("msg", "已存在！");
                    model.addAllAttributes(map);
                    return "ordermanagement";
                }
                break;
            case "最终检验报告单":
                if (finalTestService.selectFinalTest(number).size() != 0) {
                    map.put("code","1");
                    map.put("msg", "已存在！");
                    model.addAllAttributes(map);
                    return "ordermanagement";
                }
                break;
        }
        List<MultipartFile> files = request.getFiles("uploadfile");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        String path = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    String name = UUID.randomUUID().toString();
                    path = request.getSession().getServletContext().getRealPath("/excel/" + name + ".xlsx");
                    stream = new BufferedOutputStream(new FileOutputStream(new File(path)));
                    stream.write(bytes);
                    stream.close();
                } catch (Exception e) {
                    logger.error("文件上传失败：" + e.getMessage());
                    map.put("code","1");
                    map.put("msg","文件 " + i + "上传失败 ");
                    model.addAllAttributes(map);
                    return "ordermanagement";

                }
            } else {
                map.put("code","1");
                map.put("msg","文件 " + i + "上传失败 ");
                model.addAllAttributes(map);
                return "ordermanagement";
            }
        }
        try {
            orderType = request.getSession().getAttribute("orderType").toString();
            excelUtils.importExcel(path, number,orderType);
        }
        catch (Exception e){
            map.put("code","1");
            map.put("msg","添加文件失败");
            model.addAllAttributes(map);
            return "ordermanagement";
        }
        map.put("code","0");
        model.addAttribute(map);
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
    @RequestMapping(path = "/homepage/ordermanagement/updateorder")
    @ResponseBody
    public String updateOrder(@RequestParam(value = "orderNum") String orderNum, @RequestParam(value = "process") String process,
                               @RequestParam(value = "operater") String operater, @RequestParam(value = "other") String other,
                               @RequestParam(value = "ps") String ps, ModelMap model){
        Map<String,String> map = new HashMap<>();
        try {
            String path =orderService.selectPath(orderNum);
            Order order = new Order();
            order.setOperater(operater);
            order.setOther(other);
            order.setPs(ps);
            if(path == null){
                map.put("code","1");
                map.put("msg","不存在");
                model.addAllAttributes(map);
                return "flase";
            }
            map = excelUtils.replaceExcel(path,"随工单", process, order);
            orderService.updateOrder(orderNum,process,operater,other,ps);
        }
        catch (Exception e) {
            logger.error("更新随工单异常" + e.getMessage());
            map.put("code","1");
        }
        return "succes";
    }

    @RequestMapping(path = "/homepage/ordermanagement/searchorder")
    public String selectOrder(@RequestParam(value = "orderNum") String orderNum, HttpSession session){
        session.setAttribute("orderNum",orderNum);
        return "ordermanagement";
    }

    /**
     * pageoffice显示EXCEL
     * @param session
     * @return
     */
    @RequestMapping(path = "/homepage/ordermanagement/show")
    public String selectOrder(HttpSession session){
        String orderType = (session.getAttribute("orderType").toString());
        if(orderType =="选择表类型")
            return "ordermanagement";
        String user = session.getAttribute("name").toString();
        String path = null;
        if(user.equals("admin"))
            session.setAttribute("OpenModeType" , "OpenModeType.xlsNormalEdit");
        else
            session.setAttribute("OpenModeType" , "OpenModeType.xlsReadOnly");
        String orderNum = session.getAttribute("orderNum").toString();
        switch (orderType){
            case "随工单":
                path = orderService.selectPath(orderNum);
                break;
            case  "仪器备忘录":
                path = memoService.selectPath(orderNum);
                break;
            case  "返工记录表":
                path = remadeSercice.selectPath(orderNum);
                break;
            case "老化观测表":
                path = agingService.selectPath(orderNum);
                break;
            case "装箱记录单":
                path = packService.selectPath(orderNum);
                break;
            case "整机调试报告单":
                path = debugService.selectPath(orderNum);
                break;
            case "工序检验报告单":
                path = processTestService.selectPath(orderNum);
                break;
            case "整机检验报告单":
                path = machineTestService.selectPath(orderNum);
                break;
            case "成品检验报告单":
                path = productTestService.selectPath(orderNum);
                break;
            case "血压计检定报告单":
                path = sphygmomanometerService.selectPath(orderNum);
                break;
            case "性能要求检验单":
                path = performTestService.selectPath(orderNum);
                break;
            case "最终检验报告单":
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
    @RequestMapping(path = "/homepage/ordermanagement/deleteorderone")
    public String deleteOrderOne(@RequestParam(value = "name") String orderNum, HttpSession session, ModelMap model){
        String orderType = (session.getAttribute("orderType").toString());
        if(orderType =="选择表类型")
            return "ordermanagement";
        Map<String,String> map = new HashMap<>();
        try {
            switch (orderType){
                case "随工单":
                    map = orderService.deleteOrder(orderNum);
                    break;
                case  "仪器备忘录":
                    map = memoService.deleteMemo(orderNum);
                    break;
                case  "返工记录表":
                    map = remadeSercice.deleteRemade(orderNum);
                    break;
                case "老化观测表":
                    map = agingService.deleteAging(orderNum);
                    break;
                case "装箱记录单":
                    map = packService.deletePack(orderNum);
                    break;
                case "整机调试报告单":
                    map = debugService.deleteDebug(orderNum);
                    break;
                case "工序检验报告单":
                    map = processTestService.deleteProcessTest(orderNum);
                    break;
                case "整机检验报告单":
                    map = machineTestService.deleteMachineTest(orderNum);
                    break;
                case "成品检验报告单":
                    map = productTestService.deleteProductTest(orderNum);
                    break;
                case "血压计检定报告单":
                    map = sphygmomanometerService.deleteSphygmomanometer(orderNum);
                    break;
                case "性能要求检验单":
                    map = performTestService.deletePerformTest(orderNum);
                    break;
                case "最终检验报告单":
                    map = finalTestService.deleteFinalTest(orderNum);
                    break;
            }
        } catch (Exception e) {
            logger.error("删除单个随工单异常" + e.getMessage());
            map.put("code","1");
            map.put("msg","删除单个失败");
            model.addAllAttributes(map);
            return "ordermanagement";
        }
        map.put("code","0");
        model.addAllAttributes(map);
        return "ordermanagement";
    }

    /**
     * 删除全部随工单
     * @param orderNum  随工单编号
     * @return
     */
    @RequestMapping(path = "/homepage/ordermanagement/deleteorderall")
    @Transactional(propagation= Propagation.REQUIRED )
    public String deleteOrderAll(@RequestParam(value = "name") String orderNum, ModelMap model){
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
            logger.error("删除全部随工单异常" + e.getMessage());
            map.put("code","1");
            map.put("msg","删除全部随工单失败");
            model.addAllAttributes(map);
            return "ordermanagement";
        }
        map.put("code","0");
        model.addAllAttributes(map);
        return "ordermanagement";
    }

    /**
     * 选择随工单类型
     * @param orderType 随工单类型
     * @param session
     * @return
     */
    @RequestMapping(path = "/homepage/ordermanagement/selectordertype")
    public String selectOrderType(@RequestParam(value = "orderType") String orderType, HttpSession session){
        session.setAttribute("orderType", orderType);
        return "ordermanagement";
    }
}
