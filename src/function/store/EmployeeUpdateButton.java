package function.store;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import com.zaxxer.hikari.HikariDataSource;

import function.model.Employee_DB;
import hikariCP.HikariCP;
import view.store.centerPanel.Employee_enrollment;
import view.store.centerPanel.RightPanel;
import view.store.leftMenu.LeftPanel;

public class EmployeeUpdateButton implements ActionListener{
	int employee_id;
	public void actionPerformed(ActionEvent e) {
			employee_id =Integer.parseInt(RightPanel.getemployee_id().getText().trim());
			HikariCP cp = new HikariCP();
			HikariDataSource ds = cp.getHikariDataSource();
			
			String sql = String.format("UPDATE employee SET employee_name='%s', job_id='%s', phone_number='%s', positions='%s', duty_hours=%d, email='%s', salary=%d"
					+ "WHERE employee_id = %d",
					RightPanel.getemployeeName().getText().trim(), 
					RightPanel.getemployeedJob_id().getSelectedItem().toString().trim(),
					RightPanel.getemployeePhone_Number().getText().trim(), 
					RightPanel.getemployeePositions().getSelectedItem().toString().trim(),
					Integer.parseInt(RightPanel.getemployeeDuty_hours().getText().trim()), 
					RightPanel.getemployeeEmail().getText().trim(), 
					Integer.parseInt(RightPanel.getemployeesalary().getText().trim()), 
					employee_id);
			try (Connection conn = ds.getConnection(); 
					PreparedStatement pstmt = conn.prepareStatement(sql);) {
				pstmt.executeUpdate();
				ds.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			Employee_enrollment.getEmployeeTable().setValueAt((String) RightPanel.getemployeeName().getText().trim(),
					TableMouse.getClickRow(), 1);
			Employee_enrollment.getEmployeeTable().setValueAt((String) RightPanel.getemployeedJob_id().getSelectedItem().toString().trim(),
					TableMouse.getClickRow(), 2);
			
			RightPanel.getemployee_id().setText("");
			RightPanel.getemployeeName().setText("");
			RightPanel.getemployeedJob_id().setSelectedIndex(0);
			RightPanel.getemployeePhone_Number().setText("");
			RightPanel.getemployeePositions().setSelectedIndex(0);
			RightPanel.getemployeeDuty_hours().setText("");
			RightPanel.getemployeeEmail().setText("");
			RightPanel.getemployeesalary().setText("");
			RightPanel.getMoneyemployeesalary().setText("");
			JOptionPane.showMessageDialog(null, "수정되었습니다.");
	}
	

}
	
	
	
	
	
