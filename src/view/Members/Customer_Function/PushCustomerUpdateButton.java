package view.Members.Customer_Function;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import view.Members.Join;
import view.Members.MemberSearchFrame;

public class PushCustomerUpdateButton implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
	
		int choice = JOptionPane.showConfirmDialog(null, "수정하시겠습니까?", "회원 수정", JOptionPane.YES_NO_OPTION);
		int row = (MemberSearchFrame.getTable().getSelectedRow());
		
		if (choice == 0 ) {
			new Customer_Update(Integer.parseInt((String) MemberSearchFrame.getModel().getValueAt(row, 0)), 
					(String) MemberSearchFrame.getModel().getValueAt(row, 1), 
					(String) MemberSearchFrame.getModel().getValueAt(row, 2),
					(String) MemberSearchFrame.getModel().getValueAt(row, 3), 
					Integer.parseInt((String) MemberSearchFrame.getModel().getValueAt(row, 4)));
			JOptionPane.showMessageDialog(null, "수정하셨습니다");
		} 
		else {
			JOptionPane.showMessageDialog(null, "취소하셨습니다");
		}
	
		
		
	}
	
}
