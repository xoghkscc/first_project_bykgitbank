package function.payment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import function.Delivery_Insert;
import function.Member_informations_update;
import function.Sales_Insert;
import view.Payment.east.EastPayPanel;
import view.Payment.east.MemberPanel;
import view.Payment.middlePanel.TotalPaymentPanel;
import view.Payment.topPanel.TopTable;


public class FinalPayment implements ActionListener{
	String Payment_type;
	public FinalPayment(String Payment_type) {
		this.Payment_type = Payment_type;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(DeliveryButton.getDeliverycheck()) {
			new Delivery_Insert();
		}
		
		if(!MemberPanel.getMemberNameValue().getText().trim().equals("")) {
			int members_id =Integer.parseInt(MemberPanel.getMemberNumberValue().getText().trim());
			int accumulate_point = Integer.parseInt(MemberPanel.getAccumulateValue().getText().trim()) - 
					Integer.parseInt(EastPayPanel.getPointValue().getText().trim());//적립 예정 포인트에서 포인트 사용을 빼야함
			new Member_informations_update(members_id, accumulate_point);
		}
		
		new Sales_Insert(Payment_type);//SALES에 반영하는 메서드
		
		DeliveryButton.resetDeliverycheck();//배달 상태를 다시원위치
		new PaymentReset();//결제버튼 누르고 모든걸 다 처리하고 난 뒤 초기화 되는 기능
		
	}
}

class PaymentReset {
	public PaymentReset() {
		TopTable.getDefaultModel().setNumRows(0);
		PaymentInsertTable.getTotal_payment().setText("0");
		TotalPaymentPanel.get_money_total_payment().setText("0 ");
		EastPayPanel.getMoneyamountValue().setText("0 ");
		EastPayPanel.getDiscountValue().setText("0");
		EastPayPanel.getMoneydiscountValue().setText("0 ");
		EastPayPanel.getPointValue().setText("0");
		EastPayPanel.getPaymentValue().setText("0");
		EastPayPanel.getMoneypaymentValue().setText("0 ");
		MemberPanel.getMemberNumberValue().setText("");
		MemberPanel.getMemberNameValue().setText("");
		MemberPanel.getMemberPointValue().setText("");
		MemberPanel.getAccumulateValue().setText("");
		MemberPanel.getMemberPhoneNumberValue().setText("뒷자리 입력");
	}
}
