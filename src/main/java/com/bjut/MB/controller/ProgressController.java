package com.bjut.MB.controller;

import com.bjut.MB.model.*;
import com.bjut.MB.service.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/12.
 */
@Controller
public class ProgressController {
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
    @Autowired
    private HostHolder hostHolder;

    /**
     *
     * @param orderNum              随工单编号
     * @param redirectAttributes
     * @return          map结果，0为完成，1为未完成，2为没有这个表
     */
    @RequestMapping(path = "/homepage/progresscontrollerall")
    public String ProgressAll(@RequestParam(value = "orderNum") String orderNum, RedirectAttributes redirectAttributes){
        List<Order> orders = orderService.selectOrder(orderNum);
        List<Memo> memos = memoService.selectMemo(orderNum);
        List<Aging> agings = agingService.selectAging(orderNum);
        List<Pack> packs = packService.selectPack(orderNum);
        List<Debug> debugs = debugService.selectDebug(orderNum);
        List<ProcessTest> processTests = processTestService.selectProcessTest(orderNum);
        List<MachineTest> machineTests = machineTestService.selectMachineTest(orderNum);
        List<ProductTest> productTests = productTestService.selectProductTest(orderNum);
        List<Sphygmomanometer> sphygmomanometers = sphygmomanometerService.selectSphygmomanometer(orderNum);
        List<PerformTest> performTests = performTestService.selectPerformTest(orderNum);
        List<FinalTest> finalTests = finalTestService.selectFinalTest(orderNum);
        redirectAttributes.addFlashAttribute("随工单","0");
        redirectAttributes.addFlashAttribute("仪器备忘录","0");
        redirectAttributes.addFlashAttribute("老化观测表","0");
        redirectAttributes.addFlashAttribute("装箱记录单","0");
        redirectAttributes.addFlashAttribute("整机调试报告单","0");
        redirectAttributes.addFlashAttribute("工序检验报告单","0");
        redirectAttributes.addFlashAttribute("整机检验报告单","0");
        redirectAttributes.addFlashAttribute("成品检验报告单","0");
        redirectAttributes.addFlashAttribute("血压计检定报告单","0");
        redirectAttributes.addFlashAttribute("性能要求检验单","0");
        redirectAttributes.addFlashAttribute("最终检验报告单","0");
        if(orders.size()==0){
            redirectAttributes.addFlashAttribute("随工单","2");
        }
        if(memos.size()==0){
            redirectAttributes.addFlashAttribute("仪器备忘录","2");
        }
        if(agings.size()==0){
            redirectAttributes.addFlashAttribute("老化观测表","2");
        }
        if(packs.size()==0){
            redirectAttributes.addFlashAttribute("装箱记录单","2");
        }
        if(debugs.size()==0){
            redirectAttributes.addFlashAttribute("整机调试报告单","2");
        }
        if(processTests.size()==0){
            redirectAttributes.addFlashAttribute("工序检验报告单","2");
        }
        if(machineTests.size()==0){
            redirectAttributes.addFlashAttribute("整机检验报告单","2");
        }
        if(productTests.size()==0){
            redirectAttributes.addFlashAttribute("成品检验报告单","2");
        }
        if(sphygmomanometers.size()==0){
            redirectAttributes.addFlashAttribute("血压计检定报告单","2");
        }
        if(performTests.size()==0){
            redirectAttributes.addFlashAttribute("性能要求检验单","2");
        }
        if(finalTests.size()==0){
            redirectAttributes.addFlashAttribute("最终检验报告单","2");
        }

        for(Order order :orders){
            if(StringUtils.isBlank(order.getOperater())){
                redirectAttributes.addFlashAttribute("随工单","1");
                break;
            }
        }
        for(Memo memo :memos){
            if(StringUtils.isBlank(memo.getNumber())){
                redirectAttributes.addFlashAttribute("仪器备忘录","1");
                break;
            }
        }
        for(Aging aging :agings){
            if(StringUtils.isBlank(aging.getDebuger())){
                redirectAttributes.addFlashAttribute("老化观测表","1");
                break;
            }
        }
        for(Pack pack :packs){
            if(StringUtils.isBlank(pack.getPackager())){
                redirectAttributes.addFlashAttribute("装箱记录单","1");
                break;
            }
        }
        for(Debug debug :debugs){
            if(StringUtils.isBlank(debug.getResult())){
                redirectAttributes.addFlashAttribute("整机调试报告单","1");
                break;
            }
        }
        for(ProcessTest processTest :processTests){
            if(StringUtils.isBlank(processTest.getResult())){
                redirectAttributes.addFlashAttribute("工序检验报告单","1");
                break;
            }
        }
        for(MachineTest machineTest :machineTests){
            if(StringUtils.isBlank(machineTest.getResult())){
                redirectAttributes.addFlashAttribute("整机检验报告单","1");
                break;
            }
        }
        for(ProductTest productTest :productTests){
            if(StringUtils.isBlank(productTest.getResult())){
                redirectAttributes.addFlashAttribute("成品检验报告单","1");
                break;
            }
        }
        for(Sphygmomanometer sphygmomanometer :sphygmomanometers){
            if(StringUtils.isBlank(sphygmomanometer.getResult())){
                redirectAttributes.addFlashAttribute("血压计检定报告单","1");
                break;
            }
        }
        for(PerformTest performTest :performTests){
            if(StringUtils.isBlank(performTest.getResult())){
                redirectAttributes.addFlashAttribute("性能要求检验单","1");
                break;
            }
        }
        for(FinalTest finalTest :finalTests){
            if(StringUtils.isBlank(finalTest.getResult())){
                redirectAttributes.addFlashAttribute("最终检验报告单","1");
                break;
            }
        }
        return "redirect:/homepage/process";
    }

