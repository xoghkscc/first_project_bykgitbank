package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import function.topBar.ClickMain;
import function.topBar.ClickMainDesign;
import function.topBar.TopBar;
import view.Members.MemberSearchFrame;

public class MemberMainFrame extends JFrame{
	JFrame jf;
	public MemberMainFrame(JFrame jf) {
		this.jf = jf;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(jf.getWidth(), jf.getHeight());
		setLocation(jf.getX(), jf.getY());
		
		JButton test = new JButton("여긴 회원 관리 화면을 구현하면 됩니다");//JButton test는 지워도 됩니다.
		test.setLocation(500, 200);
		test.setSize(150, 150);
		
		add(test);
		
		JButton test2 = new ClickMainDesign();
		test2.addActionListener(new ClickMain(jf, this));
		
		add(test2);
		
		JPanel topBar = new TopBar();
		add(topBar, BorderLayout.NORTH);
		topBar.setBackground(new Color(43, 51, 62));
		
		new MemberSearchFrame(jf);
		
		setVisible(false);
		setLayout(null);
	}
}
