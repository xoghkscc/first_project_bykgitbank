package view.Members;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class TopBar extends JPanel{
	public TopBar() {
		JTextField text = new JTextField("공통 상단바");
		setSize(1280, 50);
		setLocation(50, 0);
		setBackground(Color.white);
		add(text);
	}
}
