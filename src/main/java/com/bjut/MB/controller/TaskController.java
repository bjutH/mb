package com.bjut.MB.controller;

import com.bjut.MB.dao.UserDao;
import com.bjut.MB.model.*;
import com.bjut.MB.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/23 0023.
 */
@Controller
public class TaskController {
    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

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
    @Autowired
    private TaskService taskService;

    @RequestMapping(path = "/homepage/taskmanagement")
    public String index(){
        return "taskmanagement";
    }

    @RequestMapping(path = "/homepage/taskmanagement/addtask")
    @Transactional
    public String addTask(@RequestParam(value = "task") String task, @RequestParam(value = "name") String name, RedirectAttributes redirectAttributes){
        String[] strings = task.split(",");
        try {
            for(int i =0;i<strings.length;i++){
                taskService.addTask(name,task);
            }
            redirectAttributes.addFlashAttribute("msg","添加成功！");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("msg","添加失败！");
        }
        return "redirect:/homepage/taskmanagement";
    }

    @RequestMapping(path = "/homepage/taskmanagement/selecttask")
    public String selectTask(@RequestParam(value = "name") String name,RedirectAttributes redirectAttributes){
        List<String> list = new LinkedList<>();
        list = taskService.queryTask(name);
        redirectAttributes.addFlashAttribute("list",list);
        return "redirect:/homepage/taskmanagement";
    }

    @RequestMapping(path = "/homepage/taskmanagement/deletetaskone")
    @Transactional
    public String deleteTask(@RequestParam(value = "name") String name,@RequestParam(value = "task") String task,RedirectAttributes redirectAttributes){
        String[] strings = task.split(",");
        try {
            for(int i =0;i<strings.length;i++){
                taskService.deleteTask(name,task);
            }
            redirectAttributes.addFlashAttribute("msg","删除成功！");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("msg","删除失败！");
        }
        return "redirect:/homepage/taskmanagement";
    }

    @RequestMapping(path = "/homepage/taskmanagement/deletetaskall")
    @Transactional
    public String deleteTask(@RequestParam(value = "name") String name,RedirectAttributes redirectAttributes){
        try {
            taskService.deleteAllTask(name);
            redirectAttributes.addFlashAttribute("msg","删除成功！");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("msg","删除失败！");
        }
        return "redirect:/homepage/taskmanagement";
    }

    @RequestMapping(path = "/homepage/taskmanagement/selectprocess")
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
        return "redirect:/homepage/taskmanagement";
    }
}
