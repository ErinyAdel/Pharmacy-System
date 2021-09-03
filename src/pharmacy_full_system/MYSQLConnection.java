package pharmacy_full_system;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MYSQLConnection 
{

    public MYSQLConnection() {
    }
    
    public static Connection connect()
    {
        try {
            String driverClass = "com.mysql.jdbc.Driver";
            String URL = "jdbc:mysql://localhost:3306/pharmacy_system";
            String username = "root";
            String password = "";

            Class.forName(driverClass);
            Connection conn = (Connection) DriverManager.getConnection(URL,username,password);
            if(conn != null) {
                return conn;
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"MYSQL connector not found!"+ex,"Error",JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Wrong Query!"+ex,"Error",JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
}
