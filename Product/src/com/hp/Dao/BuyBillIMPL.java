/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hp.Dao;


import com.hp.Po.BuyBill;

import com.hp.Po.SupplierManagement;
import com.hp.Util.DBConnection;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.Date;
import java.util.List;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.ScriptStyle;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
/**
 *
 * @author 苏宪时
 */
public class BuyBillIMPL implements IBuyBill{

    @Override
    public List<BuyBill> getBuyBill(String str) {
        List<BuyBill> list = new ArrayList<BuyBill>();
        String sql = "select * from buy_bill where concat(Define_Id,Supplier) like ?";
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
               BuyBill p = new  BuyBill();
           
               p.setBuyId(rs.getInt("Buy_Id"));
               p.setDefineId(rs.getString("Define_Id"));
               p.setBuyName(rs.getString("Buy_Name"));
               p.setBuyNum(rs.getString("Buy_Num"));
               p.setBuyPrice(rs.getString("Buy_Price"));
               p.setSupplier(rs.getString("Supplier"));
               p.setBuyTime(rs.getDate("Buy_Time"));
              
               list.add(p);
           
           }
        } catch (Exception ex) {
          ex.printStackTrace();
        }
        finally{
        DBConnection.close(con, pst, rs);
        
        }
        
        return list;
    }
    public BuyBill SxS_findId(int buyId, String goodsId) {
       String sql = "select * from buy_bill where Buy_Id= ? and Define_Id=?";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        //获取连接
        con = DBConnection.getConnection();
           try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,buyId);
             pst.setString(2,goodsId);
           rs = pst.executeQuery();//执行查询 
           while(rs.next()){
               BuyBill p = new  BuyBill();
               
               p.setBuyId(rs.getInt(1));
               p.setDefineId(rs.getString(2));
               p.setBuyName(rs.getString("Buy_Name"));
               p.setBuyNum(rs.getString("Buy_Num"));
               p.setBuyPrice(rs.getString("Buy_Price"));
               p.setSupplier(rs.getString("Supplier"));
               p.setBuyTime(rs.getDate("Buy_Time"));
              
            
           return p;
           }
        } catch (Exception ex) {
          ex.printStackTrace();
        }
        finally{
        DBConnection.close(con, pst, rs);
        
        }
           return null;
    }    
    public int SxS_DeleteNum(int buyId, String goodsId,int num)
    {
      String sql = "select * from buy_bill where Buy_Id= ? and Define_Id=?";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        //获取连接
        con = DBConnection.getConnection();
           try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,buyId);
             pst.setString(2,goodsId);
           rs = pst.executeQuery();//执行查询 
           while(rs.next()){
               BuyBill p = new  BuyBill();
             
               p.setBuyId(rs.getInt(2));
               p.setDefineId(rs.getString(3));
               p.setBuyName(rs.getString("Buy_Name"));
               p.setBuyNum(rs.getString("Buy_Num"));
               p.setBuyPrice(rs.getString("Buy_Price"));
               p.setSupplier(rs.getString("Supplier"));
               p.setBuyTime(rs.getDate("Buy_Time"));
             int number=Integer.parseInt(p.getBuyNum())-num;
             p.setBuyNum(String.valueOf(number));
            String sql2="update buy_bill set Buy_Num=? where Buy_Id=? and Define_Id=?";
            System.out.println("buy_num="+number+"buy_id="+buyId+"define_id="+goodsId);
            pst = con.prepareStatement(sql2);
            pst.setString(1,p.getBuyNum());
            pst.setInt(2,buyId);
             pst.setString(3,goodsId);
             return pst.executeUpdate();
         
           }
        } catch (Exception ex) {
          ex.printStackTrace();
        }
        finally{
        DBConnection.close(con, pst, rs);
        
        }
           return 0;
    }
    
    public int addBill(BuyBill b){                                             //采购数据上传至数据库
        
        String sql = "insert into buy_bill(Define_Id,Buy_Name,Goods_Type,Advice_Buy_Price,Buy_Num,Buy_Price,Supplier,Buy_Time,Customer_Id)  values(?,?,?,?,?,?,?,?,?)";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        //获取连接
        con = DBConnection.getConnection();
         try {
                pst = con.prepareStatement(sql);
                pst.setString(1,b.getDefineId());
                System.out.println(b.getDefineId());
                pst.setString(2,b.getBuyName());
                 //System.out.println(b.getBuyName());
                  //System.out.println(b.getGoodsType());
                 // System.out.println(b.getAdviceBuyPrice());
                  // System.out.println(b.getBuyNum());
                 //   System.out.println(b.getBuyPrice());
                  //   System.out.println(b.getSupplier());
                  //    System.out.println(b.getBuyTime());
                 //     System.out.println(b.getCustomerId());
                      
                  
                pst.setString(3,b.getGoodsType());
                pst.setString(4,b.getAdviceBuyPrice());
                pst.setString(5,b.getBuyNum());
                pst.setString(6,b.getBuyPrice());
                pst.setString(7,b.getSupplier());
                pst.setString(8,b.getBuyTime().toString());
                pst.setInt(9,b.getCustomerId());
          
          if(!pst.execute())
          {
              return 1;
          }
              else return -1;
          
              
           
           
        } catch (SQLException ex) {
          ex.printStackTrace();
        }finally{
            DBConnection.close(con, pst, rs);
        }
        return 0;
    
    
    
    }
     public int LGZ_Update(BuyBill b,int number ,Date dd){                              //增加库存
        
        String sql = "update buy_bill set Buy_Num=? ,Buy_Time=? where Define_Id=? and Buy_Name=?";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        //获取连接
        con = DBConnection.getConnection();
         try {
                pst = con.prepareStatement(sql);
                int numm=Integer.parseInt(b.getBuyNum())+number;
                pst.setString(1,String.valueOf(numm));
                  System.out.println(numm);
                System.out.println(dd);
                pst.setDate(2,dd);
               
                 pst.setString(3,b.getDefineId());
                  System.out.println(b.getDefineId());
                pst.setString(4,b.getBuyName());
         System.out.println(b.getBuyName());
          
         return pst.executeUpdate();
              
           
           
        } catch (SQLException ex) {
          ex.printStackTrace();
        }finally{
            DBConnection.close(con, pst, rs);
        }
        return 0;
    
    
    
    }
    public BuyBill LGZ_findId(String defineId, String buyName) {               //供应商名称查询
       String sql = "select * from buy_bill where Define_Id=? and Buy_Name=?";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        //获取连接
        con = DBConnection.getConnection();
           try {
            pst = con.prepareStatement(sql);
            pst.setString(1,defineId);
            pst.setString(2,buyName);
           rs = pst.executeQuery();//执行查询 
           while(rs.next()){
               BuyBill p = new  BuyBill();
               
               p.setBuyId(rs.getInt(1));
               p.setDefineId(rs.getString(2));
               p.setBuyName(rs.getString("Buy_Name"));
               p.setBuyNum(rs.getString("Buy_Num"));
               p.setBuyPrice(rs.getString("Buy_Price"));
               p.setSupplier(rs.getString("Supplier"));
               p.setBuyTime(rs.getDate("Buy_Time"));
              
            
           return p;
           }
        } catch (Exception ex) {
          ex.printStackTrace();
        }
        finally{
        DBConnection.close(con, pst, rs);
        
        }
           return null;
    }    
    
    
     public List<BuyBill> getBuyBill_BuyName(String str) {
        List<BuyBill> list = new ArrayList<BuyBill>();
        String sql = "select * from buy_bill where Buy_Name = ?";
        
      
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        //获取连接
        con = DBConnection.getConnection();
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1,str);
           rs = pst.executeQuery();//执行查询 
           while(rs.next()){
               BuyBill p = new BuyBill();
               p.setBuyId(rs.getInt("Buy_Id"));
               p.setBuyName(rs.getString("Buy_Name"));
               p.setBuyNum(rs.getString("Buy_Num"));
               p.setBuyPrice(rs.getString("Buy_Price"));
               p.setSupplier(rs.getString("Supplier"));
               p.setBuyTime(rs.getDate("Buy_Time"));
               System.out.print(p.getBuyTime());
               list.add(p);
             
           }
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return list;
    }
    
    
     public List<BuyBill> getBuyBill_Supplier(String str) {
        List<BuyBill> list = new ArrayList<BuyBill>();
        String sql = "select * from buy_bill where Supplier = ?";
        
      
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        //获取连接
        con = DBConnection.getConnection();
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, str);
           rs = pst.executeQuery();//执行查询 
           while(rs.next()){
               BuyBill p = new BuyBill();
               p.setBuyId(rs.getInt("Buy_Id"));
               p.setBuyName(rs.getString("Buy_Name"));
               p.setBuyNum(rs.getString("Buy_Num"));
               p.setBuyPrice(rs.getString("Buy_Price"));
               p.setSupplier(rs.getString("Supplier"));
               p.setBuyTime(rs.getDate("Buy_Time"));
               System.out.print(p.getBuyTime());
               list.add(p);
             
           }
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return list;
    } 
     
     public List<BuyBill> getBuyBill_Customer(String str) {
        List<BuyBill> list = new ArrayList<BuyBill>();
        String sql = "select * from buy_bill where Customer_Id = ?";
        
      
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        //获取连接
        con = DBConnection.getConnection();
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, str);
           rs = pst.executeQuery();//执行查询 
           while(rs.next()){
               BuyBill p = new BuyBill();
               p.setBuyId(rs.getInt("Buy_Id"));
               p.setBuyName(rs.getString("Buy_Name"));
               p.setBuyNum(rs.getString("Buy_Num"));
               p.setBuyPrice(rs.getString("Buy_Price"));
               p.setSupplier(rs.getString("Supplier"));
               p.setBuyTime(rs.getDate("Buy_Time"));
               System.out.print(p.getBuyTime());
               list.add(p);
             
           }
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        return list;
    }
    
     
       public static void printA(List<BuyBill> psalelist, File file) {
        String pname = "商品编号";
        String firstmonth = "商品名称";
        String secondmonth = "采购数量";
        String thirdmonth = "采购金额";
        try {
                //2==============创建excel文件并设置数据显示格式
            WritableWorkbook book = Workbook.createWorkbook(file); //创建特殊类型的变量使之与Excel表格对应以便于操作
            WritableSheet sheet1 = book.createSheet("第一页", 0); //在表格中创建第一页，参数指明页的名称和索引，索引从0开始
            sheet1.setColumnView(0, 20); //设置某一列的宽度
            sheet1.setRowView(0, 400); //设置某一行的高度
            //设置第一行第二列的高度和宽度
            sheet1.setColumnView(1, 20);
            //sheet1.setRowView(1, 500);
            //设置第一行第三列的高度和宽度
            sheet1.setColumnView(2, 20);
            //sheet1.setRowView(2, 500);
            sheet1.setColumnView(3, 20);
            //WritableSheet sheet2 = book.createSheet("第二页", 1); //创建第二页
           //创建字体，7个参数分别是字体名称，字号，是否粗体，是否斜体，下划线，颜色，上下标
            WritableFont font = new WritableFont(WritableFont.TIMES, 13, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.DARK_RED, ScriptStyle.NORMAL_SCRIPT); 
            WritableFont font1 = new WritableFont(WritableFont.TIMES, 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK, ScriptStyle.NORMAL_SCRIPT);
            
            
            WritableCellFormat format = new WritableCellFormat(font); //将字体放入单元格式中

            WritableCellFormat format1 = new WritableCellFormat(font1);
           
            format1.setAlignment(Alignment.CENTRE); //对齐方式的设定

            format.setAlignment(Alignment.CENTRE); //对齐方式的设定
            //3 ============设置第一行为列名,并添加列名
            Label labelPname= new Label(0, 0, pname, format); //写入字符串，确定位置（列，行）、内容和格式
            Label labelFirstmonth = new Label(1, 0, firstmonth, format);
            Label labelSecondmonth = new Label(2, 0,secondmonth, format);
            Label labelThirdmonth= new Label(3, 0, thirdmonth, format);
            //添加列名
            sheet1.addCell(labelPname); //sheet对象添加文本的数据类型为Label
            sheet1.addCell(labelFirstmonth);
            sheet1.addCell(labelSecondmonth);
            sheet1.addCell(labelThirdmonth);
            //4 =====================取出List集合中的的内容，放到Excel中
            int row = psalelist.size();//获取集合的长度作为表格的行数
            for (int i = 0; i < row; i++) {
                //获取每一行数据，从第一行开始，第0行是标题
                Label pname1 = new Label(0, i+1, psalelist.get(i).getDefineId(), format1);
                Label firstmonth1 = new Label(1, i+1, psalelist.get(i).getBuyName().toString(), format1);
                Label secondmonth1 = new Label(2, i+1, psalelist.get(i).getBuyNum().toString(), format1);
                Label thirdmonth1 = new Label(3, i+1, psalelist.get(i).getBuyPrice().toString(), format1);
                //添加每一行内容
                sheet1.addCell(pname1);
                sheet1.addCell(firstmonth1);
                sheet1.addCell(secondmonth1);
                sheet1.addCell(thirdmonth1);
            }
            //5 ===================保存数据，存盘
            book.write();//存盘
            book.close();
        } catch (WriteException ex) {
          ex.printStackTrace();

        } catch (IOException ex) {
           ex.printStackTrace();
        }
    }

    
    @Override
    public List getProduct(String search, String b, String d) {
        List<SupplierManagement> list=new ArrayList<SupplierManagement>();
        String sql = null;
        if(b=="一"){
        if(d=="编号")
        {
           sql="select supplier.*,buy_bill.Buy_Name,buy_bill.Buy_Num,buy_bill.Buy_Price from supplier,buy_bill where buy_bill.Buy_Time BETWEEN '2018-01-01' AND '2018-03-31' and Supplier_Id like ? and supplier.Supplier_Id=buy_bill.Supplier";
        }
        if(d=="简称")
        {
            sql="select supplier.*,buy_bill.Buy_Name,buy_bill.Buy_Num,buy_bill.Buy_Price from supplier,buy_bill where buy_bill.Buy_Time BETWEEN '2018-01-01' AND '2018-03-31' and Simple_Name like ? and supplier.Supplier_Id=buy_bill.Supplier";
        }
        }
        if(b=="二"){
        if(d=="编号")
        {
           sql="select supplier.*,buy_bill.Buy_Name,buy_bill.Buy_Num,buy_bill.Buy_Price from supplier,buy_bill where buy_bill.Buy_Time BETWEEN '2018-04-01' AND '2018-06-30' and Supplier_Id like ? and supplier.Supplier_Id=buy_bill.Supplier";
        }
        if(d=="简称")
        {
            sql="select supplier.*,buy_bill.Buy_Name,buy_bill.Buy_Num,buy_bill.Buy_Price from supplier,buy_bill where buy_bill.Buy_Time BETWEEN '2018-04-01' AND '2018-06-30' and Simple_Name like ? and supplier.Supplier_Id=buy_bill.Supplier";
        }
        }
        if(b=="三"){
        if(d=="编号")
        {
           sql="select supplier.*,buy_bill.Buy_Name,buy_bill.Buy_Num,buy_bill.Buy_Price from supplier,buy_bill where buy_bill.Buy_Time BETWEEN '2018-07-01' AND '2018-09-30' and Supplier_Id like ? and supplier.Supplier_Id=buy_bill.Supplier";
        }
        if(d=="简称")
        {
            sql="select supplier.*,buy_bill.Buy_Name,buy_bill.Buy_Num,buy_bill.Buy_Price from supplier,buy_bill where buy_bill.Buy_Time BETWEEN '2018-07-01' AND '2018-09-30' and Simple_Name like ? and supplier.Supplier_Id=buy_bill.Supplier";
        }
        }
        if(b=="四"){
        if(d=="编号")
        {
           sql="select supplier.*,buy_bill.Buy_Name,buy_bill.Buy_Num,buy_bill.Buy_Price from supplier,buy_bill where buy_bill.Buy_Time BETWEEN '2018-10-01' AND '2018-12-31' and Supplier_Id like ? and supplier.Supplier_Id=buy_bill.Supplier";
        }
        if(d=="简称")
        {
            sql="select supplier.*,buy_bill.Buy_Name,buy_bill.Buy_Num,buy_bill.Buy_Price from supplier,buy_bill where buy_bill.Buy_Time BETWEEN '2018-01-01' AND '2018-03-31' and Simple_Name like ? and supplier.Supplier_Id=buy_bill.Supplier";
        }
        }
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        con = DBConnection.getConnection();
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, "%"+search+"%");
            rs = pst.executeQuery();//执行查询 
             while(rs.next()){
               SupplierManagement p = new SupplierManagement();
               p.setSupplierId(rs.getString(2));
               p.setSimpleName(rs.getString(3));
               p.setBuyName(rs.getString(4));
               p.setBuyNum(rs.getString(7));
               p.setBuyPrice(rs.getString(8));
               list.add(p);
               
           }
             
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
         return list;   
    }

     @Override
    public List saleGoods(String search, Date time1, Date time2) {
       List<BuyBill> list=new ArrayList<BuyBill>();
       String sql=null;
           sql="select * from buy_bill where Buy_Time BETWEEN ? AND ?";
       Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        //获取连接
        con = DBConnection.getConnection();
        try {
            pst = con.prepareStatement(sql);
             pst.setDate(1, (java.sql.Date) time1);
             pst.setDate(2, (java.sql.Date) time2);
            rs = pst.executeQuery();//执行查询 
            while(rs.next()){
               BuyBill p = new BuyBill();
               p.setDefineId(rs.getString(2));
               p.setBuyName(rs.getString(3));
               p.setBuyNum(rs.getString(7));
               p.setBuyPrice(rs.getString(8));
               list.add(p);
               
           }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       return list;
    
    }

    public static void printSale(List<SupplierManagement> psalelist, File file) {
        String pname = "供应商编号";
        String firstmonth = "供应商简称";
        String secondmonth = "商品名称";
        String thirdmonth = "交易数量";
        String fourthmonth="交易金额";
        try {
                //2==============创建excel文件并设置数据显示格式
            WritableWorkbook book = Workbook.createWorkbook(file); //创建特殊类型的变量使之与Excel表格对应以便于操作
            WritableSheet sheet1 = book.createSheet("第一页", 0); //在表格中创建第一页，参数指明页的名称和索引，索引从0开始
            sheet1.setColumnView(0, 20); //设置某一列的宽度
            sheet1.setRowView(0, 400); //设置某一行的高度
            //设置第一行第二列的高度和宽度
            sheet1.setColumnView(1, 20);
            //sheet1.setRowView(1, 500);
            //设置第一行第三列的高度和宽度
            sheet1.setColumnView(2, 20);
            //sheet1.setRowView(2, 500);
            sheet1.setColumnView(3, 20);
            sheet1.setColumnView(4, 20);
            //WritableSheet sheet2 = book.createSheet("第二页", 1); //创建第二页
           //创建字体，7个参数分别是字体名称，字号，是否粗体，是否斜体，下划线，颜色，上下标
            WritableFont font = new WritableFont(WritableFont.TIMES, 13, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.DARK_RED, ScriptStyle.NORMAL_SCRIPT); 
            WritableFont font1 = new WritableFont(WritableFont.TIMES, 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK, ScriptStyle.NORMAL_SCRIPT);
            
            
            WritableCellFormat format = new WritableCellFormat(font); //将字体放入单元格式中

            WritableCellFormat format1 = new WritableCellFormat(font1);
           
            format1.setAlignment(Alignment.CENTRE); //对齐方式的设定

            format.setAlignment(Alignment.CENTRE); //对齐方式的设定
            //3 ============设置第一行为列名,并添加列名
            Label labelPname= new Label(0, 0, pname, format); //写入字符串，确定位置（列，行）、内容和格式
            Label labelFirstmonth = new Label(1, 0, firstmonth, format);
            Label labelSecondmonth = new Label(2, 0,secondmonth, format);
            Label labelThirdmonth= new Label(3, 0, thirdmonth, format);
            Label labelFourthmonth= new Label(4, 0, fourthmonth, format);
            //添加列名
            sheet1.addCell(labelPname); //sheet对象添加文本的数据类型为Label
            sheet1.addCell(labelFirstmonth);
            sheet1.addCell(labelSecondmonth);
            sheet1.addCell(labelThirdmonth);
            sheet1.addCell(labelFourthmonth);
            //4 =====================取出List集合中的的内容，放到Excel中
            int row = psalelist.size();//获取集合的长度作为表格的行数
            for (int i = 0; i < row; i++) {
                //获取每一行数据，从第一行开始，第0行是标题
                Label pname1 = new Label(0, i+1, psalelist.get(i).getSupplierId(), format1);
                Label firstmonth1 = new Label(1, i+1, psalelist.get(i).getSimpleName().toString(), format1);
                Label secondmonth1 = new Label(2, i+1, psalelist.get(i).getBuyName().toString(), format1);
                Label thirdmonth1 = new Label(3, i+1, psalelist.get(i).getBuyNum().toString(), format1);
                Label fourthmonth1=new Label(4, i+1, psalelist.get(i).getBuyPrice().toString(), format1);
                //添加每一行内容
                sheet1.addCell(pname1);
                sheet1.addCell(firstmonth1);
                sheet1.addCell(secondmonth1);
                sheet1.addCell(thirdmonth1);
                sheet1.addCell(fourthmonth1);
            }
            //5 ===================保存数据，存盘
            book.write();//存盘
            book.close();
        } catch (WriteException ex) {
          ex.printStackTrace();

        } catch (IOException ex) {
           ex.printStackTrace();
        }
    }



    
}
