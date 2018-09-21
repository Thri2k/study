/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hp.View.JIF;

import com.hp.Dao.BuyBillIMPL;
import com.hp.Dao.IBuyBill;
import com.hp.Po.BuyBill;
import com.hp.Util.StringUtile;
import java.sql.Date;


import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dr.Thri
 */
public class PurchaseSearch extends javax.swing.JInternalFrame {
IBuyBill ipd=new BuyBillIMPL();
    /**
     * Creates new form PurchaseSearch
     */
    public PurchaseSearch() {
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

        dateChooserJButton1 = new com.hp.Util.DateChooserJButton();
        jTextField1 = new javax.swing.JTextField();
        dateChooserJButton2 = new com.hp.Util.DateChooserJButton();
        btnSelect = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBuyBill = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("采购查询");

        jTextField1.setText("-");

        btnSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "商品名称", "供应商名称", "入库操作员" }));

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        btnSearch.setText("查询");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tblBuyBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "采购单号", "采购商品名", "采购数量", "采购价格", "供应商", "采购时间"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBuyBill.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblBuyBill);
        if (tblBuyBill.getColumnModel().getColumnCount() > 0) {
            tblBuyBill.getColumnModel().getColumn(0).setResizable(false);
            tblBuyBill.getColumnModel().getColumn(1).setResizable(false);
            tblBuyBill.getColumnModel().getColumn(2).setResizable(false);
            tblBuyBill.getColumnModel().getColumn(3).setResizable(false);
            tblBuyBill.getColumnModel().getColumn(4).setResizable(false);
            tblBuyBill.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dateChooserJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateChooserJButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(btnSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnSearch)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateChooserJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateChooserJButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String str = this.txtSearch.getText().trim();//获取输入框的数据
        List<BuyBill> list=null;
        if(StringUtile.validateNull(str)==false)JOptionPane.showMessageDialog(this,"输入框不能为空");
        String select = this.btnSelect.getSelectedItem().toString();
        if(select.equals("商品名称"))
        {
             list =ipd.getBuyBill_BuyName(str);
            
        }
       
        else if(select.equals("供应商名称"))
        {
            list =ipd.getBuyBill_Supplier(str);
        }
        else if(select.equals("入库操作员")){
        list =ipd.getBuyBill_Customer(str);
    }
        
        
        //2.调用dao层 将我们获取到的输入框的数据作为参数传给dao
      
        // 获取表格中的行进行删除
        DefaultTableModel dtm =(DefaultTableModel) this.tblBuyBill.getModel();
        while(dtm.getRowCount() > 0){
            dtm.removeRow(0);

        }
        for(BuyBill p :list){
            Vector v = new Vector();
            v.add(p.getBuyId());
            v.add(p.getBuyName());
            v.add(p.getBuyNum());
            v.add(p.getBuyPrice());
            v.add(p.getSupplier());
            v.add(p.getBuyTime().toString());
            
            Date date1=p.getBuyTime();
            Date date2=   new java.sql.Date(dateChooserJButton1.getDate().getTime());//相等则返回0，date1大返回1，否则返回-1
        
            Date date3=   new java.sql.Date(dateChooserJButton2.getDate().getTime());
            
            if(date1.compareTo(date2)>=0&&date3.compareTo(date1)>=0)

                

            dtm.addRow(v);}

    }//GEN-LAST:event_btnSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> btnSelect;
    private com.hp.Util.DateChooserJButton dateChooserJButton1;
    private com.hp.Util.DateChooserJButton dateChooserJButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblBuyBill;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
