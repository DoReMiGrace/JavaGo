/* Sub_Lecture_Panel
 * 용도: 소단원에서 다루는 렉쳐, 서머리 같은 버튼들과 라벨을 포함하는 프레임 
 * 		소단원 내의 버튼들을 다른 클래스에서 써야되기 때문에 JButton 메서드 생성.
 * 		버튼들 이미지 이름 수정 필요
 * */


package GUIng;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Sub_Lecture_Panel {
	
	
	private JPanel sub_ch;
	private JButton lecture;
	private JButton summary;
	private JButton quiz;
	private JButton game;
	private JLabel label;
	private JLabel lecture_name;
	private int ch_num;
	private int sub_ch_num;
	
	public Sub_Lecture_Panel(int ch_num, int sub_ch_num) {
		this.ch_num = ch_num;
		this.sub_ch_num = sub_ch_num;
		
		var_init();
		panel_init();
		lec_init();
		sum_init();
		quiz_init();
		game_init();
		label_init();
		lecture_name_init();	
	}
	public void var_init() {
		
		this.sub_ch = new JPanel();		
		this.label = new JLabel();
		this.lecture = new JButton();
		this.summary = new JButton();
		this.quiz = new JButton();
		this.game = new JButton();
	}
	public void panel_init() {
		this.sub_ch.setSize(229, 199);
		this.sub_ch.setBackground(Color.WHITE);
		this.sub_ch.setLayout(null);
	}
	public void lec_init() {
		this.lecture.setIcon(new ImageIcon(GUI.class.getResource("/Image/lec_icon.png")));
		this.lecture.setFocusPainted(false);
		this.lecture.setContentAreaFilled(false);
		this.lecture.setBorderPainted(false);
		this.lecture.setBounds(18, 116, 40, 40);
	}
	public void sum_init() {
		this.summary.setIcon(new ImageIcon(GUI.class.getResource("/Image/sum_icon.png")));
		this.summary.setFocusPainted(false);
		this.summary.setContentAreaFilled(false);
		this.summary.setBorderPainted(false);
		this.summary.setBounds(73, 116, 40, 40);
	}

	public void quiz_init() {
		this.quiz.setIcon(new ImageIcon(GUI.class.getResource("/Image/quiz_icon.png")));
		this.quiz.setFocusPainted(false);
		this.quiz.setContentAreaFilled(false);
		this.quiz.setBorderPainted(false);
		this.quiz.setBounds(125, 116, 40, 40);
	}

	public void game_init() {
		this.game.setIcon(new ImageIcon(GUI.class.getResource("/Image/game_icon.png")));
		this.game.setFocusPainted(false);
		this.game.setContentAreaFilled(false);
		this.game.setBorderPainted(false);
		this.game.setBounds(177, 116, 40, 40);
	}

	public void label_init() {
		this.label.setIcon(new ImageIcon(GUI.class.getResource("/Image/sub_icon.png")));
		this.label.setBounds(87, 10, 57, 57);
	}
	public void lecture_name_init(){
		this.lecture_name=new JLabel(this.sub_ch_num+". "+String_set.sub_ch_name[this.ch_num-1][this.sub_ch_num-1]);
		this.lecture_name.setFont(new Font("Century Gothic", Font.BOLD, 17));
		this.lecture_name.setHorizontalAlignment(SwingConstants.CENTER);
		this.lecture_name.setBounds(12,77,205,29);
	}
	
	public void add_to_panel() {
		
		sub_ch.add(this.lecture);
		sub_ch.add(this.summary);
		sub_ch.add(this.quiz);
		sub_ch.add(this.game);
		sub_ch.add(this.label);
		sub_ch.add(this.lecture_name);
	}
	public JButton get_lecture_btn(){
		return this.lecture;
	}
	public JButton get_summary_btn(){
		return this.summary;
	}
	public JButton get_quiz_btn(){
		this.add_to_panel();
		return this.quiz;
	}
	
	public JButton get_game_btn(){
		return this.game;
	}
	public JPanel get_lecture_panel(){
		this.add_to_panel();
		return this.sub_ch;
	}

}
