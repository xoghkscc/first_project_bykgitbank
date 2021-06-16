package view.stock.nextFrame.productEvent;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import function.stock.InsertDB_product;
import view.Payment.lowPanel.RoundedButton;

public class UpdateFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	RowInfo data;
	String doit;
	public UpdateFrame(RowInfo data) {
		this.data = data;


		setLayout(null);
		setBounds(100, 100, 480, 590);
		setVisible(true);
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(null);
		
		leftPanel.setBounds(0, 0, 240, 500);
		rightPanel.setBounds(240, 0, 240, 500);
		bottomPanel.setBounds(0, 480, 480, 80);
		
		add(leftPanel);
		add(rightPanel);
		add(bottomPanel);
		
		JButton jb = new roundButton_updateEvent3("수정");
		jb.setBounds(200, 20, 70, 30);
		bottomPanel.add(jb);

		JTextField tf1 = new JTextField(String.format("%d",data.product_id));
		JTextField tf2 = new JTextField(data.product_name);
		JTextField tf3 = new JTextField(data.product_type);
		JTextField tf4 = new JTextField(String.format("%d",data.price));
		JTextField tf5 = new JTextField(data.expiration_date.toString());
		JTextField tf6 = new JTextField(data.discount_type);
		JTextField tf7 = new JTextField(Double.toString(data.discount_rate));
		JTextField tf8 = new JTextField(data.product_origin);
		JTextField tf9 = new JTextField(String.format("%d",data.stocks));
		JTextField tf10 = new JTextField(String.format("%d",data.gram));
		JTextField tf11 = new JTextField(data.sales_type);
		JTextField tf12 = new JTextField(String.format("%d",data.cost));
		
		//검색버틍
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String discountTypeSql;
				if(tf6.getText().equals("")) {
					discountTypeSql = "";
				}else {
					discountTypeSql = "DISCOUNT_TYPE = \'" +tf6.getText()+ "\', ";
				}
				
				String sql = "UPDATE PRODUCTS SET "+
							"PRODUCT_NAME = \'" +tf2.getText()+ "\', " +
							"PRODUCT_TYPE = \'" +tf3.getText()+ "\', " +
							"PRODUCT_PRICE = " +tf4.getText()+ ", " +
							"EXPIRATION_DATE = \'" +tf5.getText()+ "\', " +
							discountTypeSql +
							"DISCOUNT_RATE = " +tf7.getText()+ ", " +
							"PRODUCT_ORIGIN = \'" +tf8.getText()+ "\', " +
							"STOCKS = " +tf9.getText()+ ", " +
							"GRAM = " +tf10.getText()+ ", " +
							"SALES_TYPE = \'" +tf11.getText()+ "\', " +
							"COST = " +tf12.getText() +
							" WHERE PRODUCT_ID = " +tf1.getText();
				
				System.out.println("sql슝 : " + sql);
				
				new InsertDB_product(sql);
			}
			
		});
		
		leftPanel.setLayout(null);
		leftPanel.setBackground(new Color(0,36,62));
		rightPanel.setLayout(null);
		rightPanel.setBackground(new Color(0,36,62));
		bottomPanel.setBackground(new Color(0,36,62));
	
		
		JPanel jl1 = new JPanel();
		new PanelShape(jl1, "품목번호");
			jl1.setBounds(40, 20, 160, 60);
			
		JPanel jl2 = new JPanel();
		new PanelShape(jl2, "품목이름");
			jl2.setBounds(40, 100, 160, 60);

		JPanel jl3 = new JPanel();
		new PanelShape(jl3, "품목유형");
			jl3.setBounds(40, 180, 160, 60);

		JPanel jl4 = new JPanel();
		new PanelShape(jl4, "품목가격");
			jl4.setBounds(40, 260, 160, 60);

		JPanel jl5 = new JPanel();
		new PanelShape(jl5, "유통기한");
			jl5.setBounds(40, 340, 160, 60);

		JPanel jl6 = new JPanel();
		new PanelShape(jl6, "행사유형");
			jl6.setBounds(40, 420, 160, 60);

		JPanel jl7 = new JPanel();
		new PanelShape(jl7, "할인율");
			jl7.setBounds(40, 20, 160, 60);
	
		JPanel jl8 = new JPanel();
		new PanelShape(jl8, "원산지");
			jl8.setBounds(40, 100, 160, 60);

		JPanel jl9 = new JPanel();
		new PanelShape(jl9, "개수");
			jl9.setBounds(40, 180, 160, 60);
	
		JPanel jl10 = new JPanel();
		new PanelShape(jl10, "무게");
			jl10.setBounds(40, 260, 160, 60);

		JPanel jl11 = new JPanel();
		new PanelShape(jl11, "판매유형");
			jl11.setBounds(40, 340, 160, 60);

		JPanel jl12 = new JPanel();
		new PanelShape(jl12, "원가");
			jl12.setBounds(40, 420, 160, 60);
		//===========================================================
		
		jl1.setLayout(null);
		jl2.setLayout(null);
		jl3.setLayout(null);
		jl4.setLayout(null);
		jl5.setLayout(null);
		jl6.setLayout(null);
		jl7.setLayout(null);
		jl8.setLayout(null);
		jl9.setLayout(null);
		jl10.setLayout(null);
		jl11.setLayout(null);
		jl12.setLayout(null);
		
		leftPanel.add(jl1);
		leftPanel.add(jl2);
		leftPanel.add(jl3);
		leftPanel.add(jl4);
		leftPanel.add(jl5);
		leftPanel.add(jl6);
		
		rightPanel.add(jl7);
		rightPanel.add(jl8);
		rightPanel.add(jl9);
		rightPanel.add(jl10);
		rightPanel.add(jl11);
		rightPanel.add(jl12);
		
		jl1.add(new fieldShape(tf1).getF());
		jl2.add(new fieldShape(tf2).getF());
		jl3.add(new fieldShape(tf3).getF());
		jl4.add(new fieldShape(tf4).getF());
		jl5.add(new fieldShape(tf5).getF());
		jl6.add(new fieldShape(tf6).getF());
		jl7.add(new fieldShape(tf7).getF());
		jl8.add(new fieldShape(tf8).getF());
		jl9.add(new fieldShape(tf9).getF());
		jl10.add(new fieldShape(tf10).getF());
		jl11.add(new fieldShape(tf11).getF());
		jl12.add(new fieldShape(tf12).getF());
	}
	
}
class PanelShape{
	JPanel j;
	String name;
	public PanelShape(JPanel j, String name) {
		this.name = name;
		
		j.setBounds(40, 20, 160, 60);
		j.setBackground(new Color(0,36,62));
		TitledBorder tb1 = new TitledBorder(new LineBorder(new Color(255,255,200), 5),name);
		tb1.setTitleFont(new Font("맑은샘물체", Font.PLAIN, 13));
		tb1.setTitleColor(new Color(255,230,140));
		j.setBorder(tb1);
	}
	public JPanel getJ() {
		return j;
	}
}
class fieldShape{
	JTextField f;
	public fieldShape(JTextField f) {
		this.f = f;
		f.setSize(130, 30);
		f.setLocation(15, 20);
		f.setFont(new Font("맑은샘물체", Font.PLAIN, 15));
	}
	public JTextField getF() {
		return f;
	}
}
class roundButton_updateEvent3 extends RoundedButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public roundButton_updateEvent3(String name) {
		super(name);
		super.c = new Color(255,255,150); 
		super.o = new Color(0,36,62);
		setHorizontalAlignment(JLabel.CENTER);
		setFont(new Font("맑은 고딕", Font.BOLD, 15));
	}
}