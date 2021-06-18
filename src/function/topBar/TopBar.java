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

public class TopBar extends JPanel{
	JFrame mainjf;
	JFrame paymentjf;
	
	public TopBar(JFrame mainjf, JFrame paymentjf) {
		this.mainjf = mainjf;
		this.paymentjf = paymentjf;
		
		JPanel text = new JPanel();
		setSize(1280, 50);
		setLocation(0, 0);
		text.setBackground(new Color(43, 51, 62));
		text.setBorder(null);
		
		JLabel btn1 = new JLabel();
		btn1.setBackground(new Color(43, 51, 62));
		btn1.setIcon(new ImageIcon("./files/supermarket.png"));
		btn1.setSize(400, 35);
		btn1.setLocation(830, 15);
		btn1.setBorder(null);
		add(btn1);
		
		setLayout(new BorderLayout());
		add(text);
		JButton test2 = new ClickMainDesign();
		test2.addActionListener(new ClickMain(mainjf, paymentjf));
		test2.setPreferredSize(new Dimension(50, 50));
		
		paymentjf.setBackground(new Color(0,36,62));
		add(test2, BorderLayout.WEST);
	}
	
	public TopBar() {
		
		JTextField text = new JTextField();
		setSize(1280, 50);
		setLocation(0, 0);
		text.setBackground(new Color(43, 51, 62));
		setLayout(new BorderLayout());
		add(text);
		
		JLabel btn2 = new JLabel();
		btn2.setBackground(new Color(43, 51, 62));
		btn2.setIcon(new ImageIcon("C:/Users/user/git/first_project_bykgitbank/files/supermarker.png"));
		btn2.setSize(400, 35);
		btn2.setLocation(800, 15);
		add(btn2, BorderLayout.CENTER);
		
		JButton test2 = new ClickMainDesign();
		test2.addActionListener(new ClickMain(mainjf, paymentjf));
		test2.setPreferredSize(new Dimension(50, 50));
		add(test2, BorderLayout.WEST);
	}
}
