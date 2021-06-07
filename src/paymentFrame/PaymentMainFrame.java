package paymentFrame;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import _topBar.ClickMain;
import _topBar.ClickMainDesign;
import _topBar.TopBar;

public class PaymentMainFrame extends JFrame{
	JFrame jf;
	JTextField text;
	public PaymentMainFrame(JFrame jf) {
		this.jf = jf;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(jf.getWidth(), jf.getHeight());
		setLocation(jf.getX(), jf.getY());
		setLayout(null);
		
		JButton test = new JButton("여긴 결제 화면을 구현하면 됩니다");//JButton test는 지워도 됩니다.
		test.setLocation(500, 200);
		test.setSize(150, 150);
		add(test);
		
		
		JButton test2 = new ClickMainDesign();
		test2.addActionListener(new ClickMain(jf, this));

		add(test2);//메인으로 돌아가는 버튼
		
		JPanel topBar = new TopBar();
		add(topBar, BorderLayout.NORTH);
		
		
		setVisible(true);
		}
	}
