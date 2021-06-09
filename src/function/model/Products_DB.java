package function.model;

import java.util.Date;

public class Products_DB {
	private int product_id;
	private String product_name;
	private String product_type;
	private int product_price;
	private Date expiration_date;
	private String discount_type;
	private double discount_rate;
	private String pruduct_origin;
	private int stocks;
	private int gram;
	private String sales_type;
	
	
	public Products_DB(int product_id,String product_name, String product_type, int product_price, 
			Date expiration_date, String discount_type, double discount_rate,String pruduct_origin,
			int stocks, int gram, String sales_type) {
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_type = product_type;
		this.product_price = product_price;
		this.expiration_date = expiration_date;
		this.discount_type = discount_type;
		this.discount_rate = discount_rate;
		this.pruduct_origin = pruduct_origin;
		this.stocks = stocks;
		this.gram = gram;
		this.sales_type = sales_type;
		
	}
	public int getProduct_id() {
		return product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public String getProduct_type() {
		return product_type;
	}
	public int getProduct_price() {
		return product_price;
	}
	public Date getExpiration_date() {
		return expiration_date;
	}
	public String getDiscount_type() {
		return discount_type;
	}
	public double getDiscount_rate() {
		return discount_rate;
	}
	public String getPruduct_origin() {
		return pruduct_origin;
	}
	public int getStocks() {
		return stocks;
	}
	public int getGram() {
		return gram;
	}
	public String getSales_type() {
		return sales_type;
	}
	
	
	
}
