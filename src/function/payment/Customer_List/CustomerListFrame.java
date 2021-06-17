package function.payment.Customer_List;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.zaxxer.hikari.HikariDataSource;

import function.model.Member_Informations_DB;
import function.model.members_list_DB;
import function.payment.PaymentInsertTable;
import hikariCP.HikariCP;
import view.Payment.east.MemberPanel;

public class CustomerListFrame extends JFrame {
	members_list_DB members_list_DB;
	DefaultTableModel model;
	
	
		static final int WIDTH = 600;
		static final int HEIGHT = 600;
		static final int X = 200;
		static final int Y = 200;
		private static JPanel page;
	
		public CustomerListFrame(int customer_phone_num) {
		
			
			setSize(WIDTH, HEIGHT);
			setLocation(X, Y);
			setBackground(new Color(43, 51, 62));
			setLayout(new BorderLayout());
			
			
			page = new JPanel();
			page.setLayout(new CardLayout(30, 40));
			page.setBackground(new Color(43, 51, 62));
			
			JTable salesTable = new MiniTable(customer_phone_num);
			salesTable.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					int row = ((JTable) e.getSource()).getSelectedRow();
					int member_id =Integer.parseInt((String) MiniTable.getMiniModel().getValueAt(row, 0));
					String member_name =  (String) MiniTable.getMiniModel().getValueAt(row, 1);
					String member_phoneNumber = (String) MiniTable.getMiniModel().getValueAt(row, 2);
					int member_point = Integer.parseInt((String) MiniTable.getMiniModel().getValueAt(row, 3));
					
					
					MemberPanel.getMemberNumberValue().setText("" + member_id);
					MemberPanel.getMemberNameValue().setText(member_name);
					MemberPanel.getMemberPointValue().setText("" + member_point);
					
					int total_payment = Integer.parseInt(PaymentInsertTable.getTotal_payment().getText().trim());
					
					int reserved_point = (int)(total_payment * 0.01);
					
					if(!MemberPanel.getMemberNameValue().getText().trim().equals("")) {
						MemberPanel.getAccumulateValue().setText("" + reserved_point);
					MemberPanel.getMemberPhoneNumberValue().setForeground(Color.black);
						
					}
					
					setVisible(false);
					
				};
			});
			
			
			JScrollPane miniScrollPane = new JScrollPane(salesTable);
			JPanel searchNext = new JPanel(new BorderLayout());
			searchNext.setBackground(new Color(43, 51, 62));

			
			page.add("main", miniScrollPane);
			page.add("detail", searchNext);
		
			add(page, BorderLayout.CENTER);
			
			page.setVisible(true);
			
			setVisible(true);
		}
			
	}
		class MiniTable extends JTable {
			Member_Informations_DB member_informations_DB;
			private static DefaultTableModel miniModel;
			HikariCP cp = new HikariCP();
			HikariDataSource ds = cp.getHikariDataSource();
			String[] header = {"회원 번호", "이름", "전화번호", "보유 포인트"};
			public MiniTable(int customer_phone_num) {
				miniModel = (DefaultTableModel) this.getModel();
				setFont(new Font("맑은 고딕", Font.BOLD, 12));
				getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD, 20));
				getTableHeader().setBackground(new Color(218, 222, 227));
				miniModel.setColumnIdentifiers(header);
				String sql = "SELECT * FROM members_list WHERE members_phonenumber LIKE ? "; 
				try(
						Connection conn = ds.getConnection();
						PreparedStatement pstmt = conn.prepareStatement(sql);
						) {
					
					pstmt.setString(1, "%" + customer_phone_num);
					ResultSet rs = pstmt.executeQuery();
					
					while(rs.next()) {
						String[] data = {
								""+rs.getInt(1),
								rs.getString(2),
								rs.getString(3),
								""+rs.getInt(4),
		
						};
						
						
						
						miniModel.addRow(data);
					}
					rs.close();
					ds.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			public static DefaultTableModel getMiniModel() {
				return miniModel;
			}
			
		
			
		}	