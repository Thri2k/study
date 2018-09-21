/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hp.Util;

import com.hp.Po.User;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;

/**
 * 工厂模式，生成内部窗体
 * @author yhy
 */
public class FrameUtil2 {
    //存放已生成的内部窗体
    public static HashMap<String,JInternalFrame> framemap = 
                    new HashMap<String,JInternalFrame>();
    /**
     * 根据指定的键值生成对应的内部窗体对象
     * @param framekey  窗体的键值
     * @return   内部窗体对象
     * 
     */
    public static JInternalFrame buildFrame(Class clazz){
        JInternalFrame  inFrame = null;//初始化内部窗体
        if(framemap.containsKey(clazz.getName())==true){
             //已经存
            inFrame = framemap.get(clazz.getName());
        }else{
            try {
                //集合中没有（java的反射）
                inFrame = (JInternalFrame) clazz.newInstance();
                
            } catch (InstantiationException ex) {
                Logger.getLogger(FrameUtil2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(FrameUtil2.class.getName()).log(Level.SEVERE, null, ex);
            }
                //添加到集合(类名，内部窗体对象)
                framemap.put(clazz.getName(), inFrame);
            
        }
        return inFrame;
    }
    
}
