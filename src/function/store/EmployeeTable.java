package function.store;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.zaxxer.hikari.HikariDataSource;

import function.model.Employee_DB;
import hikariCP.HikariCP;

public class EmployeeTable extends JTable{
	private static DefaultTableModel employeeModel;
	HikariCP cp = new HikariCP();
	HikariDataSource ds = cp.getHikariDataSource();
	String[] header = { "사번", "이름", "직책"};
	

	public EmployeeTable() {
		setBorder(BorderFactory.createEmptyBorder(300, 20, 10, 40));
		employeeModel = (DefaultTableModel) this.getModel();
		setFont(new Font("맑은 고딕", Font.BOLD, 12));
		getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD, 16));
//		getTableHeader().setBackground(new Color(218, 222, 227));
		employeeModel.setColumnIdentifiers(header);
		String sql = "SELECT *  FROM employee order by employee_id";

		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String[] data = { "" + rs.getInt(1), "" + rs.getString(2), "" + rs.getString(3) };
				employeeModel.addRow(data);
			}
			rs.close();
			ds.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static DefaultTableModel getEmployeeModel() {
		return employeeModel;
	}
}
