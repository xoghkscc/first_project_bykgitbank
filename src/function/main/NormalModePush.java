package function.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import main.MainFramePrivilegeMode;
import main.MainFrameNormalMode;

public class NormalModePush implements ActionListener {
	
	JFrame jf;
	public NormalModePush(JFrame jf) {
		this.jf = jf;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		jf.setVisible(false);
		
		new MainFrameNormalMode(jf);
		
	}
	
}
