package view.stock.nextFrame;

import javax.swing.JButton;
import javax.swing.JFrame;

import view.stock.nextFrame.type_search.type_search_buttons;

public class Product_profit_rate extends JFrame{
	
	JFrame jf;
	
	public Product_profit_rate(JFrame jf) {
		// TODO Auto-generated constructor stub
		this.jf = jf;
		
		String profitRate = "원가 및 마진율";
		
		new type_search_buttons(jf,profitRate, null,null);
	}
}
