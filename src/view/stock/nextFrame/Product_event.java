package view.stock.nextFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.Payment.lowPanel.RoundedButton;
import view.stock.nextFrame.findImage.GetImage;
import view.stock.nextFrame.type_search.type_search_buttons;

public class Product_event extends JFrame{

	JFrame jf;
	
	public Product_event(JFrame jf) {
		// TODO Auto-generated constructor stub
		this.jf = jf;
		
		setLayout(null);
		
		JButton backButton = new BackButton();
		backButton.addActionListener(new BackToStock(jf, this));
		
		//판넬 나누기
		JPanel backButtonPanel = new JPanel();
		JPanel centerPanel = new JPanel();  //버튼 4개 행사등록,행사수정,행사품목현황
		
		
		backButtonPanel.setLayout(null);
		backButtonPanel.setBackground(new Color(62,154,229));
//		backButtonPanel.setPreferredSize(new Dimension(150,50));
		backButtonPanel.setSize(630, 50);
		backButtonPanel.setLocation(0, 0);
		backButtonPanel.add(backButton, BorderLayout.WEST);
		
		centerPanel.setLayout(null);
		centerPanel.setPreferredSize(new Dimension(500,600));
		centerPanel.setBackground(new Color(62,154,229));
		centerPanel.setSize(630,780);
		centerPanel.setLocation(0, 50);
		centerPanel.setVisible(true);
		
		JButton registButton = new JButton("행사등록", 
				new GetImage("./files/buttons/Waterbutton.jpg",
				0,0,210,200).getIic());
		registButton.setFont(new Font("맑은샘물체", Font.BOLD, 25));
		registButton.setForeground(new Color(215,215,215));
		registButton.setLocation(50, 10);
		registButton.setSize(210, 200);		
		registButton.setBorderPainted(false);
		registButton .setHorizontalTextPosition(JButton.CENTER);
	
		
		JButton updateButton = new JButton("행사수정", 
				new GetImage("./files/buttons/Waterbutton.jpg",
				0,0,210,200).getIic());
		updateButton.setFont(new Font("맑은샘물체", Font.BOLD, 25));
		updateButton.setForeground(new Color(215,215,215));
		updateButton.setLocation(270, 130);
		updateButton.setSize(210, 200);
		updateButton.setBorderPainted(false);
		updateButton .setHorizontalTextPosition(JButton.CENTER);
		
		JButton searchButton = new JButton("행사품목",
				new GetImage("./files/buttons/Waterbutton.jpg",
				0,0,210,200).getIic());
		searchButton.setFont(new Font("맑은샘물체", Font.BOLD, 25));
		searchButton.setForeground(new Color(215,215,215));
		searchButton.setLocation(50, 260);
		searchButton.setSize(210, 200);
		searchButton.setBorderPainted(false);
		searchButton.setHorizontalTextPosition(JButton.CENTER);
		
		registButton.addMouseListener(new Actions(registButton));
		updateButton.addMouseListener(new Actions(updateButton));
		searchButton.addMouseListener(new Actions(searchButton));
		
		searchButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String fullsql = "SELECT * FROM PRODUCTS WHERE DISCOUNT_TYPE IS NOT NULL";
				
				
				new type_search_buttons(jf,null,fullsql);
			}
			
		});
		
		
		centerPanel.add(registButton);
		centerPanel.add(updateButton);
		centerPanel.add(searchButton);
		

//		centerPanel.add(image);
		
		add(backButtonPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		
		
		setBackground(new Color(62,154,229));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setSize(jf.getWidth(), jf.getHeight());
//		setLocation(jf.getX(), jf.getY());
		setSize(530,600);
		setLocation(50, 50);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
//	public static void main(String[] args) {
//		new Product_event();
//	}
}
class Actions  implements MouseListener {

	JButton button;
	
	public Actions(JButton button) {
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
		setHorizontalAlignment(JLabel.CENTER);
		setFont(new Font("맑은 고딕", Font.BOLD, 20));
	}
}