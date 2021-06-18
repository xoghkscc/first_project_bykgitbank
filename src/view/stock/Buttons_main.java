package view.stock;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import view.stock.nextFrame.Product_event;
import view.stock.nextFrame.Product_expiry_disposal;
import view.stock.nextFrame.Product_expiry_search;
import view.stock.nextFrame.Product_order;
import view.stock.nextFrame.Product_profit_rate;
import view.stock.nextFrame.Product_regist;
import view.stock.nextFrame.Product_type_search;
import view.stock.nextFrame.Product_update;

public class Buttons_main extends JPanel{

	private JPanel buttons;
	
	public Buttons_main(JPanel buttons, JFrame jf) {
		
		this.buttons = buttons;
		
		ArrayList<JButton> jbArr = new ArrayList<>();
		
		jbArr.add(new Button_round("품목등록"));
		jbArr.add(new Button_round_update("품목수정"));		
		jbArr.add(new Button_round_order("품목주문"));
		jbArr.add(new Button_round_type_search("대분류조회"));
		jbArr.add(new Button_round_expiry_search("유통기한조회"));
		jbArr.add(new Button_round_expiry_disposal("유통기한폐기"));
		jbArr.add(new Button_round_event("행사품목관리"));
		jbArr.add(new Button_round_profit_rate("원가 및 마진율"));
		
		
		jbArr.get(0).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
//				jf.setVisible(false);
				new Product_regist(jf);					
			}
			
		});
		jbArr.get(1).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
//				jf.setVisible(false);
				new Product_update(jf);					
			}	
		});
		jbArr.get(2).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
//				jf.setVisible(false);
				new Product_order(jf);					
			}	
		});
		jbArr.get(3).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
//				jf.setVisible(false);
				new Product_type_search(jf);					
			}	
		});
		jbArr.get(4).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				String num = "0";
//				jf.setVisible(false);
				new Product_expiry_search(jf,num);					
			}	
		});
		jbArr.get(5).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
//				jf.setVisible(false);
				new Product_expiry_disposal(jf);					
			}	
		});
		jbArr.get(6).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
//				jf.setVisible(false);
				new Product_event(jf);	
				
			}	
		});
		jbArr.get(7).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
//				jf.setVisible(false);
				new Product_profit_rate(jf);					
			}	
		});
		for(int i = 0; i < 8; i++) {
			
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

