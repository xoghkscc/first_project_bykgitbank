package view.Members.Customer_Function;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.Members.Customer_Delete;
import view.Members.Join;
import view.Members.MemberSearchFrame;

public class PushCustomerDelete implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	
			new Delete_Customer_list(Customer_Delete.getCustomerName().getText().trim());

		
		
		
	}
}
