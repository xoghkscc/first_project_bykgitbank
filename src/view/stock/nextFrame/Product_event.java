package view.stock.nextFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import view.Payment.lowPanel.RoundedButton;
import view.stock.nextFrame.BackButton;
import view.stock.nextFrame.BackToStock;
import view.stock.nextFrame.productEvent.UpdateEvent;
import view.stock.nextFrame.type_search.type_search_buttons;

public class Product_event extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame jf;
	public static String eventName;
	public static String rate;
	
	public Product_event(JFrame jf) {
		// TODO Auto-generated constructor stub
		this.jf = jf;
		
		setLayout(null);
		
		setTitle("행사 관리");
//		JButton backButton = new BackButton();
//		backButton.addActionListener(new BackToStock(jf, this));
		
		//판넬 나누기
//		JPanel backButtonPanel = new JPanel();
		JPanel centerPanel = new JPanel();  
		
		JLabel logo = new JLabel();
		logo.setIcon(new ImageIcon("./files/logo_stock3.JPG"));
		logo.setBounds(290, 30, 170, 170);
		add(logo);
		
		
		
		centerPanel.setLayout(null);
		centerPanel.setPreferredSize(new Dimension(500,600));
		centerPanel.setSize(560,600);
		centerPanel.setLocation(0, 50);
		centerPanel.setBackground(new Color(0,32,61));
		centerPanel.setVisible(true);
		
		
		JButton registButton = new selectButton_rounded("이벤트 등록");
		registButton.setFont(new Font("맑은샘물체", Font.BOLD, 25));
		registButton.setLocation(50, 30);
		registButton.setSize(210, 200);		
		registButton.setBorderPainted(false);
		registButton.setFocusPainted(false);
		registButton.setHorizontalTextPosition(JButton.CENTER);
//		registButton.setBorder(new TitledBorder(new LineBorder(new Color(255,255,0), 13)));
		
		JButton updateButton = new selectButton_rounded("이벤트 수정");
		updateButton.setFont(new Font("맑은샘물체", Font.BOLD, 25));
		updateButton.setLocation(290, 160);
		updateButton.setSize(210, 200);
		updateButton.setBorderPainted(false);
		updateButton.setFocusPainted(false);
		updateButton .setHorizontalTextPosition(JButton.CENTER);
		
		JButton searchButton = new selectButton_rounded("이벤트 품목현황");
		searchButton.setFont(new Font("맑은샘물체", Font.BOLD, 25));
		searchButton.setLocation(50, 280);
		searchButton.setSize(210, 200);
		searchButton.setBorderPainted(false);
		searchButton.setFocusPainted(false);
		searchButton.setHorizontalTextPosition(JButton.CENTER);

		registButton.addMouseListener(new ActionMouse(registButton));
		updateButton.addMouseListener(new ActionMouse(updateButton));
		searchButton.addMouseListener(new ActionMouse(searchButton));
		
		registButton.setForeground(new Color(0,32,61));
		updateButton.setForeground(new Color(0,32,61));
		searchButton.setForeground(new Color(0,32,61));
		
		registButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			
				eventName = JOptionPane.showInputDialog("이벤트 이름을 입력하세요");
				
				String cofirmStr;
				int confirm = -5;
				
				if(eventName != null) {
					
					rate = JOptionPane.showInputDialog(eventName + "의 할인율을 입력하세요");
				}
				if(eventName != null && rate != null) {
					cofirmStr = "이벤트 이름 : " + eventName + "\n할인율 : " + rate + "\n  등록하시겠습니까?";
					
					confirm = JOptionPane.showConfirmDialog(null,cofirmStr,"이벤트 등록", JOptionPane.YES_NO_OPTION);
					if(confirm == JOptionPane.YES_OPTION) {
						
						String fullsql = "SELECT * FROM PRODUCTS WHERE DISCOUNT_TYPE IS NULL";
						
						
						new type_search_buttons(jf,null,fullsql, "registEvent");
					}
				}
				

//				new type_search_buttons
			}
			
		});
		
		updateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				new UpdateEvent();
			}
			
		});
		
		
		searchButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String fullsql = "SELECT * FROM PRODUCTS WHERE DISCOUNT_TYPE IS NOT NULL";
				
				
				new type_search_buttons(jf,null,fullsql,null);
			}
			
		});
		
		centerPanel.add(registButton);
		centerPanel.add(updateButton);
		centerPanel.add(searchButton);
		
		getContentPane().setBackground(new Color(0,32,61));
		setLayout(null);
		add(centerPanel);

//		setSize(jf.getWidth(), jf.getHeight());
//		setLocation(jf.getX(), jf.getY());
		setSize(560,610);
		setLocation(50, 50);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
//	public static void main(String[] args) {
//		new NOPE();
//	}

}
class ActionMouse  implements MouseListener {

	JButton button;
	
	public ActionMouse(JButton button) {
		// TODO Auto-generated constructor stub
		this.button = button;
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {
		button.setForeground(Color.RED.brighter());
		button.setBackground(new Color(255,255,255).brighter());
	}
	@Override
	public void mouseExited(MouseEvent e) {
		button.setForeground(new Color(215,215,215));
		button.setBackground(new Color(255,255,255).brighter());
	}
	
}

class selectButton_rounded extends RoundedButton {
	
	public selectButton_rounded(String name) {
		super(name);
		super.c = new Color(255, 200, 200); 
		super.o = new Color(43,51,62);
		setHorizontalAlignment(JLabel.CENTER);
		setFont(new Font("맑은 고딕", Font.BOLD, 20));
//		setBorderPainted(true);
//		setOpaque(true);
//		setBorder(new TitledBorder(new LineBorder(new Color(255,255,0), 50)));
	}
}