package function.payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;

import com.zaxxer.hikari.HikariDataSource;

import function.model.Member_Informations;
import hikariCP.HikariCP;


public class Customer_Search {
	
	JPanel costomer_name;
	JPanel costomer_point;
	
	public Customer_Search(int Customer_num) {
	
		
		
		HikariCP cp = new HikariCP();
		HikariDataSource ds = cp.getHikariDataSource();
		
		String sql = "SELECT * FROM member_informations WHERE members_id = ? ";
		
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			
			pstmt.setString(1, "" + Customer_num);
			
			ResultSet rs = pstmt.executeQuery();
			
		
			
			while (rs.next()) {
				
				Member_Informations member_informations = new Member_Informations();
				member_informations.setMEMBERS_ID(rs.getInt(1));
				member_informations.setMEMBERS_NAME(rs.getString(2));
				member_informations.setMEMBERS_ADDRESS(rs.getString(3));
				member_informations.setMEMBERS_PHONENUMBER(rs.getString(4));
				member_informations.setMEMBERS_POINT(rs.getInt(5));
				
			}	
			
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new Customer_Search(11);
	}
	
}
