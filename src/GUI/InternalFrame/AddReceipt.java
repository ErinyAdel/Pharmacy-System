package GUI.InternalFrame;

import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static pharmacy_full_system.MYSQLConnection.connect;

public class AddReceipt extends javax.swing.JInternalFrame 
{
    private final Connection conn = connect();
    DecimalFormat df = new DecimalFormat("#.##");
    
    public AddReceipt() 
    {
        initComponents();
        //1. Display Current Time
        curDate_textfield.setText(currentTime());
        //2. Display Receipt Number
        int recNum = readFromFile();
        if(recNum == 0) {
            recNum = 1;
            receipt_num_textfield.setText(String.valueOf(recNum));
        }
        else {
            recNum++;
            receipt_num_textfield.setText(String.valueOf(recNum));
        }
        //3. Remove prod. (Optional)
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        remove_btn.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) {
               if(table.getSelectedRow() != -1) 
               {               
                    int ch = JOptionPane.showConfirmDialog(null, "Selected row deleted successfully","Message",JOptionPane.YES_NO_OPTION);
                    if (ch == JOptionPane.YES_OPTION) 
                    {
                        if(table.getSelectedRow() == 0)// Last row
                        {
                            model.removeRow(table.getSelectedRow());
                            emptyFields();
                        }
                        else 
                        {
                            model.removeRow(table.getSelectedRow());
                            //Calc Total Price Before any discount
                            double totalPrice = 0;
                            for(int i=0; i<model.getRowCount(); i++) {
                                 totalPrice += Double.parseDouble(table.getValueAt(i,7).toString());
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
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Selecte row first to remove it");
                    }
               }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        curDate_textfield = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        receipt_num_textfield = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        totalprice_textfield = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        discount_textfield = new javax.swing.JTextField();
        remove_btn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cust_name_textfield = new javax.swing.JTextField();
        ok_btn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        barcode_textfield = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        add_btn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        paid_up_textfield = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        residual_textfield = new javax.swing.JTextField();
        calculated_totalprice_textfield = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("New Receipt");
        setAutoscrolls(true);
        setMinimumSize(new java.awt.Dimension(1156, 525));
        setPreferredSize(new java.awt.Dimension(1157, 676));
        setVisible(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Receipt");

        jLabel3.setText("Date");

        curDate_textfield.setEditable(false);

        jLabel4.setText("Receipt Number");

        receipt_num_textfield.setEditable(false);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Barcode", "Name", "Type", "Description", "Effective Material", "Production Date", "Expiration Date", "Unit Price"
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

        jLabel5.setText("Total");

        totalprice_textfield.setEditable(false);

        jLabel6.setText("Discount %");

        discount_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discount_textfieldActionPerformed(evt);
            }
        });

        remove_btn.setBackground(new java.awt.Color(0, 79, 161));
        remove_btn.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        remove_btn.setForeground(new java.awt.Color(255, 255, 255));
        remove_btn.setText("Remove");
        remove_btn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel7.setText("Customer Name");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(424, 424, 424)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(cust_name_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(curDate_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(receipt_num_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(29, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(remove_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(totalprice_textfield, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                            .addComponent(discount_textfield))
                        .addGap(32, 32, 32))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cust_name_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(receipt_num_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(curDate_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(remove_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(totalprice_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(discount_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        ok_btn.setBackground(java.awt.SystemColor.activeCaption);
        ok_btn.setText("Ok");
        ok_btn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        ok_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ok_btnActionPerformed(evt);
            }
        });

        jButton2.setText("Print");

        jLabel2.setText("Barcode");

        add_btn.setText("Add");
        add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btnActionPerformed(evt);
            }
        });

        jLabel8.setText("Paid Up");

        paid_up_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paid_up_textfieldActionPerformed(evt);
            }
        });

        jLabel9.setText("Residual");

        residual_textfield.setEditable(false);

        calculated_totalprice_textfield.setEditable(false);

        jLabel10.setText("Total");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 102, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(calculated_totalprice_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(paid_up_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(residual_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(51, 51, 51)
                        .addComponent(ok_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(barcode_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(add_btn)))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(barcode_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(add_btn))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(calculated_totalprice_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(paid_up_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(residual_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(31, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ok_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btnActionPerformed
        if(!barcode_textfield.getText().isEmpty()) 
        {
            String barcode = barcode_textfield.getText();
            String query = "SELECT * FROM `products` WHERE `Barcode`= '"+barcode+"'";
            
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object[] rowData = new Object[8];
            
            try {
                Statement st = conn.createStatement();
                ResultSet res = st.executeQuery(query);
                while(res.next()) 
                {
                    rowData[0] = res.getString("Barcode");
                    rowData[1] = res.getString("Name");
                    rowData[2] = res.getString("Type");
                    rowData[3] = res.getString("Description");
                    rowData[4] = res.getString("EffectiveMaterial");
                    rowData[5] = res.getString("ProductionDate");
                    rowData[6] = res.getString("ExpirationDate");
                    rowData[7] = res.getDouble("Price");

                    model.addRow(rowData);
                }
                
                double totalPrice = 0;
                for(int i=0; i<model.getRowCount(); i++) {
                    totalPrice += Double.parseDouble(table.getValueAt(i,7).toString());
                }
                if(!discount_textfield.getText().isEmpty()) {
                    double discount = Double.parseDouble(discount_textfield.getText());
                    double total = Double.parseDouble(totalprice_textfield.getText());
                    double totalAfterDiscount = total*discount/100;
                    calculated_totalprice_textfield.setText(String.valueOf(df.format((total - totalAfterDiscount))));
                }
                else {
                    calculated_totalprice_textfield.setText(String.valueOf(df.format(totalPrice)));
                }
                totalprice_textfield.setText(String.valueOf(df.format(totalPrice)));
                barcode_textfield.setText("");
            }
            catch (SQLException ex) {
                Logger.getLogger(AddReceipt.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_add_btnActionPerformed

    private void ok_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ok_btnActionPerformed
        if(!paid_up_textfield.getText().isEmpty())
        {
            if(cust_name_textfield.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane,"Enter Customer Name First");
            }
            else {
                addReceipt();
            }
        }
        else {
            addReceipt();
        }
    }//GEN-LAST:event_ok_btnActionPerformed

    private void addReceipt()
    {
        try {
            int receipt_num = 0;
            double price = 0 , totalPrice = 0, paid = 0;
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            
            for(int i=0; i<model.getRowCount(); i++)
            {
                String barcode = table.getValueAt(i,0).toString();
                String query = "SELECT * FROM `products` WHERE `Barcode`= '"+barcode+"';";
                try {
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(query);
                    
                    while(rs.next())
                    {
                        int serial  = rs.getInt("SerialNumber");
                        String name = rs.getString("Name");
                        String type = rs.getString("Type");
                        String desc = rs.getString("Description");
                        String eff  = rs.getString("EffectiveMaterial");
                        String prodDate = rs.getString("ProductionDate");
                        String expDate  = rs.getString("ExpirationDate");
                        price = rs.getDouble("Price");
                        
                        if (desc.equals("NULL")) {
                            desc = "NULL";
                        }
                        if (eff.equals("NULL")) {
                            eff = "NULL";
                        }
                        
                        query = "INSERT INTO `sold_products` (`Barcode`, `Product_Number`, `Name`, `Type`, `Description`, `EffectiveMaterial`, `Price`, "
                                +"`ProductionDate`, `ExpirationDate`) "
                                +"VALUES ('"+barcode+"','"+serial+"','"+name+"','"+type+"','"+desc+"','"+eff+"','"+df.format(price)+"','"+prodDate+"','"+expDate+"');";
                        Statement st1 = conn.createStatement();
                        int res = st1.executeUpdate(query);
                        if(res > 0)
                        {
                            totalPrice += price;
                            receipt_num = readFromFile();
                            receipt_num++;
                            
                            double residual = 0;
                            if (residual_textfield.getText().isEmpty() || residual_textfield.getText().equals("0")) {
                                residual = 0;
                                paid = totalPrice;
                            } 
                            else {
                                residual = Double.parseDouble(residual_textfield.getText());
                                paid = Double.parseDouble(paid_up_textfield.getText());
                            }
                            if(cust_name_textfield.getText().isEmpty()) {
                                cust_name_textfield.setText("Unknown");
                            }
                            query = "INSERT INTO `receipts` (`Receipt_ID`,`Product_ID`,`Receipt_Date`,`Customer_Name`,`Total_Price`,`Paid`,`Residual`) VALUES "
                                        + "('" + receipt_num + "','" + serial + "','" + currentTime() + "','" + cust_name_textfield.getText() + "','" + df.format(totalPrice) + "','" + df.format(paid) + "','" + df.format(residual) + "');";
                            Statement st2 = conn.createStatement();
                            int res2 = st2.executeUpdate(query);
                            if (res2 > 0) {
                                query = "DELETE FROM `products` WHERE `Barcode`= '" + barcode + "';";
                                Statement st3 = conn.createStatement();
                                st3.executeUpdate(query);
                            }
                        }
                    }
                } catch(SQLException ex) {
                    Logger.getLogger(AddReceipt.class.getName()).log(Level.SEVERE, null, ex);
                }
            }    
            JOptionPane.showMessageDialog(rootPane, "Done");
            // Set Next Receipt Number
            writeInFile(receipt_num);
            int re = readFromFile();
            receipt_num_textfield.setText(String.valueOf((re + 1)));
            // Set Total Price & Paid Up in DB Table 
            totalPrice = Double.parseDouble(calculated_totalprice_textfield.getText());
            if(paid_up_textfield.getText().isEmpty()) {
                paid = totalPrice;
            }
            String query = "UPDATE `receipts` SET `Total_Price`= '"+df.format(totalPrice)+"',`Paid`= '"+df.format(paid)+"' WHERE `Receipt_ID`= '"+re+"';";
            Statement st = conn.createStatement();
            st.executeUpdate(query);
            // Empty All TextField & Table Rows
            emptyFields();
            model.setRowCount(0);
        } catch (SQLException ex) {
            Logger.getLogger(AddReceipt.class.getName()).log(Level.SEVERE, null, "fail in an add receipt process: "+ex);
        }
    }
    
    private void paid_up_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paid_up_textfieldActionPerformed
        double paid  = Double.parseDouble(paid_up_textfield.getText());
        double total = Double.parseDouble(calculated_totalprice_textfield.getText());
        residual_textfield.setText(String.valueOf(df.format(total-paid)));
    }//GEN-LAST:event_paid_up_textfieldActionPerformed

    private void discount_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discount_textfieldActionPerformed
        if(!totalprice_textfield.getText().isEmpty())
        {
            if(discount_textfield.getText().isEmpty()) {
                calculated_totalprice_textfield.setText(String.valueOf(totalprice_textfield.getText()));
            }
            else {
                double discount = Double.parseDouble(discount_textfield.getText());
                double total = Double.parseDouble(totalprice_textfield.getText());
                double totalAfterDiscount = total*discount/100;
                calculated_totalprice_textfield.setText(String.valueOf(df.format((total - totalAfterDiscount))));
            }
        }
        else {
            JOptionPane.showMessageDialog(rootPane,"Choose product first");
        }
    }//GEN-LAST:event_discount_textfieldActionPerformed

    private String currentTime()
    {
        String format = "yyyy-MM-dd";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        LocalDateTime now = LocalDateTime.now();
        String curDate = dtf.format(now);
        
        return curDate;
    }
    
    public static int readFromFile() 
    {
        int rec_num = 0;
        try (DataInputStream inn = new DataInputStream(new FileInputStream("receiptNumberFile.txt"))) {
            rec_num = inn.readInt();
            inn.close();
            return rec_num;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddReceipt.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddReceipt.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rec_num;
    }

    private void writeInFile(int rec_num) 
    {
        try (DataOutputStream ut = new DataOutputStream(new FileOutputStream("receiptNumberFile.txt"))) {
            ut.writeInt(rec_num);
        } catch (IOException ex) {
            Logger.getLogger(AddReceipt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void emptyFields() {
        totalprice_textfield.setText("");calculated_totalprice_textfield.setText("");discount_textfield.setText("");
        paid_up_textfield.setText("");residual_textfield.setText("");cust_name_textfield.setText("");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_btn;
    private javax.swing.JTextField barcode_textfield;
    private javax.swing.JTextField calculated_totalprice_textfield;
    private javax.swing.JTextField curDate_textfield;
    private javax.swing.JTextField cust_name_textfield;
    private javax.swing.JTextField discount_textfield;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton ok_btn;
    private javax.swing.JTextField paid_up_textfield;
    private javax.swing.JTextField receipt_num_textfield;
    private javax.swing.JButton remove_btn;
    private javax.swing.JTextField residual_textfield;
    private javax.swing.JTable table;
    private static javax.swing.JTextField totalprice_textfield;
    // End of variables declaration//GEN-END:variables
}
