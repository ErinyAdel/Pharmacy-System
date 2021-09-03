package GUI;

import java.sql.*;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static pharmacy_full_system.MYSQLConnection.connect;

public class EditReceiptDetails extends javax.swing.JFrame 
{
    private final Connection conn = connect();
    private final DecimalFormat df = new DecimalFormat("#.##");
    
    public EditReceiptDetails() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        totalprice_textfield = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        discount_textfield = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        calculated_totalprice_textfield = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        paid_up_textfield = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        residual_textfield = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        cust_name_label = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        receipt_num_label1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        remove_btn2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit Custome's Receipt");
        setLocation(new java.awt.Point(180, 180));

        totalprice_textfield.setEditable(false);

        jLabel4.setText("<html>Discount Rate<br>%</html>");

        discount_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discount_textfieldActionPerformed(evt);
            }
        });

        jLabel5.setText("Total After Discount");

        calculated_totalprice_textfield.setEditable(false);

        jLabel7.setText("Paid Up");

        paid_up_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paid_up_textfieldActionPerformed(evt);
            }
        });

        jLabel8.setText("Residual");

        residual_textfield.setEditable(false);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Barcode", "Name", "Type", "Description", "Effective Material", "Unit Price", "Production Date", "Expiry Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(3).setResizable(false);
            table.getColumnModel().getColumn(4).setResizable(false);
            table.getColumnModel().getColumn(5).setResizable(false);
            table.getColumnModel().getColumn(6).setResizable(false);
            table.getColumnModel().getColumn(7).setResizable(false);
        }

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel1.setText("Receipt's Details");

        jLabel2.setText("<html>\nTotal Price\n</html>");

        jLabel10.setText("Customer's Receipt :");

        jLabel11.setText("Receipt Number :");

        remove_btn2.setBackground(new java.awt.Color(0, 79, 161));
        remove_btn2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        remove_btn2.setForeground(new java.awt.Color(255, 255, 255));
        remove_btn2.setText("Remove");
        remove_btn2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        remove_btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remove_btn2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(javax.swing.UIManager.getDefaults().getColor("PropSheet.selectionBackground"));
        jButton1.setText("Ok");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("/");

        jCheckBox1.setText("Pay All ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 873, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel1)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 788, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGap(132, 132, 132)
                                            .addComponent(jLabel10)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cust_name_label, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel11)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(receipt_num_label1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(remove_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(5, 5, 5))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(totalprice_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(discount_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(98, 98, 98)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(calculated_totalprice_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(107, 107, 107)))
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 12, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(69, 69, 69)
                .addComponent(paid_up_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox1)
                .addGap(63, 63, 63)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(residual_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                        .addComponent(cust_name_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(receipt_num_label1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2)
                            .addComponent(jSeparator4)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(discount_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5)
                                        .addComponent(calculated_totalprice_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(totalprice_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(remove_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 51, Short.MAX_VALUE)))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(paid_up_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel3)
                        .addComponent(jCheckBox1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(residual_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void remove_btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remove_btn2ActionPerformed
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        if(table.getSelectedRow() != -1) 
        {
            int ch = JOptionPane.showConfirmDialog(null, "Selected row deleted successfully", "Message", JOptionPane.YES_NO_OPTION);
            if (ch == JOptionPane.YES_OPTION) 
            {
                //or int 
                String id = null;
                String barcode = String.valueOf(model.getValueAt(table.getSelectedRow(),0));
                String name = String.valueOf(model.getValueAt(table.getSelectedRow(),1));
                String type = String.valueOf(model.getValueAt(table.getSelectedRow(),2));
                String description = String.valueOf(model.getValueAt(table.getSelectedRow(),3));
                String effM = String.valueOf(model.getValueAt(table.getSelectedRow(),4));
                String price = String.valueOf(model.getValueAt(table.getSelectedRow(),5));
                String prodDate = String.valueOf(model.getValueAt(table.getSelectedRow(),6));
                String expDate = String.valueOf(model.getValueAt(table.getSelectedRow(),7));
                String query = "SELECT `Product_Number` FROM `sold_products` WHERE `Barcode`='"+barcode+"';";
                try {
                    Statement st1 = conn.createStatement();
                    ResultSet res1 = st1.executeQuery(query);
                    if(res1.next()) {
                        id = res1.getString("Product_Number");
                        query = "DELETE FROM `sold_products` WHERE `Product_Number`='"+id+"'";  //CASCADE
                        Statement st2 = conn.createStatement();
                        int res2 = st2.executeUpdate(query);
                        if(res2 > 0) 
                        {
                            query = "INSERT INTO `products`(`Barcode`, `SerialNumber`, `Name`, `Type`, `Description`, `EffectiveMaterial`, `Price`, "
                                    + "`ProductionDate`, `ExpirationDate`) VALUES ('" + barcode + "','" + id + "','" + name + "','" + type + "',"
                                    + "'" + description + "','" + effM + "','" + df.format(price) + "','" + prodDate + "','" + expDate + "');";
                            Statement st3 = conn.createStatement();
                            st3.executeUpdate(query);
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(EditReceiptDetails.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if (table.getRowCount() == 1)// Last row
                {                    
                    model.removeRow(table.getSelectedRow());
                    emptyFields();
                } else {
                    model.removeRow(table.getSelectedRow());
                    //Calc Total Price Before any discount
                    double totalPrice = 0;
                    for (int i = 0; i < model.getRowCount(); i++) {
                        totalPrice += Double.parseDouble(table.getValueAt(i,5).toString());
                    }
                    totalprice_textfield.setText(String.valueOf(df.format(totalPrice)));
                    //Calc Total Price After discount
                    if (discount_textfield.getText().isEmpty()) {
                        calculated_totalprice_textfield.setText(String.valueOf(totalprice_textfield.getText()));
                    } else {
                        double discount = Double.parseDouble(discount_textfield.getText());
                        double total = Double.parseDouble(totalprice_textfield.getText());
                        double totalAfterDiscount = total * discount / 100;
                        calculated_totalprice_textfield.setText(String.valueOf(df.format((total - totalAfterDiscount))));
                    }
                    //Calc Re 
                    if (!paid_up_textfield.getText().isEmpty()) {
                        double total = Double.parseDouble(totalprice_textfield.getText());
                        double paid = Double.parseDouble(paid_up_textfield.getText());
                        residual_textfield.setText(String.valueOf(df.format(total - paid)));
                    }
                    try {
                        query = "UPDATE `receipts` SET `Total_Price`='"+df.format(calculated_totalprice_textfield.getText())+"', "
                            + "`Paid`='"+df.format(paid_up_textfield.getText())+"', `Residual`='"+df.format(residual_textfield.getText())+"'"
                            + "WHERE `Receipt_ID`='"+receipt_num_label1.getText()+"';";
                        Statement stmt = conn.createStatement();
                        stmt.executeUpdate(query);
                    } catch (SQLException ex) {
                        Logger.getLogger(EditReceiptDetails.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecte row first to remove it");
            }
        }
    }//GEN-LAST:event_remove_btn2ActionPerformed

    private void discount_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discount_textfieldActionPerformed
        if (discount_textfield.getText().isEmpty() || discount_textfield.getText().equals("0")) {
            calculated_totalprice_textfield.setText(String.valueOf(df.format(totalprice_textfield.getText())));
        } else {
            double discount = Double.parseDouble(discount_textfield.getText());
            double total = Double.parseDouble(totalprice_textfield.getText());
            double totalAfterDiscount = total * discount / 100;
            calculated_totalprice_textfield.setText(String.valueOf(df.format((total - totalAfterDiscount))));
        }
        try {
            String query = "UPDATE `receipts` SET `Total_Price`='" + df.format(Double.parseDouble(calculated_totalprice_textfield.getText())) + "', "
                    + "`Paid`='"+df.format(Double.parseDouble(paid_up_textfield.getText()))+"', `Residual`='"+df.format(Double.parseDouble(residual_textfield.getText())) + "'"
                    + "WHERE `Receipt_ID`='" + receipt_num_label1.getText() + "';";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(EditReceiptDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_discount_textfieldActionPerformed

    private void paid_up_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paid_up_textfieldActionPerformed
        double paid  = Double.parseDouble(paid_up_textfield.getText());
        double total = Double.parseDouble(calculated_totalprice_textfield.getText());
        residual_textfield.setText(String.valueOf(df.format(total-paid)));
        try {
            String query = "UPDATE `receipts` SET `Total_Price`='" + df.format(Double.parseDouble(calculated_totalprice_textfield.getText())) + "', "
                    + "`Paid`='"+df.format(Double.parseDouble(paid_up_textfield.getText()))+"', `Residual`='"+df.format(Double.parseDouble(residual_textfield.getText()))+"'"
                    + "WHERE `Receipt_ID`='" + receipt_num_label1.getText() + "';";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(EditReceiptDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_paid_up_textfieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(jCheckBox1.isSelected()) {
            try {
                String query = "UPDATE `receipts` SET `Paid`='" + df.format(Double.parseDouble(calculated_totalprice_textfield.getText())) + "', "
                        + "`Residual`='0' WHERE `Receipt_ID`='" + receipt_num_label1.getText() + "';";
                Statement stmt = conn.createStatement();
                int result = stmt.executeUpdate(query);
                if(result > 0) {
                    this.setVisible(false);
                }
            } catch (SQLException ex) {
                Logger.getLogger(EditReceiptDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane,"No New Action Were Taken");
            this.setVisible(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void emptyFields() {
        totalprice_textfield.setText("");discount_textfield.setText("");calculated_totalprice_textfield.setText("");
        paid_up_textfield.setText("");residual_textfield.setText("");
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditReceiptDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditReceiptDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditReceiptDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditReceiptDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditReceiptDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField calculated_totalprice_textfield;
    public javax.swing.JLabel cust_name_label;
    public javax.swing.JTextField discount_textfield;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    public javax.swing.JTextField paid_up_textfield;
    public javax.swing.JLabel receipt_num_label1;
    private javax.swing.JButton remove_btn2;
    public javax.swing.JTextField residual_textfield;
    public javax.swing.JTable table;
    public javax.swing.JTextField totalprice_textfield;
    // End of variables declaration//GEN-END:variables
}
