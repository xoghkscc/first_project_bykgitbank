package function.member;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import view.Members.MemberSearchFrame;
import view.Payment.east.MemberPanel;

public class EnterCustomerSerachText implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		while(MemberSearchFrame.getModel().getRowCount() > 0) {
			MemberSearchFrame.getModel().removeRow(0);
		}
		
		if(MemberSearchFrame.getCustomerPhoneNumber().getText().trim().equals("※ 휴대폰 번호 4자리를 입력해주세요") ||
				MemberSearchFrame.getCustomerPhoneNumber().getText().trim().equals("")) {
			new Customer_Search();
		} else if(!(Pattern.matches("[0-9]{4}", MemberSearchFrame.getCustomerPhoneNumber().getText().trim()))) {
			JOptionPane.showMessageDialog(null, "전화번호 숫자4자리를 입력해주세요");
		} else {
		new CustomerSearch(Integer.parseInt(MemberSearchFrame.getCustomerPhoneNumber().getText().trim()));
		}
	}
	
}
