package view.stock;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import view.Payment.lowPanel.RoundedButton;



public class Button_round_search extends RoundedButton {

	public Button_round_search(String name) {
		super(name);
		super.c = new Color(122,122,122); 
		setHorizontalAlignment(JLabel.CENTER);
		setFont(new Font("맑은 고딕", Font.BOLD, 20));
	}
}

class Button_round_update extends RoundedButton {
	
	public Button_round_update(String name) {
		super(name);
		super.c = new Color(51, 61, 71); 
		setHorizontalAlignment(JLabel.CENTER);
		setFont(new Font("맑은 고딕", Font.BOLD, 20));
	}
}

class Button_round_order extends RoundedButton {
	
	public Button_round_order(String name) {
		super(name);
		super.c = new Color(51, 61, 71); 
		setHorizontalAlignment(JLabel.CENTER);
		setFont(new Font("맑은 고딕", Font.BOLD, 20));
	}
}

class Button_round_expiry_disposal extends RoundedButton {
	
	public Button_round_expiry_disposal(String name) {
		super(name);
		super.c = new Color(51, 61, 71); 
		setHorizontalAlignment(JLabel.CENTER);
		setFont(new Font("맑은 고딕", Font.BOLD, 20));
	}
}

class Button_round_expiry_search extends RoundedButton {
	
	public Button_round_expiry_search(String name) {
		super(name);
		super.c = new Color(255, 62, 62); 
		setHorizontalAlignment(JLabel.CENTER);
		setFont(new Font("맑은 고딕", Font.BOLD, 20));
	}
}

class Button_round_profit_rate extends RoundedButton {
	
	public Button_round_profit_rate(String name) {
		super(name);
		super.c = new Color(153, 153, 153); 
		setHorizontalAlignment(JLabel.CENTER);
		setFont(new Font("맑은 고딕", Font.BOLD, 20));
	}
}

class Button_round_type_search extends RoundedButton {
	
	public Button_round_type_search(String name) {
		super(name);
		super.c = new Color(111, 195, 11); 
		setHorizontalAlignment(JLabel.CENTER);
		setFont(new Font("맑은 고딕", Font.BOLD, 20));
	}
}

class Button_round_event extends RoundedButton {
	
	public Button_round_event(String name) {
		super(name);
		super.c = new Color(51, 61, 71); 
		setHorizontalAlignment(JLabel.CENTER);
		setFont(new Font("맑은 고딕", Font.BOLD, 20));
	}
}

class Button_round extends RoundedButton {
	
	public Button_round(String name) {
		super(name);
		super.c = new Color(245, 173, 37); 
		setHorizontalAlignment(JLabel.CENTER);
		setFont(new Font("맑은 고딕", Font.BOLD, 20));
	}
}