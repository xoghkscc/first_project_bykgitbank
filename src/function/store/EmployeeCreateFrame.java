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

import hikariCP.HikariCP;
import view.store.RoundButtonStore;
import view.store.centerPanel.Employee_enrollment;
import view.store.centerPanel.RightPanel;

public class EmployeeCreateFrame extends JFrame{
	private static RightPanel rp;
	public EmployeeCreateFrame() {
		setSize(new Dimension(400, 700));
		setLocation(400, 100);
		add(new EmployeeCreateFPanel(this));
		setVisible(true);
		
	}
	
}


