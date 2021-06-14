package view.store.centerPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.zaxxer.hikari.HikariDataSource;

import function.model.Employee_DB;
import hikariCP.HikariCP;
import view.Members.Design.RoundButtonDesign;
import view.store.DeleteButton;
import view.store.RoundButtonStore;

public class Employee_enrollment extends JPanel {
	private static JTable employeeTable;
	public Employee_enrollment() {
		setPreferredSize(new Dimension(300, 500));
		setLayout(new GridLayout(1, 2, 0, 30));
//		setBackground(new Color(43, 51, 62));
		JButton btn = new RoundButtonStore("직원 등록");
		JButton btn2 = new RoundButtonStore("직원 삭제");
		btn2.addActionListener(new DeleteButton());
		employeeTable = new EmployeeTable();
		employeeTable.addMouseListener(new tableMouse());
		JPanel left = new JPanel();
		JPanel emptyPanel = new JPanel();
		emptyPanel.setPreferredSize(new Dimension(300, 70));
//		emptyPanel.setBackground(new Color(43, 51, 62));
//		left.setBackground(new Color(43, 51, 62));
		JPanel right = new JPanel();
		right.add(new RightPanel());
		JScrollPane scrollPane = new JScrollPane(employeeTable);
		left.add(emptyPanel);
		left.add(scrollPane);
		left.add(btn);
		left.add(btn2);
		
		add(left);
		add(right);
		setVisible(true);
	}
	
	public static JTable getEmployeeTable() {
		return employeeTable;
	}
}

class EmployeeTable extends JTable {
	private static DefaultTableModel employeeModel;
	private static ArrayList<Employee_DB> data2;
	HikariCP cp = new HikariCP();
	HikariDataSource ds = cp.getHikariDataSource();
	String[] header = { "사번", "이름", "직책"};
	

	public EmployeeTable() {
		data2 = new ArrayList<Employee_DB>();
		setBorder(BorderFactory.createEmptyBorder(300, 20, 10, 40));
		employeeModel = (DefaultTableModel) this.getModel();
		setFont(new Font("맑은 고딕", Font.BOLD, 12));
		getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD, 16));
//		getTableHeader().setBackground(new Color(218, 222, 227));
		employeeModel.setColumnIdentifiers(header);

		String sql = "SELECT *  FROM employee";

		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String[] data = { "" + rs.getInt(1), "" + rs.getString(2), "" + rs.getString(3) };
				employeeModel.addRow(data);
				data2.add(new Employee_DB(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), 
						rs.getString(5), rs.getInt(6), rs.getString(7), rs.getInt(8)));
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
	public static ArrayList<Employee_DB> getdata2() {
		return data2;
	}
	
}

class tableMouse extends MouseAdapter{
	@Override
	public void mouseClicked(MouseEvent e) {
		int clickRow = ((JTable) e.getSource()).getSelectedRow();
		int employee_id =Integer.parseInt((String) Employee_enrollment.getEmployeeTable().getValueAt(clickRow, 0));
		for(int i = 0; i<EmployeeTable.getdata2().size(); i++) {
			if(employee_id == EmployeeTable.getdata2().get(i).getEmployee_id()) {
				RightPanel.getemployee_id().setText(""+EmployeeTable.getdata2().get(i).getEmployee_id());
				RightPanel.getemployeeName().setText(EmployeeTable.getdata2().get(i).getEmployee_name());
				RightPanel.getemployeedJob_id().setText(""+EmployeeTable.getdata2().get(i).getJob_id());
				RightPanel.getemployeePhone_Number().setText(""+EmployeeTable.getdata2().get(i).getPhone_number());
				RightPanel.getemployeePositions().setText(EmployeeTable.getdata2().get(i).getPositions());
				RightPanel.getemployeeDuty_hours().setText(""+EmployeeTable.getdata2().get(i).getDuty_hours());
				RightPanel.getemployeeEmail().setText(EmployeeTable.getdata2().get(i).getEmail());
				RightPanel.getemployeesalary().setText(""+EmployeeTable.getdata2().get(i).getSalary());
				break;
			}
			
		}
//		Employee_DB db = EmployeeTable.getdata2().get
	}
}


