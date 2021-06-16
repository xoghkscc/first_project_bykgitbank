package view.Members.Customer_Function;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.Members.MemberSearchFrame;

public class EnterCustomerSerachText implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		while(MemberSearchFrame.getModel().getRowCount() > 0) {		
			MemberSearchFrame.getModel().removeRow(0);
		}
		
			
		new CustomerSearch(Integer.parseInt(MemberSearchFrame.getCustomerPhoneNumber().getText().trim()));
		
	}
	
}
