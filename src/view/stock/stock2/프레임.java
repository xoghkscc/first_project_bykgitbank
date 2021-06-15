package view.stock.stock2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class 프레임 extends JFrame{

	public static JScrollPane jp;
	
	public 프레임() {
		// TODO Auto-generated constructor stub
//		stockTable.setSql("SELECT * FROM PRODUCTS");
		tableFactory tf = new tableFactory("SELECT * FROM PRODUCTS WHERE PRODUCT_TYPE = '아이스크림'");
	
		stockTable.setTable(tf.table);
		
		jp = new JScrollPane(stockTable.getTable());
		jp.setBounds(0, 0, 570, 510);
		jp.setVisible(true);
		
		jp.setBackground(Color.BLUE);
		
		JButton jb = new JButton();
		jb.setBounds(0, 0, 50, 50);
		jb.setVisible(true);
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				tableFactory tf = new tableFactory("SELECT * FROM PRODUCTS WHERE PRODUCT_TYPE = '어류'");
//				new tableFactory("SELECT * FROM PRODUCTS WHERE PRODUCT_TYPE = '어류'").table;
//				stockTable.setTable(tf.table);
				stockTable.setTable(new tableFactory("SELECT * FROM PRODUCTS WHERE PRODUCT_TYPE = '어류'").table);
				프레임.jp.setVisible(false);
				JScrollPane jp2 = new JScrollPane(stockTable.getTable());
				jp2.setBounds(0, 0, 570, 510);
				jp2.setVisible(true);
				add(jp2, BorderLayout.CENTER);
				add(jb, BorderLayout.NORTH);
				
//				setBounds(50,50,1300,1300);
//				setVisible(true);
//				setDefaultCloseOperation(EXIT_ON_CLOSE);
//				add(프레임.jp, BorderLayout.CENTER);
			}
			
		});
		add(jb, BorderLayout.NORTH);
		
		setBounds(50,50,1300,1300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(jp, BorderLayout.CENTER);
		
	}
	
	public static void main(String[] args) {
		new 프레임();
	}
}
