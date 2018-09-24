/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hp.Util;

/**
 *
 * @author Administrator
 */
public class StringUtile {
     //1 为空验证
    public static boolean validateNull(String s){
        if(s == "" ||s.length() == 0){
            return false;
        }else{
            return true;
        }
    }
    //2 数字格式
    public static boolean validateDigit(String s){
        //验证数字
        String regex = "^(\\d+)|(\\d+\\.\\d+)$";
        if(s.matches(regex)){
            return true;
        }else{
            return false;
        }
    }
    //3 其他，手机号，邮箱
    
    public static void main(String[] args) {
        String s = "1232";
        System.out.println(validateDigit(s));
    }
    
}
