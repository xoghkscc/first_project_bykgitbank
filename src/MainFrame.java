import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import function.delivery.DeliveryFunctionMain;
import function.topBar.TopBar;
import function.viewToGo.ClickMember;
import function.viewToGo.ClickPayment;
import function.viewToGo.ClickStock;
import function.viewToGo.ClickStore;
import function.viewToGo.MainButton;

public class MainFrame extends JFrame{
	static final int WIDTH = 1280; 
	static final int HEIGHT = 720; //topbar는 50
	static final int X = 50; 
	static final int Y = 50; 
	public int getWidth() {
		return WIDTH;
	}

	public int getHeight() {
		return HEIGHT;
	}
	public int getX() {
		return X;
	}
	public int getY() {
		return Y;
	}

	
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280, 720);
		setLocation(50, 50);
		setLayout(null);
		
		getContentPane().setBackground(new Color(0, 36, 62));
		 
		JButton logo = new JButton();
		logo.setIcon(new ImageIcon("C:/Users/user/git/first_project_bykgitbank/files/logo6.png"));
		logo.setBounds(447, 50, 338, 338);
		logo.setBorderPainted(false);
		add(logo);
		
		
		JButton payment_btn = new MainButton(135, 400, "계산");
		payment_btn.addActionListener(new ClickPayment(this));//MainFrame의 JFrame을 계산 Frame에 ActionListener로 넘김
		payment_btn.setFont(new Font("함초롬돋움", Font.PLAIN, 33));
		
		JButton member_btn = new MainButton(340, 400, "회원 관리");
		member_btn.addActionListener(new ClickMember(this));
		member_btn.setFont(new Font("함초롬돋움", Font.PLAIN, 33));
		
		JButton stock_btn = new MainButton(544, 400, "재고 관리");
		stock_btn.addActionListener(new ClickStock(this));
		stock_btn.setFont(new Font("함초롬돋움", Font.PLAIN, 33));
		
		JButton store_btn = new MainButton(749, 400, "매장 관리");
		store_btn.addActionListener(new ClickStore(this));
		store_btn.setFont(new Font("함초롬돋움", Font.PLAIN, 33));
		                                 
		JButton delivery_btn = new MainButton(953, 400, "배달 관리");
		delivery_btn.addActionListener(new DeliveryFunctionMain(this));
		delivery_btn.setFont(new Font("함초롬돋움", Font.PLAIN, 33));
	
		add(payment_btn);
		add(member_btn);
		add(stock_btn);
		add(store_btn);
		add(delivery_btn);
		
		setVisible(true);
		
	}
//	
//	public static void main(String[] args) {
//		new MainFrame();
//	}
}
