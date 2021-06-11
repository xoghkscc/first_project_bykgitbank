package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import function.topBar.ClickMain;
import function.topBar.ClickMainDesign;
import function.topBar.TopBar;
import view.stock.Buttons_main;
import view.stock.DateCheck;

public class StockMainFrame extends JFrame{
	JFrame jf;
	public StockMainFrame(JFrame jf) {
		this.jf = jf;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(jf.getWidth(), jf.getHeight());
		setLocation(jf.getX(), jf.getY());
		
		JButton test2 = new ClickMainDesign();
		test2.addActionListener(new ClickMain(jf, this));

		System.out.println();
		add(test2);

		//탑바 고정 판넬
		JPanel topBar = new TopBar();
		add(topBar, BorderLayout.NORTH);
		
		//왼쪽 버튼 판넬
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(4,2,2,2));
		
		buttons = new Buttons_main(buttons, this).getButtons(); //this를 이용해 지금의 프레임전달
//		AbstractBorder border = new BevelBorder(BevelBorder.LOWERED);
//		buttons.setBorder(border);
		buttons.setBorder(BorderFactory.createEmptyBorder(20, 10, 25, 25));
		
		buttons.setBackground(new Color(43,51,62));
		
		add(buttons, BorderLayout.EAST);
		
		//날짜, 달력, 검색 판넬
		JPanel index = new DateCheck().getIndexes(); //날짜달력과 테이블을 꺼내오는 DateCheck 클래스로 index판넬에 넣는다
		
		index.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 0));

		add(index); 
		
		setVisible(true);
	}
}
