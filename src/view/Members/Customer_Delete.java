package view.Members;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import view.Members.Customer_Function.Member_plus;
import view.Members.Customer_Function.PushCustomerDelete;
import view.Members.Design.RoundButtonDesign;

public class Customer_Delete extends JFrame  {
	
	private static JTextField customerName;
	private static JTextField customerNumber;
	private static JTextField customerID;
	
	
	public Customer_Delete() { 
		
		super("회원 삭제");
		
		setLayout(null);
				
		JLabel join = new JLabel("#회원 삭제#");
		JLabel label1 = new JLabel("이름 : ");
		customerName = new JTextField();
	
		JButton btn = new RoundButtonDesign("회원 삭제");
		
		add(join);
		add(label1);
		add(customerName);
		add(btn);
		
		join.setBounds(140,30, 1000,40);
		join.setFont(new Font("맑은 고딕", Font.PLAIN, 35));
		
		label1.setBounds(80, 100, 100, 30);
		label1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		
		customerName.setBounds(180, 100, 200, 40);
		customerName.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		
		
		btn.setBounds(140,350,200,50);
		btn.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		btn.setForeground(new Color(102, 255, 102));
		btn.addActionListener(new PushCustomerDelete());
		
		setBounds(500, 50, 500, 500);
		setBackground(new Color(43,51,62));
		setVisible(true);
		
	}
	
//	public static void main(String[] args) {
//		new Join();
//	}
	
	public static JTextField getCustomerName(){
		return customerName;
	}
	
}

