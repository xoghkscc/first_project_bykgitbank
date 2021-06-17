package view.stock.nextFrame;

import javax.swing.JFrame;

import view.stock.nextFrame.type_search.type_search_buttons;

public class Product_expiry_disposal extends JFrame{

	JFrame jf;
	
	public Product_expiry_disposal(JFrame jf) {
		// TODO Auto-generated constructor stub
		this.jf = jf;
		
		setTitle("유통기한 초과물품");
		
		String disposal = "유통기한초과물품";
		
		new type_search_buttons(jf,disposal, null,"disposal");
		

	}
}
