package function.topBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class ClickMain implements ActionListener{
	JFrame mainJf;
	JFrame jf;
	public ClickMain(JFrame mainJf, JFrame jf) {
		this.mainJf = mainJf;
		this.jf = jf;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		jf.setVisible(false);	
		mainJf.setVisible(true);
	}

}
