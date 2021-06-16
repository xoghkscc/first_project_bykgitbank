package hikariCP;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;


public class hikariTest {
	public static void main(String[] args) {
		HikariCP cp = new HikariCP();
		HikariDataSource ds = cp.getHikariDataSource();
		String sql = "SELECT * FROM employees";
		try(
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
		){
			
			while(rs.next()) {
				System.out.print(rs.getInt(1)+"+");
				System.out.print(rs.getString(2)+"+");
				System.out.print(rs.getString(3));
				System.out.println();
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	
	
	
	
	
	
	
	
}
