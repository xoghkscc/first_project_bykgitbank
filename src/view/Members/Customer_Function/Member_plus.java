package view.Members.Customer_Function;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Members.Join;

public class Member_plus implements ActionListener  {

	@Override
	public void actionPerformed(ActionEvent e) {
			new Inster_members(Join.getMemberName().getText().trim(), Join.getMemberAddress().getText().trim(), Join.getMemberPhoneNumber().getText().trim());
	}
}
