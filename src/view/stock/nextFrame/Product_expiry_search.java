package view.stock.nextFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import view.stock.Button_round_search;
import view.stock.Table_make;

public class Product_expiry_search extends JFrame{

	JFrame jf;
	Object expiryDatePeriod = "1일이내";
	String number;
	
	public Product_expiry_search(JFrame jf, String num) {//JFrame jf, String num

		this.jf = jf;
		this.number = num;
		
		setTitle("유통기한조회");
		
		JPanel topPanel = new JPanel();
		topPanel.setBounds(10, 30, 290, 80);
		topPanel.setBackground(new Color(43,51,62));
		topPanel.setLayout(null);
		
		//뒤로가기버튼 생성및 뒤로가기 기능
		JButton backButton = new BackButton();
//		backButton.addActionListener(new BackToStock(jf, this));
//		top.add(backButton, BorderLayout.WEST);
		
		JLabel logo = new JLabel();
		logo.setIcon(new ImageIcon("./files/유통기한조회.png"));
		logo.setBounds(10, 20, 350, 70);
		topPanel.add(logo);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(null);
		centerPanel.setSize(new Dimension(600,600));
		centerPanel.setLocation(40, 100);
//		centerPanel.setBackground(Color.YELLOW);
		centerPanel.setVisible(true);

		JPanel centerPanel_topPanel = new JPanel();
		JPanel tablePanel = new JPanel();
		
		JLabel selectDate = new JLabel("남은기간의 범위를 선택하세요");
		JComboBox<String> jComboBoxExpiryDate = new JComboBox<String>(new String[] {"범위선택", "1일이내","3일이내", "7일이내", "15일이내", "30일이내"});
		JButton searchButton = new Button_round_search("검색");
		
		//텍스트필드(남은기간범위선택), 콤보박스 위치설정
		selectDate.setForeground(new Color(255,255,100));
		selectDate.setSize(250,50);
		selectDate.setLocation(45, 0);
		selectDate.setVisible(true);
		selectDate.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		
		jComboBoxExpiryDate.setSize(130, 40);
		jComboBoxExpiryDate.setLocation(40, 45);
		jComboBoxExpiryDate.setVisible(true);	
		jComboBoxExpiryDate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				expiryDatePeriod = jComboBoxExpiryDate.getSelectedItem();

			}
		});
		
		searchButton.setSize(65, 40);
		searchButton.setLocation(175, 45);
		searchButton.setForeground(new Color(0,0,0));
		searchButton.setVisible(true);
		searchButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				number = "";
				if(expiryDatePeriod.equals("범위선택")) {
					number = "0";
				}else if(expiryDatePeriod.equals("1일이내")) {
					number = "1";
				}else if(expiryDatePeriod.equals("3일이내")) {
					number = "3";
				}else if(expiryDatePeriod.equals("7일이내")) {
					number = "7";
				}else if(expiryDatePeriod.equals("15일이내")) {
					number = "15";
				}else if(expiryDatePeriod.equals("30일이내")) {
					number = "30";
				}

				new Product_expiry_search(jf, number);
				setVisible(false);
			}
			
		});
		
		//center_top 판넬 위치설정
		centerPanel_topPanel.setBackground(new Color(43,51,62));
		centerPanel_topPanel.setBorder(new TitledBorder(new LineBorder(new Color(255,255,100),5)));
		centerPanel_topPanel.setSize(275, 100);
		centerPanel_topPanel.setLocation(315, 18);
		centerPanel_topPanel.setLayout(null);
		
		centerPanel_topPanel.add(selectDate);
		centerPanel_topPanel.add(jComboBoxExpiryDate);
		centerPanel_topPanel.add(searchButton);
		
		//ceter_ceter 판넬 위치설정
		tablePanel.setSize(870, 490);
		tablePanel.setLocation(20, 130);
		tablePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
//		tablePanel.setBorder(new TitledBorder(new LineBorder(new Color(255,0,0),2)));
		System.out.println(expiryDatePeriod);
		System.out.println(number);
		
		tablePanel.add(new Table_make("SELECT * FROM PRODUCTS WHERE EXPIRATION_DATE BETWEEN SYSDATE AND SYSDATE + " + number,null,null)); //컴보박스에서 나오는 날짜 입력
		tablePanel.setVisible(true);
		
		centerPanel.setBorder(new TitledBorder(new LineBorder(new Color(255,255,100),5)));
		centerPanel.add(centerPanel_topPanel);
		centerPanel.add(tablePanel, BorderLayout.SOUTH);
		
		centerPanel.setBackground(new Color(43,51,62));
//		centerPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
//		centerPanel.setForeground(Color.YELLOW);
		add(topPanel);
		add(centerPanel);
		setSize(925,680);
		setLocation(100,40);
		setVisible(true);
	}
//	public static void main(String[] args) {
//		new Product_expiry_search();
//	}
}
