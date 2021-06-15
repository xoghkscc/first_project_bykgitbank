package view.stock.nextFrame.productEvent;

import java.util.Date;

public class RowInfo {

	public int product_id;
	public String product_name;
	public String product_type;
	public int price;
	public Date expiration_date;
	public String discount_type;
	public double discount_rate;	
	public String product_origin;
	public int stocks;
	public int gram;
	public String sales_type;
	public int cost;
	
	public RowInfo(int product_id, String product_name, String product_type, int price,Date expiration_date, String discount_type,
			double discount_rate, String product_origin, int stocks, int gram, String sales_type, int cost) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_type = product_type;
		this.price = price;
		this.expiration_date = expiration_date;
		this.discount_type = discount_type;
		this.discount_rate = discount_rate;
		this.product_origin = product_origin;
		this.stocks = stocks;
		this.gram = gram;
		this.sales_type = sales_type;
		this.cost = cost;
	}
}
