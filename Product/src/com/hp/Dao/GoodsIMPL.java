/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hp.Dao;

import com.hp.Po.Goods;
import com.hp.Util.DBConnection;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
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
 * @author Dr.Thri
 */
public class GoodsIMPL  implements IGoods{
    //获取商品信息
    @Override
    public List<Goods> Thri_getGoods() {
          List<Goods> list = new ArrayList<Goods>();
        String sql = "select * from goods";
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
               Goods g = new Goods();
               g.setId(rs.getInt(1));
               g.setDefineId(rs.getString(2));
               g.setGoodsName(rs.getString(3));
               g.setGoodsType(rs.getString(4));
               g.setSafeNum(rs.getString(5));
               g.setAdviceBuyPrice(rs.getString(6));
               g.setAdviceSalePrice(rs.getString(7));
               g.setPresentNumber(rs.getString(8));   
               g.setInTime(rs.getString(9));
               g.setOutTime(rs.getString(10));
               g.setOwnerId(rs.getInt(11));
               list.add(g);         
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
    public boolean Thri_findByGoods(Goods g) {
       String sql = "select * from goods where Goods_Name=? ";
       Connection con = null;
       PreparedStatement pst = null;
       ResultSet rs = null;
       con = DBConnection.getConnection();
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, g.getGoodsName());
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
   public int Thri_findByGoodsId(String Define_Id,String Buy_Name) {
       String sql = "select * from goods where Goods_Name=? and Define_Id=?";
       Connection con = null;
       PreparedStatement pst = null;
       ResultSet rs = null;
       con = DBConnection.getConnection();
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, Buy_Name);
             pst.setString(2, Define_Id);
            rs = pst.executeQuery();
            while(rs.next()){
                return rs.getInt("Id");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
         finally
        {
            DBConnection.close(con, pst, rs);
        }
       return -1;
       
    }
    @Override
    public int Thri_addGoods(Goods g) {
        String sql = "insert into goods(Define_Id,Goods_Name,Goods_Type,Safe_Num,Advice_Buy_Price,Advice_Sale_Price,Present_Number,Owner_Id) values (?,?,?,?,?,?,?,?)";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs =null;
        int result = 0;
        con = DBConnection.getConnection();
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, g.getDefineId());
            pst.setString(2, g.getGoodsName());
            pst.setString(3, g.getGoodsType());
            pst.setString(4, g.getSafeNum());
            pst.setString(5, g.getAdviceBuyPrice());
            pst.setString(6, g.getAdviceSalePrice());
            pst.setString(7, g.getPresentNumber());
            pst.setInt(8, g.getOwnerId());
            
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
    public int Thri_updateGoods(Goods g) {
       String sql="update goods set Goods_Type=?,Safe_Num=?,Advice_Buy_Price=?,Advice_Sale_Price=?,Present_Number=? where Goods_Name=?";
       Connection con=null;
       PreparedStatement pst=null;
       ResultSet rs = null;
       int result=0;
       con=DBConnection.getConnection();
        try {
            pst=con.prepareStatement(sql);
            pst.setString(1, g.getGoodsType());
            pst.setString(2, g.getSafeNum());
            pst.setString(3, g.getAdviceBuyPrice());
            pst.setString(4, g.getAdviceSalePrice());
            pst.setString(5, g.getPresentNumber());
            pst.setString(6,g.getGoodsName());
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
     public int Thri_updateGoodsId(Date date,int id) {
       String sql="update goods set In_Time=? where Id=?";
       Connection con=null;
       PreparedStatement pst=null;
       ResultSet rs = null;
       int result=0;
       con=DBConnection.getConnection();
        try {
            pst=con.prepareStatement(sql);
            pst.setDate(1,date);
            pst.setInt(2, id);
           
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
 public int Thri_updateGoodsOId(Date date,int id) {
       String sql="update goods set Out_Time=? where Id=?";
       Connection con=null;
       PreparedStatement pst=null;
       ResultSet rs = null;
       int result=0;
       con=DBConnection.getConnection();
        try {
            pst=con.prepareStatement(sql);
            pst.setDate(1,date);
            pst.setInt(2, id);
           
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
    public int Thri_deletegoods(String name) {
         String sql="delete from goods where Goods_Name=?";
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
   
    @Override
    public Goods findByGoods(String defineId,String goodsName) {
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       String sql = "select * from goods where Define_Id=? and Goods_Name = ?";
       Connection con = null;
       PreparedStatement pst = null;
       ResultSet rs = null;
       con = DBConnection.getConnection();
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, defineId);
            pst.setString(2,goodsName);
            rs = pst.executeQuery();
            while(rs.next()){
                Goods g=new Goods();
                g.setDefineId(defineId);
                g.setGoodsName(goodsName);
                g.setGoodsType(rs.getString("Goods_Type"));
                g.setPresentNumber(rs.getString("Present_Number"));
                g.setOwnerId(rs.getInt("Owner_Id"));
                g.setAdviceSalePrice(rs.getString("Advice_Sale_Price"));
                return g;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       return null;
    }
    @Override
    public List<Goods> getGoods(String str) {
        List<Goods> list = new ArrayList<Goods>();
        String sql = "select * from goods where concat(Define_Id,Goods_Name,Goods_Type) like ?";
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
               Goods p = new Goods();
               p.setId(rs.getInt("Id"));
               p.setDefineId(rs.getString("Define_Id"));
               p.setGoodsName(rs.getString("Goods_Name"));
               p.setGoodsType(rs.getString("Goods_Type"));
               p.setPresentNumber(rs.getString("Present_Number"));
               p.setAdviceSalePrice(rs.getString("Advice_Sale_Price"));
                System.out.println("Id"+rs.getInt("Id"));
                 System.out.println("Id"+rs.getString("Define_Id"));
                  System.out.println("Goods_Name"+rs.getString("Goods_Name"));
                   System.out.println("Goods_Type"+rs.getString("Goods_Type"));
                    System.out.println("Present_Number"+rs.getString("Present_Number"));
                    System.out.println("Advice_Sale_Price"+rs.getString("Advice_Sale_Price"));
               list.add(p);
           
           }
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
        
        return list;
    }
    
    public Goods getGoods1(String defineId,String goodsName) {
        //List<Goods> list = new ArrayList<Goods>();
        String sql = "select * from goods where Define_Id=? and Goods_Name=?";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        //获取连接
        con = DBConnection.getConnection();
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1,defineId);
              pst.setString(2,goodsName);
           rs = pst.executeQuery();//执行查询 
           while(rs.next()){
               Goods g = new Goods();
               //g.setId(rs.getInt(1));
               g.setDefineId(rs.getString("Define_Id"));
               g.setGoodsName(rs.getString("Goods_Name"));
               g.setGoodsType(rs.getString("Goods_Type"));
               g.setPresentNumber(rs.getString("Present_Number"));
               g.setAdviceBuyPrice(rs.getString("Advice_Buy_Price"));
               g.setOwnerId(rs.getInt("Owner_Id"));
               return(g);
           
           }
        } catch (SQLException ex) {
          ex.printStackTrace();
        }finally{
            DBConnection.close(con, pst, rs);
        }
        
        
        return null;
    }
     
    public List<Goods> LGZ_getGoods(String str) {
        List<Goods> list = new ArrayList<Goods>();
        String sql = "select * from goods where concat(Define_Id,Goods_Name,Goods_Type) like ?";
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
               Goods g = new Goods();
               //g.setId(rs.getInt(1));
               g.setDefineId(rs.getString("Define_Id"));
               g.setGoodsName(rs.getString("Goods_Name"));
               g.setGoodsType(rs.getString("Goods_Type"));
               g.setPresentNumber(rs.getString("Present_Number"));
               g.setAdviceBuyPrice(rs.getString("Advice_Buy_Price"));
               list.add(g);
           
           }
        } catch (SQLException ex) {
          ex.printStackTrace();
        }finally{
            DBConnection.close(con, pst, rs);
        }
        
        
        return list;
    }
    
     @Override
    public List searchGoods(String search, String b) {
        List<Goods> list=new ArrayList<Goods>();
        String sql = null;
        if(b.equals("按名称")){
            sql="select * from goods where Goods_Name = ?";
            
        } 
        if(b.equals("按编号")){
           sql="select * from goods where Define_Id = ?";
        } 
         Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        //获取连接
        con = DBConnection.getConnection();
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, search);
           rs = pst.executeQuery();//执行查询 
           while(rs.next()){
               Goods p = new Goods();
               p.setDefineId(rs.getString(2));
               p.setGoodsName(rs.getString(3));
               p.setPresentNumber(rs.getString(8));
               p.setSafeNum(rs.getString(5));
               p.setAdviceBuyPrice(rs.getString(6));
               p.setInTime(rs.getString(9));
               p.setAdviceSalePrice(rs.getString(7));
               p.setOutTime(rs.getString(10));
               list.add(p);
           
           }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return list;
    }
    public static void printGoods(List<Goods> psalelist, File file) {
        String pname = "商品编号";
        String firstmonth = "商品名称";
        String secondmonth = "当前库存";
        String thirdmonth = "安全库存";
        String fourthmonth="建议采购价";
        String fifthmonth="最近采购日期";
        String sixthmonth="建议销售价";
        String seventhmonth="最近销售日期";
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
            sheet1.setColumnView(5, 20);
            sheet1.setColumnView(6, 20);
            sheet1.setColumnView(7, 20);
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
            Label labelFifthmonth= new Label(5, 0, fifthmonth, format);
            Label labelSixthmonth= new Label(6, 0, sixthmonth, format);
            Label labelSeventhmonth= new Label(7, 0, seventhmonth, format);
            //添加列名
            sheet1.addCell(labelPname); //sheet对象添加文本的数据类型为Label
            sheet1.addCell(labelFirstmonth);
            sheet1.addCell(labelSecondmonth);
            sheet1.addCell(labelThirdmonth);
            sheet1.addCell(labelFourthmonth);
            sheet1.addCell(labelFifthmonth);
            sheet1.addCell(labelSixthmonth);
            sheet1.addCell(labelSeventhmonth);
            //4 =====================取出List集合中的的内容，放到Excel中
            int row = psalelist.size();//获取集合的长度作为表格的行数
            for (int i = 0; i < row; i++) {
                //获取每一行数据，从第一行开始，第0行是标题
                Label pname1 = new Label(0, i+1, psalelist.get(i).getDefineId(), format1);
                Label firstmonth1 = new Label(1, i+1, psalelist.get(i).getGoodsName().toString(), format1);
                Label secondmonth1 = new Label(2, i+1, psalelist.get(i).getPresentNumber().toString(), format1);
                Label thirdmonth1 = new Label(3, i+1, psalelist.get(i).getSafeNum().toString(), format1);
                Label fourthmonth1=new Label(4, i+1, psalelist.get(i).getAdviceBuyPrice().toString(), format1);
                Label fifthmonth1=new Label(5, i+1, psalelist.get(i).getInTime().toString(), format1);
                Label sixthmonth1=new Label(6, i+1, psalelist.get(i).getAdviceSalePrice().toString(), format1);
                Label seventhmonth1=new Label(7, i+1, psalelist.get(i).getOutTime().toString(), format1);
                //添加每一行内容
                sheet1.addCell(pname1);
                sheet1.addCell(firstmonth1);
                sheet1.addCell(secondmonth1);
                sheet1.addCell(thirdmonth1);
                sheet1.addCell(fourthmonth1);
                sheet1.addCell(fifthmonth1);
                sheet1.addCell(sixthmonth1);
                sheet1.addCell(seventhmonth1);
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
