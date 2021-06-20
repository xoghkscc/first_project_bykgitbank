package view.store.leftMenu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.store.centerPanel.Employee_enrollment;
import view.store.centerPanel.StoreLookup;


public class LeftPanel extends JPanel{
	private static JFrame storeMainFrame;
	private static JPanel leftPanel;
	private static JPanel Employee_enrollment;
	
	private static JLabel employee;
	private static JLabel sales;
	private static JLabel employee_lookup;
	private static JLabel date_sales;
	private static JLabel item_search;
	
	public LeftPanel(JFrame storeMainFrame) {
		leftPanel = this;
		this.storeMainFrame = storeMainFrame;
		setPreferredSize(new Dimension(130, 100));
		setLayout(new GridLayout(7, 1, 15, 5));
		setBackground(new Color(153, 153, 153));
		
		employee = new MainLabel(" 직원 관리");
		employee.addMouseListener(new ClickAction(employee));
		
		sales = new MainLabel(" 매출 관리");
		sales.addMouseListener(new ClickAction(sales));
		
		Employee_enrollment = new Employee_enrollment();
		JPanel StoreLookup1 = new StoreLookup("date");
		JPanel StoreLookup2 = new StoreLookup("product");
		
		employee_lookup = new SubLabel("직원 관리");
		employee_lookup.addMouseListener(new SubClickAction(Employee_enrollment, StoreLookup1, StoreLookup2) {
		});
		date_sales = new SubLabel("날짜별 매출 조회");
		date_sales.addMouseListener(new SubClickAction(StoreLookup1, Employee_enrollment, StoreLookup2));
		
		item_search = new SubLabel("품목별 매출 조회");
		item_search.addMouseListener(new SubClickAction(StoreLookup2, Employee_enrollment, StoreLookup1));
		
		add(employee);
		
		employee.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				LeftPanel.getLeftPanel().remove(sales);
				if(employee_lookup.isVisible()) {
					LeftPanel.getLeftPanel().remove(employee_lookup);
					employee_lookup.setVisible(false);
					LeftPanel.getEmployee().setFont(new Font("맑은 고딕", Font.PLAIN, 14));
				}else {
					LeftPanel.getLeftPanel().remove(date_sales);
					LeftPanel.getLeftPanel().remove(item_search);
					date_sales.setVisible(false);
					item_search.setVisible(false);
					LeftPanel.getLeftPanel().add(employee_lookup);
					employee_lookup.setVisible(true);
				}
				LeftPanel.getLeftPanel().add(sales);
				LeftPanel.getLeftPanel().repaint();//렉이 있어 새로고침
			}
		});
		add(sales);
		sales.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(date_sales.isVisible()) {
					LeftPanel.getLeftPanel().remove(date_sales);
					LeftPanel.getLeftPanel().remove(item_search);
					date_sales.setVisible(false);
					item_search.setVisible(false);
					LeftPanel.getSales().setFont(new Font("맑은 고딕", Font.PLAIN, 14));
				}else {
					LeftPanel.getLeftPanel().remove(employee_lookup);
					employee_lookup.setVisible(false);
					LeftPanel.getLeftPanel().add(date_sales);
					LeftPanel.getLeftPanel().add(item_search);
					date_sales.setVisible(true);
					item_search.setVisible(true);
				}
				LeftPanel.getLeftPanel().repaint();//렉이 있어 새로고침
			};
		});
		
	}
	
	
	public static JFrame getStoreMainFrame() {
		return storeMainFrame;
	}
	public static JPanel getEmployee_enrollment() {
		return Employee_enrollment;
	}
	public static JPanel getLeftPanel() {
		return leftPanel;
	}
	public static JLabel getEmployee() {
		return employee;
	}
	public static JLabel getSales() {
		return sales;
	}
	public static JLabel getemployee_lookup() {
		return employee_lookup;
	}
	public static JLabel getdate_sales() {
		return date_sales;
	}
	public static JLabel getitem_search() {
		return item_search;
	}
	
}


class MainLabel extends JLabel{
	public MainLabel(String name) {
		super(name+"\t ▼");
		setHorizontalAlignment(JLabel.LEFT);
		setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		
	}
}

class ClickAction extends MouseAdapter{
	JLabel main;
	public ClickAction(JLabel main) {
		this.main = main;
	}
	public void mouseClicked(MouseEvent e) {
		LeftPanel.getEmployee().setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		LeftPanel.getSales().setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		if(main.getFont().getStyle() == Font.BOLD) {
			
			main.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		}else {
			main.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		}
	}
}


class SubLabel extends JLabel{
	public SubLabel(String name) {
		super("     "+name);
		setHorizontalAlignment(JLabel.LEFT);
		setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		
	}
}

class SubClickAction extends MouseAdapter{
	JPanel rightPanel;
	JPanel sub1;
	JPanel sub2;
	public SubClickAction(JPanel rightPanel, JPanel sub1, JPanel sub2) {
		this.rightPanel = rightPanel;
		this.sub1 = sub1;
		this.sub2 = sub2;
	}
	
	public void mouseClicked(MouseEvent e) {
		if(rightPanel.isVisible() || sub1.isVisible() || sub2.isVisible()) {
			rightPanel.setVisible(false);
			sub1.setVisible(false);
			sub2.setVisible(false);
			((JLabel) e.getSource()).setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			LeftPanel.getemployee_lookup().setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			LeftPanel.getitem_search().setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			LeftPanel.getdate_sales().setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			
			((JLabel) e.getSource()).setFont(new Font("맑은 고딕", Font.BOLD, 12));
			rightPanel.setVisible(true);
			rightPanel.setPreferredSize(new Dimension(30, 50));
			LeftPanel.getStoreMainFrame().add(rightPanel, BorderLayout.CENTER);
		}else {
			rightPanel.setVisible(true);
			rightPanel.setPreferredSize(new Dimension(30, 50));
			((JLabel) e.getSource()).setFont(new Font("맑은 고딕", Font.BOLD, 12));
			LeftPanel.getStoreMainFrame().add(rightPanel, BorderLayout.CENTER);
		}
	}
}

