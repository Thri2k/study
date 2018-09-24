/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hp.Dao;

import com.hp.Po.User;


public interface IUser {
     public boolean findByUser(User u);

    public int addUser(User user);

    public int checkUser(User user);
}
