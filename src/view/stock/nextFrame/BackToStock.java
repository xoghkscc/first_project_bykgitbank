package view.stock.nextFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class BackToStock implements ActionListener{

	JFrame stockJf;
	JFrame jf;
	public BackToStock(JFrame stockJf, JFrame jf) {
		this.stockJf = stockJf;
		this.jf = jf;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		jf.setVisible(false);
		stockJf.setVisible(true);
	}

	
}
