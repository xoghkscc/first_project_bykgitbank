package view.Members;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class TopBar extends JPanel{
	public TopBar() {
		JTextField text = new JTextField("공통 상단바");
		setSize(1150, 50);
		setLocation(0, 0);
		setBackground(Color.gray);
		add(text);
	}
}
