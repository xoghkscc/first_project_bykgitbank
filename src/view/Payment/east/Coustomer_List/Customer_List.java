package view.Payment.east.Coustomer_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import function.model.Member_Informations_DB;
import view.Payment.east.MemberPanel;

public class Customer_List implements ActionListener  {
	
	private static DefaultTableModel model;
	Member_Informations_DB member_informations_DB;
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
	new CustomerListFrame(Integer.parseInt(MemberPanel.getMemberPhoneNumberValue().getText().trim()));
	
	}
}
