/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hp.Dao;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.hp.Po.Supplier;
import com.hp.Util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author 苏宪时
 */
public class SupplierIMPL  implements ISupplier{

    @Override
    public boolean Thri_findBySupplier(Supplier s) {
        String sql = "select * from supplier where  Simple_Name=?";
       Connection con = null;
       PreparedStatement pst = null;
       ResultSet rs = null;
       con = DBConnection.getConnection();
        try {
            pst = con.prepareStatement(sql);
            
            pst.setString(1, s.getSimpleName());
            rs = pst.executeQuery();
            while(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
         finally
        {
            DBConnection.close(con, pst, rs);
        }
       return false;
    }
 public boolean Thri_findBySupplierId(int s) {
        String sql = "select * from supplier where  Supplier_Id=?";
       Connection con = null;
       PreparedStatement pst = null;
       ResultSet rs = null;
       con = DBConnection.getConnection();
        try {
            pst = con.prepareStatement(sql);
            
            pst.setString(1,String.valueOf(s));
            rs = pst.executeQuery();
            while(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
         finally
        {
            DBConnection.close(con, pst, rs);
        }
       return false;
    }

    @Override
    public int Thri_addSupplier(Supplier s) {
        String sql = "insert into supplier(Supplier_Id,Simple_Name,Complete_Name,Agent,Appellation,Phone,Mobile_Phone,Fax,Company_Address,Factory_Address) values (?,?,?,?,?,?,?,?,?,?)";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs =null;
        int result = 0;
        con = DBConnection.getConnection();
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, s.getSupplierId());
            pst.setString(2, s.getSimpleName());
            pst.setString(3, s.getCompleteName());
            pst.setString(4, s.getAgent());
            pst.setString(5, s.getAppellation());
            pst.setString(6, s.getPhone());
            pst.setString(7, s.getMobilePhone());
            pst.setString(8, s.getFax());
            pst.setString(9, s.getCompanyAddress());
            pst.setString(10, s.getFactoryAddress());
           result = pst.executeUpdate();
          while(result > 0){
              return result;
          
          }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        finally
        {
            DBConnection.close(con, pst, rs);
        }
        return 0;
    }

    @Override
    public List<Supplier> Thri_getSipplier() {
       List<Supplier> list = new ArrayList<Supplier>();
        String sql = "select * from supplier";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        //获取连接
        con = DBConnection.getConnection();
        try {
            pst = con.prepareStatement(sql);
            //pst.setString(1, "%"+str+"%");
           rs = pst.executeQuery();//执行查询 
           while(rs.next()){
               Supplier s = new Supplier();
               s.setId(rs.getInt(1));
               s.setSupplierId(rs.getString(2));
               s.setSimpleName(rs.getString(3));
               s.setCompleteName(rs.getString(4));
               s.setAgent(rs.getString(5));
               s.setAppellation(rs.getString(6));
               s.setPhone(rs.getString(7));
               s.setMobilePhone(rs.getString(8));   
               s.setFax(rs.getString(9));
               s.setCompanyAddress(rs.getString(10));
               s.setFactoryAddress(rs.getString(11));
               
               list.add(s);         
           }
        } catch (SQLException ex) {
          ex.printStackTrace();
        }  
        finally
        {
            DBConnection.close(con, pst, rs);
        }
        return list;
    }

    @Override
    public int Thri_updateSupplier(Supplier s) {
         String sql="update supplier set Complete_Name=?,Agent=?,Appellation=?,Phone=?,Mobile_Phone=?,Fax=?,Company_Address=?,Factory_Address=? where Simple_Name=?";
       Connection con=null;
       PreparedStatement pst=null;
       ResultSet rs = null;
       int result=0;
       con=DBConnection.getConnection();
        try {
            pst=con.prepareStatement(sql);
            
            pst.setString(1, s.getCompleteName());
            pst.setString(2, s.getAgent());
            pst.setString(3, s.getAppellation());
            pst.setString(4, s.getPhone());
            pst.setString(5, s.getMobilePhone());
            pst.setString(6, s.getFax());
            pst.setString(7, s.getCompanyAddress());
            pst.setString(8, s.getFactoryAddress());
            pst.setString(9, s.getSimpleName());
            result=pst.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally
        {
            DBConnection.close(con, pst, rs);
        }
       return result;
    }

    @Override
    public int Thri_deleteSupplier(String name) {
       String sql="delete from supplier where Simple_Name=?";
       Connection con=null;
       PreparedStatement pst=null;
       ResultSet rs = null;
       int result=0;
       con=DBConnection.getConnection();
        try {
            pst=con.prepareStatement(sql);
            pst.setString(1,name);
            result=pst.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally
        {
            DBConnection.close(con, pst, rs);
        }
       return result;
    }
    public Supplier SxS_findId(String id) {
        int supplier_id=Integer.parseInt(id);
         String sql = "select * from Supplier where id=?";
          Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        //获取连接
        con = DBConnection.getConnection();
        Supplier s=null;
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,supplier_id);
           rs = pst.executeQuery();//执行查询 
           while(rs.next()){
           s=new Supplier();
           s.setId(rs.getInt("Id"));
           s.setSimpleName(rs.getString("Simple_Name"));
           return s;
           }
        }catch(Exception ex){
        ex.getStackTrace();
        }
        return s;
    }
    
    public Supplier LGZ_findId(String id) {
        int supplier_id=Integer.parseInt(id);
         String sql = "select * from Supplier where id=?";
          Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        //获取连接
        con = DBConnection.getConnection();
        Supplier s=null;
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,supplier_id);
           rs = pst.executeQuery();//执行查询 
           while(rs.next()){
           s=new Supplier();
           s.setId(rs.getInt("Id"));
           s.setSimpleName(rs.getString("Simple_Name"));
           return s;
           }
        }catch(Exception ex){
        ex.getStackTrace();
        }
        return s;
    }
    public Supplier LGZ_findSimple(String Simple) {
        
         String sql = "select * from Supplier where Simple_Name=?";
          Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        //获取连接
        con = DBConnection.getConnection();
        Supplier s=null;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1,Simple);
           rs = pst.executeQuery();//执行查询 
           while(rs.next()){
           s=new Supplier();
           s.setId(rs.getInt("Id"));
           s.setSimpleName(rs.getString("Simple_Name"));
           return s;
           }
        }catch(Exception ex){
        ex.getStackTrace();
        }
        return s;
    }
}
