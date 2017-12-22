package com.bjut.MB.controller;

import com.bjut.MB.dao.UserDao;
import com.bjut.MB.model.*;
import com.bjut.MB.service.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Cheng on 2017/12/6.
 */
@Controller
public class UserManageController {
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
    private UserDao userDao;
    @Autowired
    private HostHolder hostHolder;

    @RequestMapping(path = "/homepage/staffmanagement")
    public String index(){
        return "staffmanagement";
    }

    @RequestMapping(path = "/homepage/staffmanagement/updatepower")
    public String updatePower(@RequestParam(value = "name")String name, @RequestParam(value = "power") String power){
        userDao.updatePower(power, name);
        return "redirect:/homepage/staffmanagement";
    }
    @RequestMapping(path = "/homepage/staffmanagement/updatepassword")
    public String updatePassword(@RequestParam(value = "name") String name, @RequestParam(value = "pass") String pass){
        userDao.updatePassword(pass, name);
        return "redirect:/homepage/staffmanagement";
    }
    @RequestMapping(path = "/homepage/staffmanagement/deleteuser")
    public String deleteUser(@RequestParam(value = "name") String name){
        userDao.deleteAll(name);
        return "redirect:/homepage/staffmanagement";
    }

    @RequestMapping(path = "/homepage/staffmanagement/query")
    public String selectUser(@RequestParam(value = "num") String num){
        userDao.selectOne(num);
        return "redirect:/homepage/staffmanagement";
    }

    @RequestMapping(path = "/homepage/staffmanagement/add")
    public String addUser(@RequestParam(value = "num") String num, @RequestParam(value = "name") String name, @RequestParam(value = "password") String password, @RequestParam(value = "salt") String salt, @RequestParam(value = "power") String power){
        userDao.addUser(num, name, password, salt, power);
        return "redirect:/homepage/staffmanagement";
    }

    @RequestMapping(path = "/homepage/staffmanagement/selectprocess")
    public String addUser(@RequestParam(value = "orderNum") String orderNum, @RequestParam(value = "orderType") String orderType,RedirectAttributes redirectAttributes){
        switch (orderType){
            case "随工单":
                List<Order> orders = orderService.selectOrder(orderNum);
                redirectAttributes.addFlashAttribute("list",orders);
                break;
            case  "仪器备忘录":
                List<Memo> memos = memoService.selectMemo(orderNum);
                redirectAttributes.addFlashAttribute("list",memos);
                break;
            case "老化观测表":
                List<Aging> agings = agingService.selectAging(orderNum);
                redirectAttributes.addFlashAttribute("list",agings);
                break;
            case "装箱记录单":
                List<Pack> packs = packService.selectPack(orderNum);
                redirectAttributes.addFlashAttribute("list",packs);
                break;
            case "整机调试报告单":
                List<Debug> debugs = debugService.selectDebug(orderNum);
                redirectAttributes.addFlashAttribute("list",debugs);
                break;
            case "工序检验报告单":
                List<ProcessTest> processTests = processTestService.selectProcessTest(orderNum);
                redirectAttributes.addFlashAttribute("list",processTests);
                break;
            case "整机检验报告单":
                List<MachineTest> machineTests = machineTestService.selectMachineTest(orderNum);
                redirectAttributes.addFlashAttribute("list",machineTests);
                break;
            case "成品检验报告单":
                List<ProductTest> productTests = productTestService.selectProductTest(orderNum);
                redirectAttributes.addFlashAttribute("list",productTests);
                break;
            case "血压计检定报告单":
                List<Sphygmomanometer> sphygmomanometers = sphygmomanometerService.selectSphygmomanometer(orderNum);
                redirectAttributes.addFlashAttribute("list",sphygmomanometers);
                break;
            case "性能要求检验单":
                List<PerformTest> performTests = performTestService.selectPerformTest(orderNum);
                redirectAttributes.addFlashAttribute("list",performTests);
                break;
            case "最终检验报告单":
                List<FinalTest> finalTests = finalTestService.selectFinalTest(orderNum);
                redirectAttributes.addFlashAttribute("list",finalTests);
                break;
        }
        return "redirect:/homepage/staffmanagement";
    }

    @RequestMapping(path = "/homepage/staffmanagement/setpower")
    public String addUser(@RequestParam(value = "power") String power){
        String name = hostHolder.getUser().getName();
        String[] strings = power.split(",");
        for(int i =0;i<strings.length;i++){

        }
        return "redirect:/homepage/staffmanagement";
    }
}
