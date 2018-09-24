/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hp.Dao;

import com.hp.Po.Goods;
import com.hp.Po.SaleBill;
import com.hp.Po.Supplier;
import com.hp.Util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 苏宪时
 */
public class SaleBillIMPL implements ISaleBill{
     public int  addSaleBill(SaleBill sb)
     {
         
        String sql = "insert into sale_bill(Sale_Id,Goods_Id,Goods_Name,Count,Sale_Number,Sale_Price,Client_Id,Client_Name,Sale_Time,Supplier_Id,Simple_Name) values(?,?,?,?,?,?,?,?,?,?,?)";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        //获取连接
        con = DBConnection.getConnection();
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, sb.getSaleId());
            pst.setString(2, sb.getGoodsId());
            pst.setString(3,sb.getGoodsName());
            
            pst.setString(4, sb.getCount());
            pst.setString(5, sb.getSaleNumber());
            pst.setString(6, sb.getSalePrice());
            pst.setString(7, sb.getClientId());
             
            pst.setString(8, sb.getClientName());
          
            
            pst.setDate(9, sb.getSaleTime());
           pst.setString(10, sb.getSupplierId());
           pst.setString(11,sb.getSimpleName());
               
            
            pst.execute();//执行查询 
            return 1;
           
          
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        return 0;
       
     }

    @Override
    public String querySupplier(SaleBill sb) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String sql = "select * from client where Client_Id = ?";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        //获取连接
        con = DBConnection.getConnection();
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, sb.getClientId());
            System.out.println("id="+sb.getClientId());
           rs = pst.executeQuery();//执行查询 
           while(rs.next()){
               String ClientName =rs.getString("Client_Name");
               System.out.println("ok="+ClientName );
               return ClientName;
           }
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        return null;
    }

    @Override
    public String queryClientId(SaleBill sb) {
        String sql = "select * from goods where Define_Id = ?";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        //获取连接
        con = DBConnection.getConnection();
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, sb.getGoodsId());
           rs = pst.executeQuery();//执行查询 
           while(rs.next()){
               String SupplierId =rs.getString(11);
               return SupplierId;
           }
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        return null;
    }

    @Override
    public String queryClientSimpleName(SaleBill sb) {
        String sql = "select * from supplier where Supplier_Id = ?";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        //获取连接
        con = DBConnection.getConnection();
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, sb.getSupplierId());
           rs = pst.executeQuery();//执行查询 
           while(rs.next()){
               String SupplierSimpleName =rs.getString(3);
               return SupplierSimpleName;
           }
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
       return null;
    }

    @Override
    public void LWDealGoods(SaleBill sb) {
        String sql = "update  goods set Present_Number= ? where Define_Id = ?";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        //获取连接
        con = DBConnection.getConnection();
        try {
            pst = con.prepareStatement(sql);
            
            pst.setString(1, sb.getCount());
            pst.setString(2,sb.getGoodsId());
            pst.executeUpdate();
           
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
    }

    @Override
    public int countSaleNum() {
        int num=99;
        String sql = "select * from sale_bill";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        //获取连接
        con = DBConnection.getConnection();
        try {
             pst = con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next())
            {
                ++num;
            }
            return num;
           
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        return num;
    }

    @Override
    public void addDateTime(SaleBill sb) {
        String sql = "update  client set Buy_Time =? where Client_Id =?";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        //获取连接
        con = DBConnection.getConnection();
        try {
             pst = con.prepareStatement(sql);
             pst.setString(2, sb.getClientId());
             pst.setDate(1,sb.getSaleTime());
            
            pst.execute();
           
           
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
    }
    //yangshuai
    @Override
    public List<SaleBill> getSaleBill(String str) {
        List<SaleBill> list = new ArrayList<SaleBill>();
       String sql = "Select * from sale_bill where concat(Sale_Id,Goods_Name,Client_Id,Client_Name) like ?";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        //获取链接
         con = DBConnection.getConnection();
         
        try {
            pst = con.prepareStatement(sql); //pst 用来过渡 "%"+str+"%" 即为 “？”
            pst.setString(1, "%"+str+"%");   //str 之前文本框中输入的查询内容
            rs = pst.executeQuery();//执行查询 
            while(rs.next()){
               SaleBill p = new SaleBill();
               p.setSaleId(rs.getString(2));
               p.setGoodsId(rs.getString(3));
               p.setGoodsName(rs.getString(4));
               p.setSaleNumber(rs.getString(6));
               p.setSalePrice(rs.getString(7));
               p.setClientId(rs.getString(8));
               p.setClientName(rs.getString(9));
               p.setSaleTime(rs.getDate(10));
               
               System.out.println();
               
               list.add(p);
           
           }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        
       return list;
    }


    public int Reaturn(String SaleId,String SaleNumber,String ReaturnNumber) {
        int ReturnNumber=Integer.parseInt(ReaturnNumber);
        int SaleNumberInt = Integer.parseInt(SaleNumber);
        if(ReturnNumber>SaleNumberInt)
        {
            return -1;
        }
        int saveNum=SaleNumberInt-ReturnNumber;
        String saveNumString = String.valueOf(saveNum);
       String sql = "update sale_bill set sale_number = ? where sale_id = ?";
       Connection con = null;
       PreparedStatement pst = null;
       ResultSet rs = null;
       int result = 0;
       con = DBConnection.getConnection();
        try {
            pst= con.prepareStatement(sql);
            pst.setString(1,saveNumString);
            pst.setString(2, SaleId);
            
            result = pst.executeUpdate();
            
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return result;
    }
    
     @Override
    public int addGoodPresentNum(String ReaturnNumber,String GoodsId) {
        
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    String sql = "select * from goods where Define_Id = ? ";
        System.out.println(sql);
       Connection con = null;
       PreparedStatement pst = null;
       ResultSet rs = null;
       int result = 0;
       int presentGoodsNumInt=0;
        String presentGoodsNum=null;
       con = DBConnection.getConnection();
        try {
           
            pst= con.prepareStatement(sql);
            
            pst.setString(1,GoodsId);
            
             
              rs = pst.executeQuery();//执行查询 
              while(rs.next()){
                    presentGoodsNum = rs.getString("Present_Number");
              }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        System.out.println("111111"+presentGoodsNum);
        presentGoodsNumInt =Integer.valueOf(presentGoodsNum);
        int ReturnNumber=Integer.valueOf(ReaturnNumber);
       System.out.println("presentGoodsNumInt="+presentGoodsNumInt);
       System.out.println("ReturnNumber="+ReturnNumber);
        int totalNumberInt =presentGoodsNumInt+ReturnNumber;
        String totalNumber = String.valueOf(totalNumberInt);
         System.out.println("totalNumber="+totalNumber);
         String sql2 = "update goods set Present_Number = ? where Define_Id = ?";
         try {
             pst= con.prepareStatement(sql2);
             pst.setString(1,totalNumber);
             pst.setString(2,GoodsId);
             pst.executeUpdate();
         } catch (SQLException ex) {
             ex.printStackTrace();
         }
          
        return 1;
    }
    //lihao
    public List<SaleBill> getLIHAOSaleBill(String str) {
        List<SaleBill> list = new ArrayList<SaleBill>();
        String sql = "select * from sale_bill where concat(Goods_Name,Client_Name,Sale_Time) like ?";
 
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        //获取连接
        con = DBConnection.getConnection();
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, "%"+str+"%");
           rs = pst.executeQuery();//执行查询 
           while(rs.next()){
               SaleBill p = new SaleBill();
               p.setSaleId(rs.getString("Sale_Id"));
               p.setGoodsName(rs.getString("Goods_Name"));
               p.setSaleNumber(rs.getString("Sale_Number"));
               p.setSalePrice(rs.getString("Sale_Price"));
               p.setClientName(rs.getString("Client_Name"));
               p.setSaleTime(rs.getDate("Sale_Time"));
               
               
               
               
               System.out.print(p.getSaleTime());
               list.add(p);
             
           }
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return list;
    }

   
  
    
}
