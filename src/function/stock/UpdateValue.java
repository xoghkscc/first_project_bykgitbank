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
//		DISCOUNT_RATE = discount_rate;
		PRODUCT_ORIGIN = product_origin;
		STOCKS = stocks;
		GRAM = gram;
		SALES_TYPE = sales_type;
		COST = cost;
		
		
		
		if(PRODUCT_NAME.equals("")){
		}else {
			name = "(PRODUCT_NAME LIKE \'" + PRODUCT_NAME + "%\' OR PRODUCT_NAME LIKE \'" +PRODUCT_NAME+"\')";
			
//			WHERE(name LIKE '%한%' OR name LIKE '%은%')
		}
		
		if(PRODUCT_TYPE == null) {
		}else {
			productType = "(PRODUCT_TYPE = \'" + PRODUCT_TYPE + "%\' OR PRODUCT_TYPE LIKE \'" +PRODUCT_TYPE+ "\')";
		}
		
		if(PRODUCT_PRICE.equals("")) {
		}else {
			price = "PRODUCT_PRICE = " + PRODUCT_PRICE;
		}
		
		if(expiration_date == null) {
		}else {
			date = "expiration_date = \'" + expiration_date + "\'";
		}
		
		if(discount_type == null) {
		}else {
			discountType = "(discount_type LIKE \'" + discount_type + "%\' OR discount_type LIKE \'" + discount_type+ "\')";
		}
		
//		if(discount_rate == null) {
//			System.out.println("무야호6");	
//		}else {
//			discountRate = "discount_Rate = " + discountRate;
//		}
		
		if(PRODUCT_ORIGIN.equals("")){
			PRODUCT_ORIGIN = null;
		}else {
			origin = "(PRODUCT_ORIGIN LIKE \'" + PRODUCT_ORIGIN + "%\' OR PRODUCT_ORIGIN LIKE \'" +product_origin+"\')";
		}
		
		if(STOCKS !=null) {
			if(STOCKS.equals("") || STOCKS ==null) {
				stock = "SALES_TYPE = \'개수\'";
			}else {
				stock = "stock = " + stock;
			}
		}
		if(GRAM !=null) {
			if(GRAM.equals("")) {
				gram = "SALES_TYPE = \'무게\'";
			}else {
				gram = "gram = " + gram;
			}
		}
		if(COST.equals("")) {
			PRODUCT_PRICE = null;
		}else {
			cost = "COST = " + COST;
		}
	
//		System.out.println("name : " + name);
//		System.out.println("productType : " + productType);
//		System.out.println("price : " + price);
//		System.out.println("date : " + date);
//		System.out.println("discountType : " + discountType);
//		System.out.println("discountRate : " + discountRate);
//		System.out.println("origin : " + origin);
//		System.out.println("stock : " + stock);
//		System.out.println("gram : " + gram);
//		System.out.println("salesType : " + salesType);
//		System.out.println("cost : " + cost);
		
		ArrayList<String> arr = new ArrayList<>();
		arr.add(name); arr.add(productType);
		arr.add(price); arr.add(date);
		arr.add(discountType);
//		arr.add(discountRate);
		arr.add(origin); arr.add(stock);
		arr.add(gram); arr.add(salesType);
		arr.add(cost);
		
		String arrValues=null;
		int count = 0;
		for(int i = 0; i < arr.size(); i++) {
		
			if(arr.get(i) == null || arr.get(i).equals("")) {
				continue;
			}else {
				
				String a = arr.get(i);
				arr.remove(i);
				arr.add(i, " AND " + a);
				arrValues += arr.get(i);
				count++;
			}
		}
		
		System.out.println("카운트수 : " + count);
		if(count > 0) {

			System.out.println(arrValues);
			arrValues = arrValues.substring(8);
			completeSql = "SELECT * FROM PRODUCTS WHERE "
					+ arrValues + " ORDER BY PRODUCT_ID";
		}else {
			completeSql = "SELECT * FROM PRODUCTS ORDER BY PRODUCT_ID";
		}
		

//		System.out.println("comsql : " + completeSql);
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
				
				sentence = name + " LIKE \'" + thing + "%\' ";
			}

	
		}
		
	}

}