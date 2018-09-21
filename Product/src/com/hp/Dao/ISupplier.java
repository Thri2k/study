/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hp.Dao;

import com.hp.Po.Supplier;
import java.util.List;

/**
 *
 * @author 苏宪时
 */
public interface ISupplier {

    public Supplier SxS_findId(String id);
    public boolean Thri_findBySupplier(Supplier s);
      public int Thri_addSupplier(Supplier s) ;
       public List<Supplier> Thri_getSipplier() ;
        public int Thri_updateSupplier(Supplier s);
         public int Thri_deleteSupplier(String name);
             public Supplier LGZ_findId(String id) ;
              public boolean Thri_findBySupplierId(int s);
               public Supplier LGZ_findSimple(String Simple);
}
