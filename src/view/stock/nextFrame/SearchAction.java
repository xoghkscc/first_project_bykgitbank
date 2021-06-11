package view.stock.nextFrame;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class SearchAction implements ActionListener{

	JButton jb;
	ArrayList<String> strArr;
	public SearchAction(JButton jb, ArrayList<String> strArr) {
		// TODO Auto-generated constructor stub
		this.jb = jb;
		this.strArr = strArr;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		for(int i = 0; i < comArr.size(); i++) {
//			
//			if(comArr.get(i) instanceof JTextField) {
//				JTextField jf = (JTextField)comArr.get(i);
//				jf.getText();
//			}else if(comArr.get(i) instanceof JComboBox) {
//				JComboBox jc = (JComboBox)comArr.get(i);
//				jc.getSelectedItem();
//			}
//		}
		for(int i = 0; i < strArr.size(); i++) {
			
		}
	}

}
