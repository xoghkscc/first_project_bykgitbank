package function.viewToGo;
import java.awt.Color;
import java.awt.Point;

import javax.swing.JButton;

import view.Payment.lowPanel.RoundedButton;

public class FrameMoveButton extends RoundedButton {
	public FrameMoveButton(int x, int y, String name) {
		super(name);
		super.c = new Color(102, 102, 255); 
		setSize(150, 150);
		setLocation(new Point(x, y));
	}
}
