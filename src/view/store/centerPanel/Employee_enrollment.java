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





