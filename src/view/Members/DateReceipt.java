package view.Members;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import function.member.design.RoundButtonDesign;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import view.stock.DateCheckAction;

public class DateReceipt extends JFrame {
	
	private static DefaultTableModel model;
	private static JTable table;
	public static UtilDateModel modelStart;
	public static JDatePickerImpl sales_time;
	
	
	public DateReceipt(int member_id) {
		
		JPanel panel1 = new JPanel();
		
		panel1.setLayout(null);
		
		modelStart = new UtilDateModel();
		
		JDatePanelImpl datePanelStart = new JDatePanelImpl(modelStart);
		
		sales_time = new JDatePickerImpl(datePanelStart);
		//데이트 피커 안의 글자 
		sales_time.getJFormattedTextField().setText("  조회할 날짜를 입력해주세요");
		sales_time.getJFormattedTextField().setForeground(new Color(145,145,145));
		sales_time.setBounds(110,40,300,25);
		sales_time.getJFormattedTextField().setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		
		
		JButton btn = new RoundButtonDesign("검색");
		btn.setBounds(420,40, 50,25);
		btn.setForeground(new Color(245, 173, 37));
		btn.addActionListener(new DateReceiptText(model));
		
		String[] header = {"구입한 품목","수량","가격"};
		
		model = new DefaultTableModel(header, 0) {
	
		 public boolean isCellEditable(int rowIndex, int mColIndex) {
             return false;
         }
     };
		
		table = new JTable(model);
		table.setFont(new Font("맑은 고딕", Font.PLAIN,17));
		table.getTableHeader().setReorderingAllowed(false);
	    table.getTableHeader().setResizingAllowed(false);
		table.setRowHeight(30);
		
		JTableHeader header1 = table.getTableHeader();
		header1.setPreferredSize(new Dimension(100, 40));
		header1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		
		JScrollPane pane = new JScrollPane(table);
		pane.setLocation(40, 100);
		pane.setSize(500,420);
			
		sales_time.setPreferredSize(new Dimension(203,28)); //Layout 이 있을때 크기조절
		
		DateCheckAction dc = new DateCheckAction(modelStart);
		
		//DateCheckAction 
		sales_time.addActionListener(dc);
		
		panel1.add(sales_time);
		panel1.add(btn);
		panel1.add(pane);
		panel1.setSize(1280,70);
		panel1.setLocation(50,50);
		panel1.setBackground(new Color(0,36 ,62));
		
		getContentPane().add(panel1);
		setBounds(500,50,600,600);
		setVisible(true);
	
		
		
	}

	public static DefaultTableModel getModel() {
		return model;
	}
	
	public static JTable getTable() {
		return table;
	}
	
	public static JDatePickerImpl getSales_time() {
		return sales_time;
	}
	
	
}
