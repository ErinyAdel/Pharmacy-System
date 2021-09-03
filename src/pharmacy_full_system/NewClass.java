package pharmacy_full_system;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class NewClass {

    public static void main(String[] argv) throws Exception 
    {
        JTable table = new JTable();
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        model.addColumn("A", new Object[]{"item1"});
        model.addColumn("B", new Object[]{"item2"});

        String[] values = new String[]{"1", "2", "3"};

        TableColumn col = table.getColumnModel().getColumn(0);
        col.setCellEditor((TableCellEditor) new MyComboBoxEditor(values));
        col.setCellRenderer((TableCellRenderer) new MyComboBoxRenderer(values));
    }
}