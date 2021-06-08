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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.zaxxer.hikari.HikariDataSource;

import hikariCP.HikariCP;

public class TopTable extends JTable{
	ArrayList<String> list;
	HikariCP cp = new HikariCP();
	HikariDataSource ds = cp.getHikariDataSource();
	String[] header = {"품번", "품명", "개수 및 무게", "정상가","할인 전 가격",  "할인액", "총 가격"};
	String sql = "SELECT product_id, product_name, stocks,gram, product_price, discount_rate FROM PRODUCTS WHERE product_id = ?";
	DefaultTableModel model;
	public TopTable() {
		model = (DefaultTableModel) this.getModel();
		setFont(new Font("맑은 고딕", Font.BOLD, 12));
		getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD, 20));
		getTableHeader().setBackground(new Color(218, 222, 227));
		model.setColumnIdentifiers(header);
		
	}
	
	public void addRow(int product_id) {
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				){
			pstmt.setString(1, ""+product_id);
			ResultSet rs = pstmt.executeQuery();
			list = new ArrayList<String>();
			while(rs.next()){
				list.add(""+rs.getInt("product_id"));
				list.add(""+rs.getString("product_name"));
				String cnt;
				if(rs.getInt("stocks") ==0) {
					cnt = JOptionPane.showInputDialog("무게를 입력하세요.");
				}else {
					cnt = "" + 1;
				}
				list.add(cnt);
				list.add(""+rs.getInt("product_price"));
				list.add(""+rs.getInt("product_price") * Integer.parseInt(cnt));
				if(rs.getDouble("discount_rate") > 0) {
					list.add(""+Math.round((rs.getInt("product_price") * Integer.parseInt(cnt)*(1-rs.getDouble("discount_rate")))));
				}else {
					list.add(""+0);
				}
				System.out.println((Integer.parseInt(list.get(4)) - Integer.parseInt(list.get(5))));
				list.add(""+ (Integer.parseInt(list.get(4)) - Integer.parseInt(list.get(5)))); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] row = new String[list.size()];
		list.toArray(row);
		model.addRow(row);
		setVisible(true);
	}
	
}

