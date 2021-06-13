package function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

import hikariCP.HikariCP;
import view.Payment.east.EastPayPanel;
import view.Payment.east.MemberPanel;

public class Member_informations_update {
	HikariCP cp = new HikariCP();
	HikariDataSource ds = cp.getHikariDataSource();
	public Member_informations_update(int members_id, int accumulate_point) {
		//accumulate_point가 마이너스가 될 수도 있음--환블이거나 적립이 사용보다 더 많을 경우 마이너스가 되어 오히려 추가가됨
		String update_members_point = String.format("UPDATE MEMBER_INFORMATIONS SET members_point = members_point + (%d) WHERE members_id = %d ",
				accumulate_point, members_id);
		
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(update_members_point);
				){
			
			pstmt.executeUpdate();
			ds.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
