package function.payment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import function.Customer_Search;
import function.Products_Select;
import function.model.Member_Informations_DB;
import function.model.Products_DB;
import view.Payment.east.EastPayPanel;
import view.Payment.east.MemberPanel;

public class Payment_Custormer_infor implements ActionListener {

	Member_Informations_DB member_informations_DB;
	private static JLabel Custormer_Num;

	public static JLabel getCustormer_Num() {
		return Custormer_Num;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		int Customer_id = Integer.parseInt(((JTextField) e.getSource()).getText().trim());
		member_informations_DB = new Customer_Search(Customer_id).getMember_Informations_DB();
	

		String name = member_informations_DB.getMEMBERS_NAME();
		int point = member_informations_DB.getMEMBERS_POINT();
		
		MemberPanel.getMemberNameValue().setText(name);
		MemberPanel.getMemberPointValue().setText(""+point);
		
		int total_payment = Integer.parseInt(PaymentInsertTable.getTotal_payment().getText());
		
		int reserved_point = (int)(total_payment * 0.01);
		
		MemberPanel.getAccumulateValue().setText("" + reserved_point);
	}

	
}
