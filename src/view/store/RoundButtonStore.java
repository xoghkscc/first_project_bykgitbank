package view.store;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import view.Payment.lowPanel.RoundedButton;

public class RoundButtonStore extends RoundedButton{
	public RoundButtonStore(String name) {
		super(name);
		super.c = new Color(153, 153, 153); 
		setHorizontalAlignment(JLabel.CENTER);
		setFont(new Font("맑은 고딕", Font.BOLD, 20));
	}
}
