package view;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import function.topBar.*;
public class StoreMainFrame extends JFrame{
	JFrame jf;
	public StoreMainFrame(JFrame jf) {
		this.jf = jf;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(jf.getWidth(), jf.getHeight());
		setLocation(jf.getX(), jf.getY());
		setLayout(null);
		
		JButton test = new JButton("여긴 매장 관리 화면을 구현하면 됩니다");//JButton test는 지워도 됩니다.
		test.setLocation(500, 200);
		test.setSize(150, 150);
		add(test);
		
		JButton test2 = new ClickMainDesign();
		test2.addActionListener(new ClickMain(jf, this));
		add(test2);
		

		JPanel topBar = new TopBar();
		add(topBar, BorderLayout.NORTH);
		
		setVisible(true);
	}
}