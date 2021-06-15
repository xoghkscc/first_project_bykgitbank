package function.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class PushPrivilegeMode implements ActionListener {
	
	JFrame jf1;
	
	public PushPrivilegeMode(JFrame jf1) {
		this.jf1 = jf1;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		new Privilege_Mode_Login(jf1);
		
		
	}
	
	
	
}
