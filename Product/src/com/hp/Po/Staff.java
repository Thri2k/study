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
public class Staff {
    private int id;
    private String userName;
    private String staffId;
    private String staffName;
    private String sex;
    private String nativePlace;
    private String presentAddress;

    public Staff(String staffId, String staffName, String sex, String nativePlace, String presentAddress, String phone, String QQ, String weChat, String workType) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.sex = sex;
        this.nativePlace = nativePlace;
        this.presentAddress = presentAddress;
        this.phone = phone;
        this.QQ = QQ;
        this.weChat = weChat;
        this.workType = workType;
    }
    private String phone;
    private String QQ;
    private String weChat;
    private String workType;

    public Staff() {
    }

    public Staff(String userName, String staffId, String staffName, String sex, String nativePlace, String presentAddress, String phone, String QQ, String weChat, String workType) {
        this.userName = userName;
        this.staffId = staffId;
        this.staffName = staffName;
        this.sex = sex;
        this.nativePlace = nativePlace;
        this.presentAddress = presentAddress;
        this.phone = phone;
        this.QQ = QQ;
        this.weChat = weChat;
        this.workType = workType;
    }

    public Staff(int id, String userName, String staffId, String staffName, String sex, String nativePlace, String presentAddress, String phone, String QQ, String weChat, String workType) {
        this.id = id;
        this.userName = userName;
        this.staffId = staffId;
        this.staffName = staffName;
        this.sex = sex;
        this.nativePlace = nativePlace;
        this.presentAddress = presentAddress;
        this.phone = phone;
        this.QQ = QQ;
        this.weChat = weChat;
        this.workType = workType;
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

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }
    
    
    
    
}
