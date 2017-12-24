package com.bjut.MB.Utils;

import com.bjut.MB.model.Header;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Created by Administrator on 2017/12/24.
 */
public class HeadUtils {
    private static final Logger logger = LoggerFactory.getLogger(HeadUtils.class);

    public static Header setHead(String productNum, String excelType, String productName, String productType,
                                 String innerLabel, String  debugConclusion, String debuger, Date debugDate,
                                 String environmentTemperature, String relativeHumidity, String power, String isGroud,
                                 String checkMachineName1, String checkMachineType1, String checkMachineNum1,
                                 String checkMachineName2, String checkMachineType2, String checkMachineNum2,
                                 String checkMachineName3, String checkMachineType3, String checkMachineNum3,
                                 String checkMachineName4, String checkMachineType4, String checkMachineNum4,
                                 String checkMachineName5, String checkMachineType5, String checkMachineNum5,
                                 String checkMachineName6, String checkMachineType6, String checkMachineNum6,
                                 String checkMachineName7, String checkMachineType7, String checkMachineNum7,
                                 String checkMachineName8, String checkMachineType8, String checkMachineNum8,
                                 String checkMachineName9, String checkMachineType9, String checkMachineNum9,
                                 String checkMachineName10, String checkMachineType10, String checkMachineNum10,
                                 String checkMachineName11, String checkMachineType11, String checkMachineNum11,
                                 String checkMachineName12, String checkMachineType12, String checkMachineNum12,
                                 String checker, Date checkDate, String checker2, Date checkDate2){
        Header header = new Header();
        header.setProductNum(productNum);
        header.setExcelType(excelType);
        header.setProductName(productName);
        header.setProductNum(productNum);
        header.setProductType(productType);
        header.setInnerLabel(innerLabel);
        header.setDebugConclusion(debugConclusion);
        header.setDebuger(debuger);
        header.setDebugDate(debugDate);
        header.setEnvironmentTemperature(environmentTemperature);
        header.setRelativeHumidity(relativeHumidity);
        header.setPower(power);
        header.setIsGroud(isGroud);
        header.setCheckMachineName1(checkMachineName1);
        header.setCheckMachineType1(checkMachineType1);
        header.setCheckMachineNum1(checkMachineNum1);
        header.setCheckMachineName2(checkMachineName2);
        header.setCheckMachineType2(checkMachineType2);
        header.setCheckMachineNum2(checkMachineNum2);
        header.setCheckMachineName3(checkMachineName3);
        header.setCheckMachineType3(checkMachineType3);
        header.setCheckMachineNum3(checkMachineNum3);
        header.setCheckMachineName4(checkMachineName4);
        header.setCheckMachineType4(checkMachineType4);
        header.setCheckMachineNum4(checkMachineNum4);
        header.setCheckMachineName5(checkMachineName5);
        header.setCheckMachineType5(checkMachineType5);
        header.setCheckMachineNum5(checkMachineNum5);
        header.setCheckMachineName6(checkMachineName6);
        header.setCheckMachineType6(checkMachineType6);
        header.setCheckMachineNum6(checkMachineNum6);
        header.setCheckMachineName7(checkMachineName7);
        header.setCheckMachineType7(checkMachineType7);
        header.setCheckMachineNum7(checkMachineNum7);
        header.setCheckMachineName8(checkMachineName8);
        header.setCheckMachineType8(checkMachineType8);
        header.setCheckMachineNum8(checkMachineNum8);
        header.setCheckMachineName9(checkMachineName9);
        header.setCheckMachineType9(checkMachineType9);
        header.setCheckMachineNum9(checkMachineNum9);
        header.setCheckMachineName10(checkMachineName10);
        header.setCheckMachineType10(checkMachineType10);
        header.setCheckMachineNum10(checkMachineNum10);
        header.setCheckMachineName11(checkMachineName11);
        header.setCheckMachineType11(checkMachineType11);
        header.setCheckMachineNum11(checkMachineNum11);
        header.setCheckMachineName12(checkMachineName12);
        header.setCheckMachineType12(checkMachineType12);
        header.setCheckMachineNum12(checkMachineNum12);
        header.setChecker(checker);
        header.setCheckDate(checkDate);
        header.setChecker2(checker2);
        header.setCheckDate2(checkDate2);
        return header;
    }

    public static void setHeadJpg(Header header){
        if(StringUtils.isBlank(header.getDebuger())){
            String path = header.getDebuger();
            String debuger = Base64Utils.encode(path);
            header.setDebuger(debuger);
        }
        if(StringUtils.isBlank(header.getChecker())){
            String path = header.getChecker();
            String checker = Base64Utils.encode(path);
            header.setChecker(checker);
        }
        if(StringUtils.isBlank(header.getChecker2())){
            String path = header.getChecker2();
            String checker2 = Base64Utils.encode(path);
            header.setDebuger(checker2);
        }
    }
}
