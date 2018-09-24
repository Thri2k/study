/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hp.Po;

import java.sql.Date;

/**
 *
 * @author 苏宪时
 */
public class SaleBill {
    private int id;
    private String saleId;
    private String goodsId;
    private String goodsName;
    private String count;
    private String saleNumber;
    private String salePrice;
    private String clientId;
    private String clientName;
    private Date saleTime;
    private String supplierId;
    private String simpleName;

    public SaleBill() {
    }

    public SaleBill(String saleId, String goodsId, String goodsName, String count, String saleNumber, String salePrice, String clientId, String clientName, Date saleTime, String supplierId, String simpleName) {
        this.saleId = saleId;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.count = count;
        this.saleNumber = saleNumber;
        this.salePrice = salePrice;
        this.clientId = clientId;
        this.clientName = clientName;
        this.saleTime = saleTime;
        this.supplierId = supplierId;
        this.simpleName = simpleName;
    }

    public SaleBill(int id, String saleId, String goodsId, String goodsName, String count, String saleNumber, String salePrice, String clientId, String clientName, Date saleTime, String supplierId, String simpleName) {
        this.id = id;
        this.saleId = saleId;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.count = count;
        this.saleNumber = saleNumber;
        this.salePrice = salePrice;
        this.clientId = clientId;
        this.clientName = clientName;
        this.saleTime = saleTime;
        this.supplierId = supplierId;
        this.simpleName = simpleName;
    }

    
    
    
    
    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getSaleNumber() {
        return saleNumber;
    }

    public void setSaleNumber(String saleNumber) {
        this.saleNumber = saleNumber;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Date getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(Date saleTime) {
        this.saleTime = saleTime;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }
    
    
    
    
    
    
}
