package function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

import function.payment.DeliveryButton;
import hikariCP.HikariCP;
import view.Payment.east.EastPayPanel;
import view.Payment.east.MemberPanel;

public class Delivery_Insert {
	HikariCP cp = new HikariCP();
	HikariDataSource ds = cp.getHikariDataSource();
	
	public Delivery_Insert() {
		String delivery_id_get = "SELECT max(delivery_id) FROM delivery";
		try (
				
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(delivery_id_get);
				){
			ResultSet rs = pstmt.executeQuery();
			int max_delivery_id = 0;
			while(rs.next()) {
				max_delivery_id = rs.getInt(1);
			}
			max_delivery_id += 1;
			
			String insert_sql = String.format("INSERT INTO DELIVERY VALUES (%d, %d, %d, 'N')",
					max_delivery_id,Integer.parseInt(MemberPanel.getMemberNumberValue().getText().trim()),
					Integer.parseInt(EastPayPanel.getAmountValue().getText().trim()));
			
			PreparedStatement pstmt2 = conn.prepareStatement(insert_sql);
			pstmt2.executeUpdate();
			
			rs.close();
			ds.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
