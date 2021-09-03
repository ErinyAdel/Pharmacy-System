package GUI.InternalFrame;

import GUI.EditReceiptDetails;
import static GUI.InternalFrame.LastSales.recD;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import static pharmacy_full_system.MYSQLConnection.connect;

public class EditReceipt extends javax.swing.JInternalFrame 
{
    private final Connection con = connect();
    public static EditReceiptDetails recD;
    
    public EditReceipt() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        list_btn = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        receipt_num_textfield = new javax.swing.JTextField();
        cust_name_textfield = new javax.swing.JTextField();
        search_btn = new javax.swing.JButton();

        setClosable(true);
        setTitle("Edit Receipt");
        setPreferredSize(new java.awt.Dimension(1157, 676));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Receipts");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ReceiptNumber", "Receipt Time", "Total Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        list_btn.setBackground(java.awt.SystemColor.activeCaption);
        list_btn.setText("List");
        list_btn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        list_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                list_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(435, 435, 435))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(list_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 837, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(list_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jLabel10.setText("Customer's Name :");

        jLabel11.setText("Receipt Number :");

        search_btn.setText("Search");
        search_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(cust_name_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(receipt_num_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(search_btn)
                .addGap(155, 155, 155))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(receipt_num_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(search_btn))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cust_name_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void list_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list_btnActionPerformed
        if(table.getSelectedRow() != -1) {
            String receiptNumer = table.getModel().getValueAt(table.getSelectedRow(),0).toString();
            String totalPrice   = table.getModel().getValueAt(table.getSelectedRow(),2).toString();

            recD = new EditReceiptDetails();
            recD.setVisible(true);
            JTable table1 = recD.table;
            DefaultTableModel model = (DefaultTableModel) table1.getModel();
            Object[] rowData = new Object[8];

            String query = "SELECT Barcode,Name,Type,Description,EffectiveMaterial,Price,ProductionDate,ExpirationDate,Paid,Residual,Customer_Name,Receipt_ID "
            + "FROM `receipts` JOIN `sold_products` "
            + "ON sold_products.Product_Number = receipts.Product_ID "
            + "WHERE receipts.Receipt_ID= '"+receiptNumer+"';";

            double totalBefor = 0,paid=0, residual = 0;
            int rec_id=0;
            String name = null;
            try
            {
                Statement stmt = con.createStatement();
                ResultSet res = stmt.executeQuery(query);

                while (res.next())
                {
                    rowData[0] = res.getString("Barcode");
                    rowData[1] = res.getString("Name");
                    rowData[2] = res.getString("Type");
                    rowData[3] = res.getString("Description");
                    rowData[4] = res.getString("EffectiveMaterial");
                    rowData[5] = res.getDouble("Price");
                    totalBefor += res.getDouble("Price");
                    rowData[6] = res.getString("ProductionDate");
                    rowData[7] = res.getString("ExpirationDate");
                    model.addRow(rowData);

                    name = res.getString("Customer_Name");
                    rec_id = res.getInt("Receipt_ID");
                    paid = res.getDouble("Paid");
                    residual = res.getDouble("Residual");
                }
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ModifyProducts.class.getName()).log(Level.SEVERE, null, ex);
            }

            double sale = 0;
            if(totalBefor != Double.parseDouble(totalPrice)) {
                sale = (totalBefor - Double.parseDouble(totalPrice)) * 100 / totalBefor;
            }
            DecimalFormat df = new DecimalFormat("#.##");
            
            recD.totalprice_textfield.setText(String.valueOf(df.format(totalBefor)));
            recD.discount_textfield.setText(String.valueOf(df.format(sale)));
            recD.calculated_totalprice_textfield.setText(df.format(Double.parseDouble(totalPrice)));
            recD.paid_up_textfield.setText(df.format(paid));
            recD.residual_textfield.setText(df.format(residual));
            //
            recD.cust_name_label.setText(name);
            recD.receipt_num_label1.setText(String.valueOf(rec_id));
            
        }
        else {
            JOptionPane.showMessageDialog(rootPane,"Select Receipt First");
        }
    }//GEN-LAST:event_list_btnActionPerformed

    private void search_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_btnActionPerformed
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        if(!receipt_num_textfield.getText().isEmpty() || !cust_name_textfield.getText().isEmpty())
        {
            Object[] rowData = new Object[3];
            try {
                String query = "SELECT `Receipt_ID`,COUNT(`Receipt_ID`), `Receipt_Date`, `Total_Price` FROM `receipts` "
                + "WHERE `Receipt_ID`= '"+receipt_num_textfield.getText()+"' OR `Customer_Name`= '"+cust_name_textfield.getText()+"' "
                + "GROUP BY `Receipt_ID` HAVING COUNT(`Receipt_ID`) >= 1;";
                Statement stmt = (Statement) con.createStatement();
                ResultSet res  = stmt.executeQuery(query);
                while (res.next()) {
                    rowData[0] = res.getInt("Receipt_ID");
                    rowData[1] = res.getString("Receipt_Date");
                    rowData[2] = res.getDouble("Total_Price");
                    model.addRow(rowData);
                }
            } catch (SQLException ex) {
                Logger.getLogger(LastSales.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_search_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cust_name_textfield;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton list_btn;
    private javax.swing.JTextField receipt_num_textfield;
    private javax.swing.JButton search_btn;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
