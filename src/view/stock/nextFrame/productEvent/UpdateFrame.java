package view.stock.nextFrame.productEvent;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpdateFrame extends JFrame{
	
	RowInfo data;
	String doit;
	public UpdateFrame(RowInfo data) {//RowInfo data
		// TODO Auto-generated constructor stub
		this.data = data;


		setLayout(new GridLayout(2,1, 15, 15));
		setBounds(100, 100, 480, 200);
		setVisible(true);
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		
		add(leftPanel);
		add(rightPanel);

		leftPanel.setLayout(new GridLayout(2,6,15,15));
		rightPanel.setLayout(new GridLayout(2,6,15,15));
		
		JLabel jl1 = new JLabel("품목번호", Label.RIGHT);
		JLabel jl2 = new JLabel("품목이름", Label.RIGHT);
		JLabel jl3 = new JLabel("품목유형", Label.RIGHT);
		JLabel jl4 = new JLabel("품목가격", Label.RIGHT);
		JLabel jl5 = new JLabel("유통기한", Label.RIGHT);
		JLabel jl6 = new JLabel("행사유형", Label.RIGHT);
		
		JLabel jl7 = new JLabel("할인율", Label.RIGHT);
		JLabel jl8 = new JLabel("원산지", Label.RIGHT);
		JLabel jl9 = new JLabel("개수", Label.RIGHT);
		JLabel jl10 = new JLabel("무게", Label.RIGHT);
		JLabel jl11 = new JLabel("판매유형", Label.RIGHT);
		JLabel jl12 = new JLabel("원가", Label.RIGHT);
	
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
		//===========================================================
		leftPanel.add(new labelShape(jl1).getJ());
		leftPanel.add(new fieldShape(tf1).getF());
		leftPanel.add(new labelShape(jl2).getJ());
		leftPanel.add(new fieldShape(tf2).getF());
		leftPanel.add(new labelShape(jl3).getJ());
		leftPanel.add(new fieldShape(tf3).getF());
		leftPanel.add(new labelShape(jl4).getJ());
		leftPanel.add(new fieldShape(tf4).getF());
		leftPanel.add(new labelShape(jl5).getJ());
		leftPanel.add(new fieldShape(tf5).getF());
		leftPanel.add(new labelShape(jl6).getJ());
		leftPanel.add(new fieldShape(tf6).getF());
		
		
		rightPanel.add(new labelShape(jl7).getJ());
		rightPanel.add(new fieldShape(tf7).getF());
		rightPanel.add(new labelShape(jl8).getJ());
		rightPanel.add(new fieldShape(tf8).getF());
		rightPanel.add(new labelShape(jl9).getJ());
		rightPanel.add(new fieldShape(tf9).getF());
		rightPanel.add(new labelShape(jl10).getJ());
		rightPanel.add(new fieldShape(tf10).getF());
		rightPanel.add(new labelShape(jl11).getJ());
		rightPanel.add(new fieldShape(tf11).getF());
		rightPanel.add(new labelShape(jl12).getJ());
		rightPanel.add(new fieldShape(tf12).getF());
	}
	
//	public static void main(String[] args) {
//		new UpdateFrame();
//	}
}
class labelShape{
	JLabel j;
	public labelShape(JLabel j) {
		// TODO Auto-generated constructor stub
		this.j = j;
		j.setSize(150, 30);
		j.setLocation(10,10);
		j.setBackground(new Color(255,255,200));
	}
	public JLabel getJ() {
		return j;
	}
}
class fieldShape{
	JTextField f;
	public fieldShape(JTextField f) {
		// TODO Auto-generated constructor stub
		this.f = f;
		f.setSize(150, 30);
		f.setLocation(10, 10);
	}
	public JTextField getF() {
		return f;
	}
}
