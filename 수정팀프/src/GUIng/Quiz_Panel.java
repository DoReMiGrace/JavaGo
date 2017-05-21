package GUIng;

import GUIng.GUI;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

/* quiz_Panel class
 * 용도 : quiz 버튼 눌렀을 떄 뜨는 패널 구현
 * 
 * */
public class Quiz_Panel {
	Base_element bs_elem = new Base_element();
	private JPanel quiz_panel; // quiz panel 생성. 750X1000
	private JPanel content_panel; // 컨텐츠를 담을 패널
	private JLabel quiz_title; // quiz panel 상단에 JAVAGO 타이틀
	private JButton sub_exit; // 뒤로가기 버튼
	private JPanel main_panel; // 초기화면 패널 부르려고 만듬.
	private JLabel quizmain;
	private JButton start;
	private JButton btnNewButton;
	private JLabel quiz;

	public Quiz_Panel(JPanel main_panel) {
		var_init(main_panel);
		quiz_panel_init();
		quiz_title_init();
		quizmain_init();
		start_init();
		quiz_init();
		content_panel_init();
		sub_exit_init();

	}

	public void var_init(JPanel main_panel) {
		this.main_panel = main_panel;
		this.quiz_panel = new JPanel();
		this.content_panel = new JPanel();
		this.quiz_title = new JLabel();
		this.quizmain = new JLabel();
		this.quiz = new JLabel();
		this.start = new JButton();
		this.sub_exit = bs_elem.get_sub_exit_btn();
		bs_elem.set_now_panel(quiz_panel);
		bs_elem.set_main_panel(main_panel);
	}

	public void quiz_panel_init() {
		this.quiz_panel.setBounds(0, 0, 750, 1000);
		this.quiz_panel.setBackground(bs_elem.get_Color());
		this.quiz_panel.setVisible(false);
		this.quiz_panel.setLayout(null);
	}

	public void start_init() {
		this.start.setFocusPainted(false);
		this.start.setBorderPainted(false);
		this.start.setContentAreaFilled(false);
		this.start.setIcon(new ImageIcon(Quiz_Panel.class.getResource("/Image/start.png")));
		this.start.setBounds(300, 750, 146, 85);

	}

	public void content_panel_init() {
		this.content_panel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		this.content_panel.setBounds(0, 133, 750, 867);
		this.content_panel.setBackground(Color.LIGHT_GRAY);
		this.content_panel.setLayout(null);
		this.content_panel.add(quizmain);
		this.content_panel.add(start);
		this.content_panel.add(quiz);
	}

	public void quiz_title_init() {
		this.quiz_title.setBounds(313, 31, 126, 90);
		this.quiz_title.setPreferredSize(new Dimension(12, 12));
		this.quiz_title.setMinimumSize(new Dimension(1, 12));
		this.quiz_title.setInheritsPopupMenu(false);
		this.quiz_title.setIcon(new ImageIcon(GUI.class.getResource("/Image/sub_title_icon.png")));

	}

	public void quizmain_init() {
		this.quiz_title.setBounds(125, 280, 500, 611);
		this.quiz_title.setPreferredSize(new Dimension(12, 12));
		this.quiz_title.setMinimumSize(new Dimension(1, 12));
		this.quiz_title.setIcon(new ImageIcon(GUI.class.getResource("/Image/quizmain.png")));

	}

	public void quiz_init() {
		this.quiz.setBounds(245, 45, 260, 100);
		this.quiz.setIcon(new ImageIcon(GUI.class.getResource("/Image/quiz.png")));

	}

	public void sub_exit_init() {
		sub_exit.setLocation(665, 784);
	}

	public void add_quiz_panel() {

		quiz_panel.add(bs_elem.get_main_exit_btn());
		quiz_panel.add(this.sub_exit);
		quiz_panel.add(this.quiz_title);
		quiz_panel.add(this.content_panel);
	}

	public JButton get_sub_exit_btn() {
		return this.sub_exit;
	}

	public JPanel get_quiz_panel() {
		this.add_quiz_panel();
		return this.quiz_panel;
	}
}
