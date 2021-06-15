package function.stock;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import view.stock.ConnectDB;
//import view.stock.Table_make.JTableMouseListener;

public class ActionSelectButton{

//	JTable table;
	private static JScrollPane scrollPane;
	String sql;
	JPanel jp;
	int width;
	int height;
	String startDate;
	String endDate;
	JDatePickerImpl datePickerStart;
	JDatePickerImpl datePickerEnd;
	UtilDateModel modelStart;
	UtilDateModel modelEnd;
	
	static DefaultTableModel model;
	
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
	
	public ActionSelectButton(JFrame jf,JPanel indexes,String sql, JPanel jp, int width, int height) {
		this.sql = sql;
		this.jp = jp;
		this.width = width;
		this.height = height;
		
		System.out.println("액션sql" + sql);
		System.out.println(sql);
		
		ConnectDB cdb = new ConnectDB(sql);
		
		ArrayList<Object[]> arr = new ArrayList<>();
		
		arr = cdb.getSelect();
		
		model = new DefaultTableModel(colNames, 0);
		
//		jp = new JPanel();
		JTable table = new JTable(model);	//테이블 생성
	
		table.getColumn("PRODUCT_ID").setPreferredWidth(50);
		table.getColumn("DISCOUNT_RATE").setPreferredWidth(50);
		table.getColumn("EXPIRATION_DATE").setPreferredWidth(100);
		table.getColumn("EXPIRATION_DATE").setPreferredWidth(100);
		table.getColumn("PRODUCT_NAME").setPreferredWidth(120);
		table.setRowHeight(40);
		//빈 테이블 객체 생성
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();
		
			
		for(int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
		
		
		scrollPane = new JScrollPane(table);
		
		
		
		for(int i = 0; i < arr.size(); i++) {
			model.addRow(arr.get(i));
		}
	
		scrollPane.setBounds(0, 0, 870, 510);
		scrollPane.setPreferredSize(new Dimension(870,510));
		scrollPane.setVisible(true);
		jp.add(scrollPane);
		jp.setBounds(20, 100, 900, 700);
		jp.setPreferredSize(new Dimension(870,520));
		
		indexes.add(jp, FlowLayout.CENTER);
		
	}

	public static void setScrollPane(JScrollPane scrollPane) {
		ActionSelectButton.scrollPane = scrollPane;
		
	}
	public static JScrollPane getScrollPane() {
		return scrollPane;
	}
	
	public static DefaultTableModel getModel() {
		return model;
	}
}
