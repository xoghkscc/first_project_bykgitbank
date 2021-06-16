package view.Members.Customer_Function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.zaxxer.hikari.HikariDataSource;

import hikariCP.HikariCP;
import view.Members.MemberSearchFrame;

public class CustomerSearch {

	HikariCP cp = new HikariCP();
	HikariDataSource ds = cp.getHikariDataSource();
	
	public CustomerSearch(int CustomerNumber) {
		
String sql = "SELECT * FROM member_informations WHERE members_phonenumber LIKE ? ";
		
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			pstmt.setString(1, "%" + CustomerNumber);
			ResultSet rs = pstmt.executeQuery();
			
		
			
			while (rs.next()) {
			
				String[] data = {"" + rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), 
								"" + rs.getInt(5)};
				MemberSearchFrame.getModel().addRow(data);
				
				
			}	
			
			rs.close();
			ds.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
