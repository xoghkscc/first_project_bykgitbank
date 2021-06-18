package view.Members;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import view.Members.Customer_Function.DateReceiptFun;
import view.Members.Customer_Function.ProductReceiptFun;

public class DateReceiptText implements ActionListener {
	JDatePickerImpl sales_time;
	
	
	public DateReceiptText(DefaultTableModel model) {
		this.sales_time = sales_time;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String startDate3 = String.format(""+ DateReceipt.modelStart.getYear()).substring(2);
		String startDate4 = String.format("0"+ (DateReceipt.modelStart.getMonth()+1));
		String startDate2 = (String.format(startDate3 + "/" + startDate4 + "/" + DateReceipt.modelStart.getDay()));
		startDate2.trim();
		while(DateReceipt.getModel().getRowCount() > 0) {		
			DateReceipt.getModel().removeRow(0);
		}
		new DateReceiptFun(startDate2);
	}

}
