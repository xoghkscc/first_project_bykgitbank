package view.stock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class DateCheckAction implements ActionListener{
	
	//utilDateModel 날짜 관련 달력
	
	UtilDateModel model;
	private String expiryDate;
	
	
	public DateCheckAction(UtilDateModel model) {
		// TODO Auto-generated constructor stub
		this.model = model;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//날짜 선택한것을 값으로 뽑아내기
		expiryDate = String.format(model.getYear() + "-" + (model.getMonth() + 1) + "-" + model.getDay());
		
		System.out.println(expiryDate);
	}


	public String getExpiryDate() {
		return expiryDate;
	}

	
}
