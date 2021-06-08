package view.Members;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;


public class Member_Info extends JFrame{
	
	public Member_Info () {
		super ("회원 관리");
		
		
		
		Container content_panel = getContentPane();
		
		
		JPanel panel = new JPanel();	
		JButton btn = new JButton("검색");		
		JTextField text = new JTextField(15);
		JLabel label = new JLabel("회원 정보 검색: ");
		JLabel label2 = new JLabel("※ 전화 번호 뒷자리 4자리를 입력해주세요!");
		JButton join = new JButton("회원 등록");
		JButton modify = new JButton("회원 수정");
		JButton remove = new JButton("회원 삭제");
		
		label.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		label.setForeground(Color.blue);
		text.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		btn.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		join.setFont(new Font("맑은 고딕", Font.PLAIN,20));
		modify.setFont(new Font("맑은 고딕", Font.PLAIN,20));
		remove.setFont(new Font("맑은 고딕", Font.PLAIN,20));
			
		
		panel.add(label);
		panel.add(text);	
		panel.add(btn);
		panel.add(label2);
		panel.add(join);
		panel.add(modify);
		panel.add(remove);
			
		add(new TopBar(), BorderLayout.NORTH);
		add(new ClickMainDesign());
		add(new Mainpan());
				
		content_panel.add(panel);
				
		setBounds(1000, 50, 1280, 720);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
		
	public static void main(String[] args) {
		new Member_Info();
		
	
	}
}
