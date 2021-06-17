package function.payment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import function.Products_Select;
import function.model.Products_DB;
import view.Payment.east.*;
import view.Payment.middlePanel.TotalPaymentPanel;
import view.PaymentMainFrame;

public class PaymentInsertTable implements ActionListener {// 생성자에 table을 넣으면 해당 번호가 입력된 데이터를 넣어줌
	Products_DB productDb;
	DefaultTableModel model;
	private static JLabel total_payment;
	private static String stocksOrgram;
	
	public static JLabel getTotal_payment() {
		return total_payment;
	}
	public static String getStocksOrgram() {
		return stocksOrgram;
	}
	
	
	public PaymentInsertTable(DefaultTableModel model, JLabel total_payment) {
		this.model = model;
		this.total_payment = total_payment;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		int product_id = Integer.parseInt(((JTextField) e.getSource()).getText().trim());
	
	
		productDb = new Products_Select(product_id).getProducts_DB();
		
	
		if (productDb.getStocks() == 0) {// 단위가 무게일 경우 무게를 입력하게 하는 팝업창이 띄워짐
			stocksOrgram = JOptionPane.showInputDialog("무게를 입력하세요.");
		} else {
			stocksOrgram = "" + 1;
		}
		
		int discount;
		if (productDb.getDiscount_rate() > 0 ) {
			discount = (int) Math.round((productDb.getProduct_price() * Integer.parseInt(stocksOrgram)
					* (1 - productDb.getDiscount_rate())));
		} else {
			discount = 0;
		}
		
	
		int before_discount = productDb.getProduct_price() * Integer.parseInt(stocksOrgram);// 가격*(무게 혹은 1개)
		String[] data = { "" + productDb.getProduct_id(), // 물건번호
				productDb.getProduct_name(), // 물건이름
				stocksOrgram, // 무게 혹은 1개-개수 및 무게
				"" + productDb.getProduct_price(), // 1g 혹은 1개 가격-정상가
				"" + before_discount, // 할인전 가격
				"" + discount, // 할인액
				"" + (before_discount - discount)// 총가격(할인액이 반영된 가격)
		};
		model.addRow(data);
		((JTextField) e.getSource()).setText("");
		
		DecimalFormat formatMoney = new DecimalFormat("###,### ");
		
		//view.Payment.middlePanel에 있는 합계 JLabel을 바꿔주는 기능임
		
		String before_discount2 = EastPayPanel.getAmountValue().getText().trim();
		EastPayPanel.getAmountValue().setText(Integer.toString((Integer.parseInt(before_discount2) + Integer.parseInt(data[4]))));//우측 하단 합계금액
		
		String disCount = EastPayPanel.getDiscountValue().getText().trim();
		EastPayPanel.getDiscountValue().setText(Integer.toString((Integer.parseInt(disCount) + Integer.parseInt(data[5]))));//우측 하단 할인
		
		String sumPrice = EastPayPanel.getAmountValue().getText().trim();//합계금액
		EastPayPanel.getMoneyamountValue().setText(formatMoney.format(Integer.parseInt(sumPrice)));//합계를 화폐단위로 출력
		
		String disCountPrice =  EastPayPanel.getDiscountValue().getText().trim();//할인
		EastPayPanel.getMoneydiscountValue().setText(formatMoney.format(Integer.parseInt(disCountPrice)));//합계를 화폐단위로 출력
		
		String pointValue = EastPayPanel.getPointValue().getText().trim();//포인트 사용
		
		EastPayPanel.getPaymentValue().setText(Integer.toString((Integer.parseInt(sumPrice) - (Integer.parseInt(disCountPrice) + Integer.parseInt(pointValue)))).trim());//
		EastPayPanel.getMoneypaymentValue().setText(formatMoney.format(Integer.parseInt(EastPayPanel.getPaymentValue().getText())));//최종 금액을 화폐단위로 출력

		total_payment.setText("" + (Integer.parseInt(total_payment.getText().trim()) + Integer.parseInt(data[6])));//큰 글씨 합계
		TotalPaymentPanel.get_money_total_payment().setText(formatMoney.format(Integer.parseInt(total_payment.getText())));
		
		int total_payment = Integer.parseInt(PaymentInsertTable.getTotal_payment().getText());
		
		int reserved_point = (int)(total_payment * 0.01);
		
		if(!MemberPanel.getMemberNameValue().getText().trim().equals("")) {
			MemberPanel.getAccumulateValue().setText("" + reserved_point);
		}
		
	}

}
