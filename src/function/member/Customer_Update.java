package function.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

import hikariCP.HikariCP;

public class Customer_Update {
	
	HikariCP cp = new HikariCP();
	HikariDataSource ds = cp.getHikariDataSource();		

	public Customer_Update(int member_id, String member_name, String member_address, 
						String member_phoneNumber, int member_point) {
		
		String sql = "UPDATE member_informations SET members_name = ?, members_address = ?,"
				+ " members_phonenumber = ?, members_point = ? WHERE members_id = ? ";
		
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			
			
			pstmt.setString(1, member_name);
			pstmt.setString(2, member_address);
			pstmt.setString(3, member_phoneNumber);
			pstmt.setString(4, "" + member_point);
			pstmt.setString(5, "" + member_id);
			
			pstmt.executeUpdate();
		
			ds.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
