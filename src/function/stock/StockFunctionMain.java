package function.stock;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StockFunctionMain extends JFrame{

	
	public StockFunctionMain() {
		// TODO Auto-generated constructor stub
		setBounds(50, 50, 1000, 1000);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JButton jb = new JButton();
		jb.setBounds(0, 0, 50, 50);
		
		JPanel jp = new JPanel();
		jp.setBounds(0, 0, 700, 700);
		jp.setVisible(true);
		jp.setBackground(Color.YELLOW);
		
		//버튼 누르면 테이블생성
//		jb.addActionListener(new ActionSelectButton("SELECT * FROM PRODUCTS WHERE PRODUCT_TYPE = \'과일\'", jp));
		jp.setLayout(new GridLayout(4,4,0,0));
		JTextField jt = new JTextField();
		JTextField jt2 = new JTextField();
		JTextField jt3 = new JTextField();
		JTextField jt4 = new JTextField();
		JButton jb1 = new JButton();
		
		jt.addActionListener(null);
		
		add(jb);
		add(jp);
	}
	public static void main(String[] args) {
		new StockFunctionMain();
	}
}

