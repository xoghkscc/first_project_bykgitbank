package view.stock.nextFrame.type_search;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import view.stock.Table_make;

public class type_search_buttons extends JFrame{

	JFrame jf;

	String sql = "";
	String CompleteSql;
	String fullsql = null;
	public type_search_buttons(JFrame jf, String sql, String fullsql) {//JFrame jf, String sql 
		
		this.sql = sql;
		this.jf = jf;
		this.fullsql = fullsql;
		
		
		String nameString = null;
		
//		sql = sql.trim();
		if(sql == null) {
			sql = "행사품목현황";
			nameString = "행사품목현황";
		}else if(sql.equals("유통기한초과물품")) {
			setTitle( "sql");
			nameString = "\'"+ sql + "\'";
		}else {
			setTitle( "\'"+ sql + "\' 유형 재고 현황");			
			nameString = "\'"+ sql + "\'유형";
		}
		
		
		if(sql.equals("유통기한초과물품")) {
			
			CompleteSql = "SELECT * FROM PRODUCTS WHERE EXPIRATION_DATE < SYSDATE";
		}else {
			
			CompleteSql = "SELECT * FROM PRODUCTS WHERE Product_type = \'" + sql + "\'";
		}
	
		if(fullsql != null) {
			CompleteSql = fullsql;
		}
		
		System.out.println(CompleteSql);
		
		JPanel tablePanel = new Table_make(CompleteSql);
		JPanel namePanel = new JPanel();
		JLabel name = new JLabel(nameString);
		
		int numeric = 0;
		int alphabet = 0;
		int letter = 0;
		for(int i =0; i < sql.length(); i++) {
			if(sql.charAt(i) >= '0' && sql.charAt(i) <= '9') {
				
				numeric++;
			}else if((sql.charAt(i) >= 'a' && sql.charAt(i) <= 'z') || (sql.charAt(i) >= 'A' && sql.charAt(i) <= 'Z')) {
				alphabet++;
			}else {
				letter++;
			}
		}
		
		int BottonLineLength;
		if(sql.equals("유통기한초과물품")) {
			BottonLineLength = 213;
		}else {
			BottonLineLength =  (24 * letter) + (12 * alphabet) + (11 * numeric) + 75;
		}
		
		
		namePanel.add(name);
		name.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		name.setSize(BottonLineLength, 37);
		
		if(sql.equals("유통기한초과물품")) {
			name.setBorder(new TitledBorder(new MatteBorder(0,0,5,0, new Color(255,200,200))));
			name.setForeground(new Color(255,200,200));			
		}else {
			name.setBorder(new TitledBorder(new MatteBorder(0,0,5,0, new Color(255,255,200))));
			name.setForeground(new Color(255,255,200));			
		}
		name.setLocation(20, 10);
		add(namePanel, BorderLayout.NORTH);
		add(tablePanel, BorderLayout.CENTER);
		
		namePanel.setLayout(null);
		namePanel.setPreferredSize(new Dimension(100,45));
		namePanel.setLocation(0, 20);
		namePanel.setBackground(new Color(43,51,62));
		namePanel.setVisible(true);
		
		tablePanel.setBorder(BorderFactory.createEmptyBorder(0, 15, 15, 15));
		tablePanel.setBackground(new Color(43,51,62));
		tablePanel.setVisible(true);
		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900,600);
		setLocation(200,100);
		setVisible(true);
	}
	
//	public static void main(String[] args) {
//		new type_search_buttons();
//	}
}
