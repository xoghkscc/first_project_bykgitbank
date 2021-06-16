package function.member.design;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import view.Payment.lowPanel.RoundedButton;

public class RoundButtonDesign extends RoundedButton {

		public RoundButtonDesign(String name) {
			super(name);
			super.o = new Color(100, 100, 100);
			super.c = new Color(255, 255, 240); 
			setHorizontalAlignment(JLabel.CENTER);
			setFont(new Font("맑은 고딕", Font.BOLD, 20));
		}
	
}
