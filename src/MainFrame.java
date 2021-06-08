import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JFrame;

import function.*;
import function.viewToGo.ClickDelivery;
import function.viewToGo.ClickMember;
import function.viewToGo.ClickPayment;
import function.viewToGo.ClickStock;
import function.viewToGo.ClickStore;
import function.viewToGo.FrameMoveButton;

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
		setSize(WIDTH, HEIGHT);
		setLocation(X, Y);
		setLayout(null);
		
		JButton payment_btn = new FrameMoveButton(115, 200, "계산");
		payment_btn.addActionListener(new ClickPayment(this));//MainFrame의 JFrame을 계산 Frame에 ActionListener로 넘김
		
		JButton member_btn = new FrameMoveButton(320, 200, "회원 관리");
		member_btn.addActionListener(new ClickMember(this));
		
		JButton stock_btn = new FrameMoveButton(524, 200, "재고 관리");
		stock_btn.addActionListener(new ClickStock(this));
		JButton store_btn = new FrameMoveButton(729, 200, "매장 관리");
		store_btn.addActionListener(new ClickStore(this));
		
		JButton delivery_btn = new FrameMoveButton(933, 200, "배달 관리");
		delivery_btn.addActionListener(new ClickDelivery(this));
		
		add(payment_btn);
		add(member_btn);
		add(stock_btn);
		add(store_btn);
		add(delivery_btn);
		
		setVisible(true);
		
	}
	



	public static void main(String[] args) {
		new MainFrame();
		System.out.println("1");
	}
}
