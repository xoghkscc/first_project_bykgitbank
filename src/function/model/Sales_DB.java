package function.model;

import java.util.Date;

public class Sales_DB {
	private int sales_id;
	private int members_id;
	private Date sales_time;
	private	String payment_type;
	private char refund;
	private int delivery_id;
	private int product_id;
	private int number_of_sales;
	private int sales_num;
	private int point_score;
	
	
	public Sales_DB(int sales_id,int members_id, Date sales_time, String payment_type, char refund,
			int delivery_id, int product_id, int number_of_sales,int sales_num,int point_score  ) {
		this.sales_id = sales_id;
		this.members_id = members_id;
		this.sales_time = sales_time;
		this.payment_type = payment_type;
		this.refund = refund;
		this.delivery_id = delivery_id;
		this.product_id = product_id;
		this.number_of_sales = number_of_sales;
		this.sales_num = sales_num;
		this.point_score = point_score;
		
	}
	public int getSales_id() {
		return sales_id;
	}
	public int getMembers_id() {
		return members_id;
	}
	public Date getSales_time() {
		return sales_time;
	}
	public String getPayment_type() {
		return payment_type;
	}
	public char getRefund() {
		return refund;
	}
	public int getDelivery_id() {
		return delivery_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public int getNumber_of_sales() {
		return number_of_sales;
	}
	public int getSales_num() {
		return sales_num;
	}
	public int getPoint_score() {
		return point_score;
	}
	
}
