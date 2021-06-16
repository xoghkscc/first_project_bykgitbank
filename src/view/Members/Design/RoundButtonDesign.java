package view.Members.Design;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import view.Payment.lowPanel.RoundedButton;

public class RoundButtonDesign extends RoundedButton {

		public RoundButtonDesign(String name) {
			super(name);
			super.c = new Color(153, 102, 255); 
			setHorizontalAlignment(JLabel.CENTER);
			setFont(new Font("맑은 고딕", Font.BOLD, 20));
		}
	
}
