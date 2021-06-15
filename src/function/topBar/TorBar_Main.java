package function.topBar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TorBar_Main extends JPanel {
	
	JFrame log_jf;
	JFrame main_jf;
	
	public TorBar_Main(JFrame log_jf, JFrame main_jf) {
		this.log_jf = log_jf;
		this.main_jf = main_jf;
		
		JTextField text = new JTextField();
		setSize(1280, 50);
		setLocation(0, 0);
		text.setBackground(new Color(0, 36, 62));
		text.setBorder(null);
		
		JLabel btn1 = new JLabel();
		btn1.setBackground(new Color(43, 51, 62));
		btn1.setIcon(new ImageIcon("./files/supermarket2.png"));
		btn1.setSize(400, 35);
		btn1.setLocation(830, 15);
		btn1.setBorder(null);
		add(btn1);
		
		setLayout(new BorderLayout());
		add(text);
		JButton test2 = new ClickHomeKey();
		test2.addActionListener(new ClickMain(log_jf, main_jf));
		test2.setPreferredSize(new Dimension(50, 50));
		
		add(test2, BorderLayout.WEST);
	}
}