    @RequestMapping(path = "/homepage/progresscontrollerone")
    public String ProgressOne(@RequestParam(value = "orderNum") String orderNum, @RequestParam(value = "orderType") String orderType, RedirectAttributes redirectAttributes){
        Map<String,String> map = new HashMap<>();
        switch (orderType){
            case "随工单":
                List<Order> orders = orderService.selectOrder(orderNum);
                for(Order order : orders){
                    if(StringUtils.isBlank(order.getOperater())) {
                        map.put(order.getProcess(), "false");
                    }else {
                        map.put(order.getProcess(), "true");
                    }
                }
                break;
            case  "仪器备忘录":
                List<Memo> memos = memoService.selectMemo(orderNum);
                for(Memo memo : memos){
                    if(StringUtils.isBlank(memo.getNumber())) {
                        map.put(memo.getProcess(), "false");
                    }else {
                        map.put(memo.getProcess(), "true");
                    }
                }
                break;
            case "老化观测表":
                List<Aging> agings = agingService.selectAging(orderNum);
                for(Aging aging : agings){
                    if(StringUtils.isBlank(aging.getDebuger())) {
                        map.put(aging.getProcess(), "false");
                    }else {
                        map.put(aging.getProcess(), "true");
                    }
                }
                break;
            case "装箱记录单":
                List<Pack> packs = packService.selectPack(orderNum);
                for(Pack pack : packs){
                    if(StringUtils.isBlank(pack.getPackager())) {
                        map.put(pack.getProcess(), "false");
                    }else {
                        map.put(pack.getProcess(), "true");
                    }
                }
                break;
            case "整机调试报告单":
                List<Debug> debugs = debugService.selectDebug(orderNum);
                for(Debug debug : debugs){
                    if(StringUtils.isBlank(debug.getResult())) {
                        map.put(debug.getProcess(), "false");
                    }else {
                        map.put(debug.getProcess(), "true");
                    }
                }
                break;
            case "工序检验报告单":
                List<ProcessTest> processTests = processTestService.selectProcessTest(orderNum);
                for(ProcessTest processTest : processTests){
                    if(StringUtils.isBlank(processTest.getResult())) {
                        map.put(processTest.getProcess(), "false");
                    }else {
                        map.put(processTest.getProcess(), "true");
                    }
                }
                break;
            case "整机检验报告单":
                List<MachineTest> machineTests = machineTestService.selectMachineTest(orderNum);
                for(MachineTest machineTest : machineTests){
                    if(StringUtils.isBlank(machineTest.getResult())) {
                        map.put(machineTest.getProcess(), "false");
                    }else {
                        map.put(machineTest.getProcess(), "true");
                    }
                }
                break;
            case "成品检验报告单":
                List<ProductTest> productTests = productTestService.selectProductTest(orderNum);
                for(ProductTest productTest : productTests){
                    if(StringUtils.isBlank(productTest.getResult())) {
                        map.put(productTest.getProcess(), "false");
                    }else {
                        map.put(productTest.getProcess(), "true");
                    }
                }
                break;
            case "血压计检定报告单":
                List<Sphygmomanometer> sphygmomanometers = sphygmomanometerService.selectSphygmomanometer(orderNum);
                for(Sphygmomanometer sphygmomanometer : sphygmomanometers){
                    if(StringUtils.isBlank(sphygmomanometer.getResult())) {
                        map.put(sphygmomanometer.getProcess(), "false");
                    }else {
                        map.put(sphygmomanometer.getProcess(), "true");
                    }
                }
                break;
            case "性能要求检验单":
                List<PerformTest> performTests = performTestService.selectPerformTest(orderNum);
                for(PerformTest performTest : performTests){
                    if(StringUtils.isBlank(performTest.getResult())) {
                        map.put(performTest.getProcess(), "false");
                    }else {
                        map.put(performTest.getProcess(), "true");
                    }
                }
                break;
            case "最终检验报告单":
                List<FinalTest> finalTests = finalTestService.selectFinalTest(orderNum);
                for(FinalTest finalTest : finalTests){
                    if(StringUtils.isBlank(finalTest.getResult())) {
                        map.put(finalTest.getProcess(), "false");
                    }else {
                        map.put(finalTest.getProcess(), "true");
                    }
                }
                break;
        }
        redirectAttributes.addFlashAttribute("map",map);
        return "redirect:/homepage/process";
    }
    @RequestMapping(path = {"/homepage/process"})
    public String homepage(RedirectAttributes redirectAttributes){
        List<String> list = new LinkedList<>();
        list.add("随工单");
        list.add("仪器备忘录");
        list.add("老化观测表");
        list.add("装箱记录单");
        list.add("整机调试报告单");
        list.add("工序检验报告单");
        list.add("整机检验报告单");
        list.add("成品检验报告单");
        list.add("血压计检定报告单");
        list.add("性能要求检验单");
        list.add("最终检验报告单");
        redirectAttributes.addFlashAttribute("list",list);
        redirectAttributes.addFlashAttribute("data",12345);
        return "redirect:/homepage/process";
    }
}
