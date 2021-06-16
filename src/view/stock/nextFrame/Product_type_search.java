package view.stock.nextFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.zaxxer.hikari.HikariDataSource;

import hikariCP.HikariCP;
import view.stock.Button_round_search;
import view.stock.nextFrame.type_search.type_search_buttons;

public class Product_type_search extends JFrame{
	JFrame jf;
	String columnString;
	
	public Product_type_search(JFrame jf) {

		this.jf = jf;
		
		
		setTitle("대분류조회");
		
		JPanel top = new JPanel();
		JPanel center = new JPanel();
		
		top.setLayout(null);
		
		//뒤로가기버튼 생성및 뒤로가기 기능
		JButton backButton = new BackButton();
//		backButton.addActionListener(new BackToStock(jf, this));
//		top.add(backButton, BorderLayout.WEST);
		
		JLabel logo = new JLabel();
		logo.setIcon(new ImageIcon("./files/대분류조회.png"));
		logo.setBounds(20, 20, 350, 70);
		top.add(logo);
		
//		top.setBackground(new Color(43,51,62));
		top.setPreferredSize(new Dimension(203,90));
//		top.setSize(50, 100);
		top.setVisible(true);
		
		//센터 판넬 만들어두기
//		center.setLayout(new GridLayout(10,10,10,10));
		center.setSize(new Dimension(400,300));
		center.setLocation(20, 20);
		center.setVisible(true);
		
		ArrayList<String> columnArr = new ArrayList<>();
		ArrayList<JButton> buttonArr = new ArrayList<>();
		int columnCount = 0;
		
		
		HikariDataSource ds = new HikariCP().getHikariDataSource();
		String sql = "SELECT DISTINCT product_type FROM PRODUCTS";
		try(
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
		){

			while(rs.next()) {
				columnArr.add(rs.getString("product_type"));
			}

			columnCount = columnArr.size();
				
			ds.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int i = 0;
			//컬럼갯수만큼 버튼만들기
			for(i = 0; i < columnCount; i++) {
			
			columnString = columnArr.get(i);
			JButton jb = new Button_round_search(columnString);
			jb.addActionListener(new ActionListener() {

			
				@Override
				public void actionPerformed(ActionEvent e) {
				
					String type = jb.getText();
//					jf.setVisible(false);
					new type_search_buttons(jf, type, null,null);	
				}
				
			});
			buttonArr.add(jb);
			center.add(jb);
		}
		
		center.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		center.setLayout(new GridLayout(columnCount/2 + 1,3,10,10));
		
		add(top, BorderLayout.NORTH);
		add(center);

		setSize(725,520);
		setLocation(200,100);
		setVisible(true);
	}
//	public static void main(String[] args) {
//		new Product_type_search();
//	}
	
	
}
