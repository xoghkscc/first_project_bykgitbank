package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import function.topBar.ClickMain;
import function.topBar.ClickMainDesign;
import function.topBar.TopBar;

public class DeliveryMainFrame extends JFrame {
	JFrame jf;
	public DeliveryMainFrame(JFrame jf) {
		this.jf = jf;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBackground(new Color(43, 51, 62));
		setSize(jf.getWidth(), jf.getHeight());
		setLocation(jf.getX(), jf.getY());
	
//		setLayout(null);
		
		JButton test2 = new ClickMainDesign();
		test2.addActionListener(new ClickMain(jf, this));

		add(test2);
		
		JPanel topBar = new TopBar();
		add(topBar, BorderLayout.NORTH);
		
		JPanel center = new JPanel();
		add(center, BorderLayout.CENTER);
		center.setLayout(null);
		center.setSize(1280, 700);
		center.setLocation(50, 50);
		center.setVisible(true);
		
		JPanel left = new JPanel();
		
		left.setLayout(null);
		left.setSize(600, 700);
		left.setLocation(0, 50);
		left.setVisible(true);
		center.add(left);
		
		JButton orderList = new JButton("주문 목록");
		orderList.setLayout(null);
		orderList.setSize(500, 50);
		orderList.setLocation(60, 30);
		orderList.setBackground(new Color(43, 51, 62));
		orderList.setForeground(Color.WHITE);
		
		orderList.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		
		orderList.setVisible(true);
		left.add(orderList);
		
		// 테이블 삽입
		

		
		String column[] =  {"DELIVERY_ID", "MEMBER_ID", "PAYMENT"}; 
		Object[][] DB = {
			{null, null, null},
			{null, null, null},
			{null, null, null},
			{null, null, null},
			{null, null, null},
			{null, null, null},
			{null, null, null}
			};
		 
		
		JTable table = new JTable(DB, column);
		
		table.setLayout(null);

	
		table.setLocation(60, 100);
		table.setSize(500, 400);
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		table.setVisible(true);
		
		left.add(table);
		 
		
		JPanel right = new JPanel();
		right.setLayout(null);
		right.setSize(600, 700);
		right.setLocation(615, 50);

		right.setVisible(true);
		center.add(right);
		
//		JPanel information = new JPanel();
//		information.setLayout(null);
//		information.setSize(450, 50);
//		information.setLocation(50, 30);
//		information.setBackground(new Color(43, 51, 62));
		
		JLabel information = new JLabel("주문자 정보", JLabel.CENTER);
		information.setLayout(null);
		information.setSize(450, 40);
		information.setLocation(100, 30);
		information.setOpaque(true);
		information.setBackground(new Color(43, 51, 62));
		information.setForeground(Color.WHITE);
		information.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		JTextField informationText = new JTextField("테스트");
		informationText.setLayout(null);
		informationText.setSize(450, 50);
		informationText.setLocation(100, 70);
		informationText.setBackground(Color.WHITE);
		informationText.setHorizontalAlignment(JTextField.CENTER);
		informationText.setBorder(null);
		informationText.setFont(new Font("맑은 고딕", Font.PLAIN, 15));

		JLabel address = new JLabel("주소지 정보", JLabel.CENTER);
		address.setLayout(null);
		address.setSize(450, 40);
		address.setLocation(100, 160);
		address.setOpaque(true);
		address.setBackground(new Color(43, 51, 62));
		address.setForeground(Color.WHITE);
		address.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		JTextField addressText = new JTextField("테스트");
		addressText.setLayout(null);
		addressText.setSize(450, 50);
		addressText.setLocation(100, 200);
		addressText.setBackground(Color.WHITE);
		addressText.setHorizontalAlignment(JTextField.CENTER);
		addressText.setBorder(null);
		addressText.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		
		JLabel phoneNumber = new JLabel("연락처 정보", JLabel.CENTER);
		phoneNumber.setLayout(null);
		phoneNumber.setSize(450, 40);
		phoneNumber.setLocation(100, 290);
		phoneNumber.setOpaque(true);
		phoneNumber.setBackground(new Color(43, 51, 62));
		phoneNumber.setForeground(Color.WHITE);
		phoneNumber.setFont(new Font("맑은 고딕", Font.BOLD, 15));

		JTextField phoneNumberText = new JTextField("테스트");
		phoneNumberText.setLayout(null);
		phoneNumberText.setSize(450, 50);
		phoneNumberText.setLocation(100, 330);
		phoneNumberText.setBackground(Color.WHITE);
		phoneNumberText.setHorizontalAlignment(JTextField.CENTER);
		phoneNumberText.setBorder(null);
		phoneNumberText.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		
		JLabel payment = new JLabel("주문 금액 정보", JLabel.CENTER);
		payment.setLayout(null);
		payment.setSize(450, 40);
		payment.setLocation(100, 420);
		payment.setOpaque(true);
		payment.setBackground(new Color(43, 51, 62));

		payment.setForeground(Color.WHITE);
		payment.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		
		JTextField paymentText = new JTextField("테스트");
		paymentText.setLayout(null);
		paymentText.setSize(450, 50);
		paymentText.setLocation(100, 460);
		paymentText.setBackground(Color.WHITE);
		paymentText.setHorizontalAlignment(JTextField.CENTER);
		paymentText.setBorder(null);
		paymentText.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		
//		information.setVisible(true);
//		informationText.setVisible(true);
//		
//		addressText.setVisible(true);
//		phoneNumberText.setVisible(true);
//		paymentText.setVisible(true);
		
//		information.add(informationText);
		
		right.add(information);
		right.add(informationText);
		right.add(address);
		right.add(addressText);
		right.add(phoneNumber);
		right.add(phoneNumberText);
		right.add(payment);
		right.add(paymentText);
//		right.add(information);
	
		setVisible(true);
		
	}

}
