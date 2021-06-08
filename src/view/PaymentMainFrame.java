package view;


import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import function.topBar.ClickMain;
import function.topBar.ClickMainDesign;
import function.topBar.TopBar;

public class PaymentMainFrame extends JFrame{
	JFrame jf;
	public PaymentMainFrame(JFrame jf) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(1200, 600);
		setLocation(40, 40);
		setLayout(null);
		
		JButton test = new JButton("여긴 결제 관리 화면을 구현하면 됩니다");//JButton test는 지워도 됩니다.
		test.setLocation(500, 200);
		test.setSize(150, 150);
		
		add(test);
		
		JButton test2 = new ClickMainDesign();
		test2.addActionListener(new ClickMain(jf, this));

		add(test2);
		
		JPanel topBar = new TopBar();
		add(topBar, BorderLayout.NORTH);
		
		
		setLayout(null);
	}
}
