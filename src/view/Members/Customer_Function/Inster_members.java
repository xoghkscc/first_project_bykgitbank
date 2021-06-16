package view.Members.Customer_Function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zaxxer.hikari.HikariDataSource;

import function.model.Member_Informations_DB;
import function.model.members_list_DB;
import hikariCP.HikariCP;

public class Inster_members  {
	
	HikariCP cp = new HikariCP();
	HikariDataSource ds = cp.getHikariDataSource();
	members_list_DB members_list_DB;
	
	public Inster_members(String name, String address, String phoneNumber) {
	
		
			String sql = "INSERT INTO member_informations VALUES(members_id_seq.nextval, ?, ?, ?, ?)  ";
			
			try (
					Connection conn = ds.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql);
			){
				int point = 0;
				
				pstmt.setString(1, name);
				pstmt.setString(2, address);
				pstmt.setString(3, phoneNumber);
				pstmt.setString(4, "" + point);
				
				
				pstmt.executeUpdate();
				
				ds.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
}
