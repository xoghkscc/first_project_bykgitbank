package view.Members;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ManagerFrame extends JFrame {

	public ManagerFrame() {
		super("회원 관리");
		
		setLayout(null);
		
		
		JButton join = new JButton("회원 등록");
		JButton modify = new JButton("회원 수정");
		JButton search = new JButton("회원 검색");
		
		join.setLocation(130, 170);
		join.setSize(300,300);
		join.setFont(new Font("맑은 고딕", Font.PLAIN, 40));

			
		search.setLocation(480, 170);
		search.setSize(300,300);
		search.setFont(new Font("맑은 고딕", Font.PLAIN, 40));
		
		
		modify.setLocation(830, 170);
		modify.setSize(300,300);
		modify.setFont(new Font("맑은 고딕", Font.PLAIN, 40));
		
		
		add(join);
		add(modify);
		add(search);
		
		setBounds(500, 50, 1280, 720);
		setBackground(new Color(43,51,62));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new ManagerFrame();
	}
}
