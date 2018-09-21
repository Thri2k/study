/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hp.Po;

/**
 *
 * @author 苏宪时
 */
public class Goods {
    private int id;
    private String defineId;
    private String goodsName;
    private String goodsType;
    private String safeNum;
    private String adviceBuyPrice;
    private String adviceSalePrice;


    private String presentNumber;
    private String inTime;
    private String outTime;
    private int ownerId;
    public Goods(String defineId, String goodsName, String goodsType, String safeNum, String adviceBuyPrice, String adviceSalePrice, int ownerId) {
        this.defineId = defineId;
        this.goodsName = goodsName;
        this.goodsType = goodsType;
        this.safeNum = safeNum;
        this.adviceBuyPrice = adviceBuyPrice;
        this.adviceSalePrice = adviceSalePrice;
        this.ownerId = ownerId;
    }
    
    public Goods() {
    }               
    public Goods(String defineId, String goodsName, String goodsType, String safeNum, String adviceBuyPrice, String adviceSalePrice, String presentNumber, String inTime, String outTime, int ownerId) {
        this.defineId = defineId;
        this.goodsName = goodsName;
        this.goodsType = goodsType;
        this.safeNum = safeNum;
        this.adviceBuyPrice = adviceBuyPrice;
        this.adviceSalePrice = adviceSalePrice;
        this.presentNumber = presentNumber;
        this.inTime = inTime;
        this.outTime = outTime;
        this.ownerId = ownerId;
    }

    public Goods(int id, String defineId, String goodsName, String goodsType, String safeNum, String adviceBuyPrice, String adviceSalePrice, String presentNumber, String inTime, String outTime, int ownerId) {
        this.id = id;
        this.defineId = defineId;
        this.goodsName = goodsName;
        this.goodsType = goodsType;
        this.safeNum = safeNum;
        this.adviceBuyPrice = adviceBuyPrice;
        this.adviceSalePrice = adviceSalePrice;
        this.presentNumber = presentNumber;
        this.inTime = inTime;
        this.outTime = outTime;
        this.ownerId = ownerId;
    }

    public Goods(String defineId, String goodsName, String goodsType, String safeNum, String adviceBuyPrice, String adviceSalePrice, String presentNumber, int ownerId) {
        this.defineId = defineId;
        this.goodsName = goodsName;
        this.goodsType = goodsType;
        this.safeNum = safeNum;
        this.adviceBuyPrice = adviceBuyPrice;
        this.adviceSalePrice = adviceSalePrice;
        this.presentNumber = presentNumber;
        this.ownerId = ownerId;
    }

    public Goods(String defineId, String goodsName, String goodsType, String safeNum, String adviceBuyPrice, String adviceSalePrice, String presentNumber) {
        this.defineId = defineId;
        this.goodsName = goodsName;
        this.goodsType = goodsType;
        this.safeNum = safeNum;
        this.adviceBuyPrice = adviceBuyPrice;
        this.adviceSalePrice = adviceSalePrice;
        this.presentNumber = presentNumber;
    }

    public Goods(String goodsName, String goodsType, String safeNum, String adviceBuyPrice, String adviceSalePrice, String presentNumber) {
        this.goodsName = goodsName;
        this.goodsType = goodsType;
        this.safeNum = safeNum;
        this.adviceBuyPrice = adviceBuyPrice;
        this.adviceSalePrice = adviceSalePrice;
        this.presentNumber = presentNumber;
    }




  
                    
                    
                    
                    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDefineId() {
        return defineId;
    }

    public void setDefineId(String defineId) {
        this.defineId = defineId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getSafeNum() {
        return safeNum;
    }

    public void setSafeNum(String safeNum) {
        this.safeNum = safeNum;
    }

    public String getAdviceBuyPrice() {
        return adviceBuyPrice;
    }

    public void setAdviceBuyPrice(String adviceBuyPrice) {
        this.adviceBuyPrice = adviceBuyPrice;
    }

    public String getAdviceSalePrice() {
        return adviceSalePrice;
    }

    public void setAdviceSalePrice(String adviceSalePrice) {
        this.adviceSalePrice = adviceSalePrice;
    }

    public String getPresentNumber() {
        return presentNumber;
    }

    public void setPresentNumber(String presentNumber) {
        this.presentNumber = presentNumber;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }                
}
