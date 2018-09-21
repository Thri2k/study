/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hp.Dao;

import com.hp.Po.Staff;
import com.hp.Util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Muggle
 */
public class StaffIMPL implements IStaff{

    @Override
    public List<Staff> getStaff(String str) {
        List<Staff> list = new ArrayList<Staff>();
        String sql = "select * from staff where concat(User_Name,Staff_Id,Sex,Phone,Work_Type) like ?";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        con = DBConnection.getConnection();
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, "%"+str+"%");
            rs = pst.executeQuery();
            while(rs.next()){
                Staff s = new Staff();
                s.setStaffName(rs.getString(2));
                s.setStaffId(rs.getString(3));
                s.setSex(rs.getString(4));
                s.setNativePlace(rs.getString(5));
                s.setPresentAddress(rs.getString(6));
                s.setPhone(rs.getString(7));
                s.setQQ(rs.getString(8));
                s.setWeChat(rs.getString(9));
                s.setWorkType(rs.getString(10));
                list.add(s);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            DBConnection.close(con, pst, rs);
        }
        return list;
    }

    @Override
    public boolean findByStaff(Staff s) {
        String sql = "select * from staff where Staff_Id = ?";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        con = DBConnection.getConnection();
        try {       
            pst = con.prepareStatement(sql);
            pst.setString(1, s.getStaffId());
            rs = pst.executeQuery();
            while(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            DBConnection.close(con, pst, rs);
        }
        return false;
    }

    @Override
    public int addStaff(Staff s) {
        String sql = "insert into staff(User_Name,Staff_Id,Sex,Native_Place,Present_Address,Phone,QQ,Wechat,Work_Type) values(?,?,?,?,?,?,?,?,?)";
        
        Connection con = null;
        PreparedStatement pst = null;
        int result = 0;
        con = DBConnection.getConnection();
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, s.getStaffName());
            pst.setString(2, s.getStaffId());
            pst.setString(3, s.getSex());
            pst.setString(4, s.getNativePlace());
            pst.setString(5, s.getPresentAddress());
            pst.setString(6, s.getPhone());
            pst.setString(7, s.getQQ());
            pst.setString(8, s.getWeChat());
            pst.setString(9, s.getWorkType());
            result = pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        String sql2="insert into login(UserName,Password,Power) values (?,?,?)";
         try {
            pst = con.prepareStatement(sql2);
            pst.setString(1, s.getStaffName());
            pst.setString(2,"123456");
            String powerName=s.getWorkType();
            int num=10;
            if(powerName.equals("超级管理员"))
            {
                num=7;
            }
            else if(powerName.equals("员工"))
            {
                num=8;
            }
            else if(powerName.equals("销售员"))
            {
                num=9;
            }
            pst.setInt(3, num);
            result = pst.executeUpdate();
            while(result > 0){
                return result;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            DBConnection.close(con, pst);
        }
        return 0;
    }

    @Override
    public int updateStaff(Staff s) {
        String sql = "update staff set User_Name = ?,Sex = ?,Native_Place = ?,Present_Address = ?,Phone = ?,QQ = ?,Wechat = ?,Work_Type = ? where Staff_Id = ?";
        Connection con = null;
        PreparedStatement pst = null;
        int result = 0;
        con = DBConnection.getConnection();
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, s.getStaffName());
            pst.setString(2, s.getSex());
            pst.setString(3, s.getNativePlace());
            pst.setString(4, s.getPresentAddress());
            pst.setString(5, s.getPhone());
            pst.setString(6, s.getQQ());
            pst.setString(7, s.getWeChat());
            pst.setString(8, s.getWorkType());
            pst.setString(9,s.getStaffId());
            result = pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
         String sql2 = "update login set Power= ? where UserName = ?";
         try {
            pst = con.prepareStatement(sql2);
            String powerName=s.getWorkType();
            int num=10;
            if(powerName.equals("超级管理员"))
            {
                num=7;
            }
            else if(powerName.equals("员工"))
            {
                num=8;
            }
            else if(powerName.equals("销售员"))
            {
                num=9;
            }
            pst.setInt(1,num);
            pst.setString(2,s.getStaffId());
            result = pst.executeUpdate();
           return 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteStaff(String sid,String staffName) {
        String sql = "delete from staff where Staff_Id = ?";
        Connection con =null;
        PreparedStatement pst = null;
        int result = 0;
        con = DBConnection.getConnection();
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, sid);
            result = pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        String sql2 = "delete from login where UserName = ?";
        try {
            pst = con.prepareStatement(sql2);
            pst.setString(1, staffName);
            result = pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
}
