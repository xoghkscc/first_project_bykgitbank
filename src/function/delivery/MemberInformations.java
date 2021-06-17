package function.delivery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

import function.model.DeliveryDB;
import hikariCP.HikariCP;


public class MemberInformations {
	
	private static DeliveryDB ddb;
	HikariCP cp = new HikariCP();
	HikariDataSource ds = cp.getHikariDataSource();
	
	public MemberInformations(int Customer_num) {
		
	
		String sql = "SELECT * FROM DELIVERYMEMBERS WHERE members_id = ? ";
		
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			pstmt.setString(1, "" + Customer_num);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				ddb = new DeliveryDB(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			}	
			
			rs.close();
			ds.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static DeliveryDB getDdb() {
		return ddb;
	}
}
