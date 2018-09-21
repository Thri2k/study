/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hp.Dao;

import com.hp.Po.Goods;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Thri
 */
public interface IGoods {
 public int Thri_findByGoodsId(String Define_Id,String Buy_Name);
    public List<Goods> Thri_getGoods();
 public int Thri_updateGoodsId(Date date,int id);
  public int Thri_updateGoodsOId(Date date,int id) ;
    public boolean Thri_findByGoods(Goods g);

    public int Thri_addGoods(Goods g);

    public int Thri_updateGoods(Goods g);

    public int Thri_deletegoods(String name);
    
    public List<Goods> getGoods(String str);
    
    public Goods findByGoods(String defineId,String goodsName);
    public List<Goods> LGZ_getGoods(String str);
     public Goods getGoods1(String defineId,String goodsName);
     public List searchGoods(String search,String b);
}
