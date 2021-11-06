package Models;

import javax.swing.table.DefaultTableModel;



public class TableModelPedido extends DefaultTableModel {

    public boolean isCellEditable(int linha, int coluna){

        return false;
    }

}
