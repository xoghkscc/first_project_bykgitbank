package function.payment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class RefundButton implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
			new Refund_Page();
	}

}

