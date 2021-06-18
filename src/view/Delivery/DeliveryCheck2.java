package view.Delivery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

import hikariCP.HikariCP;

public class DeliveryCheck2 {
	
	HikariCP cp = new HikariCP();
	HikariDataSource ds = cp.getHikariDataSource();		
	
	public DeliveryCheck2(int yesOrNo) {
		
		String sql = "UPDATE delivery SET delivery_check = ? WHERE delivery_id = ? ";
		
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			
			String yes = "Y";
			
			pstmt.setString(1, yes);
			pstmt.setString(2, "" + yesOrNo);
		
			
			pstmt.executeUpdate();
		
			ds.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
}
