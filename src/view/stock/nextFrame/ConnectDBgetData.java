package view.stock.nextFrame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.zaxxer.hikari.HikariDataSource;

import hikariCP.HikariCP;

public class ConnectDBgetData {

	private ArrayList<String> columnArr;
	String column;
	String update;
	
	public ConnectDBgetData(String column, String update) {
		// TODO Auto-generated constructor stub
		this.column = column;
		this.update = update;
		columnArr = new ArrayList<>();
		
		HikariDataSource ds = new HikariCP().getHikariDataSource();
		String sql = "SELECT DISTINCT " + column + " FROM PRODUCTS WHERE " + column + " IS NOT NULL";
		try(
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
		){
//			pstmt.setString(1, column);

			while(rs.next()) {
				columnArr.add(rs.getString(column));
			}
			rs.close();
			pstmt.close();
			conn.close();
			ds.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<String> getColumnArr() {
		return columnArr;
	}
	
}
