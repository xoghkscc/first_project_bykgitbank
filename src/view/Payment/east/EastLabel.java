package view.Payment.east;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class EastLabel extends JLabel{
	public EastLabel(String name) {
		super(name);
		setFont(new Font("맑은 고딕", Font.BOLD, 12));
		setBackground(new Color(211, 211, 211));
		setHorizontalAlignment(JLabel.CENTER);
		setBorder(new TitledBorder(new LineBorder(Color.black, 1)));
		setOpaque(true);
		
	}
}

class Label2 extends JLabel{
	public Label2() {
		super("");
		setBackground(new Color(43, 51, 62));
	}
}
