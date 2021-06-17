package function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.zaxxer.hikari.HikariDataSource;

import function.model.Products_DB;
import hikariCP.HikariCP;
import view.PaymentMainFrame;

public class Products_Select {
	Products_DB productDb;
	
	HikariCP cp;
	HikariDataSource ds;
	ArrayList<Products_DB> list = new ArrayList<Products_DB>();
	
	public Products_Select(int product_id) {//이 생성자는 PRODUCT_ID에 대해 물건의 정보를 받아오는 생성자(개별 조회용)
		cp = new HikariCP();
		ds = cp.getHikariDataSource();
		String sql= "SELECT * FROM Products WHERE PRODUCT_ID = ?";
		
		try(
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) {
			pstmt.setString(1, ""+product_id);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				productDb = new Products_DB(rs.getInt(1), rs.getString(2),  rs.getString(3), rs.getInt(4), rs.getDate(5), 
						 rs.getString(6), rs.getDouble(7),  rs.getString(8), rs.getInt(9), rs.getInt(10),  rs.getString(11));
			}
			
			
			
			rs.close();
			ds.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Products_Select() {//이 생성자는 PRODUCTS테이블에 대해 정보를 product_list에 받는 생성자(전체 조회용)
		cp = new HikariCP();
		ds = cp.getHikariDataSource();
		String sql= "SELECT * FROM Products ";
		
		try(
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) {
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Products_DB(rs.getInt(1), rs.getString(2),  rs.getString(3), rs.getInt(4), rs.getDate(5), 
						 rs.getString(6), rs.getDouble(7),  rs.getString(8), rs.getInt(9), rs.getInt(10),  rs.getString(11)));
				
			}
			
		
			
			rs.close();
			ds.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//필요에 따라 아래의 것들을 리턴

	public Products_DB getProducts_DB() {
		return productDb;
	}
}
