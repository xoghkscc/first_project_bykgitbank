package view.Delivery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zaxxer.hikari.HikariDataSource;

import hikariCP.HikariCP;

public class DeliveryDatabase {
	private ArrayList<String> columnArr;
	String column;
	
	public DeliveryDatabase (String column) {
		// TODO Auto-generated constructor stub
		this.column = column;
		
		columnArr = new ArrayList<>();
		
		HikariDataSource ds = new HikariCP().getHikariDataSource();
		String sql = "SELECT DISTINCT " + column + " FROM DELIVERY WHERE " + column + " IS NOT NULL";
		
		try(
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
		){

			while(rs.next()) {
				columnArr.add(rs.getString(column));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<String> getColumnArr() {
		return columnArr;
	}
}
