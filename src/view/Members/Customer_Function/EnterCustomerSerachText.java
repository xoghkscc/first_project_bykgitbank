package view.Members.Customer_Function;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Members.MemberSearchFrame;

public class EnterCustomerSerachText implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		while(MemberSearchFrame.getModel().getRowCount() > 0) {
			MemberSearchFrame.getModel().removeRow(0);
		}
		
		if(MemberSearchFrame.getCustomerPhoneNumber().getText().trim().equals("※ 휴대폰 번호 4자리를 입력해주세요")) {
			new Customer_Search();
		} else {
		new CustomerSearch(Integer.parseInt(MemberSearchFrame.getCustomerPhoneNumber().getText().trim()));
		}
	}
	
}
