package function.payment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class RufundAction implements ActionListener{
	JFrame Refund_Page;
	public RufundAction(JFrame Refund_Page) {
		this.Refund_Page = Refund_Page;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Refund_Page.dispose();
	}

}
