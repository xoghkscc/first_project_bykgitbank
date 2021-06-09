package function.payment;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

import view.Payment.east.EastPayPanel;

public class PointReset extends MouseAdapter{
	@Override
	public void mouseClicked(MouseEvent e) {
		String finalPrice = EastPayPanel.getPaymentValue().getText().trim();
		String pointValue = ((JTextField) e.getSource()).getText().trim();
		if(Integer.parseInt(((JTextField) e.getSource()).getText().trim()) == 0) {
			((JTextField) e.getSource()).setText("");
			}else {
				((JTextField) e.getSource()).setText("0");
				int pointReset = Integer.parseInt(finalPrice) + Integer.parseInt(pointValue);
				EastPayPanel.getPaymentValue().setText(Integer.toString(pointReset));
				PaymentInsertTable.getTotal_payment().setText(Integer.toString(pointReset));
				((JTextField) e.getSource()).setText("");
			}
	}
}
