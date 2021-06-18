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
		
		String sql = "SELECT * FROM sales "
				+ "Inner Join products USING(product_id) " 
				+ "WHERE (product_name LIKE \'"+ product_name +"%\' OR product_name = \'"+ product_name + "\') AND members_id = " + MemberSearchFrame.id ;
		
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int price = rs.getInt("product_price");
				int num = rs.getInt("NUMBER_OF_SALES");
				String[] data = {"" + rs.getDate("SALES_TIME"),"" + num, String.format("%d", price * num)};
				ProductReceipt.getModel().addRow(data);	
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
