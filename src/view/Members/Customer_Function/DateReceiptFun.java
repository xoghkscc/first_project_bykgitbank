package view.Members.Customer_Function;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

import hikariCP.HikariCP;
import view.Members.DateReceipt;
import view.Members.MemberSearchFrame;
import view.Members.ProductReceipt;

public class DateReceiptFun {
	
	HikariCP cp = new HikariCP();
	HikariDataSource ds = cp.getHikariDataSource();
	
	public DateReceiptFun(String sales_time) {
		

		String sql = "SELECT * FROM sales "
				+ "Inner Join products USING(product_id) " 
				+ "WHERE sales_time LIKE \'"+ sales_time + "\' AND members_id = " + MemberSearchFrame.id ;
			
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int price = rs.getInt("product_price");
				int num = rs.getInt("NUMBER_OF_SALES");
				String[] data = {"" + rs.getString("product_name"),"" + num, String.format("%d", price * num)};
				DateReceipt.getModel().addRow(data);	
			}	
			
			rs.close();
			pstmt.close();
			conn.close();
			ds.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}
}
