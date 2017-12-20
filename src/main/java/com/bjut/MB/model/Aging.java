package com.bjut.MB.model;

import java.util.Date;

/**
 * Created by Administrator on 2017/11/3.
 */
public class Aging {
    private String productNum;
    private String process;
    private String result;
    private Date date;
    private String phenomenon;
    private String handle;
    private String ps;
    private String operater;

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPhenomenon() {
        return phenomenon;
    }
    
    public void setPhenomenon(String phenomenon) {
        this.phenomenon = phenomenon;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    public String getOperater() {
        return operater;
    }

    public void setOperater(String operater) {
        this.operater = operater;
    }
}
