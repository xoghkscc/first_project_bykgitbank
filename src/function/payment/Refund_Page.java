package function.payment;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.zaxxer.hikari.HikariDataSource;

import function.model.Products_DB;
import hikariCP.HikariCP;
import view.Payment.lowPanel.LowJButton;
import view.Payment.lowPanel.RoundedButton;
import function.payment.*;

public class Refund_Page extends JFrame {
	static final int WIDTH = 800;
	static final int HEIGHT = 500;
	static final int X = 300;
	static final int Y = 150;
	private static JPanel page;
	private static int clickRow;
	private static JTable salesTable;
	JButton refund;
//	JButton refund = new LowJButtoncardPayment("환불하기");
	public Refund_Page() {
		setSize(WIDTH, HEIGHT);
		setLocation(X, Y);
		setBackground(new Color(43, 51, 62));
		setLayout(new BorderLayout());
		page = new JPanel();
		page.setLayout(new CardLayout(30, 40));
		page.setBackground(new Color(43, 51, 62));
		refund = new LowJButtoncardPayment("환불하기");
		refund.addActionListener(new RefundAction(this));
		refund.setVisible(false);
		
		salesTable = new MiniTable();
		salesTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				clickRow = ((JTable) e.getSource()).getSelectedRow();
				int sales_id =Integer.parseInt((String) MiniTable.getMiniModel().getValueAt(clickRow, 0));
				DetailMiniTable.setSales_id(sales_id);
				DetailMiniTable.detailMiniTableAddRow();
				CardLayout card = (CardLayout)page.getLayout();
				card.next(page);
				SearchPanel.getSearchText().setVisible(false);
				refund.setVisible(true);
			};
		});
		
		JScrollPane miniScrollPane = new JScrollPane(salesTable);
		JTable detailSalesTable = new DetailMiniTable();
		
		JScrollPane detailScrollPane = new JScrollPane(detailSalesTable);
		JPanel detailPane = new JPanel(new BorderLayout());
		detailPane.add(detailScrollPane, BorderLayout.CENTER);
		detailPane.setPreferredSize(new Dimension(400, 200));
		JButton prev = new LowJButtoncashPayment("<<");
		prev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DetailMiniTable.getDetailMiniModel().setNumRows(0);
				CardLayout card = (CardLayout)page.getLayout();
				card.next(page);
				refund.setVisible(false);
				SearchPanel.getSearchText().setVisible(true);
				SearchPanel.getSearchText().setText("판매번호 입력");
				new MiniTableSearch("");
			}
		});
		JPanel search = new SearchPanel();
		JPanel searchNext = new JPanel(new BorderLayout());
		searchNext.setBackground(new Color(43, 51, 62));
		searchNext.add(prev, BorderLayout.WEST);
		searchNext.add(detailPane);
		searchNext.add(refund, BorderLayout.SOUTH);
		
		page.add("main", miniScrollPane);
		page.add("detail", searchNext);
		
		add(search, BorderLayout.NORTH);
		add(page, BorderLayout.CENTER);
		
		page.setVisible(true);
		setVisible(true);
	}
	public static JPanel getPage() {
		return page;
	}
	
	public static int getClickRow() {
		return clickRow;
	}
	public static JTable getSalesTable() {
		return salesTable;
	}
	
	public void setRfundaction(JButton receiptBtn) {
		this.refund = receiptBtn;
	}
	
	public JButton getRefundBtn() {
		return this.refund;
	}
}

class SearchPanel extends JPanel {
	private static JTextField searchText;
	public SearchPanel() {
		searchText = new SearchText("판매번호 입력");
		setBackground(new Color(43, 51, 62));
		setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		add(searchText, BorderLayout.CENTER);
		setVisible(true);
	}
	
	public static JTextField getSearchText() {
		return searchText;
	}
}

class SearchText extends JTextField {
	public SearchText(String name) {
		super(name);
		setBackground(Color.WHITE);
		setFont(new Font("맑은 고딕", Font.BOLD, 12));
		setPreferredSize(new Dimension(300, 30));
		setForeground(Color.gray);
		setHorizontalAlignment(JLabel.CENTER);
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				((JTextField) e.getSource()).setText("");
			}
		});
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
			
				if(((JTextField) e.getSource()).getText().trim().equals(name)) {
					((JTextField) e.getSource()).setText(name);
				}
			}
		});
		
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sales_text = ((JTextField) e.getSource()).getText();
				new MiniTableSearch(sales_text);
				MiniTable.getMiniModel().fireTableDataChanged();
			}
		});
		
	}
}


class MiniTable extends JTable {
	private static DefaultTableModel miniModel;
	HikariCP cp = new HikariCP();
	HikariDataSource ds = cp.getHikariDataSource();
	String[] header = {"판매번호","회원 번호", "포인트" ,"구매 시간", "배달",  "총 가격"};
	public MiniTable() {
		miniModel = (DefaultTableModel) this.getModel();
		setFont(new Font("맑은 고딕", Font.BOLD, 12));
		getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD, 20));
		getTableHeader().setBackground(new Color(218, 222, 227));
		miniModel.setColumnIdentifiers(header);
		String sql = "SELECT * FROM sales_simple order by sales_id"; //simple_sales라는 뷰를 만들었음
		try(
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) {
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String[] data = {
						""+rs.getInt(1),
						""+rs.getInt(2),
						""+rs.getInt(3),
						""+rs.getDate(4),
						""+rs.getInt(5),
						""+rs.getInt(6),
				};
				if(rs.getInt(6) > 0) {
					miniModel.addRow(data);
				}
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

class DetailMiniTable extends JTable{
	private static DefaultTableModel detailMiniModel;
	private static int sales_id;
	String[] header = {"물건 번호", "물건 이름", "총 개수 및 무게", "가격"};
	public DetailMiniTable() {
		sales_id = 0;
		detailMiniModel = (DefaultTableModel) this.getModel();
		setFont(new Font("맑은 고딕", Font.BOLD, 14));
		getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD, 20));
		getTableHeader().setBackground(new Color(218, 222, 227));
		detailMiniModel.setColumnIdentifiers(header);
	}
	
	public static void detailMiniTableAddRow() {
		HikariCP cp = new HikariCP();
		HikariDataSource ds = cp.getHikariDataSource();
		String sql = String.format("SELECT product_ID, product_name, number_of_sales, number_of_sales*product_price  FROM "
				+ "sales INNER JOIN products USING (product_ID) where sales_id = %d", sales_id);
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String[] data = {
						""+rs.getInt(1),
						""+rs.getString(2),
						""+rs.getInt(3),
						""+rs.getInt(4),
				};
				detailMiniModel.addRow(data);
			}
			rs.close();
			ds.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static int getSales_id() {
		return sales_id;
	}
	public static DefaultTableModel getDetailMiniModel() {
		return detailMiniModel;
	}
	public static void setSales_id (int sales_id2) {
		sales_id = sales_id2;
	}
}


class LowJButtoncashPayment extends RoundedButton{
	public LowJButtoncashPayment(String name) {
		super(name);
		super.c = new Color(122, 122, 122); 
		setHorizontalAlignment(JLabel.CENTER);
		setFont(new Font("맑은 고딕", Font.BOLD, 20));
	}
}

class LowJButtoncardPayment extends RoundedButton{
	public LowJButtoncardPayment(String name) {
		super(name);
		super.c = new Color(153, 153, 153); 
		setHorizontalAlignment(JLabel.CENTER);
		setFont(new Font("맑은 고딕", Font.BOLD, 20));
	}
}

