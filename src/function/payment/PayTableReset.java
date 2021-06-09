package function.payment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import view.PaymentMainFrame;
import view.Payment.CenterPayPanel;
import view.Payment.east.EastPayPanel;
import view.Payment.middlePanel.TotalPaymentPanel;
import view.Payment.topPanel.TopTable;

public class PayTableReset implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		TopTable.getDefaultModel().setNumRows(0);
		TotalPaymentPanel.get_money_total_payment().setText("0");
		EastPayPanel.getMoneyamountValue().setText("0");
		EastPayPanel.getDiscountValue().setText("0");
		EastPayPanel.getMoneydiscountValue().setText("0");
		EastPayPanel.getPointValue().setText("0");
		EastPayPanel.getPaymentValue().setText("0");
		EastPayPanel.getMoneypaymentValue().setText("0");
		PaymentMainFrame.getProduct_list().clear();
	}

}
