package function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import com.zaxxer.hikari.HikariDataSource;

import function.model.Products_DB;
import function.payment.DeliveryButton;
import function.payment.Products_update;
import hikariCP.HikariCP;
import view.PaymentMainFrame;
import view.Payment.east.EastPayPanel;
import view.Payment.east.MemberPanel;
import view.Payment.topPanel.TopTable;

public class Sales_Insert {
	HikariCP cp = new HikariCP();
	HikariDataSource ds = cp.getHikariDataSource();

	public Sales_Insert(String Payment_type) {
		String sales_id_get = "SELECT max(sales_id) FROM sales";
		String sales_num_get = "SELECT max(sales_num) FROM sales";
		
		DefaultTableModel model = TopTable.getDefaultModel();
		try (Connection conn = ds.getConnection(); 
				PreparedStatement pstmt2 = conn.prepareStatement(sales_id_get);
				PreparedStatement pstmt3 = conn.prepareStatement(sales_num_get);) {

			PreparedStatement pstmt = null;
			ResultSet rs2 = pstmt2.executeQuery();
			ResultSet rs3 = pstmt3.executeQuery();
			int max_saled_id = 0;
			while (rs2.next()) {
				max_saled_id = rs2.getInt(1);
			}
			max_saled_id += 1; // DB에 넣을 값은 max+1임
			
			int max_saled_num = 0;
			while (rs3.next()) {
				max_saled_num = rs3.getInt(1);
			}
			
			int members_id = 0;
			if (!MemberPanel.getMemberNumberValue().getText().trim().equals("")) {
				members_id = Integer.parseInt(MemberPanel.getMemberNumberValue().getText().trim());
			}
			int point_score = 0;
			if (!MemberPanel.getAccumulateValue().getText().trim().equals("")) {
				point_score = Integer.parseInt(MemberPanel.getAccumulateValue().getText().trim()) - Integer.parseInt(EastPayPanel.getPointValue().getText().trim());
			}

			String sql = null;
			for (int i = 0; i < model.getRowCount(); i++) {
				max_saled_num += 1; // DB에 넣을 값은 max+1임
				if(members_id == 0) {
					sql = String.format(
							"INSERT INTO SALES (sales_num, sales_id, payment_type, sales_time, point_score, product_id, number_of_sales)"
									+ " VALUES (%d, %d, '%s', sysdate, %d, %d, %d)",
									max_saled_num, max_saled_id, Payment_type, 
									point_score, 
									Integer.parseInt((String) model.getValueAt(i, 0)),
									Integer.parseInt((String) model.getValueAt(i, 2)));
				}else {
					sql = String.format(
							"INSERT INTO SALES (sales_num, sales_id, payment_type, sales_time, members_id, point_score, product_id, number_of_sales)"
									+ " VALUES (%d, %d, '%s', sysdate, %d, %d, %d, %d)",
									max_saled_num, max_saled_id, Payment_type, 
							members_id, point_score, 
							Integer.parseInt((String) model.getValueAt(i, 0)),
							Integer.parseInt((String) model.getValueAt(i, 2)));
				}
				int product_id = Integer.parseInt((String) model.getValueAt(i, 0));
				int stocksOrGram = Integer.parseInt((String) model.getValueAt(i, 2));
				
				new Products_update(product_id, stocksOrGram);//무게 반영
				
				pstmt = conn.prepareStatement(sql);
				pstmt.executeUpdate();
				
				if(DeliveryButton.getDeliverycheck()) {//배달을 할경우 배달 번호도 추가
					String delivery_id_get = "SELECT max(delivery_id) FROM delivery";
					PreparedStatement pstmt4 = conn.prepareStatement(delivery_id_get);
					ResultSet rs4 = pstmt4.executeQuery();
					int max_delivery_id = 0;
					while(rs4.next()) {
						max_delivery_id = rs4.getInt(1);
					}
					System.out.println("max_delivery_id : "+max_delivery_id);
					System.out.println("max_saled_id : "+max_saled_id);
					String delivery_id_insert = String.format("UPDATE sales SET delivery_id = %d WHERE sales_id = %d ",
							max_delivery_id, max_saled_id);
					System.out.println(delivery_id_insert);
					PreparedStatement pstmt5 = conn.prepareStatement(delivery_id_insert);
					pstmt5.executeUpdate();
					pstmt4.close();
					pstmt5.close();
					
				}
				
				
			}
			pstmt.close();
			rs2.close();
			rs3.close();
			ds.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
