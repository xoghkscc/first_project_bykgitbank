package function.payment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.zaxxer.hikari.HikariDataSource;

import function.Member_informations_update;
import hikariCP.HikariCP;

public class RefundAction implements ActionListener{

	int clickRow;
	DefaultTableModel miniModel;
	DefaultTableModel detailMiniModel;
	JFrame refundJf;
	
	public RefundAction(JFrame refundJf) {
		this.refundJf = refundJf;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		clickRow = Refund_Page.getClickRow();
		miniModel = MiniTable.getMiniModel();
		detailMiniModel = DetailMiniTable.getDetailMiniModel();
		
		int sales_id =Integer.parseInt((String) miniModel.getValueAt(clickRow, 0));
		int members_id =Integer.parseInt((String) miniModel.getValueAt(clickRow, 1));
		int point_score =Integer.parseInt((String) miniModel.getValueAt(clickRow, 2));
		int delivery_id =Integer.parseInt((String) miniModel.getValueAt(clickRow, 4));
		new RefundDB(sales_id, members_id, point_score, delivery_id, detailMiniModel);
		JOptionPane.showMessageDialog(null, "환불 완료.");
		refundJf.dispose();
	}

}

class RefundDB{
	HikariCP cp = new HikariCP();
	HikariDataSource ds = cp.getHikariDataSource();;
	int sales_id;
	int members_id;
	int point_score;
	int delivery_id;
	DefaultTableModel detailMiniModel;
	public RefundDB(int sales_id, int members_id, int point_score, int delivery_id, DefaultTableModel detailMiniModel) {
		 this.sales_id = sales_id;
		 this.members_id = members_id;
		 this.point_score = point_score;
		 this.delivery_id = delivery_id;
		 this.detailMiniModel = detailMiniModel;
		 productsReset();//재고 개수 초기화-확인 완료
		 pointReset();//포인트 초기화 - 확인 완료
		 salesReset();/// 판매기록 수정 확인 완료
		 deliveryReset();//배달 삭제 - 확인 완료
		 
	}

	//재고 개수 초기화 하는 메서드
	public void productsReset() {
		int rowCnt = detailMiniModel.getRowCount();
		for(int i = 0; i < rowCnt; i++) {
			int product_id =Integer.parseInt((String) detailMiniModel.getValueAt(i, 0));
			int stocksOrGram =Integer.parseInt((String) detailMiniModel.getValueAt(i, 2));
			new Products_update(product_id, (-1) * stocksOrGram);
			//-1을 곱하는 이유는 Products_update에서드는 개수를 넣으면 원래 있는 개수에서 그만큼 빼는
			//기능 이기에 더해주려면 뺀 개수의 -1을 곱해 마이너스 빼기를 하면 개수가 더해짐
		}
	}
	public void deliveryReset() {//해당 배달 번호가 있다면 배달기록 삭제
		String sql = String.format("DELETE FROM delivery WHERE delivery_id = %d", delivery_id);
		
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt  = conn.prepareStatement(sql);
				){
			pstmt.executeUpdate();
			ds.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

	
	public void pointReset() {//변동된 포인트 되돌리기
		new Member_informations_update(members_id, (-1) * point_score);	
		//-1을 곱하는 이유는 productsReset와 같음
	}
	
	public void salesReset() {//판매내역 수정하기
		//판매내역은 지우는게 아니라 number_of_sales, POINT_SCORE, DELIVERY_ID 를 모두 0으로 만들고
		//refund 컬럼을 Y로 바꿀거임
		String sql = String.format("UPDATE sales SET"
				+ " POINT_SCORE=0, DELIVERY_ID= null, REFUND = 'Y', number_of_sales = 0  "
				+ "WHERE sales_id = %d", sales_id);
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt  = conn.prepareStatement(sql);
				){
			pstmt.executeUpdate();
			
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}