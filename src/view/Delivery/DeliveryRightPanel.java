package view.Delivery;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DeliveryRightPanel extends JPanel {
	
	static private DeliveryRightPanel rightPanel;
	
	public static JLabel informationText;
	public static JLabel addressText;
	public static JLabel phoneNumberText;
	public static JLabel paymentText;
	

	
	private DeliveryRightPanel() {
		setLayout(new GridLayout(8, 0, 5, 5));
		setBackground(new Color(43, 51, 62));
		setLocation(635, 0);
		setSize(635, 700);
		setLayout(null);
		
		String 주문자정보 = String.format("%d", DeliveryLeftTable.members_id);
		String 주소지정보 = String.format("%d", DeliveryLeftTable.delivery_id);
		String 연락처정보 = String.format("%d", DeliveryLeftTable.payment);
		
		System.out.println(주문자정보);
		System.out.println(주소지정보);
		System.out.println(연락처정보);
//		public static int delivery_id;
//		public static int members_id;
//		public static int payment;
		
		JLabel information = new DeliveryRightLabel("주문자 정보");
		informationText = new DeliveryRightText(주문자정보);
		JLabel address = new DeliveryRightLabel("주소지 정보");
		addressText = new DeliveryRightText(주소지정보);
		JLabel phoneNumber = new DeliveryRightLabel("연락처 정보");
		phoneNumberText = new DeliveryRightText(연락처정보);
		JLabel payment = new DeliveryRightLabel("주문 금액 정보");
		paymentText = new DeliveryRightText("테스트");
		
		information.setLocation(60, 50);
		informationText.setLocation(60, 100);
		address.setLocation(60, 180);
		addressText.setLocation(60, 230);
		phoneNumber.setLocation(60, 310);
		phoneNumberText.setLocation(60, 360);
		payment.setLocation(60, 440);
		paymentText.setLocation(60, 490);
		
		add(information);
		add(informationText);
		add(address);
		add(addressText);
		add(phoneNumber);
		add(phoneNumberText);
		add(payment);
		add(paymentText);

	}
	public static DeliveryRightPanel getRightPanel() {
		if(rightPanel == null) {
			rightPanel = new DeliveryRightPanel();
		}
		return rightPanel;
	}
	public static JLabel getInformationText() {
		return informationText;
	}
	public static void setInformationText(JLabel informationText) {
		DeliveryRightPanel.informationText = informationText;
	}
	public static JLabel getAddressText() {
		return addressText;
	}
	public static void setAddressText(JLabel addressText) {
		DeliveryRightPanel.addressText = addressText;
	}
	public static JLabel getPhoneNumberText() {
		return phoneNumberText;
	}
	public static void setPhoneNumberText(JLabel phoneNumberText) {
		DeliveryRightPanel.phoneNumberText = phoneNumberText;
	}
	public static JLabel getPaymentText() {
		return paymentText;
	}
	public static void setPaymentText(JLabel paymentText) {
		DeliveryRightPanel.paymentText = paymentText;
	}
	public static void setRightPanel(DeliveryRightPanel rightPanel) {
		DeliveryRightPanel.rightPanel = rightPanel;
	}
	
}