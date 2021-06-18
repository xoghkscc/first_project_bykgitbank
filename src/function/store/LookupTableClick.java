package function.store;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import view.Delivery.DeliveryLeftButton;
import view.store.centerPanel.StoreLookup;

public class LookupTableClick extends MouseAdapter{
	private static int clickRow;
	String type;
	public LookupTableClick(String type) {
		this.type = type;
	}
	public void mouseClicked(MouseEvent e) {
		clickRow = ((JTable) e.getSource()).getSelectedRow();
		if(type.equals("date")) {
			((DefaultTableModel) RightPane_date.getlookupRightTable().getModel()).setNumRows(0);
			DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
			Date date = null;
			try {
				date = dateFormat.parse((String) LookupTable_date.getLookupDateModel().getValueAt(clickRow, 0));
				new RightTable_dateAddRow(date);
			} catch (ParseException e1) {
				System.out.println("날짜가 이상합니다");
				e1.printStackTrace();
			} 
			
		}else if(type.equals("product")) {
			((DefaultTableModel) RightPane_product.getlookupRightTable().getModel()).setNumRows(0);
			int product_id =Integer.parseInt((String) LookupTable_product.getLookupProductModel().getValueAt(clickRow, 0));
			new RightTable_productAddRow(product_id);
		}
	}
	
	public static int getClickRow() {
		return clickRow;
	}
}
