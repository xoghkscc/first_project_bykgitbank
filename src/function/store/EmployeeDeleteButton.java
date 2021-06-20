package function.store;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.zaxxer.hikari.HikariDataSource;

import function.model.Employee_DB;
import hikariCP.HikariCP;
import view.store.centerPanel.Employee_enrollment;
import view.store.centerPanel.RightPanel;
import view.store.leftMenu.LeftPanel;

public class EmployeeDeleteButton implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (RightPanel.getemployee_id().getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "삭제하려는 직원을 눌러주세요.");
		} else {
			int select_id = Employee_enrollment.getEmployeeTable().getSelectedRow();
			((DefaultTableModel) ((Employee_enrollment) LeftPanel.getEmployee_enrollment()).getEmployeeTable().getModel()).removeRow(select_id);
			int employee_id = Integer.parseInt(RightPanel.getemployee_id().getText().trim());
			HikariCP cp = new HikariCP();
			HikariDataSource ds = cp.getHikariDataSource();
			String sql = String.format("DELETE FROM employee WHERE employee_id = %d", employee_id);
			try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
				pstmt.executeUpdate();
				ds.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			JOptionPane.showMessageDialog(null, "삭제되었습니다.");
		}
	}

}
