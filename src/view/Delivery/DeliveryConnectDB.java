package view.Delivery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DeliveryConnectDB {


	private String result;
	private ArrayList<Object[]> arr;
	private ArrayList<String> arr2;
	String check;
	
	public DeliveryConnectDB(String sql, String check) {	
		this.check = check;
		// TODO Auto-generated constructor stub
		HikariConfig config = new HikariConfig();
		
		config.setJdbcUrl("jdbc:oracle:thin:@3.35.52.40:1521");
		config.setUsername("first_project");
		config.setPassword("1234");
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

		HikariDataSource ds = new HikariDataSource(config);

		arr = new ArrayList<Object[]>();
		arr2 = new ArrayList<>();
//		select DISTINCT DELIVERY_ID, MEMBERS_NAME, MEMBERS_PHONENUMBER, TO_DATE(SALES_TIME, 'YY/MM/DD') as Sales_time from delivery 
//		INNER JOIN member_informations USING(members_id) 
//		LEFT OUTER JOIN SALES USING(DELIVERY_ID);
		
		try(
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
		){
			
			if (check == null) {
				
				while(rs.next()) {
					arr.add(new Object[]{
							rs.getInt("DELIVERY_ID"),
							rs.getString("MEMBERS_NAME"),
							rs.getInt("PAYMENT"),
							rs.getDate("SALES_TIME")
					});
					
				}
			} else {
				while(rs.next()) {
					arr2.add(rs.getString("MEMBERS_ADDRESS"));
					arr2.add(rs.getString("MEMBERS_PHONENUMBER"));
					};
				}
	
			rs.close();
			pstmt.close();
			conn.close();
			ds.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public String getResult() {
		return result;
	}
	
	public ArrayList<Object[]> getSelect(){
		return arr;
	}

	public ArrayList<Object[]> getArr() {
		return arr;
	}

	public ArrayList<String> getArr2() {
		return arr2;
	}

	public String getCheck() {
		return check;
	}

}
