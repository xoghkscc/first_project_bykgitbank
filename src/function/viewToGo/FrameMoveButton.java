package function.viewToGo;
import java.awt.Point;

import javax.swing.JButton;

public class FrameMoveButton extends JButton {
	public FrameMoveButton(int x, int y, String name) {
		super(name);
		
		setSize(150, 150);
		setLocation(new Point(x, y));
	}
}
