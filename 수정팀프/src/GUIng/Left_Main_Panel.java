/*Left_Main_Panel class
 *용도: 초기화면에서 왼쪽 패널 부분을 담당 
 *  
 * */

package GUIng;

import java.awt.Insets;

import javax.swing.*;

public class Left_Main_Panel {
	private JPanel left_panel; //왼쪽 패널
	
	private JLabel lectureindex; //패널 상단 Lecture Index Label
	
	private JButton chapter1; //1번 버튼
	private JButton chapter2; //2번 버튼
	private JButton chapter3; //3번 버튼
	
	Base_element bs_elem;
	
	public Left_Main_Panel() {
		var_init();
		left_panel_init();
		lectureindex_init();
		chapter1_init();
		chapter2_init();
		chapter3_init();
	}

	public void var_init() {
		this.left_panel=new JPanel();
		this.lectureindex=new JLabel();
		this.chapter1=new JButton();
		this.chapter2=new JButton();
		this.chapter3=new JButton();
		this.bs_elem=new Base_element();
	}

	public void left_panel_init() {
		this.left_panel.setBounds(30,325,315, 605);
		this.left_panel.setBackground(bs_elem.get_Color());
		this.left_panel.setLayout(null);
	}
	
	public void lectureindex_init(){
		lectureindex.setBounds(0,0,315, 55);
		lectureindex.setHorizontalAlignment(SwingConstants.CENTER);
		lectureindex.setIcon(new ImageIcon(GUI.class.getResource("/Image/lectureindexmain.png")));
	}

	public void chapter1_init() {
		this.chapter1.setBorderPainted(false);
		this.chapter1.setMargin(new Insets(2, 14, 2, -1));
		this.chapter1.setBounds(10, 86, 290, 155);
		this.chapter1.setFocusPainted(false);
		this.chapter1.setContentAreaFilled(false);
		this.chapter1.setIcon(new ImageIcon(GUI.class.getResource("/Image/CH1.png")));
	}

	public void chapter2_init() {
		this.chapter2.setMargin(new Insets(2, 14, 2, 0));
		this.chapter2.setBounds(10, 263, 290, 155);
		this.chapter2.setBorderPainted(false);
		this.chapter2.setFocusPainted(false);
		this.chapter2.setContentAreaFilled(false);
		this.chapter2.setIcon(new ImageIcon(GUI.class.getResource("/Image/CH2.png")));
	}

	public void chapter3_init() {
		this.chapter3.setMargin(new Insets(2, 14, 2, 0));
		this.chapter3.setBounds(10, 440, 290, 155);
		this.chapter3.setFocusPainted(false);
		this.chapter3.setContentAreaFilled(false);
		this.chapter3.setBorderPainted(false);
		this.chapter3.setIcon(new ImageIcon(GUI.class.getResource("/Image/CH3.png")));
	}
	
	public void add_left_panel(){
		left_panel.add(lectureindex);
		left_panel.add(chapter1);
		left_panel.add(chapter2);
		left_panel.add(chapter3);
	}
	
	public JLabel get_lectureindex(){
		return this.lectureindex;
	}
	public JButton get_chapter1_btn(){
		return this.chapter1;
	}
	
	public JButton get_chapter2_btn(){
		return this.chapter2;
	}
	
	public JButton get_chapter3_btn(){
		return this.chapter3;
	}
	
	public JPanel get_left_panel(){
		this.add_left_panel();
		return this.left_panel;
	}
}
