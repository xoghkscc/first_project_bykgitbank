package function.topBar;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ClickMainDesign extends JButton {
	public ClickMainDesign() {
		setSize(50, 50);
		setIcon(new ImageIcon("./files/backIcon3.jpg"));
		setBackground(new Color(43, 51, 62));
		setLocation(0, 0);
		setBorder(null);
	}
}
