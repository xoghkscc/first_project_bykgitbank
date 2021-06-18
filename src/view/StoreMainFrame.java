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
	static JFrame jf;
	public StoreMainFrame(JFrame jf) {
		this.jf = jf;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(jf.getWidth(), jf.getHeight());
		setLocation(jf.getX(), jf.getY());
		setLayout(new BorderLayout());
		getContentPane().setBackground(new Color(43, 51, 62));

		
		
		JPanel topBar = new TopBar(jf, this);
		add(topBar, BorderLayout.NORTH);
		topBar.setBackground(new Color(43, 51, 62));
		
		JPanel leftPanle = new LeftPanel(this);
		add(leftPanle, BorderLayout.WEST);
		
		setVisible(true);
	}
	
}
