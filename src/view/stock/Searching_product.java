package view.stock;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Searching_product {
	
	private JPanel index;
	
	public Searching_product(JPanel index){
		
		this.index = index;
	
		JTextField jTextField = new JTextField(20);
		
		JButton jButton = new JButton("검색");
		
		JComboBox<String> jComboBox = new JComboBox<String>(new String[] {"ID", "품목이름", "유통기한","전체검색"}); 
		
		JMenuBar menuBar = new JMenuBar();
		JMenu adminMenu = new JMenu("메뉴");
		
//		JPanel jPanel = new JPanel(new FlowLayout());
		adminMenu.add(new JMenuItem("1"));
		adminMenu.add(new JMenuItem("2"));
		adminMenu.add(new JMenuItem("3"));
		adminMenu.addSeparator(); 
		adminMenu.add(new JMenuItem("4"));
		
		menuBar.add(adminMenu);

//		jFrame.setJMenuBar(menuBar); //메뉴바는 인덱스에 넣지 못함

		index.setBackground(new Color(71,81,101));
		
//		jTextField.setSize(100, 100);
//		jTextField.setLocation(100, 200);
//		jButton.setLocation(200,300);
//		jButton.setSize(100,100);
		jButton.setBackground(new Color(122,122,122));
		jButton.setForeground(new Color(255,255,255));
		
		index.add(jComboBox);
		index.add(jTextField);
		index.add(jButton);
	}

	public JPanel getIndex() {
		return index;
	}
	
}
