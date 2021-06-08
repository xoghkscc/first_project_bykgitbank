package view.stock;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import view.stock.nextFrame.Prouduct_regist;

public class buttons_product {

	private JPanel buttons;
	
	public buttons_product(JPanel buttons, JFrame jf) {
		
		this.buttons = buttons;
		
		ArrayList<JButton> jbArr = new ArrayList<>();
		
		jbArr.add(new JButton("품목등록"));
		jbArr.add(new JButton("품목수정"));
		jbArr.add(new JButton("품목주문"));
		jbArr.add(new JButton("대분류조회"));
		jbArr.add(new JButton("유통기한조회"));
		jbArr.add(new JButton("유통기한폐기"));
		jbArr.add(new JButton("행사품목관리"));	//폐기테이블, 폐기완료버튼
		jbArr.add(new JButton("원가 및 마진율"));

		for(int i = 0; i < 8; i++) {
			new MyButton(jbArr.get(i));
			
			jbArr.get(i).addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					jf.setVisible(false);
					
					new Prouduct_regist(jf);					
				}
				
			});
			if(i == 0) {
				jbArr.get(i).setBackground(new Color(245,173,37));
			}else if(i == 2){
				jbArr.get(i).setBackground(new Color(111,195,11));
			}else if(i == 5) {
				jbArr.get(i).setBackground(new Color(255,62,62));
			}
			
			buttons.add(jbArr.get(i));
		}
		
	}

	public JPanel getButtons() {
		return buttons;
	}
}
