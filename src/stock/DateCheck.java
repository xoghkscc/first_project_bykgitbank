package stock;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class DateCheck {

//	JFrame jf; 
	private JPanel indexes;
	
	public DateCheck() {
		
		UtilDateModel modelStart = new UtilDateModel();
		UtilDateModel modelEnd = new UtilDateModel();
		
		JDatePanelImpl datePanelStart = new JDatePanelImpl(modelStart);
		JDatePanelImpl datePanelEnd = new JDatePanelImpl(modelEnd);
		
		JDatePickerImpl datePickerStart = new JDatePickerImpl(datePanelStart);
		JDatePickerImpl datePickerEnd = new JDatePickerImpl(datePanelEnd);
		
//		this.jf = jf;
		indexes = new JPanel();
		
		JPanel datePanel = new JPanel();
//		JTable productTable = new JTable(3, 4);


		datePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
		datePickerStart.setPreferredSize(new Dimension(203,28)); //Layout 이 있을때 크기조절
//		datePickerStart.setSize(203,28);//null일때 크기조절
		datePickerEnd.setPreferredSize(new Dimension(203,28));
//		datePickerEnd.setSize(203,28);
//		datePickerStart.setLocation(50, 20); //null일때 크기조절
//		datePickerEnd.setLocation(280,20);
//		datePickerStart.setVisible(true);
//		datePickerEnd.setVisible(true);
		
		//datePanel에 datePickerStart, datePickerEnd 추가 (날짜선택화면두개)
		indexes.setSize(1000,733);
		indexes.add(datePanel);
		datePanel.add(datePickerStart);
		datePanel.add(datePickerEnd);

//		JButton jb = new JButton("바보");
//		jb.setSize(80,80);
//		jb.setLocation(100, 100);
//		jb.setVisible(true);
//		datePanel.add(jb);
		
		datePanel = new Searching_product(datePanel).getIndex();
		

		DateCheckAction dc = new DateCheckAction(modelStart);
		DateCheckAction dc2 = new DateCheckAction(modelEnd);
		
		//DateCheckAction 
		datePickerStart.addActionListener(dc);
		datePickerEnd.addActionListener(dc2);
		
		//컬러
		indexes.setBackground(new Color(43,51,62));
		
		//GridLayout 사용
//		indexes.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
//		
		indexes.add(datePanel, BorderLayout.NORTH);
		
		indexes.add(new Table_make(), FlowLayout.CENTER);
		
//		productTable.setVisible(true);
		datePanel.setVisible(true);
//		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		indexes.setVisible(true);
		
	}

	public JPanel getIndexes() {
		return indexes;
	}


//	public static void main(String[] args) {
//		new DateCheck();
//	}
}
