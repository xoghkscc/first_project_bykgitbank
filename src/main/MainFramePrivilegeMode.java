package main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import function.delivery.DeliveryFunctionMain;
import function.topBar.TopBar;
import function.topBar.TorBar_Main;
import function.viewToGo.ClickMember;
import function.viewToGo.ClickPayment;
import function.viewToGo.ClickStock;
import function.viewToGo.ClickStore;
import function.viewToGo.MainButton;
import main.*;

public class MainFramePrivilegeMode extends JFrame{
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

	
	public MainFramePrivilegeMode(JFrame log_jf) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280, 720);
		setLocation(50, 50);
		setLayout(null);
		
		getContentPane().setBackground(new Color(0, 36, 62));
		
		JPanel topBar = new TorBar_Main(log_jf, this);
		add(topBar, BorderLayout.NORTH);
		
		topBar.setBackground(new Color(0, 36, 62));
		
		JButton logo = new JButton();
		logo.setIcon(new ImageIcon("./files/logo6.png"));
		logo.setBounds(447, 50, 338, 338);
		logo.setBorderPainted(false);
		add(logo);
		
		
		JButton payment_btn = new MainButton2(135, 400);
		payment_btn.setIcon(new ImageIcon("./files/payment.png"));
		payment_btn.addActionListener(new ClickPayment(this));//MainFrame의 JFrame을 계산 Frame에 ActionListener로 넘김
		payment_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				payment_btn.setIcon(new ImageIcon("./files/payment.png"));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				payment_btn.setIcon(new ImageIcon("./files/payment2.png"));
			}
		});
		payment_btn.setVisible(true);
		
		JButton member_btn = new MainButton2(340, 400);
		member_btn.setIcon(new ImageIcon("./files/member.png"));
		member_btn.addActionListener(new ClickMember(this));
		member_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				member_btn.setIcon(new ImageIcon("./files/member.png"));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				member_btn.setIcon(new ImageIcon("./files/member2.png"));
			}
		});
		
		
		JButton stock_btn = new MainButton2(544, 400);
		stock_btn.addActionListener(new ClickStock(this));
		stock_btn.setIcon(new ImageIcon("./files/stock.png"));
		stock_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				stock_btn.setIcon(new ImageIcon("./files/stock.png"));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				stock_btn.setIcon(new ImageIcon("./files/stock2.png"));
			}
		});
		
		
		JButton store_btn = new MainButton2(749, 400);
		store_btn.addActionListener(new ClickStore(this));
		store_btn.setIcon(new ImageIcon("./files/store.png"));
		store_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				store_btn.setIcon(new ImageIcon("./files/store.png"));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				store_btn.setIcon(new ImageIcon("./files/store2.png"));
			}
		});
		                                 
		JButton delivery_btn = new MainButton2(953, 400);
		delivery_btn.setIcon(new ImageIcon("./files/delivery.png"));
		delivery_btn.addActionListener(new DeliveryFunctionMain(this));
		delivery_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				delivery_btn.setIcon(new ImageIcon("./files/delivery.png"));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				delivery_btn.setIcon(new ImageIcon("./files/delivery2.png"));
			}
		});
		
		add(payment_btn);
		add(member_btn);
		add(stock_btn);
		add(store_btn);
		add(delivery_btn);
		
		setVisible(true);
		
	}
	
//	public static void main(String[] args) {
//		new MainFrame();
		
//	}
}
