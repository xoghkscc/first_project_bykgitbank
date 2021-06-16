package view.Members.Customer_Function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

import hikariCP.HikariCP;
import view.Members.MemberSearchFrame;
import view.Members.ProductReceipt;

public class ProductReceiptFun {
	
	HikariCP cp = new HikariCP();
	HikariDataSource ds = cp.getHikariDataSource();
	
	public ProductReceiptFun(String product_name) {
		
		String sql = "SELECT * FROM sales_simple "
				+ "Inner Join sales USING(members_id) "
				+ "Inner Join products USING(product_id) " 
				+ "WHERE product_name LIKE \'"+ product_name +"%\' AND members_id = " + MemberSearchFrame.id;
		
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			ResultSet rs = pstmt.executeQuery();
			
			System.out.println(sql);
			while (rs.next()) {
				String[] data = {"" + rs.getDate("SALES_TIME"), String.format("%d", rs.getInt("결제 금액"))};
				ProductReceipt.getModel().addRow(data);	
			}	
			
			rs.close();
			ds.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}
}
