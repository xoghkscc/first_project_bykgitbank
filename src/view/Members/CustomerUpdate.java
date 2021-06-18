package view.Members;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import function.member.design.RoundButtonDesign;
import function.model.Member_Informations_DB;
import view.Members.Customer_Function.CustomerUpdateText;
import view.Members.Customer_Function.CustomerUpdateText2;
import view.Members.Customer_Function.Customer_Update;
import view.Members.Customer_Function.EnterCustomerSerachText;
import view.Members.Customer_Function.Update;




public class CustomerUpdate extends JFrame {
	
	private static DefaultTableModel model;
	private static JTextField CustomerPhoneNumber;
	private static JTable table;
	
	public CustomerUpdate() {
		super ("회원 수정");
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setLocation(50, 70);
		panel.setSize(1000,70);
		panel.setBackground(new Color(43,51,62));
		
		JButton btn = new RoundButtonDesign("검색");
		btn.addActionListener(new CustomerUpdateText());
		CustomerPhoneNumber = new JTextField(20);
		CustomerPhoneNumber.setText("※ 휴대폰 번호 4자리를 입력해주세요");
		CustomerPhoneNumber.addActionListener(new CustomerUpdateText());
		
		JLabel label = new JLabel("회원 정보 검색: ");
		
				
		label.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		label.setForeground(Color.white);		
		CustomerPhoneNumber.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		CustomerPhoneNumber.setForeground(new Color(220,220,220));
			
		panel.add(label);
		panel.add(CustomerPhoneNumber);	
		panel.add(btn);
		
		
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		
		
		
		// JTable header
		String[] header = {"회원ID","회원 이름", "회원 주소", "회원 연락처"};
		
		model = new DefaultTableModel(header, 0);
			
		table = new JTable(model);
		table.setRowHeight(30);
		
		JTableHeader header1 = table.getTableHeader();
		header1.setPreferredSize(new Dimension(100, 40));
		header1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		
		JScrollPane pane = new JScrollPane(table);
		pane.setLocation(30, 150);
		pane.setSize(1200,300);
		
		JButton modify = new RoundButtonDesign("회원 수정");
		modify.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		modify.setLocation(450, 500);
		modify.setSize(300,100);
		modify.setForeground(new Color(102, 255, 102));
		modify.addActionListener(new CustomerUpdateText2());
		
		panel2.setSize(500,500);
		panel2.setLocation(500,50);
		panel2.setBackground(new Color(43,51,62));
		
		panel2.add(pane);	
		panel2.add(modify);
		
		getContentPane().add(panel);
		getContentPane().add(panel2);
		
		setBounds(500, 50, 1280, 720);
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
		
		CustomerPhoneNumber.addMouseListener(mm);
		
		btn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btn.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {

					if (e.getSource() instanceof JTextField) {
					
						((JTextField) e.getSource()).setText("");
				}
					while(model.getRowCount() > 0) {
						model.removeRow(0);
			}	
			}
		
		});
	
		
		
	
	}
	
	public static JTextField getCustomerPhoneNumber() {
		return CustomerPhoneNumber;
	}
	
	public static DefaultTableModel getModel() {
		return model;
	}
	
	public static JTable getTable() {
		return table;
	}
}
		