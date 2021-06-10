package function.payment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import view.PaymentMainFrame;
import view.Payment.CenterPayPanel;
import view.Payment.east.EastPayPanel;
import view.Payment.east.MemberPanel;
import view.Payment.middlePanel.TotalPaymentPanel;
import view.Payment.topPanel.TopTable;

public class PayTableReset implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		TopTable.getDefaultModel().setNumRows(0);//테이블 초기화
		
		PaymentInsertTable.getTotal_payment().setText("0");//계산용 합계 초기화
		TotalPaymentPanel.get_money_total_payment().setText("0 ");//보여주기용 합계 초기화
		
		
		EastPayPanel.getAmountValue().setText("0 ");//우측 하단 합계금액 초기화
		EastPayPanel.getMoneyamountValue().setText("0 ");//우측 하단 보여주기용 합계금액 초기화
		
		EastPayPanel.getDiscountValue().setText("0");//우측 하단 할인금액 초기화
		EastPayPanel.getMoneydiscountValue().setText("0 ");//우측 하단 보여주기용 합계금액 초기화
		
		EastPayPanel.getPointValue().setText("0");//우측 하단 포인트 초기화
		
		EastPayPanel.getPaymentValue().setText("0");//최종 결제금액 초기화
		EastPayPanel.getMoneypaymentValue().setText("0 ");//우측 하단 보여주기용 최종 결제금액 초기화
	
		MemberPanel.getMemberNumberValue().setText("");
		MemberPanel.getMemberNameValue().setText("");
		MemberPanel.getMemberPointValue().setText("");
		MemberPanel.getAccumulateValue().setText("");
		MemberPanel.getMemberPhoneNumberValue().setText("뒷자리 입력");
	}

}
