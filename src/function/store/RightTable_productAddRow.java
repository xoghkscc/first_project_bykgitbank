package function.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import com.zaxxer.hikari.HikariDataSource;

import hikariCP.HikariCP;

public class RightTable_productAddRow {
	String sql;
	HikariCP cp = new HikariCP();
	HikariDataSource ds = cp.getHikariDataSource();
	public RightTable_productAddRow(int product_id) {
		sql = "SELECT sales_time, number_of_sales FROM sales WHERE product_id = "+product_id;
		try(
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
					String[] data = { "" + rs.getDate(1), "" + rs.getInt(2)};
					((DefaultTableModel) RightPane_product.getlookupRightTable().getModel()).addRow(data);
			}
			rs.close();
			ds.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
