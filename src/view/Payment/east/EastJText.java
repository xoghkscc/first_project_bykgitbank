package view.Payment.east;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

public class EastJText extends JTextField{
	public EastJText(String name) {
		super(name);
		setFont(new Font("맑은 고딕", Font.BOLD, 12));
		setBorder(new TitledBorder(new LineBorder(Color.black, 1)));
		
		setForeground(Color.gray);
		setHorizontalAlignment(JLabel.RIGHT);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				((JTextField) e.getSource()).setText("");
			}
		});
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				((JTextField) e.getSource()).setText(name);
			}
		});
		
		
	}
}
class EastJText2 extends EastJText{

	public EastJText2(String name) {
		super(name);
		setFont(new Font("맑은 고딕", Font.BOLD, 15));
		setHorizontalAlignment(JLabel.CENTER);
		setPreferredSize(new Dimension(300, 150));
		
	}
	
}
