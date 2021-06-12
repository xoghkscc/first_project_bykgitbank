package view.Payment.east;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import view.Payment.east.Coustomer_List.Customer_List;


public class MemberPanel extends JPanel{
	private static JLabel memberNameValue;
	private static JLabel memberPointValue;
	private static JTextField memberPhoneNumberValue;
	private static JLabel accumulateValue;
	private static JLabel memberNumberValue;

	
	public MemberPanel() {
		
		setLayout(new GridLayout(5, 2, 0, 0));
		setBackground(new Color(43, 51, 62));
		JLabel MemberPhoneNumber = new EastLabel("전화 번호");
		memberPhoneNumberValue = new EastJText3("뒷자리 입력");
		memberPhoneNumberValue.addActionListener(new Customer_List());	
		JLabel memberNumber = new EastLabel("회원 번호");
		memberNumberValue = new EastLabel2("");
		JLabel memberName = new EastLabel("회원 이름");
		memberNameValue = new EastLabel2("");
		JLabel memberPoint = new EastLabel("보유 포인트");
		memberPointValue = new EastLabel2("");
		JLabel accumulate = new EastLabel("적립 예정 포인트");
		accumulateValue= new EastLabel2("");
		
		add(MemberPhoneNumber);
		add(memberPhoneNumberValue);
		add(memberNumber);
		add(memberNumberValue);
		add(memberName);
		add(memberNameValue);
		add(memberPoint);
		add(memberPointValue);
		add(accumulate);
		add(accumulateValue);
	}
	
	
	
	public static JTextField getMemberPhoneNumberValue(){
		return memberPhoneNumberValue;
	}
	
	public static JLabel getMemberPointValue(){
		return memberPointValue;
	}
	
	public static JLabel getAccumulateValue(){
		return accumulateValue;
	}
		
	public static JLabel getMemberNameValue(){
		return memberNameValue;
	}
	
	public static JLabel getMemberNumberValue(){
		return memberNumberValue;
	}
		
	class EastLabel2 extends EastLabel{
		public EastLabel2(String name) {
			super(name);
			setBackground(Color.white);
		}
	}
}