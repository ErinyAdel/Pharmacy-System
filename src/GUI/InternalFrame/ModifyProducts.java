package GUI.InternalFrame;

import java.sql.*;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.*;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import static pharmacy_full_system.MYSQLConnection.connect;

public class ModifyProducts extends javax.swing.JInternalFrame 
{
    private final Connection conn = connect();
    //Local Variables store old date (From Table Via TextField) when using update process
    private String prod_name, prod_type, prod_desc,prod_eff_mat, prod_price, prod_quantity, prod_expDate, prod_producDate;
    DecimalFormat df = new DecimalFormat("#.##");
    
    public ModifyProducts()
    {           
        initComponents();
        //List All Products From 'products' Table In DB
        String query = "SELECT Name,Type,Description,EffectiveMaterial,Price,ProductionDate,ExpirationDate,group_concat(Distinct `ProductionDate` SEPARATOR ',') "
                       +"FROM `products` group by Name,ProductionDate,Type,Description,EffectiveMaterial;";
        int all_quant = allAvailableProducts(query);
        products_quantity_textfield.setText(String.valueOf(all_quant));
        exp_products_quantity_textfield1.setText(String.valueOf(num_of_expired_products()));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        name_textfield = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        type_combobox = new javax.swing.JComboBox<>();
        price_textfield = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        quantity_textfield = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        stock_table = new javax.swing.JTable();
        description_textfield = new javax.swing.JTextField();
        delete_btn = new javax.swing.JButton();
        update_btn = new javax.swing.JButton();
        add_btn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        refresh_btn = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        proddate_dateChooserCombo = new com.toedter.calendar.JDateChooser();
        exipirydate_dateChooserCombo = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        eff_mat_textfield = new javax.swing.JTextField();
        search_btn = new javax.swing.JButton();
        search_type_combobox = new javax.swing.JComboBox<>();
        search_textfieldd = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        products_quantity_textfield = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        exp_products_quantity_textfield1 = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Modify The Stock");
        setAutoscrolls(true);
        setMinimumSize(new java.awt.Dimension(1156, 521));
        setPreferredSize(new java.awt.Dimension(1157, 676));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setText("Name");

        jLabel5.setText("Type");

        jLabel6.setText("Description");

        type_combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "CAPSULES", "TABLETS", "SYRUP", "POWDER", "LIQUID", "INJECTION", "ENEMA", "ORAL SUSPENSION", "EAR DROPS", "EYE DROPS", "Eye ointment", "Ophthalmic Ointment", "OINTMENT", "CREAM", "OPHTHALMIC CREAM", "PASTE", "SPRAY", "GEL", "MILK", " " }));

        jLabel8.setText("Price");

        jLabel9.setText("Quantity");

        jLabel10.setText("Expiration Date");

        jLabel11.setText("Production Date");

        stock_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Type", "Description", "Effective Material", "Unit Price", "Quantity", "Production Date", "Expiration Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        stock_table.setGridColor(new java.awt.Color(51, 0, 153));
        stock_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stock_tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(stock_table);
        if (stock_table.getColumnModel().getColumnCount() > 0) {
            stock_table.getColumnModel().getColumn(0).setResizable(false);
            stock_table.getColumnModel().getColumn(1).setResizable(false);
            stock_table.getColumnModel().getColumn(2).setResizable(false);
            stock_table.getColumnModel().getColumn(3).setResizable(false);
            stock_table.getColumnModel().getColumn(4).setResizable(false);
            stock_table.getColumnModel().getColumn(5).setResizable(false);
            stock_table.getColumnModel().getColumn(6).setResizable(false);
            stock_table.getColumnModel().getColumn(7).setResizable(false);
        }

        delete_btn.setBackground(new java.awt.Color(0, 79, 161));
        delete_btn.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        delete_btn.setForeground(new java.awt.Color(255, 255, 255));
        delete_btn.setText("Delete");
        delete_btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });

        update_btn.setBackground(java.awt.SystemColor.activeCaption);
        update_btn.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        update_btn.setText("Update");
        update_btn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btnActionPerformed(evt);
            }
        });

        add_btn.setBackground(new java.awt.Color(0, 79, 161));
        add_btn.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        add_btn.setForeground(new java.awt.Color(255, 255, 255));
        add_btn.setText("Add");
        add_btn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btnActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));

        refresh_btn.setBackground(java.awt.SystemColor.activeCaption);
        refresh_btn.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        refresh_btn.setText("Refresh");
        refresh_btn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        refresh_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_btnActionPerformed(evt);
            }
        });

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));

        proddate_dateChooserCombo.setDateFormatString("yyyy-MM-dd");

        exipirydate_dateChooserCombo.setDateFormatString("yyyy-MM-dd");

        jLabel1.setText("Effective Material");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(type_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(description_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eff_mat_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGap(54, 54, 54))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(quantity_textfield, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(price_textfield, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(proddate_dateChooserCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(exipirydate_dateChooserCombo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(23, 23, 23))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(220, Short.MAX_VALUE)
                .addComponent(refresh_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addComponent(add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(update_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(184, 184, 184))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(name_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(type_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(description_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(eff_mat_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(price_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(quantity_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(proddate_dateChooserCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(exipirydate_dateChooserCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refresh_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        search_btn.setText("Search");
        search_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_btnActionPerformed(evt);
            }
        });

        search_type_combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name", "Type", "Effective Material" }));

        jLabel2.setText("Number Of All Products");

        products_quantity_textfield.setEditable(false);

        jLabel3.setText("Number Of Expiry Products");

        exp_products_quantity_textfield1.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(search_type_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(search_textfieldd, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(search_btn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(exp_products_quantity_textfield1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(products_quantity_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_btn)
                    .addComponent(search_type_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_textfieldd, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(products_quantity_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exp_products_quantity_textfield1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void search_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_btnActionPerformed
        emptyingSomeFields();
        String searchType = String.valueOf(search_type_combobox.getSelectedItem());
        String searchItem = String.valueOf(search_textfieldd.getText()); //Hint: Textfield isEmpty --> Give "" Value not null value. 
                                                                        //(There is no validation. No error) 
        refreshTable();
        if(searchType.equals("Effective Material"))
        {
            if(searchItem == null || searchItem.equals("")) {
                searchItem = "NULL";
                searchType = "EffectiveMaterial";
            }
            else{
                searchType = "EffectiveMaterial";
            }
        }
        if(searchType.equals("Description"))
        {
            if(searchItem == null || searchItem.equals("")) {
                searchItem = "NULL";
            }
        }
        String query = "SELECT Name,Type,Description,EffectiveMaterial,Price,ProductionDate,ExpirationDate,group_concat(Distinct `ProductionDate` SEPARATOR ',') "
                       +"FROM `products` WHERE `"+searchType+"`= '"+searchItem+"' group by Name,ProductionDate,Type,Description,EffectiveMaterial;";
        allAvailableProducts(query);
    }//GEN-LAST:event_search_btnActionPerformed

    private void refresh_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh_btnActionPerformed
        refreshTable();
        emptyingFields();
        quantity_textfield.setEditable(true);
        String query = "SELECT Name,Type,Description,EffectiveMaterial,Price,ProductionDate,ExpirationDate,group_concat(Distinct `ProductionDate` SEPARATOR ',') "
                       +"FROM `products` group by Name,ProductionDate,Type,Description,EffectiveMaterial;";
        int all_quant = allAvailableProducts(query);
        products_quantity_textfield.setText(String.valueOf(all_quant));
        exp_products_quantity_textfield1.setText(String.valueOf(num_of_expired_products()));
    }//GEN-LAST:event_refresh_btnActionPerformed

    private void add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btnActionPerformed
        String name = String.valueOf(name_textfield.getText());         String price = String.valueOf(price_textfield.getText());
        String type = String.valueOf(type_combobox.getSelectedItem());  String quantity = String.valueOf(quantity_textfield.getText());
        String desc = String.valueOf(description_textfield.getText());
        String effe = String.valueOf(eff_mat_textfield.getText());
        String prodDate  = ((JTextField)proddate_dateChooserCombo.getDateEditor().getUiComponent()).getText();
        String expDate  = ((JTextField)exipirydate_dateChooserCombo.getDateEditor().getUiComponent()).getText();
        if (desc.equals("")) {
            desc = "NULL";
        }
        if (effe.equals("")) {
            effe = "NULL";
        }
        int index = 0;
        for (int i = 0; i < type_combobox.getItemCount(); i++) {
            if (type_combobox.getItemAt(i).equals(type)) {
                index = i;
                break;
            }
        }
        if (!name.isEmpty() && index > 0 && !price.isEmpty() && !quantity.isEmpty() && !prodDate.isEmpty() && !expDate.isEmpty()) 
        {
            try {
                int q = Integer.parseInt(quantity);
                
                int rowAffected = 0, ID = 0;
                while (q >= 1) {
                    String query = "INSERT INTO `products`(`Name`, `Type`, `Description`, `EffectiveMaterial`, `Price`, `ProductionDate`, `ExpirationDate`) "
                            + "VALUES ('"+name+"','"+type+"','" + desc + "','" + effe + "'," + df.format(Double.parseDouble(price)) + ",'" + prodDate + "','" + expDate + "')";
                    Statement stmt = conn.createStatement();
                    rowAffected = stmt.executeUpdate(query);
                    if (rowAffected != 1) {
                        Logger.getLogger(ModifyProducts.class.getName()).log(Level.SEVERE, null, "Data is not inserted");
                    }
                    stmt.close();
                    //
                    query = "SELECT * FROM (\n"
                            + "    SELECT * FROM `products` ORDER BY SerialNumber DESC LIMIT 1\n"
                            + ") sub\n"
                            + "ORDER BY SerialNumber ASC";
                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery(query);
                    if (rs.next()) {
                        ID = rs.getInt("SerialNumber");
                    }
                    st.close();
                    //
                    int barcode = 0, temp = 0;
                    barcode = ID;
                    String[] exDate = expDate.split("-");

                    for (String a : exDate) {
                        temp = Integer.parseInt(a);
                        barcode += temp;
                    }
                    System.out.println("barcode: "+barcode);
                    query = "UPDATE `products` SET `Barcode`= '" + barcode + "' ORDER BY SerialNumber DESC LIMIT 1";
                    Statement stm = conn.createStatement();
                    int res = stm.executeUpdate(query);
                    if (!(res > 0)) {
                        Logger.getLogger(ModifyProducts.class.getName()).log(Level.SEVERE, null, "Data is not updated");
                    }
                    q--;
                    stm.close();
                }
                emptyingFields();
                refreshTable();
                String query = "SELECT Name,Type,Description,EffectiveMaterial,Price,ProductionDate,ExpirationDate,group_concat(Distinct `ProductionDate` SEPARATOR ',') "
                    +"FROM `products` group by Name,ProductionDate,Type,Description,EffectiveMaterial;";
                int all_quant = allAvailableProducts(query);
                products_quantity_textfield.setText(String.valueOf(all_quant));
                exp_products_quantity_textfield1.setText(String.valueOf(num_of_expired_products()));
                JOptionPane.showMessageDialog(rootPane, "Product(s) are inserted successfully in the stock");
            } catch (SQLException ex) {
                Logger.getLogger(ModifyProducts.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            JOptionPane.showMessageDialog(rootPane,"Enter all required data");
        }
    }//GEN-LAST:event_add_btnActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        if(stock_table.getSelectedRow() != -1) 
        { //Selected
            if (prod_desc.equals("")) {
                prod_desc = "NULL";
            }
            if (prod_eff_mat.equals("")) {
                prod_eff_mat = "NULL";
            }  
            String query = "DELETE FROM `products` WHERE `Name`='"+prod_name+"' AND `Type`='"+prod_type+"' AND `Description`='"+prod_desc+"' "
                            +"AND `EffectiveMaterial`='"+prod_eff_mat+"' AND `Price`='"+prod_price+"' "
                            +"AND `ProductionDate`='"+prod_producDate+"' AND `ExpirationDate`='"+prod_expDate+"';";
            try {
                Statement st = conn.createStatement();
                int rs = st.executeUpdate(query);
                if (rs > 0) {
                    JOptionPane.showMessageDialog(rootPane, "Data are removed successfully");
                    emptyingFields();
                    refreshTable();
                    query = "SELECT Name,Type,Description,EffectiveMaterial,Price,ProductionDate,ExpirationDate,group_concat(Distinct `ProductionDate` SEPARATOR ',') "
                                   +"FROM `products` group by Name,ProductionDate,Type,Description,EffectiveMaterial;";
                    int all_quant = allAvailableProducts(query);
                    products_quantity_textfield.setText(String.valueOf(all_quant));
                    exp_products_quantity_textfield1.setText(String.valueOf(num_of_expired_products()));
                } else {
                    Logger.getLogger(ModifyProducts.class.getName()).log(Level.SEVERE, null, "Data aren't removed!");
                }
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(ModifyProducts.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane,"Select first to remove!");
        }
    }//GEN-LAST:event_delete_btnActionPerformed

    private void stock_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stock_tableMouseClicked
        String name = stock_table.getValueAt(stock_table.getSelectedRow(), 0).toString();
        String type = stock_table.getValueAt(stock_table.getSelectedRow(), 1).toString();
        String description = stock_table.getValueAt(stock_table.getSelectedRow(), 2).toString();
        String effM = stock_table.getValueAt(stock_table.getSelectedRow(), 3).toString();
        String price = stock_table.getValueAt(stock_table.getSelectedRow(), 4).toString();
        String quantity = stock_table.getValueAt(stock_table.getSelectedRow(), 5).toString();
        String prodDate = stock_table.getValueAt(stock_table.getSelectedRow(), 6).toString();
        String expDate = stock_table.getValueAt(stock_table.getSelectedRow(), 7).toString();

        //Set Any Field than may have null value in db as empty field
        if (description.equals("NULL")) {
            description = "";
        }
        if (effM.equals("NULL")) {
            effM = "";
        }
        //Set Type Value Form Getting 'Type' String From its Value
        int index = 0;
        for (int i = 0; i < type_combobox.getItemCount(); i++) {
            if (type_combobox.getItemAt(i).equals(type)) {
                index = i;
                break;
            }
        }
        name_textfield.setText(name);
        type_combobox.setSelectedIndex(index);
        description_textfield.setText(description);
        eff_mat_textfield.setText(effM);
        price_textfield.setText(price);
        quantity_textfield.setText(quantity);
        ((JTextField) proddate_dateChooserCombo.getDateEditor().getUiComponent()).setText(prodDate);
        ((JTextField) exipirydate_dateChooserCombo.getDateEditor().getUiComponent()).setText(expDate);

        //Use These local variables in update process.
        prod_name = name;
        prod_type = type;
        prod_desc = description;
        prod_eff_mat = effM;
        prod_price = price;
        prod_quantity = quantity;
        prod_producDate = prodDate;
        prod_expDate = expDate;
        
    }//GEN-LAST:event_stock_tableMouseClicked

    private void update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnActionPerformed
        if(stock_table.getSelectedRow() != -1) //Select Row!?
        {
            //Variables Store New (Updated) Data
            String name  = String.valueOf(name_textfield.getText());
            int index    = (int) type_combobox.getSelectedIndex();
            String type  = type_combobox.getItemAt(index);
            String desc  = String.valueOf(description_textfield.getText());
            String effc  = String.valueOf(eff_mat_textfield.getText());
            String price = String.valueOf(price_textfield.getText());
            String quant = String.valueOf(quantity_textfield.getText());
            String prod  = ((JTextField) proddate_dateChooserCombo.getDateEditor().getUiComponent()).getText();
            String exp   = ((JTextField) exipirydate_dateChooserCombo.getDateEditor().getUiComponent()).getText();
            
            if (desc.equals("")) {
                desc = "NULL";
            }
            if (prod_desc.equals("")) {
                prod_desc = "NULL";
            }
            if (effc.equals("")) {
                effc = "NULL";
            }
            if (prod_eff_mat.equals("")) {
                prod_eff_mat = "NULL";
            }

            if(!name.isEmpty() && index > 0 && !price.isEmpty() && !quant.isEmpty() && !prod.isEmpty() && !exp.isEmpty()) 
            {      
                if(Integer.parseInt(quant) > Integer.parseInt(prod_quantity)) //Wanna insert new
                {
                    int newQuantity = Integer.parseInt(quant);
                    int oldQuantity = Integer.parseInt(prod_quantity);
                    
                    while(newQuantity != oldQuantity)
                    {
                        try {
                            String sql = "INSERT INTO `products`(`Name`, `Type`, `Description`, `EffectiveMaterial`, `Price`, `ProductionDate`, `ExpirationDate`) "
                                    + "VALUES ('"+name+"','"+type+"','"+desc+"','"+effc+"','"+df.format(Double.parseDouble(price))+"','"+prod+"','"+exp+"')";
                            Statement st = conn.createStatement();
                            int rs = st.executeUpdate(sql);
                            if(rs > 0)
                            {
                                st.close();
                                int ID = 0;
                                sql = "SELECT * FROM (\n"
                                    + "    SELECT * FROM `products` ORDER BY SerialNumber DESC LIMIT 1\n"
                                    + ") sub\n"
                                    + "ORDER BY SerialNumber ASC";
                                Statement st2 = conn.createStatement();
                                ResultSet rs2 = st2.executeQuery(sql);
                                if (rs2.next()) {
                                    ID = rs2.getInt("SerialNumber");
                                }
                                st.close();
                                //
                                int barcode = 0, temp = 0;
                                barcode = ID;
                                String[] exDate = exp.split("-");

                                for (String a : exDate) {
                                    temp = Integer.parseInt(a);
                                    barcode += temp;
                                }
                                sql = "UPDATE `products` SET `Barcode`= '" + barcode + "' ORDER BY SerialNumber DESC LIMIT 1";
                                Statement st3 = conn.createStatement();
                                int re3 = st3.executeUpdate(sql);
                                if (!(re3 > 0)) {
                                    Logger.getLogger(ModifyProducts.class.getName()).log(Level.SEVERE, null, "Data is not updated");
                                }
                            }
                            newQuantity--;
                        } catch (SQLException ex) {
                            Logger.getLogger(ModifyProducts.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }                    
                }
                else if(Integer.parseInt(quant) < Integer.parseInt(prod_quantity)) //Wanna delete 
                {
                    int newQuantity = Integer.parseInt(quant);
                    int oldQuantity = Integer.parseInt(prod_quantity);
                    
                    while(newQuantity != oldQuantity)
                    {
                        try {
                            String sql = "DELETE FROM `products` WHERE `Name`= '"+name+"' AND `Type`= '"+type+"' AND `Description`= '"+desc+"' AND "
                                    + "`EffectiveMaterial`= '"+effc+"' AND `Price`= '"+df.format(Double.parseDouble(price))+"' AND `ProductionDate`= '"+prod+"' AND `ExpirationDate`= '"+exp+"' " 
                                    + "ORDER BY SerialNumber DESC LIMIT 1;";//May set LIMIT (n) .. but the used way is better to void any error
                            Statement st = conn.createStatement();
                            st.executeUpdate(sql);
                            newQuantity++;
                        } catch (SQLException ex) {
                            Logger.getLogger(ModifyProducts.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                try {
                    String query = "UPDATE `products` SET `Name`='"+name+"',`Type`='"+type+"',`Description`='"+desc+"',`EffectiveMaterial`= '"+effc+"',"
                            + "`Price`='"+df.format(Double.parseDouble(price))+"',`ProductionDate`='"+prod+"',`ExpirationDate`='"+exp+"' WHERE `Name`='"+prod_name+"' "
                            + "AND `Type`='"+prod_type+"' AND `Description`='"+prod_desc+"' AND `EffectiveMaterial`= '"+prod_eff_mat+"' "
                            + "AND `Price`='"+prod_price+"' AND `ProductionDate`='"+prod_producDate+"' AND `ExpirationDate`='"+prod_expDate+"';";
                    Statement stmt = conn.createStatement();
                    int result = stmt.executeUpdate(query);
                    if(result > 0) 
                    {
                        JOptionPane.showMessageDialog(null, "Data are updated successfully");
                        emptyingFields();
                        refreshTable();
                        query = "SELECT Name,Type,Description,EffectiveMaterial,Price,ProductionDate,ExpirationDate,group_concat(Distinct `ProductionDate` SEPARATOR ',') "
                           +"FROM `products` group by Name,ProductionDate,Type,Description,EffectiveMaterial;";
                        int all_quant = allAvailableProducts(query);
                        products_quantity_textfield.setText(String.valueOf(all_quant));
                        exp_products_quantity_textfield1.setText(String.valueOf(num_of_expired_products()));
                    }
                    else {
                        Logger.getLogger(ModifyProducts.class.getName()).log(Level.SEVERE, null, "Data aren't updated!");
                    }
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ModifyProducts.class.getName()).log(Level.SEVERE, null,"Error: "+ex);
                }
            }      
            else {
                JOptionPane.showMessageDialog(rootPane,"Fill all required fields!");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane,"Select row first to update!");
        }
    }//GEN-LAST:event_update_btnActionPerformed
    
    private void emptyingFields()
    {
        name_textfield.setText("");type_combobox.setSelectedIndex(0);quantity_textfield.setText("");description_textfield.setText("");price_textfield.setText("");
        eff_mat_textfield.setText("");proddate_dateChooserCombo.setCalendar(null); exipirydate_dateChooserCombo.setCalendar(null);
        search_textfieldd.setText("");products_quantity_textfield.setText("");exp_products_quantity_textfield1.setText("");
    }
    
    private void emptyingSomeFields() {
        name_textfield.setText("");type_combobox.setSelectedIndex(0);quantity_textfield.setText("");description_textfield.setText("");price_textfield.setText("");
        eff_mat_textfield.setText("");proddate_dateChooserCombo.setCalendar(null); exipirydate_dateChooserCombo.setCalendar(null);
    }
    
    private int allAvailableProducts(String query)
    {
        DefaultTableModel model = (DefaultTableModel) stock_table.getModel();
        Object[] rowData = new Object[8];
        int allQuant = 0;
        try
        {
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(query);
            String eff , desc , sql ;
            while (res.next()) 
            {                                
                if(res.getString("Description") == null || res.getString("Description").equals("NULL")) {
                    rowData[2] = "NULL";
                    desc  = "NULL";                    
                } else {
                    rowData[2] = res.getString("Description");
                    desc  = res.getString("Description");
                }
                if(res.getString("EffectiveMaterial") == null || res.getString("EffectiveMaterial").equals("NULL")) {
                    rowData[3] = "NULL";
                    eff   = "NULL";
                } else {
                    rowData[3] = res.getString("EffectiveMaterial");
                    eff   = res.getString("EffectiveMaterial");
                }
                
                rowData[0] = res.getString("Name");
                rowData[1] = res.getString("Type");
                rowData[4] = res.getDouble("Price");
                rowData[6] = res.getString("ProductionDate");
                rowData[7] = res.getString("ExpirationDate");
                
                //Get Number of repeated/samilar products (Quantity)
                sql = "SELECT COUNT(1) FROM `products` "
                            + "WHERE `Name`= '"+res.getString("Name")+"' AND `ExpirationDate`= '"+res.getString("ExpirationDate")+"' "
                            + "AND `ProductionDate`= '"+res.getString("ProductionDate")+"' AND `Type`= '"+res.getString("Type")+"' "
                            + "AND `Price`= '"+res.getDouble("Price")+"' AND `Description`= '"+desc+"' "
                            + "AND `EffectiveMaterial`= '"+eff+"';";
                Statement st = conn.createStatement();
                ResultSet result = st.executeQuery(sql);
                
                int quant = 0;
                while(result.next()) {
                    quant = result.getInt("count(1)");
                }
                rowData[5] = quant;

                model.addRow(rowData);
                allQuant += quant;
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModifyProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allQuant;
    }
    
    private int num_of_expired_products() {
        int quant = 0;
        try {
            String sql = "SELECT COUNT(1) FROM `products` WHERE `ExpirationDate` < '"+currentTime()+"'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                quant = rs.getInt("COUNT(1)");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModifyProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return quant;
    }
    
    private String currentTime()
    {
        String format = "YYYY-MM-dd";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        LocalDateTime now = LocalDateTime.now();
        String curDate = dtf.format(now);
        
        return curDate;
    }
        
    private void refreshTable()
    {
        DefaultTableModel model = (DefaultTableModel) stock_table.getModel(); 
        model.setRowCount(0);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_btn;
    private javax.swing.JButton delete_btn;
    private static javax.swing.JTextField description_textfield;
    private javax.swing.JTextField eff_mat_textfield;
    private com.toedter.calendar.JDateChooser exipirydate_dateChooserCombo;
    private javax.swing.JTextField exp_products_quantity_textfield1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private static javax.swing.JTextField name_textfield;
    private javax.swing.JTextField price_textfield;
    private com.toedter.calendar.JDateChooser proddate_dateChooserCombo;
    private javax.swing.JTextField products_quantity_textfield;
    private javax.swing.JTextField quantity_textfield;
    private javax.swing.JButton refresh_btn;
    private javax.swing.JButton search_btn;
    private javax.swing.JTextField search_textfieldd;
    private javax.swing.JComboBox<String> search_type_combobox;
    private javax.swing.JTable stock_table;
    private static javax.swing.JComboBox<String> type_combobox;
    private javax.swing.JButton update_btn;
    // End of variables declaration//GEN-END:variables
}
