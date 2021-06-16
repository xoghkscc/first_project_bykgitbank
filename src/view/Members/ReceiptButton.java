package view.Members;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import function.member.design.RoundButtonDesign;



public class ReceiptButton extends JFrame {
	
		
	public ReceiptButton() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(600,600);
		panel.setBackground(new Color(0, 36, 62));
		
		JButton logo = new JButton();
		logo.setIcon(new ImageIcon("./files/logo6.png"));
		logo.setBounds(200, 20, 170, 200);
		logo.setBorderPainted(false);
		
		
		JButton btn1 = new RoundButtonDesign("물품명으로 조회");
		btn1.setSize(150,150);
		btn1.setLocation(100,240);
		
		JButton btn2 = new RoundButtonDesign("날짜로 조회");
		btn2.setSize(150,150);
		btn2.setLocation(320,240);
		
		
		panel.add(btn1);
		panel.add(btn2);
		panel.add(logo);
		getContentPane().add(panel);
		setBounds(500,50, 600,600);	
		setVisible(true);
	
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = MemberSearchFrame.getTable().getSelectedRow();
				new ProductReceipt(Integer.parseInt((String)MemberSearchFrame.getModel().getValueAt(row, 0)));
			}
		});
	
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = MemberSearchFrame.getTable().getSelectedRow();
				new DateReceipt(Integer.parseInt((String)MemberSearchFrame.getModel().getValueAt(row, 0)));
			}
		});
	}
	
	
}
