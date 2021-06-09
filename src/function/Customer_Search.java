package function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.zaxxer.hikari.HikariDataSource;

import hikariCP.HikariCP;


public class Customer_Search {
	
	Member_Informations_DB member_informations_DB;
	ArrayList<Member_Informations_DB> Member_Informations_DB_list;
	HikariCP cp = new HikariCP();
	HikariDataSource ds = cp.getHikariDataSource();
	
	public Customer_Search(int Customer_num) {
		
	
		String sql = "SELECT * FROM member_informations WHERE members_id = ? ";
		
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			pstmt.setString(1, "" + Customer_num);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
			
				member_informations_DB = new Member_Informations_DB(rs.getInt(1), rs.getString(2),
												rs.getString(3), rs.getString(4), rs.getInt(5));
				
			}	
			
			rs.close();
			ds.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public Customer_Search() {
		Member_Informations_DB_list = new ArrayList<Member_Informations_DB>();
		String sql = "SELECT * FROM member_informations ";
		
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Member_Informations_DB_list.add(new Member_Informations_DB(rs.getInt(1), rs.getString(2), 
														rs.getString(3), rs.getString(4), rs.getInt(5)));
				
			}	
			
			rs.close();
			ds.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

	public Member_Informations_DB getMember_Informations_DB() {
		return member_informations_DB;
	}
	public ArrayList<Member_Informations_DB> getMember_Informations_DB_list() {
		return Member_Informations_DB_list;
	}
}
