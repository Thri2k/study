/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hp.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *链接数据库公用的工具类
 * @author Administrator
 */
public class DBConnection {
    private static String url ="jdbc:mysql://localhost:3306/product";//链接数据库的URL地址
    private static String username="root";
    private static String password="123";
    private static Connection con;
    
    //获取数据库的驱动
    static{
//        try {
          
//            Class.forName("com.mysql.jdbc.Driver");//数据库驱动
//        } catch (ClassNotFoundException ex) {
//           ex.printStackTrace();
//        } 
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //链接数据库
    public static Connection getConnection(){
        try {
             
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return con;
    }
    
    //关闭
  public static void close(Connection con,Statement st,ResultSet rs){
        if(con != null ){
            try {
                con.close();
               
            } catch (SQLException ex) {
                ex.getStackTrace();
            }
            }
            if(st!=null){
            try {
                
                st.close();
               
            } catch (SQLException ex) {
                ex.getStackTrace();
            }
        }
      if(rs!=null){
            try {
                
                rs.close();
               
            } catch (SQLException ex) {
                ex.getStackTrace();
            }
        }
    
    }
  public static void close(Connection con,Statement st){
        if(con != null ){
            try {
                con.close();
               
            } catch (SQLException ex) {
                ex.getStackTrace();
            }
            }
            if(st!=null){
            try {
                
                st.close();
               
            } catch (SQLException ex) {
                ex.getStackTrace();
            }
        }
      
    
    }
    
}
