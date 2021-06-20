package view.stock.nextFrame.productEvent;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import function.stock.InsertDB_product;
import view.Payment.lowPanel.RoundedButton;
import view.stock.nextFrame.ConnectDBgetData;

public class UpdateEvent extends JFrame{

	public UpdateEvent() {
		// TODO Auto-generated constructor stub
		
		
		JPanel ct = new JPanel();
		JPanel ct2 = new JPanel();
		
		add(ct);
		ct.setBounds(0, 0, 800, 190);
		ct.setLayout(null);
		ct.setVisible(true);
		add(ct2);
		ct2.setBounds(50, 190, 200, 110);
	
		TitledBorder tb = new TitledBorder(new LineBorder(new Color(255,255,100), 5),"수정할 행사를 고르세요.");
		tb.setTitleFont(new Font("맑은고딕체", Font.PLAIN, 13));
		tb.setTitleColor(new Color(255,255,200));
		ct2.setBorder(tb);
		
		ct2.setForeground(new Color(255,255,200));
		ct2.setLayout(null);
		ct2.setVisible(true);
		
		
		
		ArrayList<String> eventArr = new ConnectDBgetData("DISCOUNT_TYPE",null).getColumnArr();
		
		String[] event = new String[eventArr.size()]; 
		
		for(int i = 0; i < eventArr.size(); i++) { //스트링배열에 타입에 관한 내용 넣기
			event[i] = eventArr.get(i);
		}
		
		JComboBox<String> jComboBoxEvent = new JComboBox<String>(event); 
		jComboBoxEvent.setBounds(20, 25, 150, 35);
		jComboBoxEvent.setVisible(true);
		
		JLabel logo = new JLabel();
		ImageIcon ii = new ImageIcon("./files/logo_stock3.JPG");
		logo.setIcon(ii);
		logo.setBounds(60, 20, 168, 168);
//		logo.setBorderPainted(false);
		
		JButton jl = new roundButton_updateEvent("수정");
		jl.setBounds(40, 70, 50, 25);
		JButton jl2 = new roundButton_updateEvent("삭제");
		jl2.setBounds(110, 70, 50, 25);
		
		//버튼 액션
		jl.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String column = "DISCOUNT_RATE";
				String item = (String)jComboBoxEvent.getSelectedItem();
				String where = "DISCOUNT_TYPE = '" + item + "\'";
				ArrayList<String> columnArr = new ConnectDBgetData(column, where).getColumnArr();
				
				setVisible(false);
				new UpdateEventCheck(item,columnArr.get(0));
				
//				JOptionPane.showMessageDialog(null, columnArr.get(0), "되니", 1);
			}
			
		});
		jl2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String item = (String)jComboBoxEvent.getSelectedItem();
				String sql = "UPDATE PRODUCTS SET DISCOUNT_TYPE = null, DISCOUNT_RATE = NULL WHERE DISCOUNT_TYPE = '" + item + "\'";
	
				
				setVisible(false);
				int check = JOptionPane.showConfirmDialog(null, "\'" + item + "' 을 삭제하시겠습니까?", "이벤트 삭제", JOptionPane.YES_NO_OPTION);
				if(check == JOptionPane.YES_OPTION) {
					new InsertDB_product(sql);
				}
				
			}
			
		});

		ct.add(logo);
		ct2.add(jl);
		ct2.add(jl2);
		ct2.add(jComboBoxEvent);
		
		ct.setBackground(new Color(0,36,62));
		ct2.setBackground(new Color(0,36,62));
		getContentPane().setBackground(new Color(0,36,62));
		setBounds(100, 100, 310, 370);
		setLayout(null);
		setVisible(true);
	}
	public static void main(String[] args) {
		new UpdateEvent();
	}
	
}

class roundButton_updateEvent extends RoundedButton {

	public roundButton_updateEvent(String name) {
		super(name);
		super.c = new Color(255,255,150); 
		super.o = new Color(0,36,62);
		setHorizontalAlignment(JLabel.CENTER);
		setFont(new Font("맑은 고딕", Font.BOLD, 15));
	}
}