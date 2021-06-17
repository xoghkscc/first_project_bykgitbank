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

public class LookupTable extends JTable{
	String type;
	String sql;
	private static DefaultTableModel lookupModel;
	HikariCP cp = new HikariCP();
	HikariDataSource ds = cp.getHikariDataSource();
	public LookupTable(String type) {
		ArrayList<String> header = new ArrayList<String>(); 
		this.type = type;
		if(type.equals("date")) {
			header.add("날짜");
			header.add("총 금액");
			header.add("총 원가");
			header.add("순수익");
			sql = "SELECT * FROM sales_date";
		}else if(type.equals("product")) {
			header.add("물건번호");
			header.add("물건이름");
			header.add("개수 및 무게");
			header.add("총 금액");
			header.add("총 원가");
			header.add("순수익");
			sql = "SELECT * FROM products_date";
		}else if(type.equals("member")) {
			header.add("회원번호");
			header.add("회원이름");
			header.add("총 금액");
			header.add("총 원가");
			header.add("순수익");
			sql = "SELECT * FROM members_date";
		}
		String[] headerArr = new String[header.size()];
		header.toArray(headerArr);
		
		lookupModel = (DefaultTableModel) this.getModel();
		setFont(new Font("맑은 고딕", Font.BOLD, 12));
		getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lookupModel.setColumnIdentifiers(headerArr);
		try(
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				if(type.equals("date")) {
					String[] data = { "" + rs.getDate(1), "" + rs.getInt(2), "" + rs.getInt(3), "" + rs.getInt(4)};
					lookupModel.addRow(data);
				}else if(type.equals("product")) {
					String[] data = { "" + rs.getInt(1), "" + rs.getString(2), "" + rs.getInt(3), "" + rs.getInt(4), "" + rs.getInt(5), "" + rs.getInt(6) };
					lookupModel.addRow(data);
				}else if(type.equals("member")) {
					String[] data = { "" + rs.getInt(1), "" + rs.getString(2),  "" + rs.getInt(4), "" + rs.getInt(5), "" + rs.getInt(6)  };
					//뷰에는 개수가 있으니 사실 회원별로 개수가 의미 없어서 뺏음
					lookupModel.addRow(data);
				}
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static DefaultTableModel getLookupModel() {
		return lookupModel;
	}
	
}
