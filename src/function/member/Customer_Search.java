package function.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.zaxxer.hikari.HikariDataSource;

import function.model.Member_Informations_DB;
import hikariCP.HikariCP;
import view.Members.MemberSearchFrame;


public class Customer_Search {
	
	private static Member_Informations_DB member_informations_DB;
	ArrayList<Member_Informations_DB> Member_Informations_DB_list;
	HikariCP cp = new HikariCP();
	HikariDataSource ds = cp.getHikariDataSource();
	
	public Customer_Search() {
		
		String sql = "SELECT * FROM member_informations ";
		
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		){
		
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
