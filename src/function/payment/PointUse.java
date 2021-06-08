package function.payment;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import view.Payment.east.EastPayPanel;

public class PointUse implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		((JTextField) e.getSource()).setForeground(Color.BLACK);
		String pointValue = ((JTextField) e.getSource()).getText();
		String finalPrice = EastPayPanel.getPaymentValue().getText().trim();
		EastPayPanel.getPaymentValue().setText(Integer.toString(Integer.parseInt(finalPrice)-Integer.parseInt(pointValue)));
		PaymentInsertTable.getTotal_payment().setText(EastPayPanel.getPaymentValue().getText());
	}

}
