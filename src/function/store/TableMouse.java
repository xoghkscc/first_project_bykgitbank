package function.store;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.swing.JTable;

import com.zaxxer.hikari.HikariDataSource;

import hikariCP.HikariCP;
import view.store.centerPanel.Employee_enrollment;
import view.store.centerPanel.RightPanel;

public class TableMouse extends MouseAdapter{
	private static int clickRow;
	public void mouseClicked(MouseEvent e) {
		DecimalFormat formatMoney = new DecimalFormat("###,###");
		clickRow = ((JTable) e.getSource()).getSelectedRow();
		int employee_id =Integer.parseInt((String) Employee_enrollment.getEmployeeTable().getValueAt(clickRow, 0));
		
		HikariCP cp = new HikariCP();
		HikariDataSource ds = cp.getHikariDataSource();
		
		String sql = "SELECT * FROM employee WHERE employee_id = "+employee_id;
		try(
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) {
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				RightPanel.getemployee_id().setText(""+rs.getInt(1));
				RightPanel.getemployeeName().setText(""+rs.getString(2));
				RightPanel.getemployeedJob_id().setSelectedItem(""+rs.getString(3));
				RightPanel.getemployeePhone_Number().setText(""+rs.getString(4));
				RightPanel.getemployeePositions().setSelectedItem(""+rs.getString(5));
				RightPanel.getemployeeDuty_hours().setText(""+rs.getInt(6));
				RightPanel.getemployeeEmail().setText(""+rs.getString(7));
				RightPanel.getemployeesalary().setText(""+rs.getInt(8));
				RightPanel.getMoneyemployeesalary().setText(formatMoney.format(rs.getInt(8)));
			}
			rs.close();
			ds.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	public static int getClickRow() {
		return clickRow;
	}
}