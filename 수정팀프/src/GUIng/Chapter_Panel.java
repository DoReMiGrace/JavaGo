/* Chapter_Panel class
 * 
 * 용도: chapter1,2,3 버튼 눌렀을 때 뜨는 오른쪽 프레임 구성
 * 		sub_Lecture_Panel에서 만든 소단원별 프레임을 가져와서 배치
 * 		단원 별 이름은 String_set class에서 가져와서 붙임
 * 		종료버튼은 Base_element에서 가져옴.
 * 		이 프레임 내에서 맨 위 라벨.
 * 		테스트 버튼 구현 필요.
 * 
 * */

package GUIng;

import java.awt.Color;

import javax.swing.*;

public class Chapter_Panel {
	Base_element bs_elem=new Base_element();

	private JPanel ch_panel;
	private JLabel oop_label;
	private JButton test;
	private int ch;
	
	Sub_Lecture_Panel sub_1;
	Sub_Lecture_Panel sub_2;

	public Chapter_Panel(int ch){
		this.ch = ch;
		var_init();
		chapter_panel_init();
		oop_label_init();
		test_init();
	}
	public void var_init(){
		this.ch_panel=new JPanel();
		this.oop_label=new JLabel();
		this.test=new JButton();
		this.sub_1=new Sub_Lecture_Panel(this.ch, 1);
		this.sub_2=new Sub_Lecture_Panel(this.ch, 2);	
	}
	public void chapter_panel_init(){
		
		this.ch_panel.setBounds(405, 324, 315, 615);
		this.ch_panel.setBackground(Color.WHITE);
		this.ch_panel.setLayout(null);
	}
	public void oop_label_init(){
		this.oop_label.setHorizontalAlignment(SwingConstants.CENTER);
		this.oop_label.setBounds(12, 5, 291, 42);
		this.oop_label.setIcon(new ImageIcon(GUI.class.getResource("/Image/oopmenu.png")));
	}
	public void test_init(){
		this.test.setIcon(new ImageIcon(GUI.class.getResource("/Image/test_icon.png")));
		this.test.setFocusPainted(false);
		this.test.setContentAreaFilled(false);
		this.test.setBorderPainted(false);
		this.test.setBounds(130, 530, 57, 57);

	}
	public void add_panel(){
		
		sub_1.get_lecture_panel().setLocation(42, 100);
		sub_2.get_lecture_panel().setLocation(42, 320);
		
		ch_panel.add(this.oop_label);
		ch_panel.add(sub_1.get_lecture_panel());
		ch_panel.add(sub_2.get_lecture_panel());
		ch_panel.add(this.test);

	}
	public JPanel get_chapter_panel(){
		this.add_panel();
		return this.ch_panel;
	}
	
}
