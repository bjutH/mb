package com.bjut.MB.controller;

import com.bjut.MB.model.*;
import com.bjut.MB.service.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
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

    @RequestMapping(path = "/homepage/progresscontrollerall")
    public String ProgressAll(@RequestParam(value = "orderNum") String orderNum, ModelMap model){
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
        model.addAttribute("随工单",true);
        model.addAttribute("仪器备忘录",true);
        model.addAttribute("老化观测表",true);
        model.addAttribute("装箱记录单",true);
        model.addAttribute("整机调试报告单",true);
        model.addAttribute("工序检验报告单",true);
        model.addAttribute("整机检验报告单",true);
        model.addAttribute("成品检验报告单",true);
        model.addAttribute("血压计检定报告单",true);
        model.addAttribute("性能要求检验单",true);
        model.addAttribute("最终检验报告单",true);
        for(Order order :orders){
            if(StringUtils.isBlank(order.getOperater())){
                model.addAttribute("随工单",false);
                break;
            }
        }
        for(Memo memo :memos){
            if(StringUtils.isBlank(memo.getNumber())){
                model.addAttribute("仪器备忘录",false);
                break;
            }
        }
        for(Aging aging :agings){
            if(StringUtils.isBlank(aging.getOperater())){
                model.addAttribute("老化观测表",false);
                break;
            }
        }
        for(Pack pack :packs){
            if(StringUtils.isBlank(pack.getOperater())){
                model.addAttribute("装箱记录单",false);
                break;
            }
        }
        for(Debug debug :debugs){
            if(StringUtils.isBlank(debug.getResult())){
                model.addAttribute("整机调试报告单",false);
                break;
            }
        }
        for(ProcessTest processTest :processTests){
            if(StringUtils.isBlank(processTest.getResult())){
                model.addAttribute("工序检验报告单",false);
                break;
            }
        }
        for(MachineTest machineTest :machineTests){
            if(StringUtils.isBlank(machineTest.getResult())){
                model.addAttribute("整机检验报告单",false);
                break;
            }
        }
        for(ProductTest productTest :productTests){
            if(StringUtils.isBlank(productTest.getResult())){
                model.addAttribute("成品检验报告单",false);
                break;
            }
        }
        for(Sphygmomanometer sphygmomanometer :sphygmomanometers){
            if(StringUtils.isBlank(sphygmomanometer.getResult())){
                model.addAttribute("血压计检定报告单",false);
                break;
            }
        }
        for(PerformTest performTest :performTests){
            if(StringUtils.isBlank(performTest.getResult())){
                model.addAttribute("性能要求检验单",false);
                break;
            }
        }
        for(FinalTest finalTest :finalTests){
            if(StringUtils.isBlank(finalTest.getResult())){
                model.addAttribute("最终检验报告单",false);
                break;
            }
        }
        return "redirect:/homepage/progresscontrollerall";
    }

    @RequestMapping(path = "/homepage/progresscontrollerone")
    public String ProgressOne(@RequestParam(value = "orderNum") String orderNum, @RequestParam(value = "orderType") String orderType, ModelMap model){
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
                    if(StringUtils.isBlank(aging.getOperater())) {
                        map.put(aging.getProcess(), "false");
                    }else {
                        map.put(aging.getProcess(), "true");
                    }
                }
                break;
            case "装箱记录单":
                List<Pack> packs = packService.selectPack(orderNum);
                for(Pack pack : packs){
                    if(StringUtils.isBlank(pack.getOperater())) {
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
        model.addAttribute("map",map);
        return "redirect:/homepage/progresscontrollerone";
    }
}
