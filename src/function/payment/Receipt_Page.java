package function.payment;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeListener;

import view.Payment.lowPanel.RoundedButton;

public class Receipt_Page extends Refund_Page{
	JFrame receipt;
	JButton receiptBtn;
	public Receipt_Page() {
		getRefundBtn().setText("영수증 출력");
		for(ActionListener al : getRefundBtn().getActionListeners()) {
			getRefundBtn().removeActionListener(al);
		}//기존의 액션 리스너 삭제
		getRefundBtn().addActionListener(new ReceiptAction(this));
		
		
	}
	
	
}

class ReceiptAction implements ActionListener{
	JFrame jf;
	public ReceiptAction(JFrame jf) {
		this.jf = jf;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "영수증 출력 완료.");
		jf.dispose();
	}
	
}

