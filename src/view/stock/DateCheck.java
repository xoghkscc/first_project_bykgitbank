package view.stock;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class DateCheck {

//	JFrame jf; 
	String startDate;
	String endDate;
	public static JPanel table_panel;
	
	private JPanel indexes;
	
	public DateCheck(JFrame jf) {
		
		UtilDateModel modelStart = new UtilDateModel();
		UtilDateModel modelEnd = new UtilDateModel();
		
		JDatePanelImpl datePanelStart = new JDatePanelImpl(modelStart);
		JDatePanelImpl datePanelEnd = new JDatePanelImpl(modelEnd);
		
		JDatePickerImpl datePickerStart = new JDatePickerImpl(datePanelStart);
		JDatePickerImpl datePickerEnd = new JDatePickerImpl(datePanelEnd);
		
		//데이트 피커 안의 글자 
		datePickerStart.getJFormattedTextField().setText("  처음날짜를 선택하세요");
		datePickerStart.getJFormattedTextField().setForeground(new Color(145,145,145));
		datePickerEnd.getJFormattedTextField().setText("  마지막날짜를 선택하세요");
		datePickerEnd.getJFormattedTextField().setForeground(new Color(145,145,145));
		
		modelStart.setDate(2021, 00, 01);
		modelEnd.setDate(2021, 11, 31);

		indexes = new JPanel();
		
		JPanel datePanel = new JPanel();

		datePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
		datePickerStart.setPreferredSize(new Dimension(203,28)); //Layout 이 있을때 크기조절
		datePickerEnd.setPreferredSize(new Dimension(203,28));

		
		//datePanel에 datePickerStart, datePickerEnd 추가 (날짜선택화면두개)
		indexes.setSize(1000,733);
		indexes.add(datePanel);
		datePanel.add(datePickerStart);
		datePanel.add(datePickerEnd);
		

		//컬러
		indexes.setBackground(new Color(43,51,62));
		
		//GridLayout 사용
//		indexes.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
//		
		indexes.add(datePanel, BorderLayout.NORTH);
		
		JPanel table_panel = new Table_make("SELECT * FROM PRODUCTS",null,null);
//		JPanel table_panel = new JPanel();
		table_panel.setBounds(0, 0, 700, 700);
		table_panel.setSize(700, 700);
		table_panel.setPreferredSize(new Dimension(870,520));
		
		table_panel.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
		table_panel.setBackground(new Color(43,51,62));
		indexes.add(table_panel, FlowLayout.CENTER);
		
		datePanel = new Searching_product(jf,indexes, table_panel,datePanel,datePickerStart,datePickerEnd,modelStart,modelEnd).getIndex();

		datePanel.setVisible(true);
		indexes.setVisible(true);
		
	}

	public JPanel getIndexes() {
		return indexes;
	}


//	public static void main(String[] args) {
//		new DateCheck();
//	}
}
