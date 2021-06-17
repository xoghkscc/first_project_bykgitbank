package view;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import function.topBar.TopBar;
import view.store.leftMenu.LeftPanel;
public class StoreMainFrame extends JFrame{
	JFrame jf;
	public StoreMainFrame(JFrame jf) {
		this.jf = jf;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(jf.getWidth(), jf.getHeight());
		setLocation(jf.getX(), jf.getY());
		setLayout(new BorderLayout());
		getContentPane().setBackground(new Color(43, 51, 62));

		
		JLabel logo = new JLabel();
		logo.setIcon(new ImageIcon("./files/logo8.png"));
		logo.setBackground(new Color(43, 51, 62));
		add(logo);
		
		JPanel topBar = new TopBar(jf, this);
		add(topBar, BorderLayout.NORTH);
		
		
		JPanel leftPanle = new LeftPanel(this);
		add(leftPanle, BorderLayout.WEST);
		
		setVisible(true);
	}
}
