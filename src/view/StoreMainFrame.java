package view;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import function.topBar.*;
import view.store.leftMenu.LeftPanel;
public class StoreMainFrame extends JFrame{
	JFrame jf;
	public StoreMainFrame(JFrame jf) {
		this.jf = jf;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(jf.getWidth(), jf.getHeight());
		setLocation(jf.getX(), jf.getY());
		setLayout(new BorderLayout());
		

		JPanel topBar = new TopBar(jf, this);
		add(topBar, BorderLayout.NORTH);
		
		
		JPanel leftPanle = new LeftPanel(this);
		add(leftPanle, BorderLayout.WEST);
		
		setVisible(true);
	}
}
