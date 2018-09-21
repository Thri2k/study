/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hp.Dao;

import com.hp.Po.Staff;
import java.util.List;

/**
 *
 * @author Muggle
 */
public interface IStaff {

    public List<Staff> getStaff(String str);

    public boolean findByStaff(Staff s);

    public int addStaff(Staff s);

    public int updateStaff(Staff s);

    public int deleteStaff(String sid,String staffName);
    
}
