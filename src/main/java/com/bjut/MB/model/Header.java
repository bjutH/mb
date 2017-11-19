package com.bjut.MB.model;

import java.util.Date;

/**
 * Created by Administrator on 2017/11/19.
 */
public class Header {
    private String orderNum;
    private String name;
    private String type;
    private String label;
    private String conclusion;
    private String debuger;
    private Date date;
    private String temperature;
    private String humidity;
    private String power;
    private String groud;

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public String getDebuger() {
        return debuger;
    }

    public void setDebuger(String debuger) {
        this.debuger = debuger;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getGroud() {
        return groud;
    }

    public void setGroud(String groud) {
        this.groud = groud;
    }
}
