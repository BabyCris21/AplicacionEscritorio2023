package vista;
import java.awt.Component;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JLabel;
import javax.swing.JTable;

public class RenderImage extends DefaultTableCellRenderer {
       @Override
       public Component getTableCellRendererComponent(JTable table, Object value, boolean inSelected, boolean hasFocus, int row, int column){
           if (value instanceof JLabel) {
               JLabel lbl = (JLabel) value;
               return lbl;
           }
        return super.getTableCellRendererComponent(table, value, inSelected, hasFocus, row, column);
    }
       
}
