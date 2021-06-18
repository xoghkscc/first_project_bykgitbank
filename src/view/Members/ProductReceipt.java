package view.Members;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import function.member.design.RoundButtonDesign;
import view.Members.Customer_Function.ProductReceiptText;

public class ProductReceipt extends JFrame {
	
	private static DefaultTableModel model;
	private static JTable table;
	private static JTextField product_name;
	
	public ProductReceipt(int member_id) {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0,36, 62));
		panel.setSize(600,600);
		product_name = new JTextField("조회할 물품을 입력해주세요");
		product_name.setBounds(110,40, 300,25);
		product_name.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		product_name.setForeground(new Color(145,145,145));
		product_name.addActionListener(new ProductReceiptText());
		
		JButton btn = new RoundButtonDesign("검색");
		btn.addActionListener(new ProductReceiptText());
		btn.setBounds(420,40, 50,25);
		btn.setForeground(new Color(245, 173, 37));
		
		String[] header = {"물건을 구입한 날짜","수량", "결제 금액"};
		
		model = new DefaultTableModel(header, 0) {
	
		 public boolean isCellEditable(int rowIndex, int mColIndex) {
             return false;
         }
     };
		
		table = new JTable(model);
		table.setFont(new Font("맑은 고딕", Font.PLAIN,17));
		table.getTableHeader().setReorderingAllowed(false);
	    table.getTableHeader().setResizingAllowed(false);
		table.setRowHeight(30);
		
		JTableHeader header1 = table.getTableHeader();
		header1.setPreferredSize(new Dimension(100, 40));
		header1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		
		JScrollPane pane = new JScrollPane(table);
		pane.setLocation(40, 100);
		pane.setSize(500,420);
		
		panel.add(pane);
		panel.add(btn);
		panel.add(product_name);
		
		getContentPane().add(panel);
		
		setBounds(500,50, 600, 600);
		setVisible(true);
	
		
		MouseListener mm = new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (e.getSource() instanceof JTextField) {
					
					((JTextField) e.getSource()).setText("");
					while(model.getRowCount() > 0) {
						model.removeRow(0);
					}
					((JTextField) e.getSource()).setForeground(new Color(000,000,000));
				}
			}
		};
			product_name.addMouseListener(mm);
	
	
	}
	
	public static JTextField getProduct_name() {
		return product_name;
	}
	
	public static DefaultTableModel getModel() {
		return model;
	}
	public static JTable getTable() {
		return table;
	}
}
