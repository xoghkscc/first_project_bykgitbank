package function.store;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.zaxxer.hikari.HikariDataSource;

import hikariCP.HikariCP;
import view.store.centerPanel.StoreLookup;

public class RightTable_dateAddRow extends JTable{
	String sql;
	HikariCP cp = new HikariCP();
	HikariDataSource ds = cp.getHikariDataSource();
	public RightTable_dateAddRow(Date date) {
		java.sql.Date date2 = new java.sql.Date(date.getTime());
		sql = "SELECT product_id, product_name, number_of_sales FROM " + 
				"sales INNER JOIN products USING ( product_id ) WHERE " + 
				"to_date(sales_time, 'yy/mm/dd') = to_date('"+date2+"', 'yy/mm/dd')";
		try(
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
					String[] data = { "" + rs.getInt(1), "" + rs.getString(2), "" + rs.getInt(3)};
					((DefaultTableModel) RightPane_date.getlookupRightTable().getModel()).addRow(data);
			}
			rs.close();
			ds.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
