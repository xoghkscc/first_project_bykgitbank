package function.payment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

import function.Customer_Search;
import function.Member_Informations_DB;

public class Payment_Custormer_name implements ActionListener {

	
	Member_Informations_DB member_informations_DB;
	JLabel name;
	
	public Payment_Custormer_name()  {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		int Customer_id = Integer.parseInt(((JTextField) e.getSource()).getText().trim());
		member_informations_DB = new Customer_Search(Customer_id).getMember_Informations_DB();
	
		String name = member_informations_DB.getMEMBERS_NAME();
		

		
		((JTextField) e.getSource()).setText("");
	}

	
}
