package pharmacy_full_system;

import GUI.InternalFrame.AddReceipt;
import static GUI.InternalFrame.AddReceipt.readFromFile;
import GUI.InternalFrame.ModifyProducts;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static pharmacy_full_system.MYSQLConnection.connect;

public class CommonMethod 
{
    private final Connection conn = connect();

    private void allAvailableProducts(String query, JTable tableName)
    {
        DefaultTableModel model = (DefaultTableModel) tableName.getModel();
        Object[] rowData = new Object[7];
        
        try
        {
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(query);

            while (res.next()) 
            {
                rowData[0] = res.getString("Name");
                rowData[1] = res.getString("Type");
                rowData[2] = res.getString("Description");
                rowData[3] = res.getDouble("Price");

                rowData[5] = res.getString("ProductionDate");
                rowData[6] = res.getString("ExpirationDate");

                String namee = res.getString("Name");
                String exp = res.getString("ExpirationDate");
                String prod = res.getString("ProductionDate");
                
                String sql = "SELECT COUNT(1) FROM `products` "
                            + "WHERE `Name`= '"+namee+"' AND `ExpirationDate`= '"+exp+"' AND `ProductionDate`= '"+prod+"';";
                Statement st = conn.createStatement();
                ResultSet result = st.executeQuery(sql);
                int quant = 0;
                while(result.next()) {
                    quant = result.getInt("count(1)");
                }
                rowData[4] = quant;

                model.addRow(rowData);
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModifyProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private String currentTime()
    {
        String format = "MM/dd/yyyy";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        LocalDateTime now = LocalDateTime.now();
        String curDate = dtf.format(now);
        
        return curDate;
    }
    
    public static int readFromFile(String fileName) 
    {
        int rec_num = 0;
        try (DataInputStream inn = new DataInputStream(new FileInputStream(fileName))) { //"receiptNumberFile.txt"
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

    private void writeInFile(int rec_num,String fileName) 
    {
        try (DataOutputStream ut = new DataOutputStream(new FileOutputStream(fileName))) {
            ut.writeInt(rec_num);
        } catch (IOException ex) {
            Logger.getLogger(AddReceipt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void refreshTable(JTable tableName)
    {
        DefaultTableModel model = (DefaultTableModel) tableName.getModel();        
        model.setRowCount(0);
        tableName.clearSelection();
        //stock_table.getSelectionModel().clearSelection();
        //stock_table.clearSelection();
        //stock_table.removeRowSelectionInterval(stock_table.getSelectedRow(),stock_table.getSelectedRow());
    }
}
