/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hp.View.JIF;

import com.hp.Dao.BuyBillIMPL;
import com.hp.Po.BuyBill;

import java.io.File;
import java.sql.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dr.Thri
 */
public class ProcurementStatistics extends javax.swing.JInternalFrame {
    BuyBillIMPL bb = new BuyBillIMPL();

    /**
     * Creates new form ProcurementStatistics
     */
    public ProcurementStatistics() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnName = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtTime1 = new com.hp.Util.DateChooserJButton();
        jLabel3 = new javax.swing.JLabel();
        txtTime2 = new com.hp.Util.DateChooserJButton();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGoods = new javax.swing.JTable();
        btnOut = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("采购统计");

        jLabel1.setText("按");

        btnName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "商品名称", "供应商" }));

        jLabel2.setText("从");

        jLabel3.setText("…");

        btnSearch.setText("汇总");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tblGoods.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "商品编号", "商品名称", "采购数量", "供应商名称"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblGoods);
        if (tblGoods.getColumnModel().getColumnCount() > 0) {
            tblGoods.getColumnModel().getColumn(0).setResizable(false);
            tblGoods.getColumnModel().getColumn(1).setResizable(false);
            tblGoods.getColumnModel().getColumn(2).setResizable(false);
            tblGoods.getColumnModel().getColumn(3).setResizable(false);
        }

        btnOut.setText("打印报表");
        btnOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOutActionPerformed(evt);
            }
        });

        jButton3.setText("退出");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnName, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTime1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTime2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnSearch)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnOut)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(41, 41, 41)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtTime1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtTime2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOut)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        int a=this.btnName.getSelectedIndex();
        String b=this.btnName.getItemAt(a);
        Date time1 = null,time2 = null;
        time1=   new java.sql.Date(txtTime1.getDate().getTime());
        time2=   new java.sql.Date(txtTime2.getDate().getTime());
        List<BuyBill> list= bb.saleGoods(b,time1,time2);
         DefaultTableModel dtm =(DefaultTableModel) this.tblGoods.getModel();
        while(dtm.getRowCount() > 0){
            dtm.removeRow(0);
        }
        for(BuyBill p :list){
            Vector v = new Vector();
            v.add(p.getDefineId());
            v.add(p.getBuyName());
            v.add(p.getBuyNum());
            v.add(p.getBuyPrice());
            dtm.addRow(v);
        }  // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOutActionPerformed
        // TODO add your handling code here:
        int a=this.btnName.getSelectedIndex();
        String b=this.btnName.getItemAt(a);
        Date time1 = null,time2 = null;
        time1=   new java.sql.Date(txtTime1.getDate().getTime());
        time2=   new java.sql.Date(txtTime2.getDate().getTime());
        List<BuyBill> pp = bb.saleGoods(b,time1,time2);
        JFileChooser savefile = new JFileChooser();//文件选择对话框
        
        FileFilter filter = new FileNameExtensionFilter("Excel文件(*.xls)", "xls");
        savefile.addChoosableFileFilter(filter);//添加过滤器
        savefile.setFileFilter(filter);

        int flag = savefile.showSaveDialog(this);//打开文件选选择对话框
        File file = null;
        if (flag == JFileChooser.APPROVE_OPTION) {
        //如果点击了保存按钮
        file = savefile.getSelectedFile();//所选择的文件名（手写或选择）
        System.out.println("文件名：" + file.getAbsolutePath());
        String filename = file.getAbsolutePath();
        //截取文件扩展名（文件名长度后4位）
        String ftype = filename.substring(filename.length()-4);
        if(!ftype.equals(".xls")){
            //如果用户没有填写扩展名，自动添加扩展名.xls
            file = new File(filename+".xls");
        }
        //集合获取数据，输出到文件
        BuyBillIMPL.printA(pp, file);
        }
    }//GEN-LAST:event_btnOutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> btnName;
    private javax.swing.JButton btnOut;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblGoods;
    private com.hp.Util.DateChooserJButton txtTime1;
    private com.hp.Util.DateChooserJButton txtTime2;
    // End of variables declaration//GEN-END:variables
}