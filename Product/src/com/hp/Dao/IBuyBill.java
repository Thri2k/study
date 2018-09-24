/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hp.Dao;

import com.hp.Po.BuyBill;
import java.sql.Date;

import java.util.List;

/**
 *
 * @author 苏宪时
 */
public interface IBuyBill {

    public List<BuyBill> getBuyBill(String str);
       public BuyBill SxS_findId(int buyId,String goodsId);
  public int SxS_DeleteNum(int buyId, String goodsId,int num);  
    public int addBill(BuyBill b);
    public BuyBill LGZ_findId(String defineId, String buyName);
    public int LGZ_Update(BuyBill b,int number,Date dd);  
      public List<BuyBill> getBuyBill_BuyName(String str);
     public List<BuyBill> getBuyBill_Supplier(String str);
      public List<BuyBill> getBuyBill_Customer(String str);
      public List getProduct(String Search,String b,String d);
     public List saleGoods(String search,Date time1,Date time2);
}
