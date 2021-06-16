import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import function.main.NormalModePush;
import function.main.PushPrivilegeMode;
import function.viewToGo.ClickPayment;
import function.viewToGo.MainButton;
import main.MainFrameNormalMode;

public class Login_Frame extends JFrame {
	
	static final int WIDTH = 680; 
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

	
	public Login_Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setLocation(X, Y);
		setLayout(null);
		
		getContentPane().setBackground(new Color(0, 36, 62));
		 
		JButton logo = new JButton();
		logo.setIcon(new ImageIcon("./files/logo6.png"));
		logo.setBounds(170, 50, 338, 338);
		logo.setBorderPainted(false);
		add(logo);
		
		
		JButton payment_btn = new MainButton(135, 400, "일반 모드");
		payment_btn.addActionListener(new NormalModePush(this));//MainFrame의 JFrame을 계산 Frame에 ActionListener로 넘김
		payment_btn.setFont(new Font("함초롬돋움", Font.PLAIN, 27));
		
		add(payment_btn);
				 
		
		JButton privilege_btn = new MainButton(380, 400, "관리자 모드");
		privilege_btn.addActionListener(new PushPrivilegeMode(this));
		privilege_btn.setFont(new Font("함초롬돋움", Font.PLAIN, 27));
		add(privilege_btn);
		 
		
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Login_Frame();
	}
}
