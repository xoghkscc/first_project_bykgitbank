package view.Members;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;



public class Mainpan extends JFrame {
	
	public Mainpan() {
		JPanel pan = new JPanel(new BorderLayout());
		pan.setBorder(new EmptyBorder(100, 100, 100, 100));
		String[] header = {"회원ID","회원 이름", "회원 주소", "회원 연락처","회원 포인트"};
		String[][] content = new String[20][5];
		DefaultTableModel model = new DefaultTableModel(0,5);	
		JTable table = new JTable(model);
		JScrollPane pane = new JScrollPane(table);
	
		setLocation(0,100);
		setSize(1200,600);
		add(pan);
		
	}
}
