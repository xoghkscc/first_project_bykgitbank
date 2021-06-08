package view.stock.nextFrame;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Product_opder extends JFrame{

	JFrame jf;
	
	public Product_opder(JFrame jf) {
		// TODO Auto-generated constructor stub
		this.jf = jf;
		
		setLayout(null);
		
		JButton backButton = new BackButton();
		backButton.addActionListener(new BackToStock(jf, this));
		add(backButton);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(jf.getWidth(), jf.getHeight());
		setLocation(jf.getX(), jf.getY());
		setVisible(true);
	}
}
