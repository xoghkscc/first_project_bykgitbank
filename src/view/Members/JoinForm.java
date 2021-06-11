package view.Members;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JoinForm extends JPanel{
   
   JLabel title=new JLabel("회원가입", JLabel.CENTER);
   JLabel la1, la2, la3, la4, la5, la6, la7, la8, la9, la10, la11;
   JTextField tf1, tf2, tf3, tf4, tf5, tf6;
   JLabel dash=new JLabel("-");
   JButton b2=new JButton("우편번호 검색");
   JPasswordField pf1, pf2;
   JRadioButton rb1, rb2;
   JTextArea ta;
   JCheckBox box1, box2, box3, box4, box5;
   JButton b1;
   JComboBox telBox=new JComboBox();
   JTextField tf7, tf8;
   JLabel dash2=new JLabel("-");
   JButton b3=new JButton("회원가입");
   JButton b4=new JButton("취소");
 
   //초기화
   public JoinForm(){
      la1=new JLabel("ID", JLabel.RIGHT);
      la2=new JLabel("비밀번호", JLabel.RIGHT);
      la3=new JLabel("재입력", JLabel.RIGHT);
      la4=new JLabel("이름", JLabel.RIGHT);
      la5=new JLabel("성별", JLabel.RIGHT);
      la6=new JLabel("우편번호", JLabel.RIGHT);
      la7=new JLabel("주소", JLabel.RIGHT);
      la8=new JLabel("상세주소", JLabel.RIGHT);
      la9=new JLabel("전화번호", JLabel.RIGHT);
      la10=new JLabel("소개", JLabel.RIGHT);
      la11=new JLabel("레시피", JLabel.RIGHT);
 
      tf1=new JTextField();
      tf2=new JTextField();
      tf3=new JTextField();
      tf4=new JTextField();
      tf5=new JTextField();
      tf6=new JTextField();
      tf7=new JTextField();
      tf8=new JTextField();
 
      pf1=new JPasswordField();
      pf2=new JPasswordField();
 
      rb1=new JRadioButton("남자");
      rb2=new JRadioButton("여자");
      ButtonGroup gb=new ButtonGroup();//하나만 선택되어야 하기 때문에 그룹 잡음
      gb.add(rb1);
      gb.add(rb2);
 
      b1=new JButton("중복체크");
 
      title.setFont(new Font("맑은 고딕", Font.PLAIN, 40));//HTML:<h1><b>회원가입</b></h1>
 
      //배치
      setLayout(null);
      title.setBounds(10, 15, 1000, 55);
      //추가
      add(title);
 
      la1.setBounds(300, 100, 80, 30);
      tf1.setBounds(385, 100, 200, 30);
      b1.setBounds(590, 100, 150, 30);
      add(la1);
      add(tf1);
      add(b1);
 
      la2.setBounds(300, 135, 80, 30);
      pf1.setBounds(385, 135, 200, 30);
      add(la2);
      add(pf1);
 
      la3.setBounds(300, 170, 80, 30);
      pf2.setBounds(385, 170, 200, 30);
      add(la3);
      add(pf2);
 
      la4.setBounds(300, 205, 80, 30);
      tf2.setBounds(385, 205, 200, 30);
      add(la4);
      add(tf2);
 
      la5.setBounds(300, 240, 80, 30);
      rb1.setBounds(385, 240, 95, 30);
      rb2.setBounds(485, 240, 95, 30);
      add(la5);
      add(rb1);
      add(rb2);
 
      la6.setBounds(300, 275, 80, 30);
      tf3.setBounds(385, 275, 100, 30);
      dash.setBounds(500, 275, 20, 30);
      tf4.setBounds(525, 275, 100, 30);
      b2.setBounds(630, 275, 150, 30);
      add(la6);add(tf3);add(dash);add(tf4);add(b2);
      
      la7.setBounds(300, 310, 80, 30);
      tf5.setBounds(385, 310, 400, 30);
      add(la7);add(tf5);
      
      la8.setBounds(300, 345, 80, 30);
      tf6.setBounds(385, 345, 400, 30);
      add(la8);add(tf6);
      
      telBox.addItem("010");
      telBox.addItem("011");
      telBox.addItem("017");
      
      la9.setBounds(300, 380, 80, 30);
      telBox.setBounds(385, 380, 100, 30);
      tf7.setBounds(490, 380, 100, 30);
      dash2.setBounds(595, 380, 20, 30);
      tf8.setBounds(620, 380, 100, 30);
      add(la9);add(telBox);add(tf7);add(dash2);add(tf8);
 
      
      ta=new JTextArea();
      JScrollPane js=new JScrollPane(ta);
      
      la10.setBounds(300, 415, 80, 30);
      js.setBounds(385, 415, 400, 200);
      add(la10); add(js);
      
      box1=new JCheckBox("샐러드");
      box2=new JCheckBox("디저트");
      box3=new JCheckBox("김치찌개");
      box4=new JCheckBox("피자");
      box5=new JCheckBox("초밥");
      
      JPanel p=new JPanel();
      p.add(box1); p.add(box2); p.add(box3); p.add(box4); p.add(box5);
      la11.setBounds(300, 620, 80, 30);
      p.setBounds(385, 620, 400, 35);
      add(la11); add(p);
      
      JPanel p2=new JPanel();
      p2.add(b3); p2.add(b4);       
      p2.setBounds(300, 665, 485, 35);
      add(p2);
      
      p.setOpaque(false);
      p2.setOpaque(false);
      rb1.setOpaque(false);
      rb2.setOpaque(false);
      box1.setOpaque(false);
      box2.setOpaque(false);
      box3.setOpaque(false);
      box4.setOpaque(false);
      box5.setOpaque(false);
   
      setBounds(500, 50, 1280, 720);
		setVisible(true);
		
   }
   
//  public static void main(String[] args) {
//	new JoinForm();
//}
}