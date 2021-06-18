import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
//d
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
		
		
		JButton payment_btn = new JButton();
		payment_btn.setSize(178, 100);
		payment_btn.setBackground(new Color(0, 36, 62));
		payment_btn.setLocation(115, 420);
		payment_btn.setIcon(new ImageIcon("./files/button.png"));
		payment_btn.setBorder(null);
		payment_btn.addActionListener(new NormalModePush(this));//MainFrame의 JFrame을 계산 Frame에 ActionListener로 넘김
		payment_btn.setFont(new Font("함초롬돋움", Font.PLAIN, 27));
		
		add(payment_btn);
				 
		payment_btn.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {
				payment_btn.setIcon(new ImageIcon("./files/button.png"));
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				payment_btn.setIcon(new ImageIcon("./files/buttonclick2.png"));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {}
		});
		
		
		JButton privilege_btn = new JButton();
		privilege_btn.setSize(178, 100);
		privilege_btn.setBackground(new Color(0, 36, 62));
		privilege_btn.setLocation(375, 420);
		privilege_btn.setIcon(new ImageIcon("./files/button2.png"));
		privilege_btn.setBorder(null);
		privilege_btn.addActionListener(new PushPrivilegeMode(this));
		privilege_btn.setFont(new Font("함초롬돋움", Font.PLAIN, 27));
		add(privilege_btn);
		
		privilege_btn.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {
				privilege_btn.setIcon(new ImageIcon("./files/button2.png"));
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				privilege_btn.setIcon(new ImageIcon("./files/button2click2.png"));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {}
		});
		 
		
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Login_Frame();
	}
}
