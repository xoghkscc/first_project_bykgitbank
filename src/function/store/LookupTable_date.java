package function.store;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.zaxxer.hikari.HikariDataSource;

import hikariCP.HikariCP;

public class LookupTable_date extends JTable{
	String type;
	String sql;
	private static DefaultTableModel lookupDateModel;
	HikariCP cp = new HikariCP();
	HikariDataSource ds = cp.getHikariDataSource();
	public LookupTable_date() {
		ArrayList<String> header = new ArrayList<String>(); 
		this.type = type;
			header.add("날짜");
			header.add("총 금액");
			header.add("총 원가");
			header.add("순수익");
			sql = "SELECT * FROM sales_date ORDER BY \"순수익\" DESC";
		String[] headerArr = new String[header.size()];
		header.toArray(headerArr);
		
		lookupDateModel = (DefaultTableModel) this.getModel();
		setFont(new Font("맑은 고딕", Font.BOLD, 12));
		getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lookupDateModel.setColumnIdentifiers(headerArr);
		try(
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
					String[] data = { "" + rs.getDate(1), "" + rs.getInt(2), "" + rs.getInt(3), "" + rs.getInt(4)};
					lookupDateModel.addRow(data);
			}
			rs.close();
			pstmt.close();
			ds.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static DefaultTableModel getLookupDateModel() {
		return lookupDateModel;
	}
	
}
