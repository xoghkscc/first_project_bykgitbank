package view.store.centerPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import function.model.Employee_DB;
import function.store.*;
import view.store.RoundButtonStore;

public class RightPanel extends JPanel {
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
	public RightPanel() {
		listRenderer = new DefaultListCellRenderer();
		listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
		setBackground(new Color(43, 51, 62));
		setPreferredSize(new Dimension(210, 700));
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

		saveBtn = new RoundButtonStore("수정하기");
		saveBtn.addActionListener(new EmployeeUpdateButton());
		
		
		
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


