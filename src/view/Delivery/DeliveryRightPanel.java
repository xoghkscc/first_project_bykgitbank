package view.Delivery;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DeliveryRightPanel extends JPanel {
	static private DeliveryRightPanel rightPanel;
	
	public static JLabel informationText;
	public static JLabel addressText;
	public static JLabel phoneNumberText;
	public static JLabel paymentText;
	
	public DeliveryRightPanel() {
		setLayout(new GridLayout(8, 0, 5, 5));
		setBackground(new Color(43, 51, 62));
		setLocation(635, 0);
		setSize(635, 700);
		setLayout(null);
		
		JLabel information = new DeliveryRightLabel("주문자 정보");
		JLabel informationText = new DeliveryRightText("테스트");
		JLabel address = new DeliveryRightLabel("주소지 정보");
		JLabel addressText = new DeliveryRightText("테스트");
		JLabel phoneNumber = new DeliveryRightLabel("연락처 정보");
		JLabel phoneNumberText = new DeliveryRightText("테스트");
		JLabel payment = new DeliveryRightLabel("주문 금액 정보");
		JLabel paymentText = new DeliveryRightText("테스트");
		
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
		if (rightPanel == null) {
			rightPanel = new DeliveryRightPanel();
		}
		return rightPanel;
	}

	public static JLabel getInformationText() {
		return informationText;
	}

	public static JLabel getAddressText() {
		return addressText;
	}

	public static JLabel getPhoneNumberText() {
		return phoneNumberText;
	}

	public static JLabel getPaymentText() {
		return paymentText;
	}
	
}