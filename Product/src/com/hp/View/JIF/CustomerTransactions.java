/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hp.View.JIF;

import com.hp.Dao.BuyBillIMPL;
import com.hp.Dao.ClientIMPL;
import com.hp.Po.SaleBill;
import com.hp.Po.SupplierManagement;
import java.io.File;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;
import javax.swing.AbstractButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dr.Thri
 */
public class CustomerTransactions extends javax.swing.JInternalFrame {
    ClientIMPL bb = new ClientIMPL();

    /**
     * Creates new form CustomerTransactions
     */
    public CustomerTransactions() {
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

        btnSearch = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnTime = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        btnOut = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Top10客户历史交易记录");

        btnSearch.setText("查询");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel1.setText("第");

        btnTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "一", "二", "三", "四" }));

        jLabel2.setText("季度");

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "客户编号", "客户简称", "交易金额"
            }
        ));
        jScrollPane1.setViewportView(tblProduct);

        btnOut.setText("打印报表");
        btnOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOutActionPerformed(evt);
            }
        });

        jButton3.setText("关闭");
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(31, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnSearch)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTime, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addGap(123, 123, 123))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnOut)
                                .addGap(28, 28, 28)
                                .addComponent(jButton3)
                                .addGap(62, 62, 62))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(jLabel1)
                    .addComponent(btnTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOut)
                    .addComponent(jButton3))
                .addGap(25, 25, 25))
        );

        getAccessibleContext().setAccessibleName("Top10 客户历史交易记录");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        int a=this.btnTime.getSelectedIndex();
        String b=this.btnTime.getItemAt(a);
        List<SaleBill> list= bb.searchClient(b);       
        DefaultTableModel dtm =(DefaultTableModel) this.tblProduct.getModel();
        while(dtm.getRowCount() > 0){
            dtm.removeRow(0);       
        }
        for(SaleBill p :list){
            Vector v = new Vector();
            v.add(p.getClientId());
            v.add(p.getClientName());
            v.add(p.getSalePrice());
            dtm.addRow(v);
        } 
        
    }//GEN-LAST:event_btnSearchActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOutActionPerformed
        // TODO add your handling code here:
        int a=this.btnTime.getSelectedIndex();
        String b=this.btnTime.getItemAt(a);
        List<SaleBill> pp = bb.searchClient(b);
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
        ClientIMPL.printClient(pp, file);
    }//GEN-LAST:event_btnOutActionPerformed
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOut;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> btnTime;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProduct;
    // End of variables declaration//GEN-END:variables
}
