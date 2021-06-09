package function.payment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import function.Sales_Insert;

public class FinalPayment implements ActionListener{
	String Payment_type;
	public FinalPayment(String Payment_type) {
		this.Payment_type = Payment_type;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		new Sales_Insert(Payment_type);
		
	}

}
