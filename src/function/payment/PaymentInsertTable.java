package function.payment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import function.Products_DB;
import function.Products_Select;

public class PaymentInsertTable implements ActionListener{//생성자에 table을  넣으면 해당 번호가 입력된 데이터를 넣어줌
	JTable table;
	Products_DB productDb;
	DefaultTableModel model;
	public PaymentInsertTable(DefaultTableModel model) {
		this.model = model;
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int product_id = Integer.parseInt(((JTextField) e.getSource()).getText());
		productDb = new Products_Select(product_id).getProducts_DB();
		String stocksOrgram;
		if(productDb.getStocks() == 0) {//단위가 무게일 경우 무게를 입력하게 하는 팝업창이 띄워짐
			stocksOrgram = JOptionPane.showInputDialog("무게를 입력하세요.");
		} else {
			stocksOrgram = "" + 1;
		}
		int discount;
		if(productDb.getDiscount_rate() > 0) {
			discount = (int) Math.round((productDb.getProduct_price() * Integer.parseInt(stocksOrgram)*(1-productDb.getDiscount_rate())));
		}else {
			discount = 0;
		}
		int before_discount = productDb.getProduct_price() * Integer.parseInt(stocksOrgram);//가격*(무게 혹은 1개)
		String[] data = {
				""+productDb.getProduct_id(),//물건번호
				productDb.getProduct_name(),//물건이름
				stocksOrgram, //무게 혹은 1개-개수 및 무게
				""+productDb.getProduct_price(),//1g 혹은 1개 가격-정상가
				""+before_discount,//할인전 가격
				""+discount,//할인액
				""+(before_discount - discount)//총가격(할인액이 반영된 가격)
		};
		model.addRow(data);
	}

}
