package function.stock;

import java.util.ArrayList;

public class UpdateValue {

//	PRODUCT_ID, PRODUCT_NAME, PRODUCT_TYPE, PRODUCT_PRICE, EXPIRATION_DATE, DISCOUNT_TYPE, DISCOUNT_RATE, PRODUCT_ORIGIN, STOCKS, GRAM, SALES_TYPE, COST          
	
	int PRODUCT_ID;
    String PRODUCT_NAME;
    String PRODUCT_TYPE;
    String PRODUCT_PRICE;
    String EXPIRATION_DATE;
    String DISCOUNT_TYPE;
    Double DISCOUNT_RATE;
    String PRODUCT_ORIGIN;
    String STOCKS;
    String GRAM;
    String SALES_TYPE;
    String COST;
    
	String id;
	String name;
	String productType;
	String price;
	String date;
	String discountType;
	String discountRate;
	String origin;
	String stock;
	String gram;
	String salesType;
	String cost;

	public String completeSql;
	
	public UpdateValue(int product_id, String product_name, String product_type, String product_price,
			String expiration_date, String discount_type, Double discount_rate, String product_origin, String stocks,
			String gram, String sales_type, String cost) {
		super();
		PRODUCT_ID = product_id;
		PRODUCT_NAME = product_name;
		PRODUCT_TYPE = product_type;
		PRODUCT_PRICE = product_price;
		EXPIRATION_DATE = expiration_date;
		DISCOUNT_TYPE = discount_type;
		DISCOUNT_RATE = discount_rate;
		PRODUCT_ORIGIN = product_origin;
		STOCKS = stocks;
		GRAM = gram;
		SALES_TYPE = sales_type;
		COST = cost;
		
		/*
		SELECT PRODUCTS SET WHERE PRODUCT_ID = 108,PRODUCT_NAME = '치토스',
								PRODUCT_TYPE = 'null',PRODUCT_PRICE = 1111,
								EXPIRATION_DATE = 'null',DISCOUNT_TYPE = 'null',
								DISCOUNT_RATE = null,PRODUCT_ORIGIN = '미국',
								STOCKS = null,GRAM = 21,SALES_TYPE = '무게',COST = 2222
		*/
//		new NullCheck(PRODUCT_NAME);
//		price = ", PRODUCT_PRICE = " + PRODUCT_PRICE;
//		date = ", EXPIRATION_DATE = \'" + EXPIRATION_DATE + "\'";
//		discountType = ", DISCOUNT_TYPE = \'" + DISCOUNT_TYPE + "\'";
//		discountRate = ", DISCOUNT_RATE = " + DISCOUNT_RATE + "";
//		origin = ", PRODUCT_ORIGIN = \'" + PRODUCT_ORIGIN + "\'";
//		stock = ", STOCKS = " + STOCKS;
//		gram = ", GRAM = " + GRAM;
//		salesType = ", SALES_TYPE = \'" + SALES_TYPE + "\'";
//		cost = ", COST = " + COST;
		if(PRODUCT_ORIGIN.equals("")){
			PRODUCT_ORIGIN = null;
		}
	
		name =	new NullCheck((String)PRODUCT_NAME, "PRODUCT_NAME").sentence;
		productType = new NullCheck((String)PRODUCT_TYPE, "PRODUCT_TYPE").sentence;
		price = new NullCheck(PRODUCT_PRICE, "PRODUCT_PRICE").sentence;
		date = new NullCheck((String)EXPIRATION_DATE, "EXPIRATION_DATE").sentence;
		discountType = new NullCheck((String)DISCOUNT_TYPE, "DISCOUNT_TYPE").sentence;
		if(DISCOUNT_RATE == null) {
			discountRate = null;
		}else{
			
			discountRate = new NullCheck((double)DISCOUNT_RATE, "DISCOUNT_RATE").sentence;
		}
		origin = new NullCheck((String)PRODUCT_ORIGIN, "PRODUCT_ORIGIN").sentence;
		stock = new NullCheck((String)STOCKS, "STOCKS").sentence;
		gram = new NullCheck((String)GRAM, "GRAM").sentence;
		salesType = new NullCheck((String)SALES_TYPE, "SALES_TYPE").sentence;
		cost = new NullCheck((String)COST, "COST").sentence;
	
		System.out.println("name : " + name);
		System.out.println("productType : " + productType);
		System.out.println("price : " + price);
		System.out.println("date : " + date);
		System.out.println("discountType : " + discountType);
		System.out.println("discountRate : " + discountRate);
		System.out.println("origin : " + origin);
		System.out.println("stock : " + stock);
		System.out.println("gram : " + gram);
		System.out.println("salesType : " + salesType);
		System.out.println("cost : " + cost);
		
		ArrayList<String> arr = new ArrayList<>();
		arr.add(name); arr.add(productType);
		arr.add(price); arr.add(date);
		arr.add(discountType); arr.add(discountRate);
		arr.add(origin); arr.add(stock);
		arr.add(gram); arr.add(salesType);
		arr.add(cost);
		for(int i = 0; i < arr.size(); i++) {
		
				String a = arr.get(i);
				arr.remove(i);
				arr.add(i, "AND " + a);
			
		}
		String arrValues = arr.get(0) 
						+ arr.get(1)
						+ arr.get(2)
						+ arr.get(3)
						+ arr.get(4)
						+ arr.get(5)
						+ arr.get(6)
						+ arr.get(7)
						+ arr.get(8)
						+ arr.get(9)
						+ arr.get(10);
		arrValues = arrValues.substring(4);
		
		completeSql = "SELECT * FROM PRODUCTS WHERE "
				+ arrValues;
		
		System.out.println("comsql : " + completeSql);
//		completeSql = "SELECT PRODUCTS SET WHERE "
//				+ name
//				+ productType
//				+ price
//				+ date
//				+ discountType
//				+ discountRate
//				+ origin
//				+ stock
//				+ gram
//				+ salesType
//				+ cost;
		
	}

}

class NullCheck{
	
	String sentence;
	Object thing;
	String name;
	int thingInt;
	double thingDouble;
	public NullCheck(String thing, String name) {
		// TODO Auto-generated constructor stub
		this.thing = thing;
		this.name = name;
		if(thing == null) {
			sentence = null;
		}else{
			if(name.equals("PRODUCT_PRICE") || name.equals("DISCOUNT_RATE") || name.equals("STOCKS") || name.equals("GRAM") || name.equals("COST")) {
				sentence = name + " = " + thing;
			}else {
				
				sentence = name + " = \'" + thing + "\'";
			}

	
		}
		
	}
	public NullCheck(int thingInt, String name) {
		// TODO Auto-generated constructor stub
		this.thingInt = thingInt;
		this.name = name;
		if(thingInt == 0) {
			sentence = null;
		}else{
//				/	name = "PRODUCT_NAME = \'" +PRODUCT_NAME + "\'";
			sentence = name + " = " + thingInt +" ";
		}
	}
	
	public NullCheck(double thingDouble, String name) {
		// TODO Auto-generated constructor stub
		this.thingDouble = thingDouble;
		this.name = name;
		if(thingDouble == 0) {
			sentence = null;
		}else{
//				/	name = "PRODUCT_NAME = \'" +PRODUCT_NAME + "\'";
			sentence = name + " = \'" + thingDouble + "\' ";
		}
	}
}