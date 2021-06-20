package view.stock.nextFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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

import function.stock.InsertDB_product;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import view.stock.Button_round_search;
import view.stock.ConnectDB;
import view.stock.DateCheckAction;

public class Product_regist extends JFrame{
	
	JFrame jf;
	JTextField jTextField;
	JTextField jTextField2;
	JTextField jTextField3;
	JTextField jTextField4;
	
	UtilDateModel modelStart ;
	JDatePanelImpl datePanelStart;	
	JDatePickerImpl datePickerStart;
	
	JComboBox<String> jComboBoxProductType; 
	JComboBox<String> jComboBoxEvent; 
	JComboBox<String> jComboBoxSalesType;
	
	String date;
	
	ArrayList<Component> comArr;
	public Product_regist(JFrame jf) {//JFrame jf
		// TODO Auto-generated constructor stub
		this.jf = jf;
		
		setTitle("물품등록");
		
		JPanel top = new JPanel();
		JPanel center = new JPanel();
		
		top.setLayout(null);
		
		//뒤로가기버튼 생성및 뒤로가기 기능
		JButton backButton = new BackButton();
//		backButton.addActionListener(new BackToStock(jf, this));
//		top.add(backButton, BorderLayout.WEST);
		
		JLabel logo = new JLabel();
		logo.setIcon(new ImageIcon("./files/품목등록.png"));
		logo.setBounds(20, 20, 350, 70);
		top.add(logo);
		
		top.setBackground(new Color(255,255,204));
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
		JLabel jLabel3 = new JLabel("품목가격");
		JLabel jLabel4 = new JLabel("유통기한");
		JLabel jLabel5 = new JLabel("행사유형");	//행사 유형 고르면 할인율 자동적용
		JLabel jLabel6 = new JLabel("판매유형"); //GRAM or STOCKS 로 나뉨
		JLabel jLabel7 = new JLabel("원산지"); 
		JLabel jLabel8 = new JLabel("품목원가");
		
		jTextField = new JTextField(20);
		jTextField2 = new JTextField(20);
		jTextField3 = new JTextField(20);
		jTextField4 = new JTextField(20);
		
		modelStart = new UtilDateModel();
		datePanelStart = new JDatePanelImpl(modelStart);	
		datePickerStart = new JDatePickerImpl(datePanelStart);
		
		
		//콤보박스에 타입내용 확정을 위한 메소드
		
		ArrayList<String> typeArr = new ConnectDBgetData("PRODUCT_TYPE",null).getColumnArr();
		ArrayList<String> eventArr = new ConnectDBgetData("DISCOUNT_TYPE",null).getColumnArr();
		
		String[] types = new String[typeArr.size()+1]; //콤보박스에 넣을 스트링배열생성
		String[] event = new String[eventArr.size()+1]; 
		event[0] = "선택안함";
		
		
		for(int i = 0; i < typeArr.size(); i++) { //스트링배열에 타입에 관한 내용 넣기
			types[i] = typeArr.get(i);
		}
		for(int i = 0; i < eventArr.size(); i++) { //스트링배열에 타입에 관한 내용 넣기
			event[i+1] = eventArr.get(i);
		}
//		System.out.println("types배열 : " + Arrays.toString(types));
//		System.out.println("eventArr배열 : " + Arrays.toString(event));
		types[typeArr.size()] = "직접입력";
		
		jComboBoxProductType = new JComboBox<String>(types); 
		jComboBoxEvent = new JComboBox<String>(event); 
		jComboBoxSalesType = new JComboBox<String>(new String[] {"무게", "개수"});
		
		JRadioButton radioBtn1 = new JRadioButton("개수");
		JRadioButton radioBtn2 = new JRadioButton("무게");
		
		JButton jButton = new Button_round_search("등록");
		
		JTextField jtf = new JTextField();
		jtf.setBounds(445, 13, 160, 37);
		jtf.setVisible(false);
		
		datePickerStart.addActionListener(new DateCheckAction(modelStart));
		
		jComboBoxProductType.addActionListener(new ComboBoxActions(jComboBoxProductType, jtf));
		
		date = new DateCheckAction(modelStart).getExpiryDate();
		JTextField jTextFieldDate = new JTextField(date);
		
		comArr = new ArrayList<>();
		comArr.add(jTextField);
		comArr.add(jTextField2);
		comArr.add(jTextFieldDate);
		comArr.add(jComboBoxProductType);
		comArr.add(jComboBoxEvent);
		comArr.add(jComboBoxSalesType);
		
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
		//가격과 텍스트필드
		JPanel border2 = new JPanel();
		new Panel_titleBorder(border2);
		border2.setBounds(30, 120, 650, 62);
		center.add(border2);
		
		new Regist_layout(jLabel3);
		jLabel3.setLocation(30,13);
		new Regist_layout2(jTextField2);
		jTextField2.setLocation(100,13);
	
		//유통기한과 달력
		new Regist_layout(jLabel4);
		jLabel4.setLocation(370,13);
		new Regist_layout2(datePickerStart);
		datePickerStart.setSize(180,27);
		datePickerStart.setLocation(445,20);


		//-------------------------------------
		//행사유형과 콤보박스
		JPanel border3 = new JPanel();
		new Panel_titleBorder(border3);
		border3.setBounds(30, 220, 650, 62);
		center.add(border3);
		
		new Regist_layout(jLabel5);
		jLabel5.setLocation(30,13);
		new Regist_layout2(jComboBoxEvent);
		jComboBoxEvent.setLocation(100,13);
		
		
		
		//-------------------------------------
		//판매타입과 라디오버튼
		
		JPanel radioBorder = new JPanel();
		radioBorder.setBorder(new TitledBorder(new LineBorder(new Color(101,111,121),2)));
		border3.add(radioBorder);
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
		
		new Regist_layout(jLabel6);
		jLabel6.setLocation(370,13);
        new Regist_layout(jLabel5);
		jLabel5.setLocation(30,13);
		new Regist_layout2(radioBtn1);
		radioBtn1.setSize(55, 35);
		radioBtn1.setLocation(25,4);
		new Regist_layout2(radioBtn2);
		radioBtn2.setSize(55, 35);
		radioBtn2.setLocation(100,4);
		
		//
		JPanel border4 = new JPanel();
		new Panel_titleBorder(border4);
		border4.setBounds(30, 320, 650, 62);
		center.add(border4);
		
		new Regist_layout(jLabel7);
		jLabel7.setLocation(30,13);
		new Regist_layout2(jTextField3);
		jTextField3.setLocation(100,13);

		new Regist_layout(jLabel8);
		jLabel8.setLocation(370,13);
		new Regist_layout2(jTextField4);
		jTextField4.setLocation(445, 13);
		
		
		//검색버튼
		jButton.setLocation(300,420);
		jButton.setSize(100, 35);
		jButton.setVisible(true);
		
		//버튼의 액션
		jButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String sql;
				
				
				String name = jTextField.getText();
				Object productType = jComboBoxProductType.getSelectedItem();
				String price = jTextField2.getText();
				String expiryDay = modelStart.getYear() + "-" + modelStart.getMonth() + "-" + modelStart.getDay();
				Object event = jComboBoxEvent.getSelectedItem();
				String origin = jTextField3.getText();
				String cost = jTextField4.getText();
				String salesType;
				if(productType.equals("직접입력")) {
					productType = jtf.getText();
				}
				if(radioBtn1.isSelected()) {
					
					salesType = radioBtn1.getText();
				}else {
					salesType = radioBtn2.getText();
					
				}
				String stock;
				String weight;
				if(salesType.equals("무게")) {
					
					weight = JOptionPane.showInputDialog("무게를 입력하세요");
					stock = null;
				}else {
					stock = JOptionPane.showInputDialog("개수를 입력하세요");
					weight = null;
					
				}
				
				int yes = JOptionPane.showConfirmDialog(null, "등록하시겠습니까?", "등록알림창", JOptionPane.YES_NO_OPTION);
				if(yes == JOptionPane.YES_OPTION) {
					
					String discountRateSql = "SELECT DISTINCT DISCOUNT_RATE FROM PRODUCTS WHERE DISCOUNT_TYPE = \'" + event + "\'";
					String sequenceSql = "SELECT MAX(PRODUCT_ID) AS PRODUCT_ID FROM PRODUCTS";
					
					ConnectDB con = new ConnectDB(discountRateSql);
					Double discountRate = con.getResultRate();
					ConnectDB con2 = new ConnectDB(sequenceSql);
					int sequenceID = con2.getResultID() + 1;
					
					if(name.equals("")) {
						name = null;
					}
					if(String.format(price).equals("")) {
						price = null;
					}
					if(origin.equals("")) {
						origin = null;
					}
					if(stock != null) {
						if(stock.equals("")) {
							stock = null;
						}					
					}
					if(weight != null) {
						if(weight.equals("")) {
							weight = null;
						}					
					}
					if(cost.equals("")) {
						cost = null;
					}

					sql = "INSERT INTO PRODUCTS VALUES(" +sequenceID+",\'" + name +"\',\'"+productType+"\',"+price+",\'"+expiryDay+"\',\'" 
							+event+ "\'," +discountRate+ ",\'" +origin+ "\'," +stock+ "," +weight+ ",\'" +salesType+ "\'," +cost+ ")"; 
					
					new InsertDB_product(sql);
				}
			}
			
		});
		border1.add(jtf);

		border1.add(jLabel);
		border1.add(jTextField);
		border1.add(jLabel2);
		border1.add(jComboBoxProductType);
		
		border2.add(jLabel3);
		border2.add(jTextField2);
		border2.add(jLabel4);
		border2.add(datePickerStart);
		
		border3.add(jLabel5);
		border3.add(jComboBoxEvent);
		border3.add(jLabel6);
		
		border4.add(jLabel7);
		border4.add(jTextField3);
		border4.add(jLabel8);
		border4.add(jTextField4);
		
		center.add(jButton);
		
		//판넬 색상
		center.setBackground(new Color(255,255,204));
		border1.setBackground(new Color(255,255,164));
		border1.setBorder(new TitledBorder(new LineBorder(new Color(255,255,0),2)));
		border2.setBackground(new Color(255,255,164));
		border2.setBorder(new TitledBorder(new LineBorder(new Color(255,255,0),2)));
		border3.setBackground(new Color(255,255,164));
		border3.setBorder(new TitledBorder(new LineBorder(new Color(255,255,0),2)));
		border4.setBackground(new Color(255,255,164));
		border4.setBorder(new TitledBorder(new LineBorder(new Color(255,255,0),2)));
		
		//판넬 2개 프레임에 추가
		add(top, BorderLayout.NORTH);
		add(center);

		setSize(725,620);
		setLocation(200,100);
		setVisible(true);
	}

}
