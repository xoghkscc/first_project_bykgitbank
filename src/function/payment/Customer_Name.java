package function.payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import function.model.Member_Informations;
import hikariCP.HikariCP;

public class Customer_Name {
	

	public Customer_Name(int Customer_num) {
	
		HikariConfig config = new HikariConfig();
		
		HikariCP cp = new HikariCP();
		HikariDataSource ds = cp.getHikariDataSource();
		
		String sql = "SELECT * FROM member_informations WHERE members_id LIKE ? ";
		
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			
			pstmt.setString(1, "%" + Customer_num + "%");
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				Member_Informations member_informations = new Member_Informations();
	
				member_informations.setMEMBERS_NAME(rs.getString(2));
	
				System.out.print(member_informations.getMEMBERS_NAME());
			
			}	
			
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Customer_Name(11);
	}
	
}
