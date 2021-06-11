package view.stock.nextFrame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class Regist_layout {

	public Regist_layout(Component cc) {
		
		cc.setSize(100, 35);
//		cc.setForeground(Color.WHITE);
		cc.setVisible(true);
		cc.setFont(new Font("맑은 고딕",Font.PLAIN, 14));
	}
}

class Regist_layout2{
	public Regist_layout2(Component cc) {

		cc.setSize(180, 37);
//		cc.setForeground(Color.WHITE);
		cc.setVisible(true);
		cc.setFont(new Font("맑은 고딕",Font.PLAIN, 14));
	}
}

class Panel_titleBorder{
	public Panel_titleBorder(JPanel jp) {
		
		jp.setLayout(null);
		jp.setBorder(new TitledBorder(null, null, TitledBorder.LEADING,    
				TitledBorder.TOP, null, null));
		jp.setToolTipText("");
		jp.setVisible(true);
	}
}
