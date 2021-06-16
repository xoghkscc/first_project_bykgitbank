package view.Members.Customer_Function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

import hikariCP.HikariCP;

public class Update {
	
	HikariCP cp = new HikariCP();
	HikariDataSource ds = cp.getHikariDataSource();
	
	public Update(int member_id, String member_name, String member_address, 
			String member_phoneNumber) {

			String sql = "UPDATE member_informations SET  members_name = ?, members_address = ?,"
					+ " members_phonenumber = ? WHERE members_id = ? ";

	try (
		Connection conn = ds.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
	){
	
	pstmt.setString(1, member_name);
	pstmt.setString(2, member_address);
	pstmt.setString(3, member_phoneNumber);
	pstmt.setString(4, "" + member_id);
	
	pstmt.executeUpdate();
	
	ds.close();
	} catch (SQLException e) {
	e.printStackTrace();
	}
	}
}
