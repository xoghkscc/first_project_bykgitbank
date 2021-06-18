package view.Delivery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

import hikariCP.HikariCP;

public class DeliveryCheck {
	
	HikariCP cp = new HikariCP();
	HikariDataSource ds = cp.getHikariDataSource();		
	
	public DeliveryCheck(int checkString) {
		
		String sql = "UPDATE delivery SET delivery_check = ? WHERE delivery_id = ? ";
		
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			
			String no = "N";
			
			pstmt.setString(1, no);
			pstmt.setString(2, "" + checkString);
		
			
			pstmt.executeUpdate();
		
			ds.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
}
