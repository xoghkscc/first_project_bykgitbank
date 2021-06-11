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
		
		JComboBox<String> jComboBox = new JComboBox<String>(new String[] {"번호", "품목이름", "유통기한","전체검색"}); 

		index.setBackground(new Color(71,81,101));
		

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
