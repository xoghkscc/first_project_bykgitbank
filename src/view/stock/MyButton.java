package view.stock;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.AbstractBorder;
import javax.swing.border.BevelBorder;

public class MyButton {

	public MyButton(JButton jb) {
		
		AbstractBorder border = new BevelBorder(BevelBorder.RAISED);
		jb.setBorder(border);
		jb.setBackground(new Color(51,61,71));
		jb.setForeground(Color.WHITE);
		jb.setSize(50, 50);
		jb.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		jb.setVisible(true);
	}
}
