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


public class LeftPanel extends JPanel{
	private static JFrame storeMainFrame;
	private static JPanel leftPanel;
	
	private static JLabel employee;
	private static JLabel sales;
	
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
		
		JLabel employee_lookup = new SubLabel("직원 관리");
		employee_lookup.addMouseListener(new SubClickAction(new Employee_enrollment()) {
		});
		
		JLabel date_sales = new SubLabel("날짜별 매출 조회");
		
		JLabel item_search = new SubLabel("품목별 매출 조회");
		JLabel inquiry_search = new SubLabel("매출순 조회");
		
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
					LeftPanel.getLeftPanel().remove(inquiry_search);
					date_sales.setVisible(false);
					item_search.setVisible(false);
					inquiry_search.setVisible(false);
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
					LeftPanel.getLeftPanel().remove(inquiry_search);
					date_sales.setVisible(false);
					item_search.setVisible(false);
					inquiry_search.setVisible(false);
					LeftPanel.getSales().setFont(new Font("맑은 고딕", Font.PLAIN, 14));
				}else {
					LeftPanel.getLeftPanel().remove(employee_lookup);
					employee_lookup.setVisible(false);
					LeftPanel.getLeftPanel().add(date_sales);
					LeftPanel.getLeftPanel().add(item_search);
					LeftPanel.getLeftPanel().add(inquiry_search);
					date_sales.setVisible(true);
					item_search.setVisible(true);
					inquiry_search.setVisible(true);
				}
				LeftPanel.getLeftPanel().repaint();//렉이 있어 새로고침
			};
		});
		
	}
	
	
	public static JFrame getStoreMainFrame() {
		return storeMainFrame;
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
	public SubClickAction(JPanel rightPanel) {
		this.rightPanel = rightPanel;
	}
	
	public void mouseClicked(MouseEvent e) {
		((JLabel) e.getSource()).setFont(new Font("맑은 고딕", Font.BOLD, 12));
		rightPanel.setPreferredSize(new Dimension(30, 50));
		LeftPanel.getStoreMainFrame().add(rightPanel, BorderLayout.CENTER);
	}
}

