package function.topBar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TopBar extends JPanel{
	JFrame mainjf;
	JFrame paymentjf;
	public TopBar(JFrame mainjf, JFrame paymentjf) {
		this.mainjf = mainjf;
		this.paymentjf = paymentjf;
		
		JTextField text = new JTextField("공통 상단바");
		setSize(1280, 50);
		setLocation(0, 0);
		setBackground(Color.gray);
		setLayout(new BorderLayout());
		add(text);
		
		JButton test2 = new ClickMainDesign();
		test2.addActionListener(new ClickMain(mainjf, paymentjf));
		test2.setPreferredSize(new Dimension(50, 50));
		add(test2, BorderLayout.WEST);
	}
	
	public TopBar() {
		JTextField text = new JTextField("공통 상단바");
		setSize(1280, 50);
		setLocation(0, 0);
		setBackground(Color.gray);
		setLayout(new BorderLayout());
		add(text);
		
		JButton test2 = new ClickMainDesign();
		test2.addActionListener(new ClickMain(mainjf, paymentjf));
		test2.setPreferredSize(new Dimension(50, 50));
		add(test2, BorderLayout.WEST);
	}
}
