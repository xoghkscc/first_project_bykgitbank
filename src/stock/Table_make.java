package stock;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

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
		"SALES_TYPE"
	};
	
	private DefaultTableModel model = new DefaultTableModel(colNames, 0);
	
	public Table_make() {
//		setLayout(null);
		setLayout(new FlowLayout(FlowLayout.CENTER, 10,10));
		table = new JTable(model);	//테이블 생성
		table.addMouseListener(new JTableMouseListener()); //테이블에 마우스리스너 감지하는 클래스를 추가
		table.setRowHeight(40);	//테이블의 셀 높이 조정
		table.getColumn("PRODUCT_ID").setPreferredWidth(50); //테이블의 컬럼 셀 넓이 조정
		table.getColumn("PRODUCT_NAME").setPreferredWidth(200); 
		table.getColumn("EXPIRATION_DATE").setPreferredWidth(180);
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		
		//빈 테이블 객체 생성
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();
		
			
		for(int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
		
		
		dtcr.setBackground(new Color(255,255,255));
		
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(900,420));
		scrollPane.setLocation(100, 100);
		
		add(scrollPane);
	
//		initialize();
		select("select * from products");

	}
	private class JTableMouseListener implements MouseListener{	
		
		public void mouseClicked(MouseEvent e) {	//마우스클릭했을때의 액션
			
			JTable jtable = (JTable)e.getSource();
			int row = jtable.getSelectedRow();	//행값 넣기
			int col = jtable.getSelectedColumn();	//컬럼값 넣기
			
			System.out.println(model.getValueAt(row, col));
		}

	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	}
	
	private void select(String sql) {	
		ConnectDB cdb = new ConnectDB(sql);
		
		ArrayList<Object[]> arr = new ArrayList<>();
		
		arr = cdb.getSelect();
		for(int i = 0; i < arr.size(); i++) {
			model.addRow(arr.get(i));
		}
	}

//	public static void main(String[] args) {
//		
//		Table_make tm = new Table_make();
//		JFrame win = new JFrame();
//		
//		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		win.add(tm);
//		win.setSize(800,800);
//		win.setVisible(true);
//	}
}
