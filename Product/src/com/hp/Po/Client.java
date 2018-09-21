/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hp.Po;

/**
 *
 * @author Muggle
 */
public class Client {
    private int id;
    private String userName;
    private String clientId;
    private String clientName;
      private String taobaoId;
     private String phone;
     private String mobilePhone;
      private String deliveryAddress;
       private String post;
        private String buyTime;

    public Client(String clientId, String clientName, String taobaoId, String phone, String mobilePhone, String deliveryAddress, String post) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.taobaoId = taobaoId;
        this.phone = phone;
        this.mobilePhone = mobilePhone;
        this.deliveryAddress = deliveryAddress;
        this.post = post;
        this.buyTime = buyTime;
    }

    public Client() {
    }

    public Client(String userName, String clientId, String clientName, String taobaoId, String phone, String mobilePhone, String deliveryAddress, String post, String buyTime) {
        this.userName = userName;
        this.clientId = clientId;
        this.clientName = clientName;
        this.taobaoId = taobaoId;
        this.phone = phone;
        this.mobilePhone = mobilePhone;
        this.deliveryAddress = deliveryAddress;
        this.post = post;
        this.buyTime = buyTime;
    }

    public Client(int id, String userName, String clientId, String clientName, String taobaoId, String phone, String mobilePhone, String deliveryAddress, String post, String buyTime) {
        this.id = id;
        this.userName = userName;
        this.clientId = clientId;
        this.clientName = clientName;
        this.taobaoId = taobaoId;
        this.phone = phone;
        this.mobilePhone = mobilePhone;
        this.deliveryAddress = deliveryAddress;
        this.post = post;
        this.buyTime = buyTime;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getTaobaoId() {
        return taobaoId;
    }

    public void setTaobaoId(String taobaoId) {
        this.taobaoId = taobaoId;
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

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(String buyTime) {
        this.buyTime = buyTime;
    }
          
        
        
        
        
}
