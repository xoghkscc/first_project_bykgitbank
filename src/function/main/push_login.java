package function.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import function.model.Employee_DB;

public class push_login implements ActionListener {
	private static Employee_DB employee_DB;
	JFrame jf;
	JFrame jf1;
	
	public push_login(JFrame jf, JFrame jf1) {
		this.jf = jf;
		this.jf1 = jf1;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		new Check_Job_Id(Privilege_Mode_Login.getMember_id().getText().trim(),
				Privilege_Mode_Login.getMember_password().getText().trim(), jf, jf1);
		
		
		}
	
		
}
	
	
	

