package function.main;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import function.member.design.RoundButtonDesign;

public class Privilege_Mode_Login extends JFrame {

	private static JTextField member_id;
	private static JTextField member_password;
	
	public Privilege_Mode_Login (JFrame jf1) {
		
		super("관리자 로그인");
				
		setLayout(null);
				
		JLabel Privilege_Mode_Login = new JLabel(new ImageIcon("./files/logo6.png"));
		JLabel label1 = new JLabel(" 아이디  ");
		member_id = new JTextField();
		JLabel label2 = new JLabel("비밀번호  ");
		member_password = new JTextField();
		JButton btn = new JButton();
		
		btn.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {
				btn.setIcon(new ImageIcon("./files/login.png"));
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				btn.setIcon(new ImageIcon("./files/loginclick2.png"));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {}
		});
		
		add(Privilege_Mode_Login);
		add(label1);
		add(label2);
		add(member_id);
		add(member_password);
		add(btn);
		
		Privilege_Mode_Login.setBounds(81, 60, 338, 212);
		Privilege_Mode_Login.setFont(new Font("맑은 고딕", Font.PLAIN, 35));
		Privilege_Mode_Login.setForeground(new Color(255, 255, 255));
		
		label1.setBounds(40, 330, 80, 20);
		label1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		label1.setForeground(new Color(255, 255, 255));
		
		member_id.setBounds(140, 330, 180, 30);
		member_id.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		member_id.setForeground(new Color(0, 0, 0));
		
		label2.setBounds(40, 370, 80, 20);
		label2.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		label2.setForeground(new Color(255, 255, 255));
		
		member_password.setBounds(140, 370, 180, 30);
		member_password.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		member_password.setForeground(new Color(0, 0, 0));
		
		btn.setBounds(350,330,100 , 73);
		btn.setIcon(new ImageIcon("./files/login.png"));
		btn.setBackground(new Color(0, 36, 62));
		btn.addActionListener(new push_login(this, jf1));
		btn.setBorder(null);
	
		
		setBounds(500, 50, 500, 500);
		getContentPane().setBackground(new Color(0, 36, 62));
		setVisible(true);
		
	}
	
	
	public static JTextField getMember_id(){
		return member_id;
	}
	public static JTextField getMember_password(){
		return member_password;
	}
}

	

