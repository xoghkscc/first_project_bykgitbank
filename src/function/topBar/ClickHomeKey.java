package function.topBar;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ClickHomeKey extends JButton {
	
	public ClickHomeKey() {
		
		setSize(80, 80);
		setIcon(new ImageIcon("./files/homeKey.jpg"));
		setBackground(new Color(0, 36, 62));
		setLocation(30, 30);
		setBorder(null);
	}
}
