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

public class LookupTable_product extends JTable{
	String sql;
	private static DefaultTableModel lookupProductModel;
	HikariCP cp = new HikariCP();
	HikariDataSource ds = cp.getHikariDataSource();
	public LookupTable_product() {
		ArrayList<String> header = new ArrayList<String>(); 
			header.add("물건번호");
			header.add("물건이름");
			header.add("개수 및 무게");
			header.add("총 금액");
			header.add("총 원가");
			header.add("순수익");
			sql = "SELECT * FROM products_date";
		String[] headerArr = new String[header.size()];
		header.toArray(headerArr);
		
		lookupProductModel = (DefaultTableModel) this.getModel();
		setFont(new Font("맑은 고딕", Font.BOLD, 12));
		getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lookupProductModel.setColumnIdentifiers(headerArr);
		try(
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
					String[] data = { "" + rs.getInt(1), "" + rs.getString(2), "" + rs.getInt(3), "" + rs.getInt(4), "" + rs.getInt(5), "" + rs.getInt(6) };
					lookupProductModel.addRow(data);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static DefaultTableModel getLookupProductModel() {
		return lookupProductModel;
	}
	
}
