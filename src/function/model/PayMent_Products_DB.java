package function.model;

import java.util.Date;

public class PayMent_Products_DB extends Products_DB{

	public PayMent_Products_DB(int product_id, String product_name, String product_type, int product_price,
			Date expiration_date, String discount_type, double discount_rate, String pruduct_origin, int stocks,
			int gram, String sales_type) {
		super(product_id, product_name, product_type, product_price, expiration_date, discount_type, discount_rate,
				pruduct_origin, stocks, gram, sales_type);
		// TODO Auto-generated constructor stub
	}

}
