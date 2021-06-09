package function.payment;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;

import javax.swing.JTextField;

import view.Payment.east.EastPayPanel;
import view.Payment.middlePanel.TotalPaymentPanel;

public class PointUse implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		DecimalFormat formatMoney = new DecimalFormat("###,### ");
		DecimalFormat formatPoint = new DecimalFormat("# ");
		((JTextField) e.getSource()).setForeground(Color.BLACK);
		String pointValue = ((JTextField) e.getSource()).getText();
		
		((JTextField) e.getSource()).setText(formatPoint.format(Integer.parseInt(pointValue)));
		
		String finalPrice = EastPayPanel.getPaymentValue().getText().trim();
		
		EastPayPanel.getPaymentValue().setText(Integer.toString(Integer.parseInt(finalPrice)-Integer.parseInt(pointValue)));
		EastPayPanel.getMoneypaymentValue().setText(formatMoney.format(Integer.parseInt(EastPayPanel.getPaymentValue().getText())));//최종 금액을 화폐단위로 출력
		
		PaymentInsertTable.getTotal_payment().setText(EastPayPanel.getPaymentValue().getText());
		TotalPaymentPanel.get_money_total_payment().setText(formatMoney.format(Integer.parseInt(PaymentInsertTable.getTotal_payment().getText())));//최종 금액을 화폐단위로 출력
	}

}

