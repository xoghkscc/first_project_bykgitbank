package function.payment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class MiniTableSearch{
	int sales_id;
	String sales_text;
	TableRowSorter<DefaultTableModel> sorter;
	public MiniTableSearch(String sales_text) {
		this.sales_text = sales_text;
		
		DefaultTableModel salesmodel = MiniTable.getMiniModel();
		JTable table = Refund_Page.getSalesTable();
		sorter = new TableRowSorter<DefaultTableModel>(salesmodel);
		
		if(!sales_text.trim().equals("")) {
			this.sales_id = Integer.parseInt(sales_text.trim());
			sorter.setRowFilter(filter);
		}else {
			sorter.setRowFilter(resetfilter);
		}
		table.setRowSorter(sorter);
	}
	RowFilter<Object, Object> filter = new RowFilter<Object, Object>() {
		public boolean include(Entry entry) {
			int population = Integer.parseInt((String) entry.getValue(0));
			return population == sales_id;
		}
	};
	RowFilter<Object, Object> resetfilter = new RowFilter<Object, Object>() {
		public boolean include(Entry entry) {
			return true;
		}
	};
}