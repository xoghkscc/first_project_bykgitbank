package view.Payment.east;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

import function.payment.PointReset;
import function.payment.PointUse;

public class EastPayPanel extends JPanel{
	private static JLabel amountValue;
	private static JLabel moneyamountValue;
	private static JLabel discountValue;
	private static JLabel moneydiscountValue;
	private static JLabel paymentValue;
	private static JLabel moneypaymentValue;
	private static JTextField pointValue;
	private static JTextField moneypointValue;
	
	public EastPayPanel() {
		setLayout(new GridLayout(4, 2, 0, 0));
		setBackground(new Color(43, 51, 62));
		setBorder(BorderFactory.createEmptyBorder(0, 0, 7, 0));
		JLabel amount = new PayLabelDesign1("합계금액");
		amountValue = new PayLabelDesign3("0");//계산용
		moneyamountValue =  new PayLabelDesign3("0");//실제 화페 단위로 출력할 JLabel
		
		JLabel discount = new PayLabelDesign2_1("할인");
		discountValue = new PayLabelDesign3("0");//계산용
		moneydiscountValue =  new PayLabelDesign3("0");//실제 화페 단위로 출력할 JLabel
		
		JLabel point = new PayLabelDesign2_1("포인트 사용");
		pointValue = new PayTextDesign("0 ");
		pointValue.addActionListener(new PointUse());
		pointValue.addMouseListener(new PointReset());
		
		JLabel payment = new PayLabelDesign4("결제 금액");
		paymentValue = new PayLabelDesign3("0");//계산용
		moneypaymentValue = new PayLabelDesign3("0");//실제 화폐 단위로 출력할 JLabel
		//얘가 테이블 아래에 나타날 변수
		
		add(amount);
		add(moneyamountValue);
		add(discount);
		add(moneydiscountValue);
		add(point);
		add(pointValue);
		add(payment);
		add(moneypaymentValue);
		
	}
	public static JTextField getMoneypointValue() {
		return moneypointValue;
	}
	public static JLabel getMoneypaymentValue() {
		return moneypaymentValue;
	}
	public static JLabel getMoneydiscountValue() {
		return moneydiscountValue;
	}
	public static JLabel getMoneyamountValue() {
		return moneyamountValue;
	}
	public static JTextField getPointValue() {
		return pointValue;
	}
	public static JLabel getPaymentValue() {
		return paymentValue;
	}
	public static JLabel getAmountValue() {
		return amountValue;
	}
	public static JLabel getDiscountValue() {
		return discountValue;
	}
}

class PayTextDesign extends JTextField {
	public PayTextDesign(String name) {
		super(name);
		setFont(new Font("맑은 고딕", Font.BOLD, 12));
		setBorder(new TitledBorder(new LineBorder(Color.black, 1)));
		setPreferredSize(new Dimension(300, 150));
		setHorizontalAlignment(JLabel.RIGHT);
		setForeground(Color.gray);
	}
}


class PayLabelDesign1 extends JLabel{
	public PayLabelDesign1(String name) {
		super(name);
		setFont(new Font("맑은 고딕", Font.BOLD, 12));
		setHorizontalAlignment(JLabel.CENTER);
		setBorder(new TitledBorder(new LineBorder(Color.black, 1)));
		setBackground(new Color(218, 236, 196));
		
		setOpaque(true);
	}
}
class PayLabelDesign2 extends JLabel{
	public PayLabelDesign2(String name) {
		super(name);
		setFont(new Font("맑은 고딕", Font.BOLD, 12));
		setHorizontalAlignment(JLabel.CENTER);
		setBorder(new TitledBorder(new LineBorder(Color.black, 1)));
		setOpaque(true);
		setBackground(new Color(219, 222, 227));
	}
}

class PayLabelDesign2_1 extends PayLabelDesign2{

	public PayLabelDesign2_1(String name) {
		super(name);
		setForeground(Color.RED);
		
	}
	
}
class PayLabelDesign3 extends JLabel{
	public PayLabelDesign3(String name) {
		super(name+" ");
		setFont(new Font("맑은 고딕", Font.BOLD, 12));
		setBorder(new TitledBorder(new LineBorder(Color.black, 1)));
		setBackground(Color.white);
		setHorizontalAlignment(JLabel.RIGHT);
		setOpaque(true);
	}
}

class PayLabelDesign4 extends JLabel{
	public PayLabelDesign4(String name) {
		super(name);
		setFont(new Font("맑은 고딕", Font.BOLD, 12));
		setHorizontalAlignment(JLabel.CENTER);
		setBorder(new TitledBorder(new LineBorder(Color.black, 1)));
		setOpaque(true);
		setBackground(new Color(255, 226, 226));
	}
}