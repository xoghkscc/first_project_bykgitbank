package function.store;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.zaxxer.hikari.HikariDataSource;

import function.model.Employee_DB;
import function.store.*;
import hikariCP.HikariCP;
import view.store.RoundButtonStore;
import view.store.centerPanel.Employee_enrollment;
import view.store.centerPanel.RightPanel;

public class EmployeeCreateFPanel extends JPanel{
	private static JTextField employee_id;
	private static JTextField employeeName;
	private static JComboBox<String> employeedJob_id;
	private static JTextField employeePhone_Number;
	private static JComboBox<String> employeePositions;
	private static JTextField employeeDuty_hours;
	private static JTextField employeeEmail;
	private static JTextField employeesalary;
	private static JTextField moneyemployeesalary;
	private static JButton saveBtn;
	DefaultListCellRenderer listRenderer;
	public EmployeeCreateFPanel(JFrame createJf) {
		listRenderer = new DefaultListCellRenderer();
		listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
		setBackground(new Color(43, 51, 62));
		setPreferredSize(new Dimension(210, 700));
		setBorder(BorderFactory.createEmptyBorder(10, 90, 10, 90));
		employee_id = new RightJText();
		JLabel name = new EmployeeLabel("이름");
		employeeName = new RightJText();
		JLabel label2 = new EmployeeLabel("직책");
		employeedJob_id = new JComboBox<String>(new String[] {"", "store-owner", "manager", "distribution", "cashier"}); 
		employeedJob_id.setBackground(Color.WHITE);
		employeedJob_id.setPreferredSize(new Dimension(200, 40));
		employeedJob_id.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		employeedJob_id.setRenderer(listRenderer);
		
		JLabel label3 = new EmployeeLabel("연락처");
		employeePhone_Number = new RightJText();
		JLabel label4 = new EmployeeLabel("근무형태");
		employeePositions = new JComboBox<String>(new String[] {"", "full-time", "part-time"}); 
		employeePositions.setBackground(Color.WHITE);
		employeePositions.setPreferredSize(new Dimension(200, 40));
		employeePositions.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		employeePositions.setRenderer(listRenderer);
		
		JLabel label5 = new EmployeeLabel("근무시간");
		employeeDuty_hours = new RightJText();
		JLabel label6 = new EmployeeLabel("이메일");
		employeeEmail = new RightJText();
		JLabel label7 = new EmployeeLabel("월급");
		employeesalary = new RightJText();
		moneyemployeesalary = new RightJText();

		saveBtn = new RoundButtonStore("저장하기");
		saveBtn.addActionListener(new EmployeeInsertButton(createJf));
		
		
		
		JPanel emptyPanel = new JPanel();
		emptyPanel.setPreferredSize(new Dimension(300, 40));
		
		add(name);
		add(employeeName);
		add(label2);
		add(employeedJob_id);
		add(label3);
		add(employeePhone_Number);
		add(label4);
		add(employeePositions);
		add(label5);
		add(employeeDuty_hours);
		add(label6);
		add(employeeEmail);
		add(label7);
		add(moneyemployeesalary);
		add(saveBtn);
		
		setVisible(true);
	}
	
	public static void setsaveBtn(String name) {
		saveBtn.setText(name);;
	}
	
	public static JButton getsaveBtn() {
		return saveBtn;
	}
	public static JTextField getemployee_id() {
		return employee_id;
	}
	public static JTextField getemployeeName() {
		return employeeName;
	}
	public static JComboBox<String> getemployeedJob_id() {
		return employeedJob_id;
	}
	public static JTextField getemployeePhone_Number() {
		return employeePhone_Number;
	}
	public static JComboBox<String> getemployeePositions() {
		return employeePositions;
	}
	public static JTextField getemployeeDuty_hours() {
		return employeeDuty_hours;
	}
	public static JTextField getemployeeEmail() {
		return employeeEmail;
	}
	public static JTextField getemployeesalary() {
		return employeesalary;
	}
	public static JTextField getMoneyemployeesalary() {
		return moneyemployeesalary;
	}
}


class EmployeeInsertButton implements ActionListener{
	int employee_id;
	
	JFrame createJf;
	public EmployeeInsertButton(JFrame createJf) {
		this.createJf = createJf;
	}
	public void actionPerformed(ActionEvent e) {
			HikariCP cp = new HikariCP();
			HikariDataSource ds = cp.getHikariDataSource();
			String employee_id_get = "SELECT max(employee_id) FROM employee";
			int max_employee_id = 0;
			try (Connection conn = ds.getConnection(); 
					PreparedStatement pstmt = conn.prepareStatement(employee_id_get);) {
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					max_employee_id = rs.getInt(1);
				}
				max_employee_id += 1;
				String sql = null;
				try{
				sql = String.format("INSERT INTO employee(employee_id, employee_name, job_id, phone_number, positions, duty_hours, email, salary)"
						+ " VALUES(%d, '%s', '%s', '%s', '%s', %d, '%s', %d)",
						max_employee_id, 
						EmployeeCreateFPanel.getemployeeName().getText().trim(),
						EmployeeCreateFPanel.getemployeedJob_id().getSelectedItem().toString().trim(),
						EmployeeCreateFPanel.getemployeePhone_Number().getText().trim(),
						EmployeeCreateFPanel.getemployeePositions().getSelectedItem().toString().trim(),
						Integer.parseInt(EmployeeCreateFPanel.getemployeeDuty_hours().getText().trim()),
						EmployeeCreateFPanel.getemployeeEmail().getText().trim(),
						Integer.parseInt(EmployeeCreateFPanel.getMoneyemployeesalary().getText().trim())
						);
				PreparedStatement pstmt2 = conn.prepareStatement(sql);
				pstmt2.executeUpdate();
				rs.close();
				pstmt2.close();
				ds.close();
				String[] data = {
						""+max_employee_id,
						""+	EmployeeCreateFPanel.getemployeeName().getText().trim(),
						""+	EmployeeCreateFPanel.getemployeedJob_id().getSelectedItem().toString().trim(),
				};
				((DefaultTableModel) Employee_enrollment.getEmployeeTable().getModel()).addRow(data);
				JOptionPane.showMessageDialog(null, "추가하였습니다.");
				
				RightPanel.getemployee_id().setText("");
				RightPanel.getemployeeName().setText("");
				RightPanel.getemployeedJob_id().setSelectedIndex(0);
				RightPanel.getemployeePhone_Number().setText("");
				RightPanel.getemployeePositions().setSelectedIndex(0);
				RightPanel.getemployeeDuty_hours().setText("");
				RightPanel.getemployeeEmail().setText("");
				RightPanel.getemployeesalary().setText("");
				RightPanel.getMoneyemployeesalary().setText("");
				
				
				createJf.dispose();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "빠짐없이 기입해 주세요.");
					createJf.dispose();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
	}
	

}
	
class RightJText extends JTextField {
	public RightJText() {
		setPreferredSize(new Dimension(200, 40));
		setHorizontalAlignment(JLabel.CENTER);
		setFont(new Font("맑은 고딕", Font.BOLD, 12));
	}
}

class EmployeeLabel extends JLabel {
	public EmployeeLabel(String name) {
		super(name);
		setSize(100, 50);
		setForeground(Color.WHITE);
		setFont(new Font("맑은 고딕", Font.BOLD, 18));
		setHorizontalAlignment(JLabel.CENTER);
	}
}

	
	

	






