package view.stock.nextFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class ComboBoxActions implements ActionListener{

	JComboBox<String> comboBox;
	JTextField jtf;
	public ComboBoxActions(JComboBox<String> comboBox,JTextField jtf) {
		// TODO Auto-generated constructor stub
		this.comboBox = comboBox;
		this.jtf = jtf;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		comboBox.getSelectedItem();

		
		if(comboBox.getSelectedItem().equals("직접입력")) {
			
			 jtf.setVisible(true);
			 
		}else {
			jtf.setVisible(false);
		}
	}
}
