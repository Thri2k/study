/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hp.Dao;

import com.hp.Po.SaleBill;
import com.hp.Po.Supplier;
import java.util.List;
import javax.swing.JTextField;

/**
 *
 * @author 苏宪时
 */
public interface ISaleBill {

    public int addSaleBill(SaleBill sb);

    public String querySupplier(SaleBill sb);

    

    public String queryClientSimpleName(SaleBill sb);

    public String queryClientId(SaleBill sb);

    public void LWDealGoods(SaleBill sb);

    public int countSaleNum();

    public void addDateTime(SaleBill sb);
    
    public List<SaleBill> getSaleBill(String str);

    public int Reaturn(String SaleId,String SaleNumber,String ReaturnNumber);
    
    public List<SaleBill> getLIHAOSaleBill(String str);

   

    public int addGoodPresentNum(String ReaturnNumber, String GoodsId);

    
    
}
