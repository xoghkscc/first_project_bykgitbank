package function.payment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReceiptButton implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		new Receipt_Page();
	}

}
