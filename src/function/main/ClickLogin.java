package function.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class ClickLogin implements ActionListener{
	
	JFrame log_Jf;
	JFrame jf;
	
	public ClickLogin(JFrame log_Jf, JFrame jf) {
		this.log_Jf = log_Jf;
		this.jf = jf;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		jf.setVisible(false);	
		log_Jf.setVisible(true);
	}

}
