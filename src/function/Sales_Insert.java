package function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zaxxer.hikari.HikariDataSource;

import function.model.Products_DB;
import function.payment.PaymentInsertTable;
import hikariCP.HikariCP;
import view.PaymentMainFrame;
import view.Payment.east.MemberPanel;

public class Sales_Insert {
	HikariCP cp = new HikariCP();
	HikariDataSource ds = cp.getHikariDataSource();
	public Sales_Insert(String Payment_type) {
		String sales_id_get = "SELECT max(sales_id) FROM sales";
		try(
				Connection conn = ds.getConnection();
				PreparedStatement pstmt2 = conn.prepareStatement(sales_id_get);
				) {
		
			PreparedStatement pstmt = null;
			ResultSet rs2 = pstmt2.executeQuery();
			int max_saled_id=0;
			
			while(rs2.next()) {
				max_saled_id = rs2.getInt(1);
			}
			max_saled_id += 1; //DB에 넣을 값은 max+1임
			
			ArrayList<Products_DB> list = PaymentMainFrame.getProduct_list();
			
			for(int i=0; i< list.size(); i++) {
				int number_of_sales=0;
				if(list.get(i).getGram() == 0) {
					number_of_sales = list.get(i).getStocks();
				}else {
					number_of_sales = list.get(i).getGram();
				}
				
				
				int members_id= 0;
				if(!MemberPanel.getMemberNumberValue().getText().trim().equals("회원 번호 입력")) {
					members_id = Integer.parseInt(MemberPanel.getAccumulateValue().getText());
				}
				
				int point_score = 0;
				if(!MemberPanel.getAccumulateValue().getText().trim().equals("")) {
					point_score = Integer.parseInt(MemberPanel.getAccumulateValue().getText());
				}
				
				String sql =String.format
						("INSERT INTO sales (sales_num, sales_id, payment_type, sales_time, members_id, point_score, delivery_id, product_id, number_of_sales)"
								+ " VALUES (sales_seq.nextval, %d, %s, sysdate, %d, %d, %d, %d, %d)"
								,max_saled_id , Payment_type, members_id, 
								point_score,
								0, list.get(i).getProduct_id(),
								number_of_sales); 
				
				pstmt = conn.prepareStatement(sql);
				pstmt.executeUpdate();
			}
			PaymentMainFrame.getProduct_list().clear();
			pstmt.close();
			rs2.close();
			ds.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
