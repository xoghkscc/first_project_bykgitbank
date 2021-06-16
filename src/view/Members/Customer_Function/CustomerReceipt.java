package view.Members.Customer_Function;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Members.ReceiptSearch;

public class CustomerReceipt implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		while (ReceiptSearch.getModel().getRowCount() > 0) {
			ReceiptSearch.getModel().removeRow(0);
		}
		
	}
	
}
