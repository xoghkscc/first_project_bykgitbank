package view.Members.Customer_Function;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.zaxxer.hikari.HikariDataSource;

import function.model.Member_Informations_DB;
import hikariCP.HikariCP;
import view.Members.Customer_Delete;

public class Delete_Customer_list extends JFrame {

	Member_Informations_DB Member_Informations_DB;
	
	DefaultTableModel model;
	
		static final int WIDTH = 600;
		static final int HEIGHT = 600;
		static final int X = 200;
		static final int Y = 200;
		private static JPanel page;
	
		public Delete_Customer_list(String customerName) {
		
			
			setSize(WIDTH, HEIGHT);
			setLocation(X, Y);
			setBackground(new Color(43, 51, 62));
			setLayout(new BorderLayout());
			
			
			page = new JPanel();
			page.setLayout(new CardLayout(30, 40));
			page.setBackground(new Color(43, 51, 62));
			
			JTable salesTable = new MiniTable(customerName);
			
			salesTable.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					
				int row = ((JTable) e.getSource()).getSelectedRow();
				int member_id =Integer.parseInt((String) MiniTable.getMiniModel().getValueAt(row, 0));
			
				
				int choice = JOptionPane.showConfirmDialog(null, "회원을 삭제하시겠습니까?", "회원 삭제", JOptionPane.YES_NO_OPTION);
				
				if (choice == 0 ) {
					new Delete_Customer(member_id);
					JOptionPane.showMessageDialog(null, "삭제하셨습니다");
				} 
				else {
					JOptionPane.showMessageDialog(null, "취소하셨습니다");
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
			private static DefaultTableModel miniModel;
			HikariCP cp = new HikariCP();
			HikariDataSource ds = cp.getHikariDataSource();
			String[] header = {"회원 번호", "이름", "주소", "전화번호", "보유 포인트"};
			
			public MiniTable(String customerName) {
				miniModel = (DefaultTableModel) this.getModel();
				setFont(new Font("맑은 고딕", Font.BOLD, 12));
				getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD, 20));
				getTableHeader().setBackground(new Color(218, 222, 227));
				miniModel.setColumnIdentifiers(header);
				String sql = "SELECT * FROM member_informations WHERE members_name = ? "; 
				try(
						Connection conn = ds.getConnection();
						PreparedStatement pstmt = conn.prepareStatement(sql);
						) {
					
					pstmt.setString(1, customerName);
					ResultSet rs = pstmt.executeQuery();
					while(rs.next()) {
						String[] data = {
								""+rs.getInt(1),
								rs.getString(2),
								rs.getString(3),
								rs.getString(4),
								""+rs.getInt(5),
		
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