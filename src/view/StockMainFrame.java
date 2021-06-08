package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import function.topBar.ClickMain;
import function.topBar.ClickMainDesign;
import function.topBar.TopBar;
import view.stock.DateCheck;
import view.stock.buttons_product;

public class StockMainFrame extends JFrame{
	JFrame jf;
	public StockMainFrame(JFrame jf) {
		this.jf = jf;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(jf.getWidth(), jf.getHeight());
		setLocation(jf.getX(), jf.getY());
//		setLayout(null);
		
//		JButton test = new JButton("여긴 재고 관리 화면을 구현하면 됩니다");//JButton test는 지워도 됩니다.
//		test.setLocation(500, 200);
//		test.setSize(150, 150);
//		add(test);
		
		JButton test2 = new ClickMainDesign();
		test2.addActionListener(new ClickMain(jf, this));

		
		add(test2);

		//탑바 고정 판넬
		JPanel topBar = new TopBar();
		add(topBar, BorderLayout.NORTH);
		
		//왼쪽 버튼 판넬
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(4,4,2,2));
//		JButton test = new JButton("여긴 재고 관리 화면을 구현하면 됩니다");//JButton test는 지워도 됩니다.
//		test.setLocation(100, 100);
//		test.setSize(50, 50);
//		buttons.add(test);
		
		buttons = new buttons_product(buttons, this).getButtons(); //this를 이용해 지금의 프레임전달
		add(buttons, BorderLayout.WEST);
		
		//날짜, 달력, 검색 판넬
		JPanel index = new DateCheck().getIndexes(); //날짜달력과 테이블을 꺼내오는 DateCheck 클래스로 index판넬에 넣는다
		
//		index = new Searching_product(index).getIndex();
//		
		add(index); 
		
		setVisible(true);
	}
}
