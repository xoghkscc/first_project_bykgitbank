package function.payment;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

class ResetPoint implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
