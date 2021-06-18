package view.Delivery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

import hikariCP.HikariCP;

public class DeliveryCheck {
	
	HikariCP cp = new HikariCP();
	HikariDataSource ds = cp.getHikariDataSource();		
	
	public DeliveryCheck(String checkString) {
		
		String sql = "UPDATE delivery SET delivery_check = ? WHERE delivery_check = ? ";
		
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			
			String no = "N";
			
			pstmt.setString(1, checkString);
			pstmt.setString(2, no);
		
			
			pstmt.executeUpdate();
		
			ds.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
}
