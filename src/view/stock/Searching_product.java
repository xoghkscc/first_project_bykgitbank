package view.stock;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import function.stock.ActionSelectButton;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import view.Payment.topPanel.TopTable;

public class Searching_product{
	
	private JPanel index;
	String madeSql = "";
	String comboBoxText;
	static String startDate;
	static String endDate;
	JComboBox<String> jComboBox;
	JPanel table_panel;
	
	public Searching_product(JFrame jf,
							JPanel indexes, JPanel table_panel,JPanel index, 
							JDatePickerImpl datePickerStart, JDatePickerImpl datePickerEnd,
							UtilDateModel modelStart , UtilDateModel modelEnd){
		
		this.table_panel = table_panel;
		//재고관리 메인화면의 검색창
		
		this.index = index;
	
		JTextField jTextField = new JTextField(20);
		

		JButton jButton = new Button_round_search("검색");

//		select * from products where expiration_date BETWEEN '21-06-10' and '21-06-30'; 
		
		jButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				// TODO Auto-generated method stub
//				table_panel.setVisible(false);
				
				JPanel jpp = new JPanel();
				
				String startDate2 = (String.format(modelStart.getYear() + "-" + (modelStart.getMonth() + 1) + "-" + modelStart.getDay()));
				String endDate2 = (String.format(modelEnd.getYear() + "-" + (modelEnd.getMonth() + 1) + "-" + modelEnd.getDay()));
				String text = jTextField.getText();
				Object columnComboBox = jComboBox.getSelectedItem();
				String endSql = "";
//				"번호", "가격", "품목이름", "행사유형","전체검색"
//				 AND " + columnComboBox + " = \'" + text +"\'"
				if(text.equals("") && !columnComboBox.equals("전체검색")) {
					JOptionPane.showMessageDialog(null, columnComboBox + "를 입력하세요", "검색항목부족", 1);
				}else {
					
					if(columnComboBox == "번호") {
						columnComboBox = "PRODUCT_ID";
						endSql = " AND " + columnComboBox + " = \'" + text +"\'";
					}else if(columnComboBox == "가격") {
						columnComboBox = "PRODUCT_PRICE";
						endSql = " AND " + columnComboBox + " = \'" + text +"\'";
					}else if(columnComboBox == "품목이름") {
						columnComboBox = "PRODUCT_NAME";
						text += "%";
						endSql = " AND " + columnComboBox + " LIKE \'" + text +"\'";
					}else if(columnComboBox == "행사유형") {
						columnComboBox = "PRODUCT_TYPE";
						endSql = " AND " + columnComboBox + " LIKE \'" + text +"\'";
					}else if(columnComboBox == "전체검색") {
						endSql = "";
					}
					
					
					new ActionSelectButton(jf, indexes,
							"SELECT * FROM PRODUCTS WHERE (expiration_date BETWEEN \'" + startDate2 + "\' and \'" + endDate2 +"\')" + endSql,
							jpp, 870, 510);
					
					
					ActionSelectButton.setScrollPane(new JScrollPane(new JTable(ActionSelectButton.getModel())));
				}
				if(ActionSelectButton.getScrollPane() != null) {
					
					table_panel.add(ActionSelectButton.getScrollPane());
				}
			}	
			
		});

		jComboBox = new JComboBox<String>(new String[] {"번호", "가격", "품목이름", "행사유형","전체검색"}); 
		jComboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				comboBoxText = (String) jComboBox.getSelectedItem();
			}
			
		});
			
		index.setBackground(new Color(71,81,101));
		
		if(ActionSelectButton.getScrollPane() != null) {
			
			table_panel.add(ActionSelectButton.getScrollPane());
		}
		
		index.add(jComboBox);
		index.add(jTextField);
		index.add(jButton);
	}

	public JPanel getIndex() {
		return index;
	}
	
}
