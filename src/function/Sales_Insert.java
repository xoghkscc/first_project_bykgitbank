package function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import com.zaxxer.hikari.HikariDataSource;

import function.model.Products_DB;
import hikariCP.HikariCP;
import view.PaymentMainFrame;
import view.Payment.east.MemberPanel;
import view.Payment.topPanel.TopTable;

public class Sales_Insert {
	HikariCP cp = new HikariCP();
	HikariDataSource ds = cp.getHikariDataSource();

	public Sales_Insert(String Payment_type) {
		String sales_id_get = "SELECT max(sales_id) FROM sales";
		DefaultTableModel model = TopTable.getDefaultModel();
		try (Connection conn = ds.getConnection(); 
				PreparedStatement pstmt2 = conn.prepareStatement(sales_id_get);) {

			PreparedStatement pstmt = null;
			ResultSet rs2 = pstmt2.executeQuery();
			int max_saled_id = 0;
			while (rs2.next()) {
				max_saled_id = rs2.getInt(1);
			}
			max_saled_id += 1; // DB에 넣을 값은 max+1임

			int members_id = 0;
			if (!MemberPanel.getMemberNumberValue().getText().trim().equals("회원 번호 입력")) {
				members_id = Integer.parseInt(MemberPanel.getMemberNumberValue().getText().trim());
			}
			int point_score = 0;
			if (!MemberPanel.getAccumulateValue().getText().trim().equals("")) {
				point_score = Integer.parseInt(MemberPanel.getAccumulateValue().getText().trim());
			}

			String sql = null;
			for (int i = 0; i < model.getRowCount(); i++) {
				if(members_id == 0) {
					sql = String.format(
							"INSERT INTO SALES (sales_num, sales_id, payment_type, sales_time, point_score, product_id, number_of_sales)"
									+ " VALUES (sales_seq.nextval, %d, '%s', sysdate, %d, %d, %d)",
									max_saled_id, Payment_type, 
									point_score, 
									Integer.parseInt((String) model.getValueAt(i, 0)),
									Integer.parseInt((String) model.getValueAt(i, 2)));
				}else {
					sql = String.format(
							"INSERT INTO SALES (sales_num, sales_id, payment_type, sales_time, members_id, point_score, product_id, number_of_sales)"
									+ " VALUES (sales_seq.nextval, %d, '%s', sysdate, %d, %d, %d, %d)",
							max_saled_id, Payment_type, 
							members_id, point_score, 
							Integer.parseInt((String) model.getValueAt(i, 0)),
							Integer.parseInt((String) model.getValueAt(i, 2)));
				}
				
				pstmt = conn.prepareStatement(sql);
				pstmt.executeUpdate();
			}
			System.out.println(sql);

			rs2.close();
			ds.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
