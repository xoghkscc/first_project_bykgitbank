package view.store.centerPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import view.Members.Design.RoundButtonDesign;

public class Employee_enrollment extends JPanel{
	public Employee_enrollment() {
		setPreferredSize(new Dimension(300, 500));
		add(new EmployeeGridPanle(), BorderLayout.CENTER);
		
		JButton btn = new RoundButtonDesign("직원 등록");
//		btn.setLocation(this.getWidth()/2, 400);
		add(btn, BorderLayout.SOUTH);
		setVisible(true);
	}
}

class EmployeeGridPanle extends JPanel{
	private static JTextField employeeName;
	private static JTextField employeedJob_id;
	private static JTextField employeePhone_Number;
	private static JTextField employeePositions;
	private static JTextField employeeDuty_hours;
	private static JTextField employeeEmail;
	private static JTextField employeesalary;
	public EmployeeGridPanle() {
		setLayout(new GridLayout(8, 2, 50, 50));
		setBackground(Color.GRAY);
		JLabel name = new EmployeeLabel("이름 : ");
		employeeName = new JTextField();
		JLabel label2 = new EmployeeLabel("직책 : ");
		employeedJob_id = new JTextField();
		JLabel label3 = new EmployeeLabel("연락처 : ");
		employeePhone_Number = new JTextField();
		JLabel label4 = new EmployeeLabel("근무형태 : ");
		employeePositions = new JTextField();
		JLabel label5 = new EmployeeLabel("근무시간 : ");
		employeeDuty_hours = new JTextField();
		JLabel label6 = new EmployeeLabel("이메일 : ");
		employeeEmail = new JTextField();
		JLabel label7 = new EmployeeLabel("월급 : ");
		employeesalary = new JTextField();
		
		
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
		add(employeesalary);
		setVisible(true);
	}
}

class EmployeeLabel extends JLabel{
	public EmployeeLabel(String name) {
		super(name);
		setSize(100, 50);
		setBackground(Color.BLUE);
	}
}
