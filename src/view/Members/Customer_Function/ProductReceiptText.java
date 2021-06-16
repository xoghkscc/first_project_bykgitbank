package view.Members.Customer_Function;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Members.MemberSearchFrame;
import view.Members.ProductReceipt;

public class ProductReceiptText implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		while(ProductReceipt.getModel().getRowCount() > 0) {		
			ProductReceipt.getModel().removeRow(0);
		}
				
		new ProductReceiptFun((ProductReceipt.getProduct_name().getText().trim()));
		
	}

}
