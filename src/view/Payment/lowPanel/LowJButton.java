package view.Payment.lowPanel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class LowJButton extends RoundedButton{
	public LowJButton(String name) {
		super(name);
		super.c = new Color(51, 61, 71); 
		setHorizontalAlignment(JLabel.CENTER);
		setFont(new Font("맑은 고딕", Font.BOLD, 20));
	}
}

class LowJButtonReset extends RoundedButton{
	public LowJButtonReset(String name) {
		super(name);
		super.c = new Color(245, 173, 37); 
		setHorizontalAlignment(JLabel.CENTER);
		setFont(new Font("맑은 고딕", Font.BOLD, 20));
	}
}
class LowJButtonCancel extends RoundedButton{
	public LowJButtonCancel(String name) {
		super(name);
		super.c = new Color(153, 153, 153); 
		setHorizontalAlignment(JLabel.CENTER);
		setFont(new Font("맑은 고딕", Font.BOLD, 20));
	}
}
class LowJButtoncashPayment extends RoundedButton{
	public LowJButtoncashPayment(String name) {
		super(name);
		super.c = new Color(255, 62, 62); 
		setHorizontalAlignment(JLabel.CENTER);
		setFont(new Font("맑은 고딕", Font.BOLD, 20));
	}
}
class LowJButtoncardPayment extends RoundedButton{
	public LowJButtoncardPayment(String name) {
		super(name);
		super.c = new Color(111, 195, 11); 
		setHorizontalAlignment(JLabel.CENTER);
		setFont(new Font("맑은 고딕", Font.BOLD, 20));
	}
}


