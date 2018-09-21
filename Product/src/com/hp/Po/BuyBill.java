/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hp.Po;

import java.sql.Date;

/**
 *
 * 
 */
public class BuyBill {
    private int buyId;
    private String defineId;
    private String buyName;
    private String goodsType;
    private String adviceBuyPrice;
     private String buyNum;
     private String buyPrice; 
    private String supplier;
    private Date buyTime;
    private int customerId;

    public BuyBill() {
    }

    public BuyBill(int buyId, String defineId, String buyName, String goodsType, String adviceBuyPrice, String buyNum, String buyPrice, String supplier, Date buyTime, int customerId) {
        this.buyId = buyId;
        this.defineId = defineId;
        this.buyName = buyName;
        this.goodsType = goodsType;
        this.adviceBuyPrice = adviceBuyPrice;
        this.buyNum = buyNum;
        this.buyPrice = buyPrice;
        this.supplier = supplier;
        this.buyTime = buyTime;
        this.customerId = customerId;
    }

    public int getBuyId() {
        return buyId;
    }

    public void setBuyId(int buyId) {
        this.buyId = buyId;
    }

  

    public String getDefineId() {
        return defineId;
    }

    public void setDefineId(String defineId) {
        this.defineId = defineId;
    }

    public String getBuyName() {
        return buyName;
    }

    public void setBuyName(String buyName) {
        this.buyName = buyName;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getAdviceBuyPrice() {
        return adviceBuyPrice;
    }

    public void setAdviceBuyPrice(String adviceBuyPrice) {
        this.adviceBuyPrice = adviceBuyPrice;
    }

    public String getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(String buyNum) {
        this.buyNum = buyNum;
    }

    public String getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(String buyPrice) {
        this.buyPrice = buyPrice;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Date getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    
    
    
    
    
    
    
    
  
    
    
    
    
    
    
}
