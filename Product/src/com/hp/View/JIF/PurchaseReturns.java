/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hp.View.JIF;

import com.hp.Dao.BuyBillIMPL;
import com.hp.Dao.IBuyBill;
import com.hp.Dao.ISupplier;
import com.hp.Dao.SupplierIMPL;
import com.hp.Po.BuyBill;
import com.hp.Po.Supplier;
import com.hp.Util.DateChooserJButton;
import com.hp.Util.StringUtile;
import java.awt.BorderLayout;
import java.awt.Label;
import java.sql.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dr.Thri
 */
public class PurchaseReturns extends javax.swing.JInternalFrame {
    IBuyBill ipd=new BuyBillIMPL();
    ISupplier is=new SupplierIMPL();
    /**
     * Creates new form PurchaseOutWarehouse
     */
    public PurchaseReturns() {
     
      
        initComponents();
        //重新设置mainPanel的布局管理器

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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBill = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        dateChooserJButton1 = new com.hp.Util.DateChooserJButton();
        dateChooserJButton2 = new com.hp.Util.DateChooserJButton();
        jLabel1 = new javax.swing.JLabel();
        txtBuyId = new javax.swing.JTextField();
        txtBuyNum = new javax.swing.JTextField();
        txtGoodsId = new javax.swing.JTextField();
        txtDropNum = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        BuyDrop = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("采购退货");
        setToolTipText("");

        btnSearch.setText("搜索");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tblBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "采购编号", "商品编号", "商品名", "采购数量", "采购价格", "供应商编号", "供应商", "采购时间"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBill.getTableHeader().setReorderingAllowed(false);
        tblBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBillMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBill);
        if (tblBill.getColumnModel().getColumnCount() > 0) {
            tblBill.getColumnModel().getColumn(0).setResizable(false);
            tblBill.getColumnModel().getColumn(1).setResizable(false);
            tblBill.getColumnModel().getColumn(2).setResizable(false);
            tblBill.getColumnModel().getColumn(3).setResizable(false);
            tblBill.getColumnModel().getColumn(4).setResizable(false);
            tblBill.getColumnModel().getColumn(5).setResizable(false);
            tblBill.getColumnModel().getColumn(6).setResizable(false);
            tblBill.getColumnModel().getColumn(7).setResizable(false);
        }

        jLabel1.setText("-");

        txtBuyId.setEditable(false);

        txtBuyNum.setEditable(false);

        txtGoodsId.setEditable(false);

        jLabel2.setText("采购编号:");

        jLabel3.setText("商品编号:");

        jLabel4.setText("采购数量:");

        jLabel5.setText("退货数量:");

        BuyDrop.setText("采购退货");
        BuyDrop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuyDropActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(dateChooserJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(dateChooserJButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnSearch)
                .addGap(84, 84, 84))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuyId, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGoodsId, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuyNum, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDropNum, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BuyDrop)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateChooserJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateChooserJButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtGoodsId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtBuyNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuyId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDropNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BuyDrop)
                    .addComponent(jLabel5))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
         String str = this.txtSearch.getText();//获取输入框的数据
        //2.调用dao层 将我们获取到的输入框的数据作为参数传给dao
       if(StringUtile.validateNull(str) == false){
         JOptionPane.showMessageDialog(this,"搜索条件不能为空");
            return;
       }
        List<BuyBill> list =ipd.getBuyBill(str);
       
        // 获取表格中的行进行删除
        DefaultTableModel dtm =(DefaultTableModel) this.tblBill.getModel();
        while(dtm.getRowCount() > 0){
            dtm.removeRow(0);
        
        }
        for(BuyBill p :list){
            Vector v = new Vector();
            v.add(String.valueOf(p.getBuyId()));
            System.out.println(p.getBuyId());
            v.add(p.getDefineId());
            v.add(p.getBuyName());
            v.add(p.getBuyNum());
            v.add(p.getBuyPrice());
            v.add(p.getSupplier());
           
            Supplier s=is.SxS_findId(p.getSupplier());
            
            if(s!=null)
            v.add(s.getSimpleName());
            else  v.add("查询错误");
             v.add(p.getBuyTime().toString());
              Date date1=p.getBuyTime();
            Date date2=new java.sql.Date(dateChooserJButton1.getDate().getTime());
              Date date3=new java.sql.Date(dateChooserJButton2.getDate().getTime());
              if(date1.compareTo(date2)>=0&&date3.compareTo(date1)>=0){System.out.println("ok");
            dtm.addRow(v);}
        }
        
        
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tblBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBillMouseClicked
        // TODO add your handling code here:
        
          int selectRow = this.tblBill.getSelectedRow();
       // Integer id =(Integer) this.tblProduct.getValueAt(selectRow,0);
        txtBuyId.setText(((String) this.tblBill.getValueAt(selectRow,0)));
        txtGoodsId.setText((String)this.tblBill.getValueAt(selectRow, 1));
        txtBuyNum.setText((String)this.tblBill.getValueAt(selectRow, 3));
        
       
    }//GEN-LAST:event_tblBillMouseClicked

    private void BuyDropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuyDropActionPerformed
        // TODO add your handling code here:
        String str=txtDropNum.getText().trim();
        String BuyId=txtBuyId.getText().trim();
        String  GoodsId=txtGoodsId.getText().trim();
        
         if(StringUtile.validateNull(str) == false)
         {
         JOptionPane.showMessageDialog(this,"搜索条件不能为空");
            return;
        }
         if(StringUtile.validateDigit(str)==false)
        {
         JOptionPane.showMessageDialog(this,"退货数目必须是数字");
            return;
        }
         BuyBill b=ipd.SxS_findId(Integer.parseInt(BuyId), GoodsId);
         System.out.print("b=zhi"+b);
         System.out.print("b="+b.getBuyNum());
         System.out.print("str="+str);
         if(Integer.parseInt(b.getBuyNum())<Integer.parseInt(str))
          {
         JOptionPane.showMessageDialog(this,"退货数目超出");
            return;
        }
         if(ipd.SxS_DeleteNum(Integer.parseInt(BuyId), GoodsId,Integer.parseInt(str))>0){
         
          JOptionPane.showMessageDialog(this,"退货成功");
          btnSearchActionPerformed(evt);
            return;
         }else
         { JOptionPane.showMessageDialog(this,"退货失败");
         btnSearchActionPerformed(evt);
            return;}
         
        
    }//GEN-LAST:event_BuyDropActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuyDrop;
    private javax.swing.JButton btnSearch;
    private com.hp.Util.DateChooserJButton dateChooserJButton1;
    private com.hp.Util.DateChooserJButton dateChooserJButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBill;
    private javax.swing.JTextField txtBuyId;
    private javax.swing.JTextField txtBuyNum;
    private javax.swing.JTextField txtDropNum;
    private javax.swing.JTextField txtGoodsId;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
