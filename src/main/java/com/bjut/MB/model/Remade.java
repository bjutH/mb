package com.bjut.MB.model;

import java.util.Date;

/**
 * Created by Administrator on 2017/11/3.
 */
public class Remade {
    private String productNum;
    private Date date;
    private String number;
    private String updateSoftware;
    private String updateHardware;
    private String updateContent;
    private String updatePeople;
    private String testPeople;

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUpdateSoftware() {
        return updateSoftware;
    }

    public void setUpdateSoftware(String updateSoftware) {
        this.updateSoftware = updateSoftware;
    }

    public String getUpdateHardware() {
        return updateHardware;
    }

    public void setUpdateHardware(String updateHardware) {
        this.updateHardware = updateHardware;
    }

    public String getUpdateContent() {
        return updateContent;
    }

    public void setUpdateContent(String updateContent) {
        this.updateContent = updateContent;
    }

    public String getUpdatePeople() {
        return updatePeople;
    }

    public void setUpdatePeople(String updatePeople) {
        this.updatePeople = updatePeople;
    }

    public String getTestPeople() {
        return testPeople;
    }

    public void setTestPeople(String testPeople) {
        this.testPeople = testPeople;
    }
}
