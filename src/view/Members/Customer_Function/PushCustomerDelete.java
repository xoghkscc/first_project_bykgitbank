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
		
		int choice = JOptionPane.showConfirmDialog(null, "회원을 삭제하시겠습니까?", "회원 삭제", JOptionPane.YES_NO_OPTION);
		
		if (choice == 0 ) {
			new Delete_Customer_list(Customer_Delete.getCustomerName().getText().trim());
			JOptionPane.showMessageDialog(null, "삭제하셨습니다");
		} 
		else {
			JOptionPane.showMessageDialog(null, "취소하셨습니다");
		}
		
		
		
	}
}
