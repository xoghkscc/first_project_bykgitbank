package view.stock;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import function.stock.MouseListener_getDataFromTable;

public class Table_make extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	private String colNames2[] = { 
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
			"COST",
			"순이익"
		};
	
	private DefaultTableModel model;
	DefaultTableCellRenderer dtcr;
	
	String update = null;
	String sql;
	String doit;
	public Table_make(String sql,String update, String doit) {
//		setLayout(null);
		this.update = update;
		this.doit = doit;
		this.sql = sql;
		
		if(sql.equals("SELECT * FROM PRODUCTS INNER JOIN "
				+ "(SELECT product_id,(product_price - COST) AS 순이익 FROM PRODUCTS) USING(product_id)")){
			model = new DefaultTableModel(colNames2, 0);
		}else {
			
			model = new DefaultTableModel(colNames, 0);
		}
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 10,10));
		table = new ColorGrayTable(model);	//테이블 생성
		
		//중요 리스너!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		if(doit != null) {
			table.addMouseListener(new MouseListener_getDataFromTable(table, doit));
//			if(doit.equals("productUpdate")) {
//				table.addMouseListener(new MouseListener_getDataFromTable(table, "productUpdate"));
//			}
//			
//			if(doit.equals("registEvent")) {
//				
//				table.addMouseListener(new MouseListener_getDataFromTable(table, "registEvent")); //테이블에 마우스리스너 감지하는 클래스를 추가
//			}
//			
//			if(doit.equals("disposal")) {
//				
//				table.addMouseListener(new MouseListener_getDataFromTable(table, "disposal"));
//				
//			}
		}
		
		table.setRowHeight(40);	//테이블의 셀 높이 조정
		table.getColumn("PRODUCT_ID").setPreferredWidth(50); //테이블의 컬럼 셀 넓이 조정
		table.getColumn("PRODUCT_NAME").setPreferredWidth(150); 
		table.getColumn("EXPIRATION_DATE").setPreferredWidth(120);
		table.getColumn("DISCOUNT_TYPE").setPreferredWidth(100);
		table.getColumn("DISCOUNT_RATE").setPreferredWidth(50);
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		
	
	
		if(sql.equals("SELECT * FROM PRODUCTS INNER JOIN "
				+ "(SELECT product_id,(product_price - COST) AS 순이익 FROM PRODUCTS) USING(product_id)")){
			table.getColumn("순이익").setPreferredWidth(150);
		}
		
		//컬럼헤더 크기바꾸기
		JTableHeader header = table.getTableHeader();
		header.setPreferredSize(new Dimension(100, 40));
		header.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		
		//컬럼이름 바꾸기
		header.getColumnModel().getColumn(0).setHeaderValue("번호");
		header.getColumnModel().getColumn(1).setHeaderValue("품목이름");
		header.getColumnModel().getColumn(2).setHeaderValue("품목유형");
		header.getColumnModel().getColumn(3).setHeaderValue("가격");
		header.getColumnModel().getColumn(4).setHeaderValue("유통기한");
		header.getColumnModel().getColumn(5).setHeaderValue("행사유형");
		header.getColumnModel().getColumn(6).setHeaderValue("할인율");
		header.getColumnModel().getColumn(7).setHeaderValue("원산지");
		header.getColumnModel().getColumn(8).setHeaderValue("수량");
		header.getColumnModel().getColumn(9).setHeaderValue("무게");
		header.getColumnModel().getColumn(10).setHeaderValue("판매유형");
		header.getColumnModel().getColumn(11).setHeaderValue("원가");
		
		
		//빈 테이블 객체 생성
		dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();
		
		System.out.println(tcm.getColumnCount());
		for(int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
		
		
		
		
		dtcr.setBackground(model.getRowCount() % 2 == 0? new Color(255,255,255) : Color.BLUE);
//		dtcr.setBackground(new Color(255,255,255));
		
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(850,490));
		scrollPane.setLocation(100, 100);
		
		
		add(scrollPane);

//		initialize();
		select(sql);

	}
	
	
	private void select(String sql) {	

		ConnectDB cdb = new ConnectDB(sql);

		ArrayList<Object[]> arr = new ArrayList<>();
		
		arr = cdb.getSelect();
		for(int i = 0; i < arr.size(); i++) {
			model.addRow(arr.get(i));
			
//			dtcr.setb
//			dtcr.setBackground(table.isRowSelected(i) % 2 == 0? new Color(255,255,255) : Color.BLUE);
		}
	}
}
class ColorGrayTable extends JTable {
	
	public ColorGrayTable(DefaultTableModel dtm) { 
		// TODO Auto-generated constructor stub 
		super(dtm); 
	} 
	@Override 
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		// TODO Auto-generated method stub 
		
		JComponent component = (JComponent) super.prepareRenderer(renderer, row, column); 
		component.setBackground(row % 2 == 0 ? new Color(230,230,230) : Color.WHITE); 
		return component;

	}
	
}


