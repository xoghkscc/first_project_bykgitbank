package function.store;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class LookupRightTable_product extends JTable{
	private static DefaultTableModel rightTableProductModel;
	private static JTable table;
	private static JScrollPane pane;
	public LookupRightTable_product() {
		setSize(600, 400);
		ArrayList<String> header = new ArrayList<String>(); 
		header.add("시간");
		header.add("개수 및 무게");
		String[] headerArr = new String[header.size()];
		header.toArray(headerArr);
		rightTableProductModel = (DefaultTableModel) this.getModel();
		setFont(new Font("맑은 고딕", Font.BOLD, 12));
		getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD, 16));
		getTableHeader().setBackground(new Color(218, 222, 227));
		rightTableProductModel.setColumnIdentifiers(headerArr);
		
	}
	
	public static DefaultTableModel getRightTableProductModel() {
		return rightTableProductModel;
	}
	public static JTable gettable() {
		return table;
	}
}

