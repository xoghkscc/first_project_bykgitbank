package function.store;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.zaxxer.hikari.HikariDataSource;

import hikariCP.HikariCP;
import view.store.centerPanel.RightPanel;

public class EmployeeCreateButton implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		new EmployeeCreateFrame();
	}

}
