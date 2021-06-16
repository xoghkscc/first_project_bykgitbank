package view.Members;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClickReceipt extends MouseAdapter  {

	@Override
	public void mouseClicked(MouseEvent e) {
		
		int row = MemberSearchFrame.getTable().getSelectedRow();
		new ReceiptSearch(Integer.parseInt((String)MemberSearchFrame.getModel().getValueAt(row, 0)));
	}
}
