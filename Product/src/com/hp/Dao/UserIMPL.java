/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hp.Dao;

import com.hp.Po.User;
import com.hp.Util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserIMPL implements IUser{
    
    @Override
    public boolean findByUser(User u) {
       String sql = "select * from login where UserName=?";
       Connection con = null;
       PreparedStatement pst = null;
       ResultSet rs = null;
       con = DBConnection.getConnection();
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, u.getUserName());
            rs = pst.executeQuery();
            while(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       return false;
    }

    @Override
    public int addUser(User u) {
        String sql = "insert into login(UserName,Password,Power) values (?,?,?)";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs =null;
        int result = 0;
        con = DBConnection.getConnection();
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, u.getUserName());
            pst.setString(2, u.getPassword());
            pst.setInt(3, u.getPower());
           result = pst.executeUpdate();
          while(result > 0){
              return result;
          
          }
        } catch (SQLException ex) {
          ex.getStackTrace();
        }
        return 0;
    }

    @Override
    public int checkUser(User u) {
         String sql = "select * from login where UserName= ? and Password= ?";
           Connection con = null;
       PreparedStatement pst = null;
       ResultSet rs = null;
       con = DBConnection.getConnection();
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, u.getUserName());
            pst.setString(2,u.getPassword());
            rs = pst.executeQuery();
            
            while(rs.next()){
                return rs.getInt(4);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       return 0;
         
    }
}
