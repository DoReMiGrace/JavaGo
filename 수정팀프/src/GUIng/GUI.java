/**
 *2017.5.20
 *
 * JMK
 * 
 * 특징 및 수정사항
 * 피카츄버튼->종료
 * 기타 라벨들 다시 따와서 수정해야됨
 * 손가락 모양 커서 일단 제거
 * chapter 1,2,3에서 오른쪽 뒤로가기 버튼 일단 제거
 * Image 폴더 내 이름들 수정 및 폴더 세분화 필요 
 * **/

package GUIng;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.LayeredHighlighter;
import javax.swing.border.BevelBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

/* GUI class
 * 
 * frame 정보와 main_panel 구현
 * main_panel에서 작동하는 모든 기능들 구현
 * 
 * */
public class GUI extends JFrame implements ActionListener {

	Base_element bs_elem = new Base_element(); // 기본적인 타이틀 로고나 종료버튼 등 수록

	Left_Main_Panel lpanel = new Left_Main_Panel(); // 초기화면 왼쪽 패널
	Right_Main_Panel rpanel = new Right_Main_Panel(); // 초기화면 오른쪽 패널
	JPanel main_panel = new JPanel(); // 초기화면 패널,750X1000

	Chapter_Panel ch1panel = new Chapter_Panel(1); // 초기화면에서 버튼 누른 후 오른쪽 ch1 패널
	Chapter_Panel ch2panel = new Chapter_Panel(2); // 초기화면에서 버튼 누른 후 오른쪽 ch2 패널
	Chapter_Panel ch3panel = new Chapter_Panel(3); // 초기화면에서 버튼 누른 후 오른쪽 ch3 패널

	Lecture_Panel lecPanel = new Lecture_Panel(main_panel); // lecture버튼 클릭시 뜨는
															// 패널
	Quiz_Panel quizpanel = new Quiz_Panel(main_panel); // quiz버튼을 클릭할때 생성되는 패널

	JFrame frame = new JFrame();

	/*
	 * GUI() frame 생성 및 구현 기타 기능들 추가(메소드 호출)
	 * 
	 */

	public GUI() {

		this.frame.setSize(750, 1000);
		this.frame.setUndecorated(true);
		this.frame.setResizable(false);// 프로그램 실행후 창의 크기를 조절할수 없게 해주는놈
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension di = tk.getScreenSize();
		Dimension di1 = this.frame.getSize();
		this.frame.setLocation((int) (di.getWidth() / 2 - di1.getWidth() / 2),
				(int) (di.getHeight() / 2 - di1.getHeight() / 2));
		this.frame.setResizable(false);
		this.frame.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.frame.getContentPane().setLayout(null);

		this.main_panel_init();
		this.init();
		this.ch_click();

		this.lecture_click(ch1panel);
		this.lecture_click(ch2panel);
		this.lecture_click(ch3panel);
		
		this.quiz_click(ch1panel);
		this.quiz_click(ch2panel);
		this.quiz_click(ch3panel);

		this.frame.setVisible(true);

	}

	/*
	 * main_panel_init() 초기화면 패널에 대한 정보들. 패널 만들고 기본정보 설정 후 frame에 추가. 패널에 left,
	 * right, chapter패널들을 저장해놓고, setVisible 사용
	 * 
	 */

	public void main_panel_init() {

		this.main_panel.setBounds(0, 0, 750, 1000);
		this.main_panel.setBackground(bs_elem.get_Color());
		this.main_panel.setLayout(null);

		this.main_panel.add(bs_elem.get_title_logo());
		this.main_panel.add(bs_elem.get_main_exit_btn());

		this.main_panel.add(lpanel.get_left_panel());
		this.main_panel.add(rpanel.get_right_panel());

		this.main_panel.add(ch1panel.get_chapter_panel());
		this.main_panel.add(ch2panel.get_chapter_panel());
		this.main_panel.add(ch3panel.get_chapter_panel());

		this.frame.getContentPane().add(main_panel);

		main_panel.add(bs_elem.get_leg_panel());
		ch1panel.get_chapter_panel().setVisible(false);
		ch2panel.get_chapter_panel().setVisible(false);
		ch3panel.get_chapter_panel().setVisible(false);
	}

	/*
	 * init() lecture, summary, quiz, game, test 패널 frame에 추가 Visible은 각각 클래스에서
	 * false로 설정해 둠
	 * 
	 * 현재 lecture만 추가함.
	 */

	public void init() {

		this.frame.getContentPane().add(lecPanel.get_lecture_panel());
		this.frame.getContentPane().add(quizpanel.get_quiz_panel());
	}

	/*
	 * ch_click() chapter 1,2,3 눌렀을 때 작동하는 메소드 내용이 복잡해서 따로 메서드로 줄일 수 없었음.
	 */

