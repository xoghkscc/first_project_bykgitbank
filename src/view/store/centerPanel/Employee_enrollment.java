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
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.zaxxer.hikari.HikariDataSource;

import function.model.Employee_DB;
import hikariCP.HikariCP;
import view.store.RoundButtonStore;
import function.store.*;

public class Employee_enrollment extends JPanel {
	private static JTable employeeTable;
	private static JScrollPane scrollPane;
	public Employee_enrollment() {
		setPreferredSize(new Dimension(300, 500));
		setLayout(new GridLayout(1, 2, 0, 30));
		setBackground(new Color(43, 51, 62));
		JButton btn = new RoundButtonStore("직원 등록");
		btn.addActionListener(new EmployeeCreateButton());
		JButton btn2 = new RoundButtonStore("직원 삭제");
		btn2.addActionListener(new EmployeeDeleteButton());
		
		employeeTable = new EmployeeTable();
		employeeTable.addMouseListener(new TableMouse());
		JPanel left = new JPanel();
		left.setBackground(new Color(43, 51, 62));
		JPanel emptyPanel = new JPanel();
		emptyPanel.setBackground(new Color(43, 51, 62));
		emptyPanel.setPreferredSize(new Dimension(300, 70));
//		emptyPanel.setBackground(new Color(43, 51, 62));
//		left.setBackground(new Color(43, 51, 62));
		JPanel right = new JPanel();
		right.setBackground(new Color(43, 51, 62));
		right.add(new RightPanel());
		scrollPane = new JScrollPane(employeeTable);
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
	public static JScrollPane getscrollPane() {
		return scrollPane;
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

		String sql = "SELECT *  FROM employee ORDER BY employee_id ASC ";

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
}







