package view.Payment.lowPanel;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import function.payment.DeliveryButton;
import function.payment.FinalPayment;
import function.payment.PayTableReset;
import function.payment.ReceiptButton;
import function.payment.RefundButton;

public class LowPanel extends JPanel{
	public LowPanel() {
		setBackground(new Color(43, 51, 62));
		setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		setLayout(new GridLayout(2, 3, 5, 5));
		JButton reset = new LowJButtonReset("초기화");
		reset.addActionListener(new PayTableReset());
		
		JButton receipt = new LowJButton("영수증출력");
		receipt.addActionListener(new ReceiptButton());
		JButton cancelPayment = new LowJButtonCancel("배달");
		cancelPayment.addActionListener(new DeliveryButton());
		JButton refund = new LowJButton("환불");
		refund.addActionListener(new RefundButton());
		
		
		JButton cashPayment = new LowJButtoncashPayment("현금결제");
		cashPayment.addActionListener(new FinalPayment("CASH"));//산 품목들을 SALES에 넘기는 이벤트
		
		
		JButton cardPayment = new LowJButtoncardPayment("카드결제");
		cardPayment.addActionListener(new FinalPayment("CARD"));//산 품목들을 SALES에 넘기는 이벤트
		
		add(reset);
		add(receipt);
		add(cashPayment);
		add(cancelPayment);
		add(refund);
		add(cardPayment);
	}
}
