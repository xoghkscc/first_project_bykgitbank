package view.Members;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import function.member.EnterCustomerSerachText;
import function.member.PushCustomerUpdateButton;
//import com.sun.media.sound.ModelAbstractChannelMixer;

import function.model.Member_Informations_DB;
import function.topBar.ClickMain;
import function.topBar.TopBar;
import view.Members.Customer_Function.Delete_Customer;
import view.Members.Customer_Function.*;
import view.Payment.lowPanel.RoundedButton;


public class MemberSearchFrame extends JFrame{
	
	private static DefaultTableModel model;
	private static JTextField CustomerPhoneNumber;
	private static JTable table;
	JFrame jf;
	
	public MemberSearchFrame (JFrame jf) {
		
		this.jf = jf;
		
//		 ("회원 정보 검색");
			
		Container content_panel = getContentPane();
		Container content_panel2 = getContentPane();
		Container content_panel3 = getContentPane();
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setLocation(100, 70);
		panel.setSize(1000,70);
		
		
		JButton btn = new Search("검색");
		btn.addActionListener(new EnterCustomerSerachText());
		CustomerPhoneNumber = new JTextField(20);
		CustomerPhoneNumber.setText("※ 휴대폰 번호 4자리를 입력해주세요");
		CustomerPhoneNumber.addActionListener(new EnterCustomerSerachText());
		
		JLabel label = new JLabel("회원 정보 검색: ");
				
		label.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		label.setForeground(Color.white);		
		CustomerPhoneNumber.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		CustomerPhoneNumber.setForeground(new Color(220,220,220));
			
		panel.add(label);
		panel.add(CustomerPhoneNumber);	
		panel.add(btn);
	
		
		panel.setBackground(new Color (43,51,62));
		add(new TopBar(jf, this));
		
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		
		// JTable header
		String[] header = {"회원ID","회원 이름", "회원 주소", "회원 연락처","회원 포인트"};
		
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
		pane.setLocation(30, 150);
		pane.setSize(1200,300);
		
		JButton join = new MemberJoin("회원 등록");
		join.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		join.setLocation(70, 500);
		join.setSize(300,100);
		join.setForeground(new Color(153, 153, 255));
		
		JButton modify = new MemberModify("회원 수정");
		modify.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		modify.setLocation(480, 500);
		modify.setSize(300,100);
		modify.setForeground(new Color(153, 255, 153));
		
		JButton remove = new MemberRemove("회원 삭제");
		remove.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		remove.setLocation(890, 500);
		remove.setSize(300,100);
		remove.setForeground(new Color(255, 204, 204));
		
		panel2.add(join);
		panel2.add(modify);
		panel2.add(remove);
		panel2.add(pane);
		panel2.setBackground(new Color(43, 51, 62));				
		content_panel.add(panel);
		content_panel2.add(panel2);
		
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
		
		join.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				new Join();
				
			}
		});
		modify.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				new CustomerUpdate();
				
			}
		});
		
		remove.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				new Customer_Delete();
				
			}
		});
		
		table.addMouseListener(new ClickReceipt());
		
		setSize(jf.getWidth(), jf.getHeight());
		setLocation(jf.getX(), jf.getY());
		
//		setBounds(500, 50, 1280, 720);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	private void add(ClickMain cm) {
		// TODO Auto-generated method stub
		
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


class Search extends RoundedButton{
	public Search(String name) {
		super(name);
		super.c = new Color(245, 173, 37); 
		setHorizontalAlignment(JLabel.CENTER);
		setFont(new Font("맑은 고딕", Font.BOLD, 20));
	}
}

class MemberJoin extends RoundedButton{
	public MemberJoin(String name) {
		super(name);
		super.c = new Color(153, 153, 255); 
		setHorizontalAlignment(JLabel.CENTER);
		setFont(new Font("맑은 고딕", Font.BOLD, 20));
	}
}

class MemberModify extends RoundedButton{
	public MemberModify(String name) {
		super(name);
		super.c = new Color(153, 255, 153); 
		setHorizontalAlignment(JLabel.CENTER);
		setFont(new Font("맑은 고딕", Font.BOLD, 20));
	}
}

class MemberRemove extends RoundedButton{
	public MemberRemove(String name) {
		super(name);
		super.c = new Color(255, 000, 102); 
		setHorizontalAlignment(JLabel.CENTER);
		setFont(new Font("맑은 고딕", Font.BOLD, 20));
	}
}

