package view.Members.Customer_Function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

import hikariCP.HikariCP;
import view.Members.MemberSearchFrame;

public class Receipt {
	
	HikariCP cp = new HikariCP();
	HikariDataSource ds = cp.getHikariDataSource();
	
	public Receipt(int member_id) {
		
		String sql = "SELECT * FROM sales_simple Inner Join member_informations USING(members_id) WHERE member_id = ? ";
		
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			pstmt.setString(1, "%" + member_id);
			ResultSet rs = pstmt.executeQuery();
			
		
			
			while (rs.next()) {
			
				String[] data = {"" + rs.getDate(4), rs.getString(6)};
				MemberSearchFrame.getModel().addRow(data);	
			}	
			
			rs.close();
			ds.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}
}
