package function.payment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import view.Payment.CenterPayPanel;
import view.Payment.topPanel.TopTable;

public class PayTableReset implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		TopTable.getDefaultModel().setNumRows(0);
	}

}
