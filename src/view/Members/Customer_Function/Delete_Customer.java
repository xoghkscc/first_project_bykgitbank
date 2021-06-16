package view.Members.Customer_Function;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.zaxxer.hikari.HikariDataSource;

import function.model.Member_Informations_DB;
import function.payment.PaymentInsertTable;
import hikariCP.HikariCP;
import view.Payment.east.MemberPanel;

public class Delete_Customer extends JFrame {


		HikariCP cp = new HikariCP();
		HikariDataSource ds = cp.getHikariDataSource();		
	
		public Delete_Customer(int member_id) {
			
			String sql = "DELETE FROM member_informations WHERE members_id = ? ";
			
			try (
					Connection conn = ds.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql);
			){
				
				pstmt.setString(1, "" + member_id);
				
				pstmt.executeUpdate();
			
				ds.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}