package view.Payment.east;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class EastJText3 extends JTextField {

		public EastJText3(String name) {
			super(name);
			setFont(new Font("맑은 고딕", Font.BOLD, 12));
			setBorder(new TitledBorder(new LineBorder(Color.black, 1)));
			setForeground(Color.gray);
			setHorizontalAlignment(JLabel.CENTER);
			
			addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					((JTextField) e.getSource()).setText("");
				}
			});
			
		}
	
	
}