	public void ch_click() {
		lpanel.get_chapter1_btn().addActionListener(this);
		lpanel.get_chapter1_btn().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getSource() == lpanel.get_chapter1_btn() && lpanel.get_chapter1_btn().isEnabled() == true
						&& lpanel.get_chapter2_btn().isEnabled() == true
						&& lpanel.get_chapter3_btn().isEnabled() == true) {
					lpanel.get_chapter2_btn().setEnabled(false);
					lpanel.get_chapter3_btn().setEnabled(false);
					lpanel.get_lectureindex().setEnabled(false);

					ch1panel.get_chapter_panel().setVisible(true);
					rpanel.get_right_panel().setVisible(false);
					bs_elem.leg_init(320, 468);

				} else if (e.getSource() == lpanel.get_chapter1_btn() && lpanel.get_chapter1_btn().isEnabled() == true
						&& lpanel.get_chapter2_btn().isEnabled() == false
						&& lpanel.get_chapter3_btn().isEnabled() == false) {
					lpanel.get_chapter2_btn().setEnabled(true);
					lpanel.get_chapter3_btn().setEnabled(true);
					lpanel.get_lectureindex().setEnabled(true);

					ch1panel.get_chapter_panel().setVisible(false);
					rpanel.get_right_panel().setVisible(true);
					bs_elem.get_leg_panel().setVisible(false);
				}
			}
		});
		lpanel.get_chapter2_btn().addActionListener(this);
		lpanel.get_chapter2_btn().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == lpanel.get_chapter2_btn() && lpanel.get_chapter1_btn().isEnabled() == true
						&& lpanel.get_chapter2_btn().isEnabled() == true
						&& lpanel.get_chapter3_btn().isEnabled() == true) {

					lpanel.get_chapter1_btn().setEnabled(false);
					lpanel.get_chapter3_btn().setEnabled(false);
					lpanel.get_lectureindex().setEnabled(false);

					ch2panel.get_chapter_panel().setVisible(true);
					rpanel.get_right_panel().setVisible(false);
					bs_elem.leg_init(320, 645);

				} else if (e.getSource() == lpanel.get_chapter2_btn() && lpanel.get_chapter1_btn().isEnabled() == false
						&& lpanel.get_chapter2_btn().isEnabled() == true
						&& lpanel.get_chapter3_btn().isEnabled() == false) {

					lpanel.get_chapter1_btn().setEnabled(true);
					lpanel.get_chapter3_btn().setEnabled(true);
					lpanel.get_lectureindex().setEnabled(true);

					ch2panel.get_chapter_panel().setVisible(false);
					rpanel.get_right_panel().setVisible(true);
					bs_elem.get_leg_panel().setVisible(false);
				}
			}
		});

		lpanel.get_chapter3_btn().addActionListener(this);
		lpanel.get_chapter3_btn().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == lpanel.get_chapter3_btn() && lpanel.get_chapter1_btn().isEnabled() == true
						&& lpanel.get_chapter2_btn().isEnabled() == true
						&& lpanel.get_chapter3_btn().isEnabled() == true) {

					lpanel.get_chapter1_btn().setEnabled(false);
					lpanel.get_chapter2_btn().setEnabled(false);
					lpanel.get_lectureindex().setEnabled(false);

					ch3panel.get_chapter_panel().setVisible(true);
					rpanel.get_right_panel().setVisible(false);
					bs_elem.leg_init(320, 822);
				} else if (e.getSource() == lpanel.get_chapter3_btn() && lpanel.get_chapter1_btn().isEnabled() == false
						&& lpanel.get_chapter2_btn().isEnabled() == false
						&& lpanel.get_chapter3_btn().isEnabled() == true) {

					lpanel.get_chapter1_btn().setEnabled(true);
					lpanel.get_chapter2_btn().setEnabled(true);
					lpanel.get_lectureindex().setEnabled(true);

					ch3panel.get_chapter_panel().setVisible(false);
					rpanel.get_right_panel().setVisible(true);
					bs_elem.get_leg_panel().setVisible(false);
				}
			}
		});
	}

	/*
	 * lecture_click(Chapter_Panel ch_panel) chapter 버튼 누른 후 오른쪽 서브패널 내 lecture
	 * 버튼 작동 ch_panel 파라미터 값에 따라서 1,2,3번 설정 가능 sub_1,2도 메서드로 뺄 수 있지만 코드가 짧기 때문에
	 * 굳이 안함.
	 * 
	 */

	public void lecture_click(Chapter_Panel ch_panel) {

		ch_panel.sub_1.get_lecture_btn().addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				// 기능 구현 할것
				if (e.getSource() == ch_panel.sub_1.get_lecture_btn()) {
					lecPanel.get_lecture_panel().setVisible(true);
					main_panel.setVisible(false);
				}
			}
		});
		ch_panel.sub_2.get_lecture_btn().addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				// 기능 구현 할것
				if (e.getSource() == ch_panel.sub_2.get_lecture_btn()) {
					lecPanel.get_lecture_panel().setVisible(true);
					main_panel.setVisible(false);
				}
			}
		});

	}

	public void quiz_click(Chapter_Panel ch_panel) {

		ch_panel.sub_1.get_quiz_btn().addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				// 기능 구현 할것
				if (e.getSource() == ch_panel.sub_1.get_quiz_btn()) {
					quizpanel.get_quiz_panel().setVisible(true);
					main_panel.setVisible(false);
				}
			}
		});
		ch_panel.sub_2.get_quiz_btn().addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				// 기능 구현 할것
				if (e.getSource() == ch_panel.sub_2.get_quiz_btn()) {
					quizpanel.get_quiz_panel().setVisible(true);
					main_panel.setVisible(false);
				}
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	}

}