package memberFrame;

import javax.swing.JButton;
import javax.swing.JFrame;

import _MainToGo.ClickMain;
import _MainToGo.ClickMainDesign;

public class MemberMainFrame extends JFrame{
	JFrame jf;
	public MemberMainFrame(JFrame jf) {
		this.jf = jf;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(jf.getWidth(), jf.getHeight());
		setLocation(jf.getX(), jf.getY());
		setLayout(null);
		
		JButton test = new JButton("여긴 회원 관리 화면을 구현하면 됩니다");
		test.setLocation(500, 200);
		test.setSize(150, 150);
		
		add(test);
		
		JButton test2 = new ClickMainDesign();
		test2.addActionListener(new ClickMain(jf, this));

		add(test2);
	}
}
