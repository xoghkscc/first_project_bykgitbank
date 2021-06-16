package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import function.topBar.ClickMain;
import function.topBar.ClickMainDesign;
import function.topBar.TopBar;
import view.Delivery.DeliveryCenterPanel;

public class DeliveryMainFrame extends JFrame {
	public static JFrame jf;
	public DeliveryMainFrame() {
//		this.jf = jf;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280, 720);
		setLocation(50, 50);
	
//		setLayout(null);
		
//		JButton test2 = new ClickMainDesign();
//		test2.addActionListener(new ClickMain(jf, this));
//
//		add(test2);
		
		JPanel topBar = new TopBar(jf, this);
		add(topBar, BorderLayout.NORTH);
		
		JPanel DeliveryCenterPanel = new DeliveryCenterPanel(this);
		add(DeliveryCenterPanel, BorderLayout.CENTER);

		setVisible(true);
		
	}
	public static void main(String[] args) {
		new DeliveryMainFrame();
	}
}
