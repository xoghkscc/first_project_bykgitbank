package view.Members;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import view.Payment.lowPanel.RoundedButton;



public class Join extends JFrame {
	
	
	
	public Join () {
		
		super("회원 등록");
				
		setLayout(null);
				
		JLabel join = new JLabel("#회원 등록#");
		JLabel label1 = new JLabel("이름 : ");
		JTextField text1 = new JTextField();
		JLabel label2 = new JLabel("주소 : ");
		JTextField text2 = new JTextField();
		JLabel label3 = new JLabel("연락처 : ");
		JTextField text3 = new JTextField();
		JButton btn = new MemJoin("회원 등록");
		
		add(join);
		add(label1);
		add(label2);
		add(label3);
		add(text1);
		add(text2);
		add(text3);
		add(btn);
		
		join.setBounds(140,30, 1000,40);
		join.setFont(new Font("맑은 고딕", Font.PLAIN, 35));
		
		label1.setBounds(80, 100, 100, 30);
		label1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		
		text1.setBounds(180, 100, 200, 40);
		text1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		
		label2.setBounds(80, 180, 100, 30);
		label2.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		
		text2.setBounds(180, 180, 200, 40);
		text2.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		
		label3.setBounds(80, 260, 100, 30);
		label3.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		
		text3.setBounds(180, 260, 200, 40);
		text3.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		
		btn.setBounds(140,350,200,50);
		btn.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		btn.setForeground(new Color(102, 255, 102));
		
		setBounds(500, 50, 500, 500);
		setBackground(new Color(43,51,62));
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new Join();
	}
}

class MemJoin extends RoundedButton{
	public MemJoin(String name) {
		super(name);
		super.c = new Color(255, 255, 153); 
		setHorizontalAlignment(JLabel.CENTER);
		setFont(new Font("맑은 고딕", Font.BOLD, 20));
	}
}
