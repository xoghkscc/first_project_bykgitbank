package view.stock.nextFrame.productEvent;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import function.stock.InsertDB_product;

public class UpdateEventCheck extends JFrame{

	String name;
	String rate;
	public UpdateEventCheck(String name, String rate) {//String name, String rate
		// TODO Auto-generated constructor stub
		this.name = name;
		this.rate = rate;
		
		
		JPanel ct = new JPanel();
		JPanel ct2 = new JPanel();
		
		add(ct);
		ct.setBounds(210, 25, 200, 65);
		ct.setLayout(null);
		ct.setVisible(true);
		ct.setBackground(new Color(0,36,62));
		add(ct2);
		ct2.setLayout(null);
		ct2.setVisible(true);
		ct2.setBounds(210, 110, 200, 65);
		ct2.setBackground(new Color(0,36,62));
	
		TitledBorder tb = new TitledBorder(new LineBorder(new Color(255,255,100), 5),"행사 이름 수정");
		tb.setTitleColor(new Color(255,235,75));
		tb.setTitleFont(new Font("맑은샘물체", Font.CENTER_BASELINE, 17));
		TitledBorder tb2 = new TitledBorder(new LineBorder(new Color(255,255,100), 5),"할인율 수정");
		tb2.setTitleColor(new Color(255,235,75));
		tb2.setTitleFont(new Font("맑은샘물체", Font.CENTER_BASELINE, 17));
		ct.setBorder(tb);
		ct2.setBorder(tb2);
		
		JLabel logo = new JLabel();
		logo.setIcon(new ImageIcon("./files/logo_stock3.JPG"));
		logo.setBounds(20, 30, 168, 168);
//		logo.setBorderPainted(false);
		
		JTextField jf1 = new JTextField();
		jf1.setBounds(20, 23, 160, 30);
		JTextField jf2 = new JTextField();
		jf2.setBounds(20, 23, 160, 30);
		
		JButton bt = new roundButton_updateEvent3("수정");
		bt.setBounds(275, 190, 60, 30);
		
		//버튼 액션
		bt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String sql = "UPDATE PRODUCTS SET DISCOUNT_TYPE = '" + jf1.getText() + "\', DISCOUNT_RATE = " +jf2.getText()
				+ " WHERE DISCOUNT_TYPE = '" +name+"\'";
				
				String info = "행사이름 : " + jf1.getText() + "\n 할인율 : " + jf2.getText() + "\n\t 변경하시겠습니까?";
				
				int yes = JOptionPane.showConfirmDialog(null, info, "수정요청", JOptionPane.YES_NO_OPTION);
				if(yes == JOptionPane.YES_OPTION) {
					
					
					setVisible(false);
					new InsertDB_product(sql);
				}
			}
			
		});
		
		
		ct.add(jf1);
		ct2.add(jf2);
		add(logo);
		add(bt);
		
		getContentPane().setBackground(new Color(0,36,62));
		setBounds(100, 100, 470, 290);
		setLayout(null);
		setVisible(true);
	}

}