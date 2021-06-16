package function.viewToGo;
import java.awt.Color;
import java.awt.Point;

import javax.swing.JButton;

import view.Payment.lowPanel.RoundedButton;

public class MainButton extends RoundedButton {
	public MainButton(int x, int y, String name) {
		super(name);
		super.o = new Color(100, 100, 100);
		super.c = new Color(255, 255, 240); 
		setSize(150, 150);
		setLocation(new Point(x, y));
	}
}
