package view.Members;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import view.stock.DateCheckAction;

public class ReceiptSearch extends JFrame {

	private static JTable table;
	private static DefaultTableModel model;
	
	public ReceiptSearch(int member_id) {
		super ("회원 영수증 조회");
		
		JPanel panel1 = new JPanel();
		
		panel1.setLayout(null);
		
		UtilDateModel modelStart = new UtilDateModel();
		UtilDateModel modelEnd = new UtilDateModel();
		
		JDatePanelImpl datePanelStart = new JDatePanelImpl(modelStart);
		JDatePanelImpl datePanelEnd = new JDatePanelImpl(modelEnd);
		
		JDatePickerImpl datePickerStart = new JDatePickerImpl(datePanelStart);
		JDatePickerImpl datePickerEnd = new JDatePickerImpl(datePanelEnd);
		
		//데이트 피커 안의 글자 
		datePickerStart.getJFormattedTextField().setText("  구입한 날짜를 입력해주세요");
		datePickerStart.getJFormattedTextField().setForeground(new Color(145,145,145));
		datePickerStart.setBounds(40,40,300,25);
		datePickerStart.getJFormattedTextField().setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		
		datePickerEnd.getJFormattedTextField().setText("  마지막날짜를 선택하세요");
		datePickerEnd.getJFormattedTextField().setForeground(new Color(145,145,145));
		datePickerEnd.setBounds(290,40,200,25);
		datePickerEnd.getJFormattedTextField().setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		
		JTextField field = new JTextField("조회할 물품을 입력해주세요");
		field.setBounds(40,80, 300,25);
		field.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		field.setForeground(new Color(145,145,145));
		
		JButton btn = new MemberJoin("검색");
		btn.setBounds(360,80, 50,25);
		btn.setForeground(new Color(245, 173, 37));
		
		String[] header = {"물건을 구입한 날짜", "결제 금액"};
		
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
		pane.setLocation(40, 120);
		pane.setSize(500,400);
		
		
		datePickerStart.setPreferredSize(new Dimension(203,28)); //Layout 이 있을때 크기조절
		datePickerEnd.setPreferredSize(new Dimension(203,28));
		
		DateCheckAction dc = new DateCheckAction(modelStart);
		DateCheckAction dc2 = new DateCheckAction(modelEnd);
		
		//DateCheckAction 
		datePickerStart.addActionListener(dc);
		datePickerEnd.addActionListener(dc2);
		
		panel1.add(datePickerStart);
		//panel1.add(datePickerEnd);
		panel1.add(field);
		panel1.add(btn);
		panel1.add(pane);
		panel1.setSize(1280,70);
		panel1.setLocation(50,50);
		panel1.setBackground(new Color(43,51 ,62));
		
		getContentPane().add(panel1);
		setBounds(500,50,600,600);
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
			field.addMouseListener(mm);
				
		}

	public static DefaultTableModel getModel() {
		return model;
	}
	public static JTable getTable() {
		return table;
	}
}
