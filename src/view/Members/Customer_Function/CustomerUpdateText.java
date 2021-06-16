package view.Members.Customer_Function;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Members.CustomerUpdate;
import view.Members.MemberSearchFrame;

public class CustomerUpdateText implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		while(CustomerUpdate.getModel().getRowCount() > 0) {		
			CustomerUpdate.getModel().removeRow(0);
		}
				
		new Customer_Update(Integer.parseInt(CustomerUpdate.getCustomerPhoneNumber().getText().trim()));
		
	}

}
