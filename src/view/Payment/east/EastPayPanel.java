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

public class EastPayPanel extends JPanel{
	public EastPayPanel() {
		setLayout(new GridLayout(4, 2, 0, 0));
		setBackground(new Color(43, 51, 62));
		setBorder(BorderFactory.createEmptyBorder(0, 0, 7, 0));
		JLabel amount = new PayLabelDesign1("합계금액");
		JLabel memberNameValue = new PayLabelDesign3("0");
		JLabel discount = new PayLabelDesign2_1("할인");
		JLabel discountValue = new PayLabelDesign3("0");
		JLabel point = new PayLabelDesign2_1("포인트 사용");
		JTextField pointValue = new PayTextDesign("포인트 입력");
		JLabel payment = new PayLabelDesign4("결제 금액");
		JLabel paymentValue = new PayLabelDesign3("0");
		
		add(amount);
		add(memberNameValue);
		add(discount);
		add(discountValue);
		add(point);
		add(pointValue);
		add(payment);
		add(paymentValue);
		
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
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				((JTextField) e.getSource()).setText("");
			}
		});
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				((JTextField) e.getSource()).setText(name);
			}
		});
		
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