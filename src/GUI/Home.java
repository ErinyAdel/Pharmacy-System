package GUI;

import static pharmacy_full_system.MYSQLConnection.connect;
import GUI.InternalFrame.AddReceipt;
import GUI.InternalFrame.EditReceipt;
import GUI.InternalFrame.ModifyProducts;
import GUI.InternalFrame.LastSales;
import static GUI.Login.password_text;
import static GUI.Login.username_text;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;

public class Home extends javax.swing.JFrame 
{
    private Connection conn = connect();
    String username = String.valueOf(username_text.getText());
    String password = String.valueOf(password_text.getText());
    
    public Home() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);  
        ImageIcon img = new ImageIcon("E:\\Faculty\\Summer 2020\\Applications\\Desktop App\\Pharmacy_Full_System\\src\\Images\\pharmacy_icon.png");
        setIconImage(img.getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        desktopPane = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        file_Menu = new javax.swing.JMenu();
        logout_MenuItem = new javax.swing.JMenuItem();
        exit_MenuItem = new javax.swing.JMenuItem();
        sales_menu = new javax.swing.JMenu();
        addreceipt_MenuItem = new javax.swing.JMenuItem();
        lastsales_MenuItem = new javax.swing.JMenuItem();
        editreceipt_MenuItem = new javax.swing.JMenuItem();
        stock_menu = new javax.swing.JMenu();
        modifystock_MenuItem = new javax.swing.JMenuItem();
        expirationprod_MenuItem = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dr. Mina Pharmacy");
        setBackground(new java.awt.Color(51, 51, 51));
        setResizable(false);

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1156, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 489, Short.MAX_VALUE)
        );

        file_Menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/New_File_Icon.png"))); // NOI18N
        file_Menu.setText("File");

        logout_MenuItem.setText("Log out");
        logout_MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_MenuItemActionPerformed(evt);
            }
        });
        file_Menu.add(logout_MenuItem);

        exit_MenuItem.setText("Exit");
        exit_MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_MenuItemActionPerformed(evt);
            }
        });
        file_Menu.add(exit_MenuItem);

        jMenuBar1.add(file_Menu);

        sales_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/medicines_sales_icon.png"))); // NOI18N
        sales_menu.setText("Sales");

        addreceipt_MenuItem.setText("Add Receipt");
        addreceipt_MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addreceipt_MenuItemActionPerformed(evt);
            }
        });
        sales_menu.add(addreceipt_MenuItem);

        lastsales_MenuItem.setText("Last Sales");
        lastsales_MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastsales_MenuItemActionPerformed(evt);
            }
        });
        sales_menu.add(lastsales_MenuItem);

        editreceipt_MenuItem.setText("Edit Receipt");
        editreceipt_MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editreceipt_MenuItemActionPerformed(evt);
            }
        });
        sales_menu.add(editreceipt_MenuItem);

        jMenuBar1.add(sales_menu);

        stock_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/medicines_icon.png"))); // NOI18N
        stock_menu.setText("Stocks");

        modifystock_MenuItem.setText("Modify The Stock");
        modifystock_MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifystock_MenuItemActionPerformed(evt);
            }
        });
        stock_menu.add(modifystock_MenuItem);

        expirationprod_MenuItem.setText("Expired Products");
        expirationprod_MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expirationprod_MenuItemActionPerformed(evt);
            }
        });
        stock_menu.add(expirationprod_MenuItem);

        jMenuBar1.add(stock_menu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lastsales_MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastsales_MenuItemActionPerformed
        LastSales internalFrame = new LastSales();
        desktopPane.add(internalFrame);
        internalFrame.setVisible(true);
    }//GEN-LAST:event_lastsales_MenuItemActionPerformed

    private void addreceipt_MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addreceipt_MenuItemActionPerformed
        AddReceipt internalFrame = new AddReceipt();
        desktopPane.add(internalFrame);
        internalFrame.setVisible(true);
    }//GEN-LAST:event_addreceipt_MenuItemActionPerformed

    private void exit_MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_MenuItemActionPerformed
        int ch = JOptionPane.showConfirmDialog(null, "Are you sure","Select option",JOptionPane.YES_NO_OPTION);
        if (ch == JOptionPane.YES_OPTION)
            System.exit(0);
    }//GEN-LAST:event_exit_MenuItemActionPerformed

    private void modifystock_MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifystock_MenuItemActionPerformed
        try {
            String query = "SELECT `UserType` FROM `users` WHERE `UserType`= 1 AND `Username`= '"+username+"' AND `Password`= '"+password+"'";
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(query);
            
            if(res.next()) 
            {
                ModifyProducts internalFrame = null;
                internalFrame = new ModifyProducts();
                desktopPane.add(internalFrame);
                internalFrame.setVisible(true);
            }
            else {
                JOptionPane.showConfirmDialog(rootPane,"You're not allowed to modify stocks");
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModifyProducts.class.getName()).log(Level.SEVERE, null,"Error: "+ex);
        }
        
    }//GEN-LAST:event_modifystock_MenuItemActionPerformed

    private void logout_MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_MenuItemActionPerformed
        this.dispose();
        Login login = new Login();
        login.setVisible(true);
        LastSales l = new LastSales();
        if(l.recD != null) {
            l.recD.setVisible(false);
        }
    }//GEN-LAST:event_logout_MenuItemActionPerformed

    private void expirationprod_MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expirationprod_MenuItemActionPerformed
        ExpiredProducts expiredPage = new ExpiredProducts();
        expiredPage.setVisible(true);
    }//GEN-LAST:event_expirationprod_MenuItemActionPerformed

    private void editreceipt_MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editreceipt_MenuItemActionPerformed
        EditReceipt internalFrame = new EditReceipt();
        desktopPane.add(internalFrame);
        internalFrame.setVisible(true);
    }//GEN-LAST:event_editreceipt_MenuItemActionPerformed

    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addreceipt_MenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem editreceipt_MenuItem;
    private javax.swing.JMenuItem exit_MenuItem;
    private javax.swing.JMenuItem expirationprod_MenuItem;
    private javax.swing.JMenu file_Menu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem lastsales_MenuItem;
    private javax.swing.JMenuItem logout_MenuItem;
    private javax.swing.JMenuItem modifystock_MenuItem;
    private javax.swing.JMenu sales_menu;
    private javax.swing.JMenu stock_menu;
    // End of variables declaration//GEN-END:variables
}
