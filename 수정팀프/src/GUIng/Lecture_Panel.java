package GUIng;

import GUIng.GUI;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
/* Lecture_Panel class
 * 용도 : lecture 버튼 눌렀을 떄 뜨는 패널 구현
 * 
 * */
public class Lecture_Panel{
	Base_element bs_elem=new Base_element();
	private JPanel lecture_panel; //lecture panel 생성. 750X1000
	private JPanel content_panel; //컨텐츠를 담을 패널
	private JLabel lecture_title; // lecture panel 상단에 JAVAGO 타이틀
	private JButton sub_exit; // 뒤로가기 버튼
	private JPanel main_panel; // 초기화면 패널 부르려고 만듬.
	
	public Lecture_Panel(JPanel main_panel){
		var_init(main_panel);
		lecture_panel_init();
		lecture_title_init();
		content_panel_init();
		sub_exit_init();
	}
	
	public void var_init(JPanel main_panel){
		this.main_panel = main_panel;
		this.lecture_panel=new JPanel();
		this.content_panel=new JPanel();
		this.lecture_title=new JLabel();
		
		this.sub_exit=bs_elem.get_sub_exit_btn();
		bs_elem.set_now_panel(lecture_panel);
		bs_elem.set_main_panel(main_panel);
	}
	
	public void lecture_panel_init(){
		this.lecture_panel.setBounds(0, 0, 750, 1000);
		this.lecture_panel.setBackground(bs_elem.get_Color());
		this.lecture_panel.setVisible(false);
		this.lecture_panel.setLayout(null);
	}

	public void content_panel_init(){
		this.content_panel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		this.content_panel.setBounds(0, 133, 750, 867);
		this.content_panel.setBackground(Color.LIGHT_GRAY);
		this.content_panel.setLayout(null);
	}
	
	public void lecture_title_init(){
		this.lecture_title.setBounds(313, 31, 126, 90);
		this.lecture_title.setPreferredSize(new Dimension(12, 12));
		this.lecture_title.setMinimumSize(new Dimension(1, 12));
		this.lecture_title.setInheritsPopupMenu(false);
		this.lecture_title.setIcon(new ImageIcon(GUI.class.getResource("/Image/sub_title_icon.png")));
		
	}
	public void sub_exit_init(){
		sub_exit.setLocation(665,784);
	}
	
	public void add_lecture_panel(){
		
		lecture_panel.add(bs_elem.get_main_exit_btn());
		lecture_panel.add(this.sub_exit);
		lecture_panel.add(this.lecture_title);
		lecture_panel.add(this.content_panel);
		
	}
	
	public JButton get_sub_exit_btn(){
		return this.sub_exit;
	}
	
	public JPanel get_lecture_panel(){
		this.add_lecture_panel();
		return this.lecture_panel;
	}
}
