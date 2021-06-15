package view.stock.stock2;

import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import view.stock.ConnectDB;

public class tableFactory {

	JTable table;
	JScrollPane tablePanel;
	
	String sql;
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
	public tableFactory(String sql) {
		// TODO Auto-generated constructor stub
		
		this.sql = sql;
		
		ConnectDB cdb = new ConnectDB(sql);
		
		ArrayList<Object[]> arr = new ArrayList<>();
		
		arr = cdb.getSelect();
		
		
		
		DefaultTableModel model = new DefaultTableModel(colNames, 0);
		
//		jp = new JPanel();
//		JTable table = new JTable(model);	//테이블 생성
		table = new JTable(model);
		
		
		//빈 테이블 객체 생성
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();
		
			
		for(int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
		
		
//		scrollPane = new JScrollPane(table);
		
		
		
		for(int i = 0; i < arr.size(); i++) {
			model.addRow(arr.get(i));
		}
		
//		tablePanel = new JScrollPane(table);
//		scrollPane.setBounds(0, 0, 870, 510);
//		scrollPane.setVisible(true);
	}
}
