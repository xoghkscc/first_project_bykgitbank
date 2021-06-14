package view.Payment.topPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.zaxxer.hikari.HikariDataSource;

import hikariCP.HikariCP;

public class TopTable extends JTable{
	private static DefaultTableModel model;
	String[] header = {"품번", "품명", "개수 및 무게", "정상가","할인 전 가격",  "할인액", "총 가격"};
	String sql = "SELECT product_id, product_name, stocks,gram, product_price, discount_rate FROM PRODUCTS WHERE product_id = ?";
	public TopTable() {
		model = (DefaultTableModel) this.getModel();
		setFont(new Font("맑은 고딕", Font.BOLD, 12));
		getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD, 20));
		getTableHeader().setBackground(new Color(218, 222, 227));
		model.setColumnIdentifiers(header);
		
	}
	
	
	public static DefaultTableModel getDefaultModel() {
		return model;
	}
	
}

