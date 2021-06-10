package function.payment;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

import view.Payment.CenterPayPanel;
import view.Payment.east.EastPayPanel;
import view.Payment.east.MemberPanel;
import view.Payment.middlePanel.TotalPaymentPanel;
import view.Payment.topPanel.TopTable;

public class Products_Stocks_Modify extends MouseAdapter{
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
		String[] data = new String[7];
		
		int row =  CenterPayPanel.getTop().getSelectedRow();
		String product_name = (String) TopTable.getDefaultModel().getValueAt(row, 1);
		int stock =Integer.parseInt(JOptionPane.showInputDialog(product_name+"의 개수 혹은 무게를 입력하세요."));
		
		int modify_stocks = Integer.parseInt((String) TopTable.getDefaultModel().getValueAt(row, 2));
		int price = Integer.parseInt((String) TopTable.getDefaultModel().getValueAt(row, 3));
		int before_discount =Integer.parseInt((String)TopTable.getDefaultModel().getValueAt(row, 4));
		int discount =Integer.parseInt((String)TopTable.getDefaultModel().getValueAt(row, 5));
		int totalPrice =Integer.parseInt((String)TopTable.getDefaultModel().getValueAt(row, 6));
		
		float discount_percent = (discount / (float) before_discount);//할인율
		
		TopTable.getDefaultModel().setValueAt(""+stock, row, 2);//개수 세팅
		TopTable.getDefaultModel().setValueAt(""+stock*price, row, 4);//할인전 가격 세팅
		TopTable.getDefaultModel().setValueAt(""+ Math.round(stock*price*discount_percent), row, 5);//할인액 세팅
		TopTable.getDefaultModel().setValueAt(""+ Math.round(stock*price*(1- discount_percent)), row, 6);//총 가격 세팅
		
		for(int i =0; i<data.length; i++) {
			data[i] = (String) TopTable.getDefaultModel().getValueAt(row, i);
		}
		
		int total_changePrice = totalPrice - Integer.parseInt((String) TopTable.getDefaultModel().getValueAt(row, 6));
		int changePrice = before_discount - Integer.parseInt((String) TopTable.getDefaultModel().getValueAt(row, 4));
		int changeDiscount = discount - Integer.parseInt((String) TopTable.getDefaultModel().getValueAt(row, 5));
		DecimalFormat formatMoney = new DecimalFormat("###,### ");
		
		PaymentInsertTable.getTotal_payment().setText(""+(Integer.parseInt(PaymentInsertTable.getTotal_payment().getText()) - total_changePrice));
		TotalPaymentPanel.get_money_total_payment().setText(formatMoney.format(Integer.parseInt(PaymentInsertTable.getTotal_payment().getText())));
		
		EastPayPanel.getAmountValue().setText("" + (Integer.parseInt(EastPayPanel.getAmountValue().getText()) - changePrice));
		EastPayPanel.getMoneyamountValue().setText((formatMoney.format(Integer.parseInt(EastPayPanel.getAmountValue().getText()))));
		
		EastPayPanel.getDiscountValue().setText(""+(Integer.parseInt(EastPayPanel.getDiscountValue().getText()) - changeDiscount));
		EastPayPanel.getMoneydiscountValue().setText(formatMoney.format(Integer.parseInt(EastPayPanel.getDiscountValue().getText().trim())));
		
		EastPayPanel.getPaymentValue().setText(""+ Integer.parseInt(PaymentInsertTable.getTotal_payment().getText()));
		EastPayPanel.getMoneypaymentValue().setText(formatMoney.format(Integer.parseInt(EastPayPanel.getPaymentValue().getText().trim())));
		
		
		
	}
}
