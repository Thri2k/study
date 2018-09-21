/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hp.Dao;

import com.hp.Po.Client;
import com.hp.Po.SaleBill;
import com.hp.Util.DBConnection;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
 * @author Muggle
 */
public class ClientIMPL implements IClient{

    @Override
    public List<Client> getClient(String str) {
        List<Client> list = new ArrayList<Client>();
        String sql = "select * from client where concat(Client_Id,Client_Name,Mobile_Phone,Delivery_Address) like ?";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        con =DBConnection.getConnection();
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, "%"+str+"%");
            rs = pst.executeQuery();
            while(rs.next()){
                Client c = new Client();
                c.setClientId(rs.getString(3));
                c.setClientName(rs.getString(4));
                c.setTaobaoId(rs.getString(5));
                c.setPhone(rs.getString(6));
                c.setMobilePhone(rs.getString(7));
                c.setDeliveryAddress(rs.getString(8));
                c.setPost(rs.getString(9));
                c.setBuyTime(rs.getString(10));
                list.add(c);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            DBConnection.close(con, pst, rs);
        }
        return list;
    }

    @Override
    public boolean findByClient(Client c) {
        String sql = "select * from client where Client_Id = ?";
        Connection con =null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        con = DBConnection.getConnection();
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, c.getClientId());
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
    public int addClient(Client c) {
        String sql = "insert into client(Client_Id,Client_Name,TaoBao_Id,Phone,Mobile_Phone,Delivery_Address,Post) values(?,?,?,?,?,?,?)";
        Connection con =null;
        PreparedStatement pst = null;
        int result = 0;
        con = DBConnection.getConnection();
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, c.getClientId());
            pst.setString(2, c.getClientName());
            pst.setString(3, c.getTaobaoId());
            pst.setString(4, c.getPhone());
            pst.setString(5, c.getMobilePhone());
            pst.setString(6, c.getDeliveryAddress());
            pst.setString(7, c.getPost());
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
    public int deleteClient(String clientid) {
        String sql = "delete from client where Client_Id = ?";
        Connection con =null;
        PreparedStatement pst = null;
        int result = 0;
        con = DBConnection.getConnection();
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, clientid);
            result = pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            DBConnection.close(con, pst);
        }
        return result;
    }

    @Override
    public int updateClient(Client c) {
        String sql = "update client set Client_Name = ?,TaoBao_Id = ?,Phone = ?,Mobile_Phone = ?,Delivery_Address = ?,Post = ? where Client_Id = ?";
        Connection con = null;
        PreparedStatement pst = null;
        int result = 0;
        con = DBConnection.getConnection();
        try {
            pst = con.prepareStatement(sql);
            
            pst.setString(1, c.getClientName());
            pst.setString(2, c.getTaobaoId());
            pst.setString(3, c.getPhone());
            pst.setString(4, c.getMobilePhone());
            pst.setString(5, c.getDeliveryAddress());
            pst.setString(6, c.getPost());
            pst.setString(7, c.getClientId());
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
    public List searchClient(String str) {
        List<SaleBill> list=new ArrayList<SaleBill>();
        String sql=null;
        if(str=="一"){
            sql="select * from sale_bill where Sale_Time BETWEEN '2018-01-01' AND '2018-03-31' order by Sale_Price";
        }
        if(str=="二"){
            sql="select * from sale_bill where Sale_Time BETWEEN '2018-04-01' AND '2018-06-30' order by Sale_Price";
        }
        if(str=="三"){
            sql="select * from sale_bill where Sale_Time BETWEEN '2018-07-01' AND '2018-09-30' order by Sale_Price ";
        }
        if(str=="四"){
            sql="select * from sale_bill where Sale_Time BETWEEN '2018-10-01' AND '2018-12-31' order by Sale_Price ";
        }
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        //获取连接
        con = DBConnection.getConnection();
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
               SaleBill p = new SaleBill();
               p.setClientId(rs.getString(8));
               p.setClientName(rs.getString(9));
               p.setSalePrice(rs.getString(7));
               list.add(p);
           
           }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return list;
    }
    public static void printClient(List<SaleBill> psalelist, File file){
        String pname = "客户编号";
        String firstmonth = "客户简称";
        String secondmonth = "交易金额";;
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
            //添加列名
            sheet1.addCell(labelPname); //sheet对象添加文本的数据类型为Label
            sheet1.addCell(labelFirstmonth);
            sheet1.addCell(labelSecondmonth);
            //4 =====================取出List集合中的的内容，放到Excel中
            int row = psalelist.size();//获取集合的长度作为表格的行数
            for (int i = 0; i < row; i++) {
                //获取每一行数据，从第一行开始，第0行是标题
                Label pname1 = new Label(0, i+1, psalelist.get(i).getClientId(), format1);
                Label firstmonth1 = new Label(1, i+1, psalelist.get(i).getClientName().toString(), format1);
                Label secondmonth1 = new Label(2, i+1, psalelist.get(i).getSalePrice().toString(), format1);
                //添加每一行内容
                sheet1.addCell(pname1);
                sheet1.addCell(firstmonth1);
                sheet1.addCell(secondmonth1);
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
