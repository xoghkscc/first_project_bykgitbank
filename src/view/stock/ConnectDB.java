package view.stock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectDB {

	private Double resultRate;
	private int resultID;
	private ArrayList<Object[]> arr;
	public ConnectDB(String sql) {	
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

			if(sql.charAt(7) == 'D') {//select *
				
				while(rs.next()) {
	
					resultRate = rs.getDouble("DISCOUNT_RATE");
				}
			}else if(sql.charAt(7) == 'M'){
				while(rs.next()) {
	
					resultID = rs.getInt("PRODUCT_ID");
				}
			}else {
				if(sql.equals("SELECT * FROM PRODUCTS INNER JOIN (SELECT product_id,(product_price - COST) AS 순이익 FROM PRODUCTS) USING(product_id)")) {

					while(rs.next()) {		
						arr.add(new Object[]{rs.getInt("PRODUCT_ID"),
								rs.getString("PRODUCT_NAME"),
								rs.getString("PRODUCT_TYPE"),
								rs.getInt("PRODUCT_PRICE"),
								rs.getDate("EXPIRATION_DATE"),
								rs.getString("DISCOUNT_TYPE"),
								rs.getDouble("DISCOUNT_RATE"),
								rs.getString("PRODUCT_ORIGIN"),
								rs.getInt("STOCKS"),
								rs.getInt("GRAM"),
								rs.getString("SALES_TYPE"),
								rs.getInt("COST"),
								rs.getInt("순이익")
						});
					}
				}else {
					while(rs.next()) {		
						arr.add(new Object[]{rs.getInt("PRODUCT_ID"),
								rs.getString("PRODUCT_NAME"),
								rs.getString("PRODUCT_TYPE"),
								rs.getInt("PRODUCT_PRICE"),
								rs.getDate("EXPIRATION_DATE"),
								rs.getString("DISCOUNT_TYPE"),
								rs.getDouble("DISCOUNT_RATE"),
								rs.getString("PRODUCT_ORIGIN"),
								rs.getInt("STOCKS"),
								rs.getInt("GRAM"),
								rs.getString("SALES_TYPE"),
								rs.getInt("COST")
						});
					}
				}
			}
			rs.close();
			pstmt.close();
			conn.close();
			ds.close();	//커넥션풀을 꼭닫아주세요
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public Double getResultRate() {
		return resultRate;
	}
	public int getResultID() {
		return resultID;
	}
	public ArrayList<Object[]> getSelect(){
		return arr;
	}

}

