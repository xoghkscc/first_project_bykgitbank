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

public class EmployeeDeleteButton implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(RightPanel.getemployee_id().getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "삭제하려는 직원을 눌러주세요.");
		}else {
			int employee_id =Integer.parseInt(RightPanel.getemployee_id().getText().trim());
			HikariCP cp = new HikariCP();
			HikariDataSource ds = cp.getHikariDataSource();
			String sql = String.format("DELETE FROM employee WHERE employee_id = %d", employee_id);
			try (Connection conn = ds.getConnection(); 
					PreparedStatement pstmt = conn.prepareStatement(sql);) {
				pstmt.executeUpdate();
				ds.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int i=0;
			while(true) {
				int tableRow = Integer.parseInt((String) Employee_enrollment.getEmployeeTable().getValueAt(i, 0));
				if(tableRow ==  employee_id) {
					EmployeeTable.getEmployeeModel().removeRow(i);
					break;
				}
				i++;
			}
			JOptionPane.showMessageDialog(null, "삭제되었습니다.");
		}
	}

}
