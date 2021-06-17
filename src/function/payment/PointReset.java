package function.payment;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

import javax.swing.JTextField;

import view.Payment.east.EastPayPanel;
import view.Payment.middlePanel.TotalPaymentPanel;

public class PointReset extends MouseAdapter{
	@Override
	public void mouseClicked(MouseEvent e) {
		DecimalFormat formatMoney = new DecimalFormat("###,### ");
		
		String finalPrice = EastPayPanel.getPaymentValue().getText().trim();
		String pointValue = ((JTextField) e.getSource()).getText().trim();
	
		
			if(((JTextField) e.getSource()).getForeground() == Color.gray) {
				((JTextField) e.getSource()).setText("");
				
			} else if(pointValue.equals("")) {
				((JTextField) e.getSource()).setText("");
				
			} else if (Integer.parseInt(pointValue) == 0) {
			((JTextField) e.getSource()).setText("");
			
			} else if (Integer.parseInt(pointValue) != 0) {	
				((JTextField) e.getSource()).setText("0");
				int pointReset = Integer.parseInt(finalPrice) + Integer.parseInt(pointValue);
				
				EastPayPanel.getPaymentValue().setText(Integer.toString(pointReset));
				EastPayPanel.getMoneypaymentValue().setText(formatMoney.format(Integer.parseInt(EastPayPanel.getPaymentValue().getText())));//최종 금액을 화폐단위로 출력
				
				PaymentInsertTable.getTotal_payment().setText(Integer.toString(pointReset));
				TotalPaymentPanel.get_money_total_payment().setText(formatMoney.format(Integer.parseInt(PaymentInsertTable.getTotal_payment().getText())));//최종 금액을 화폐단위로 출력
				EastPayPanel.getPointValue().setForeground(Color.gray);
				//((JTextField) e.getSource()).setText("");
			}
	}
}
