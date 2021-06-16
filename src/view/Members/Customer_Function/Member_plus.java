package view.Members.Customer_Function;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.Members.Join;

public class Member_plus implements ActionListener  {

	
	@Override
	public void actionPerformed(ActionEvent e) {
	

	int choice = JOptionPane.showConfirmDialog(null, "추가하시겠습니까?", "회원 추가", JOptionPane.YES_NO_OPTION);
	
	if (choice == 0 ) {
		new Inster_members(Join.getMemberName().getText().trim(), Join.getMemberAddress().getText().trim(), Join.getMemberPhoneNumber().getText().trim());
		JOptionPane.showMessageDialog(null, "추가하셨습니다");
	} 
	else {
		JOptionPane.showMessageDialog(null, "취소하셨습니다");
	}
	
			
	}
}
