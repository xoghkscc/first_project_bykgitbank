package function.stock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class InsertDB_product {

	String sql;
	UpdateValue ud;
	String completeSql;

	
	public InsertDB_product(String sql) {
		
		this.sql = sql;
		this.ud = ud;
		
	
		completeSql = sql;
	
		
		System.out.println("들어온sql" + completeSql);
		HikariConfig config = new HikariConfig();
		
		config.setJdbcUrl("jdbc:oracle:thin:@3.35.52.40:1521");
		config.setUsername("first_project");
		config.setPassword("1234");
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

		HikariDataSource ds = new HikariDataSource(config);
		
		try(
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(completeSql);
		){

			int row = pstmt.executeUpdate();
			System.out.println(row + "행 업데이트됨");
//			JOptionPane.showConfirmDialog(null,row + "행 업데이트","수정사항", JOptionPane.YES_NO_OPTION);
			JOptionPane.showMessageDialog(null, row + "행 업데이트", "수정사항" , 1);
			pstmt.close();
			conn.close();
			ds.close();	//커넥션풀을 꼭닫아주세요
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
