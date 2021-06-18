package main;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JButton;

public class MainButton2 extends JButton{
	public MainButton2(int x, int y) {
		setSize(150, 150);
		setLocation(new Point(x, y));
		setBackground(new Color(0, 36, 62));
		setContentAreaFilled(false);
		setBorder(null);
	}
}
