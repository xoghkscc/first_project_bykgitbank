package view.Members.Customer_Function;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Members.MemberSearchFrame;

public class EnterCustomerSerachText implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		new CustomerSearch(Integer.parseInt(MemberSearchFrame.getCustomerPhoneNumber().getText().trim()));
		
	}
	
}
