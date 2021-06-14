package function.payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

import hikariCP.HikariCP;

public class Products_update {
	HikariCP cp2 = new HikariCP();
	HikariDataSource ds2 = cp2.getHikariDataSource();
	
	public Products_update(int product_id, int stocksOrGram ) {
		//이걸로 재고를 빼거나 추가할 수 있음
		//추가할 때는 stocksOrGram가 마이너스면 됨
		String sales_type= null;
		String sales_type_check = String.format("SELECT sales_type FROM products WHERE product_id = %d",product_id);
		
		try (
				Connection conn = ds2.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sales_type_check);
				){
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				sales_type = rs.getString(1);//sales_type이 product_id에 대한 sales_type을 판단
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String update_product = null; 
		if(sales_type.equals("무게")) {
			update_product = String.format("UPDATE PRODUCTS SET gram = gram - (%d) WHERE product_id = %d ", 
				stocksOrGram, product_id);
		} else {
			update_product = String.format("UPDATE PRODUCTS SET stocks = stocks - (%d) WHERE product_id = %d ", 
					stocksOrGram, product_id);
		}
		
		try (
				Connection conn = ds2.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(update_product);
				){
			
			pstmt.executeUpdate();
			
			ds2.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
}
