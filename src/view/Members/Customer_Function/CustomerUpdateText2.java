package view.Members.Customer_Function;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.Members.CustomerUpdate;
import view.Members.MemberSearchFrame;

public class CustomerUpdateText2 implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		int choice = JOptionPane.showConfirmDialog(null, "수정 하시겠습니까?", "회원 수정", JOptionPane.YES_NO_OPTION);
		int row = (CustomerUpdate.getTable().getSelectedRow());
		
		if (choice == 0 ) {
			new Update(Integer.parseInt((String) CustomerUpdate.getModel().getValueAt(row, 0)), 
					(String) CustomerUpdate.getModel().getValueAt(row, 1), 
					(String) CustomerUpdate.getModel().getValueAt(row, 2),
					(String) CustomerUpdate.getModel().getValueAt(row, 3));
			JOptionPane.showMessageDialog(null, "수정 되었습니다");
		} 
		else {
			JOptionPane.showMessageDialog(null, "취소 하셨습니다");
		}
	}
}