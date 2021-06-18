package function.payment;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import view.Payment.east.EastPayPanel;
import view.Payment.east.MemberPanel;
import view.Payment.middlePanel.TotalPaymentPanel;

public class PointUse implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		DecimalFormat formatMoney = new DecimalFormat("###,### ");
		DecimalFormat formatPoint = new DecimalFormat("# ");
		String pointValue = ((JTextField) e.getSource()).getText().trim();
		
		((JTextField) e.getSource()).setText(formatPoint.format(Integer.parseInt(pointValue)).trim());
		
		String finalPrice = EastPayPanel.getPaymentValue().getText().trim();
		
		if(EastPayPanel.getPointValue().getForeground() == Color.BLACK ) {
			JOptionPane.showMessageDialog(null, "이미포인트를 사용하셨습니다");
		} else if(Integer.parseInt(EastPayPanel.getPaymentValue().getText().trim()) < 
				Integer.parseInt(EastPayPanel.getPointValue().getText())) {
			JOptionPane.showMessageDialog(null, "결재금액보다 포인트가 더 많습니다");
			PaymentInsertTable.getTotal_payment().setText(EastPayPanel.getPaymentValue().getText());
			EastPayPanel.getPointValue().setText("0");
			
		} else if(Integer.parseInt(MemberPanel.getMemberPointValue().getText().trim()) < Integer.parseInt(EastPayPanel.getPointValue().getText().trim())) {
			JOptionPane.showMessageDialog(null, "보유한 포인트보다 더 많이 입력하셨습니다");
			PaymentInsertTable.getTotal_payment().setText(EastPayPanel.getPaymentValue().getText());
			EastPayPanel.getPointValue().setText("0");
			
		} else if(Integer.parseInt(EastPayPanel.getPointValue().getText().trim()) % 1000 != 0) {
			JOptionPane.showMessageDialog(null, "1,000 포인트 단위로만 사용할 수 있습니다");
			PaymentInsertTable.getTotal_payment().setText(EastPayPanel.getPaymentValue().getText());
			EastPayPanel.getPointValue().setText("0");
			
		} else {
			EastPayPanel.getPaymentValue().setText(Integer.toString(Integer.parseInt(finalPrice) - Integer.parseInt(pointValue)).trim());
			EastPayPanel.getMoneypaymentValue().setText(formatMoney.format(Integer.parseInt(EastPayPanel.getPaymentValue().getText().trim())));
			PaymentInsertTable.getTotal_payment().setText(EastPayPanel.getPaymentValue().getText().trim());
			TotalPaymentPanel.get_money_total_payment().setText(formatMoney.format(Integer.parseInt(PaymentInsertTable.getTotal_payment().getText().trim())));
			((JTextField) e.getSource()).setForeground(Color.BLACK);
		}
		
		
		
	}

}

