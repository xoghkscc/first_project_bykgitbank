package view.stock.nextFrame.productEvent;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.stock.nextFrame.ConnectDBgetData;

public class UpdateEvent extends JFrame{

	public UpdateEvent() {
		// TODO Auto-generated constructor stub
		
		
		JPanel ct = new JPanel();
		
		add(ct);
		ct.setBounds(0, 0, 800, 500);
		ct.setLayout(null);
		ct.setVisible(true);
		
		
		ArrayList<String> eventArr = new ConnectDBgetData("DISCOUNT_TYPE",null).getColumnArr();
		
		String[] event = new String[eventArr.size()]; 
		
		for(int i = 0; i < eventArr.size(); i++) { //스트링배열에 타입에 관한 내용 넣기
			event[i] = eventArr.get(i);
		}
		
		JComboBox<String> jComboBoxEvent = new JComboBox<String>(event); 
		jComboBoxEvent.setBounds(320, 370, 150, 45);
		jComboBoxEvent.setVisible(true);
		
		JLabel jl = new JLabel("수정할 행사를 고르세요.");
		jl.setBounds(20, 20, 200, 30);
		
		ct.add(jl);
		ct.add(jComboBoxEvent);
		
		setBounds(100, 100, 800, 500);
		setLayout(null);
		setVisible(true);
	}
	public static void main(String[] args) {
		new UpdateEvent();
	}
	
	
	
}
