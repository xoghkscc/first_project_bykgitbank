package view.stock.stock2;

import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import view.stock.ConnectDB;

public class stockTable extends JTable{
	
	static private JTable table;
	
	private  stockTable() {	}
	
	public static JTable getTable() {
		
		if(table == null) {
			table = new stockTable();
		}
		
		return table;
	}
	public static void setTable(JTable table) {
		stockTable.table = table;
		System.out.println("넵");
		
	}
	
}
