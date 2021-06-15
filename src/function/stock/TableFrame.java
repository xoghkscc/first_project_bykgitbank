package function.stock;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableFrame extends JFrame{

	ArrayList<Object[]> arr;
	
	private JTable table;
	private JScrollPane scrollPane;	//스크롤 자동생성
	
	private String colNames[] = { 
		"PRODUCT_ID",    
		"PRODUCT_NAME", 
		"PRODUCT_TYPE", 
		"PRODUCT_PRICE",   
		"EXPIRATION_DATE",         
		"DISCOUNT_TYPE", 
		"DISCOUNT_RATE",  
		"PRUDUCT_ORIGIN", 
		"STOCKS",   
		"GRAM",    
		"SALES_TYPE",
		"COST"
	};
	
	private DefaultTableModel model = new DefaultTableModel(colNames, 0);
	
	private String sql;
	
	public TableFrame(ArrayList<Object[]> arr) {
		// TODO Auto-generated constructor stub
		this.arr = arr;
		
		setBounds(100, 100, 600, 600);
		setVisible(true);
		
//		add(new Table_make())
	}
}
