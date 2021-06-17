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
	public DeliveryConnectDB(String sql) {	
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
		
		
		try(
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
		){
			
			while(rs.next()) {
				 arr.add(new Object[]{
					rs.getInt("DELIVERY_ID"),
					rs.getString("MEMBERS_NAME"),
					rs.getInt("PAYMENT")
				 });
				 
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

}
