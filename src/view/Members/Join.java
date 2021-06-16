package view.Members;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import function.member.Member_plus;
import function.member.design.RoundButtonDesign;




public class Join extends JFrame {
	
	private static JTextField memberName;
	private static JTextField memberAddress;
	private static JTextField memberPhoneNumber;
	
	
	public Join () {
		
		super("회원 등록");
				
		setLayout(null);
				
//		JLabel join = new JLabel("#회원 등록#");
		JLabel label1 = new JLabel("이름 : ");
		memberName = new JTextField();
		JLabel label2 = new JLabel("주소 : ");
		memberAddress = new JTextField();
		JLabel label3 = new JLabel("연락처 : ");
		memberPhoneNumber = new JTextField();
		JButton btn = new RoundButtonDesign("회원 등록");
		
//		add(join);
		add(label1);
		add(label2);
		add(label3);
		add(memberName);
		add(memberAddress);
		add(memberPhoneNumber);
		add(btn);
		
		
		JButton logo = new JButton();
		logo.setIcon(new ImageIcon("./files/logo6.png"));
		logo.setBounds(75, 0, 337, 212);
		logo.setBorderPainted(false);
		add(logo);
		
//		join.setBounds(140,30, 1000,40);
//		join.setFont(new Font("맑은 고딕", Font.PLAIN, 35));
//		join.setForeground(new Color(255, 255, 255));
		
		label1.setBounds(80, 230, 100, 30);
		label1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		label1.setForeground(new Color(255, 255, 255));
		
		memberName.setBounds(180, 230, 200, 30);
		memberName.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
	
		
		label2.setBounds(80, 280, 200, 30);
		label2.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		label2.setForeground(new Color(255, 255, 255));
		
		memberAddress.setBounds(180, 280, 200, 30);
		memberAddress.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
	
		
		label3.setBounds(80, 330, 100, 30);
		label3.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		label3.setForeground(new Color(255, 255, 255));
		
		memberPhoneNumber.setBounds(180, 330, 200, 30);
		memberPhoneNumber.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		
		btn.setBounds(150,390,200,50);
		btn.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		btn.setForeground(new Color(102, 255, 102));
		btn.addActionListener(new Member_plus());
		
		setBounds(500, 50, 500, 500);
		getContentPane().setBackground(new Color(0,36,62));
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new Join();
	}
	
	public static JTextField getMemberName(){
		return memberName;
	}
	public static JTextField getMemberAddress(){
		return memberAddress;
	}
	public static JTextField getMemberPhoneNumber(){
		return memberPhoneNumber;
	}
}



