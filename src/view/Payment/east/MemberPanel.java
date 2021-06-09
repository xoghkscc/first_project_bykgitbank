package view.Payment.east;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import function.payment.Payment_Custormer_infor;


public class MemberPanel extends JPanel{
	private static JLabel memberNameValue;
	private static JLabel memberPointValue;
	private static JTextField memberNumberValue;
	private static JLabel accumulateValue;

	
	public MemberPanel() {
		
		setLayout(new GridLayout(4, 2, 0, 0));
		setBackground(new Color(43, 51, 62));
		JLabel memberNumber = new EastLabel("회원 번호");
		memberNumberValue = new EastJText("회원 번호 입력");
		JTextField memberNumberValue = new EastJText3("회원 번호 입력");
		memberNumberValue.addActionListener(new Payment_Custormer_infor());	
		JLabel memberName = new EastLabel("회원 이름");
		memberNameValue = new EastLabel2("");
		JLabel memberPoint = new EastLabel("보유 포인트");
		memberPointValue = new EastLabel2("");
		JLabel accumulate = new EastLabel("적립 예정 포인트");
		accumulateValue= new EastLabel2("");
		
			
		add(memberNumber);
		add(memberNumberValue);
		add(memberName);
		add(memberNameValue);
		add(memberPoint);
		add(memberPointValue);
		add(accumulate);
		add(accumulateValue);
	}
	
	
	
	public static JTextField getMemberNumberValue(){
		return memberNumberValue;
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
		
	class EastLabel2 extends EastLabel{
		public EastLabel2(String name) {
			super(name);
			setBackground(Color.white);
		}
	}
}