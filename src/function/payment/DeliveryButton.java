package function.payment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import function.Customer_Search;
import function.model.Member_Informations_DB;
import view.Payment.east.EastPayPanel;
import view.Payment.east.MemberPanel;


public class DeliveryButton implements ActionListener{
	
	private static boolean deliverycheck;
	Member_Informations_DB member_informations_DB;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		deliverycheck = false;
		
		//새로운 배달 공식
			
			if(!(PaymentInsertTable.getTotal_payment().getText()).trim().equals("0")) {
				if((Integer.parseInt((EastPayPanel.getAmountValue().getText()))>=30000) &
					!(MemberPanel.getMemberNameValue().getText().equals(""))) {//금액 3만원, 회원 입력할때만 작동함
					
					new Customer_Search(Integer.parseInt(MemberPanel.getMemberNumberValue().getText().trim()));
					String name = MemberPanel.getMemberNameValue().getText();
					String address = Customer_Search.getMember_Informations_DB().getMEMBERS_ADDRESS();
					
					int result = JOptionPane.showConfirmDialog(null, "이름 : "+name+"\n주소 : "+ address+"\n배달하시겠습니까?");
					
					if(result == JOptionPane.YES_OPTION) {
						deliverycheck = true;
					}else {
						//팝업창에서 no와 창을 닫을 경우 그냥 넘어가는 걸로
					}
				}else {
					System.out.println((EastPayPanel.getAmountValue().getText()));
					JOptionPane.showMessageDialog(null, "배달하려면 3만원 이상과 마트 회원이여야 합니다.");
				}
			}else {
				JOptionPane.showMessageDialog(null, "물품번호를 입력하세요.");
			}
	}
	
	public static boolean getDeliverycheck() {
		return deliverycheck;
	}
	
	public static void resetDeliverycheck() {
		deliverycheck = false;
	}

}
