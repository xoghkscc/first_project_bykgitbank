package function.payment.Customer_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import function.model.Member_Informations_DB;
import view.Payment.east.MemberPanel;

public class Customer_List implements ActionListener  {
	
	private static DefaultTableModel model;
	Member_Informations_DB member_informations_DB;
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
	if(!(Pattern.matches("[0-9]{4}", MemberPanel.getMemberPhoneNumberValue().getText().trim()))) {
		JOptionPane.showMessageDialog(null, "전화번호 숫자 4자리를 입력해주세요");
	} else {
		new CustomerListFrame(Integer.parseInt(MemberPanel.getMemberPhoneNumberValue().getText().trim()));
	}
	
	}
}
