package view.Members;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class BackToMemberSearchMain implements ActionListener{//memberSearchJf
	JFrame memberSearchJf;
	JFrame jf;
	public BackToMemberSearchMain(JFrame memberSearchJf, JFrame jf) {
		this.memberSearchJf = memberSearchJf;
		this.jf = jf;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		jf.setVisible(false);
		memberSearchJf.setVisible(true);
	}

}
