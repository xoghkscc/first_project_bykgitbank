package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import function.topBar.ClickMain;
import function.topBar.ClickMainDesign;
import function.topBar.TopBar;

public class DeliveryMainFrame extends JFrame{

	public DeliveryMainFrame(JFrame jf) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		setSize(jf.getWidth(), jf.getHeight());
		setLocation(jf.getX(), jf.getY());
		setLayout(null);
		
		JButton test = new JButton("여긴 배달 화면을 구현하면 됩니다");//JButton test는 지워도 됩니다.
		
		test.setLocation(500, 200);
		test.setSize(150, 150);
		add(test);
		
		JButton test2 = new ClickMainDesign();
		test2.addActionListener(new ClickMain(jf, this));

		
		JPanel topBar = new TopBar();
		JPanel center = new TopBar();
		JPanel left = new TopBar();
		JPanel right = new TopBar();
		topBar.add(test2);
		
		left.setBackground(Color.BLUE);
		left.setBackground(Color.RED);
		
		
		center.setSize(600,600);
		center.setLocation(10, 10);
		center.setVisible(true);
		center.setLayout(new GridLayout(1,2));
		
		
		center.add(left);
		center.add(right);
		
		add(topBar, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
		
		setLayout(null);
		setSize(1000,1000);
		setVisible(true);
	}

}
