package function.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.zaxxer.hikari.HikariDataSource;

import function.model.Employee_DB;
import function.model.Login_DB;
import hikariCP.HikariCP;
import main.MainFramePrivilegeMode;

public class Check_Job_Id {
	
	HikariCP cp = new HikariCP();
	HikariDataSource ds = cp.getHikariDataSource();		
	private static Login_DB employee_DB;
	String data;
	JFrame jf;
	JFrame jf1;

	public Check_Job_Id(String manager_id, String manager_password, JFrame jf, JFrame jf1) {
		String sql = "SELECT job_id FROM employee WHERE login_id = ? AND login_password = ? ";
		int count = 0;
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			
			pstmt.setString(1, manager_id);
			pstmt.setString(2, manager_password);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				employee_DB = new Login_DB(rs.getString(1));	
				count++;
			}	
			
		
			if(count == 0) {
				JOptionPane.showMessageDialog(null, "아이디 혹은 비밀번호가 틀렸습니다");
				Privilege_Mode_Login.getMember_password().setText("");
			} else if(employee_DB.getJob_id().equals("manager") || employee_DB.getJob_id().equals("store-owner")) {			
				new MainFramePrivilegeMode(jf1);
				jf.setVisible(false);
				jf1.setVisible(false);
			};
			
			rs.close();
			ds.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Login_DB getEmployee_DB() {
		return employee_DB;
	}
	
	
	
}
