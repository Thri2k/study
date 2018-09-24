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
public class Supplier {
    private int id;
    private String supplierId;
    private String simpleName;
    private String completeName;
    private String agent;
    private String appellation;
    private String phone;
    private String mobilePhone;
    private String fax;
    private String companyAddress;
    private String factoryAddress;

    public Supplier() {
    }

    public Supplier(String supplierId, String simpleName, String completeName, String agent, String appellation, String phone, String mobilePhone, String fax, String companyAddress, String factoryAddress) {
        this.supplierId = supplierId;
        this.simpleName = simpleName;
        this.completeName = completeName;
        this.agent = agent;
        this.appellation = appellation;
        this.phone = phone;
        this.mobilePhone = mobilePhone;
        this.fax = fax;
        this.companyAddress = companyAddress;
        this.factoryAddress = factoryAddress;
    }

    public Supplier(int id, String supplierId, String simpleName, String completeName, String agent, String appellation, String phone, String mobilePhone, String fax, String companyAddress, String factoryAddress) {
        this.id = id;
        this.supplierId = supplierId;
        this.simpleName = simpleName;
        this.completeName = completeName;
        this.agent = agent;
        this.appellation = appellation;
        this.phone = phone;
        this.mobilePhone = mobilePhone;
        this.fax = fax;
        this.companyAddress = companyAddress;
        this.factoryAddress = factoryAddress;
    }
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCompleteName() {
        return completeName;
    }

    public void setCompleteName(String completeName) {
        this.completeName = completeName;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getAppellation() {
        return appellation;
    }

    public void setAppellation(String appellation) {
        this.appellation = appellation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getFactoryAddress() {
        return factoryAddress;
    }

    public void setFactoryAddress(String factoryAddress) {
        this.factoryAddress = factoryAddress;
    }
          
          
          
          
          
}
