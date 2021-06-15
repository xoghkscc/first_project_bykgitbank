package view.Members;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import function.member.PushCustomerDelete;
import function.member.design.RoundButtonDesign;



public class Customer_Delete extends JFrame  {
	
	private static JTextField customerName;
	private static JTextField customerNumber;
	private static JTextField customerID;
	
	
	public Customer_Delete() { 
		
		super("회원 삭제");
		
		setLayout(null);
				
//		JLabel join = new JLabel("#회원 삭제#");
		JLabel label1 = new JLabel("이름 : ");
		customerName = new JTextField();
	
		JButton btn = new RoundButtonDesign("회원 삭제");
		
		JButton logo = new JButton();
		logo.setIcon(new ImageIcon("./files/logo7.png"));
		logo.setBounds(75, 20, 337, 212);
		logo.setBorderPainted(false);
		add(logo);
		
//		add(join);
		add(label1);
		add(customerName);
		add(btn);
		
//		join.setBounds(140, 230, 1000,40);
//		join.setFont(new Font("맑은 고딕", Font.PLAIN, 35));
//		join.setForeground(new Color(255, 255, 255));
		
		label1.setBounds(80, 290, 100, 30);
		label1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		label1.setForeground(new Color(255, 255, 255));
		
		customerName.setBounds(150, 290, 200, 30);
		customerName.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		customerName.setBackground(new Color(255, 255, 255));
		
		
		btn.setBounds(150,370,200,50);
		btn.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		btn.setForeground(new Color(100, 100, 100));
		btn.addActionListener(new PushCustomerDelete());
		
		setBounds(500, 50, 500, 500);
		getContentPane().setBackground(new Color(0,36,62));
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Customer_Delete();
	}
	
	public static JTextField getCustomerName(){
		return customerName;
	}
	
	
	
}

