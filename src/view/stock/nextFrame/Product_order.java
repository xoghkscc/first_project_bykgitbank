package view.stock.nextFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import view.stock.Button_round_search;

public class Product_order extends JFrame{
	
	JFrame jf;
	JTextField jTextField;
	JTextField jTextField2;
	
	JComboBox<String> jComboBoxProductType; 
	
	public Product_order(JFrame jf) {

		this.jf = jf;
		
		setTitle("물품주문");
		
		JPanel top = new JPanel();
		JPanel center = new JPanel();
		
		top.setLayout(null);
		
		//뒤로가기버튼 생성및 뒤로가기 기능
		JButton backButton = new BackButton();
//		backButton.addActionListener(new BackToStock(jf, this));
//		top.add(backButton, BorderLayout.WEST);
		
		JLabel logo = new JLabel();
		logo.setIcon(new ImageIcon("./files/품목주문.png"));
		logo.setBounds(20, 20, 350, 70);
		top.add(logo);
		
		top.setBackground(new Color(43,51,62));
		top.setPreferredSize(new Dimension(203,90));
//		top.setSize(50, 100);
		top.setVisible(true);
		

//		center.setLayout(new FlowLayout(FlowLayout.RIGHT));
		center.setLayout(null);
		center.setSize(new Dimension(400,300));
		center.setLocation(20, 20);
		center.setVisible(true);
		
		JLabel jLabel = new JLabel("품목이름");
		JLabel jLabel2 = new JLabel("품목유형");	//콤보박스
		JLabel jLabel3 = new JLabel("원산지");
		JLabel jLabel4 = new JLabel("판매유형");
		
		jTextField = new JTextField(20);
		jTextField2 = new JTextField(20);

		
		
		//콤보박스에 타입내용 확정을 위한 메소드
		
		ArrayList<String> typeArr = new ConnectDBgetData("PRODUCT_TYPE",null).getColumnArr();
		
		String[] types = new String[typeArr.size() + 1]; //콤보박스에 넣을 스트링배열생성
		types[0] = "선택안함";
		
		for(int i = 0; i < typeArr.size(); i++) { //스트링배열에 타입에 관한 내용 넣기
			types[i+1] = typeArr.get(i);
		}
	
		System.out.println("types배열 : " + Arrays.toString(types));
		
		jComboBoxProductType = new JComboBox<String>(types); 
		
		JRadioButton radioBtn1 = new JRadioButton("개수");
		JRadioButton radioBtn2 = new JRadioButton("무게");
		
		JButton jButton = new Button_round_search("주문");
		
	
		jComboBoxProductType.addActionListener(new ComboBoxActions(jComboBoxProductType, null));
		

		//위치조정
		//품목이름과 필드
		
		JPanel border1 = new JPanel();
		new Panel_titleBorder(border1);
		border1.setBounds(30, 20, 650, 62);
		center.add(border1);
		
		new Regist_layout(jLabel);
		jLabel.setLocation(30,13);
		new Regist_layout2(jTextField);
		jTextField.setLocation(100,13);

		//품목유형과 콤보박스
		new Regist_layout(jLabel2);
		jLabel2.setLocation(370,13);
		new Regist_layout2(jComboBoxProductType);
		jComboBoxProductType.setLocation(445, 13);


		//-------------------------------------
		//행사유형과 콤보박스
		JPanel border2 = new JPanel();
		new Panel_titleBorder(border2);
		border2.setBounds(30, 120, 650, 62);
		center.add(border2);
		

		
		
		
		//-------------------------------------
		//판매타입과 라디오버튼
		
		JPanel radioBorder = new JPanel();
		radioBorder.setBorder(new TitledBorder(new LineBorder(new Color(101,111,121),2)));
		border2.add(radioBorder);
		radioBorder.setLayout(null);
		radioBorder.setSize(180, 45);
		radioBorder.setLocation(445, 9);
		radioBorder.setVisible(true);
		
		ButtonGroup radioGroup = new ButtonGroup();
		
		radioBtn1.setForeground(Color.BLACK);
		radioBtn2.setForeground(Color.BLACK);
		
		radioGroup.add(radioBtn1);
		radioGroup.add(radioBtn2);
		radioBorder.add(radioBtn2);
		radioBorder.add(radioBtn1);
		
		new Regist_layout(jLabel3);
		jLabel3.setLocation(30,13);
		new Regist_layout2(jTextField2);
		jTextField2.setLocation(100,13);
        new Regist_layout(jLabel4);
		jLabel4.setLocation(370,13);
		new Regist_layout2(radioBtn1);
		radioBtn1.setSize(55, 35);
		radioBtn1.setLocation(25,4);
		new Regist_layout2(radioBtn2);
		radioBtn2.setSize(55, 35);
		radioBtn2.setLocation(100,4);
		
		
		//검색버튼
		jButton.setLocation(300,220);
		jButton.setSize(100, 35);
		jButton.setVisible(true);
		
		
		//버튼의 액션
		jButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String sql;
				
				
				String name = jTextField.getText();
				String origin = jTextField2.getText();
				String salesType;
				String productType = (String) jComboBoxProductType.getSelectedItem();
				if(radioBtn1.isSelected()) {
					
					salesType = radioBtn1.getText();
				}else {
					salesType = radioBtn2.getText();
					
				}
				if(productType.equals("선택안함")) {
					productType = null;
				
				}
				
				
				
				String stock;
				if(salesType.equals("무게")) {
					
					stock = JOptionPane.showInputDialog("무게를 입력하세요");
					
				}else {
					stock = JOptionPane.showInputDialog("개수를 입력하세요");
				
					
				}
				String pop = "품목이름 : " +name+ "\n품목유형 : " +productType+ "\n원산지 : " +origin+ "\n판매유형 및 양: " +salesType+ ", " +stock;
				JOptionPane.showMessageDialog(radioBorder, pop, "주문완료!",1);
			}
			
		});
		
//		jButton.addActionListener(new SearchAction(jButton, comArr));
		
		border1.add(jLabel);
		border1.add(jTextField);
		border1.add(jLabel2);
		border1.add(jComboBoxProductType);
		
		
		border2.add(jLabel3);
		border2.add(jTextField2);
		border2.add(jLabel4);
	
		
		center.add(jButton);
		
		//판넬 색상
		center.setBackground(new Color(43,51,62));
		border1.setBackground(new Color(193,201,212));
		border1.setBorder(new TitledBorder(new LineBorder(new Color(255,255,100),2)));
		border2.setBackground(new Color(193,201,212));
		border2.setBorder(new TitledBorder(new LineBorder(new Color(255,255,100),2)));
		
		//판넬 2개 프레임에 추가
		add(top, BorderLayout.NORTH);
		add(center);
		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setSize(725,420);
		setLocation(200,100);
		setVisible(true);
	}

}
