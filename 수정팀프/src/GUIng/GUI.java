/**
 *2017.5.20
 *
 * JMK
 * 
 * Ư¡ �� ��������
 * ��ī���ư->����
 * ��Ÿ �󺧵� �ٽ� ���ͼ� �����ؾߵ�
 * �հ��� ��� Ŀ�� �ϴ� ����
 * chapter 1,2,3���� ������ �ڷΰ��� ��ư �ϴ� ����
 * Image ���� �� �̸��� ���� �� ���� ����ȭ �ʿ� 
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
 * frame ������ main_panel ����
 * main_panel���� �۵��ϴ� ��� ��ɵ� ����
 * 
 * */
public class GUI extends JFrame implements ActionListener {

	Base_element bs_elem = new Base_element(); // �⺻���� Ÿ��Ʋ �ΰ� �����ư �� ����

	Left_Main_Panel lpanel = new Left_Main_Panel(); // �ʱ�ȭ�� ���� �г�
	Right_Main_Panel rpanel = new Right_Main_Panel(); // �ʱ�ȭ�� ������ �г�
	JPanel main_panel = new JPanel(); // �ʱ�ȭ�� �г�,750X1000

	Chapter_Panel ch1panel = new Chapter_Panel(1); // �ʱ�ȭ�鿡�� ��ư ���� �� ������ ch1 �г�
	Chapter_Panel ch2panel = new Chapter_Panel(2); // �ʱ�ȭ�鿡�� ��ư ���� �� ������ ch2 �г�
	Chapter_Panel ch3panel = new Chapter_Panel(3); // �ʱ�ȭ�鿡�� ��ư ���� �� ������ ch3 �г�

	Lecture_Panel lecPanel = new Lecture_Panel(main_panel); // lecture��ư Ŭ���� �ߴ�
															// �г�
	Quiz_Panel quizpanel = new Quiz_Panel(main_panel); // quiz��ư�� Ŭ���Ҷ� �����Ǵ� �г�

	JFrame frame = new JFrame();

	/*
	 * GUI() frame ���� �� ���� ��Ÿ ��ɵ� �߰�(�޼ҵ� ȣ��)
	 * 
	 */

	public GUI() {

		this.frame.setSize(750, 1000);
		this.frame.setUndecorated(true);
		this.frame.setResizable(false);// ���α׷� ������ â�� ũ�⸦ �����Ҽ� ���� ���ִ³�
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
	 * main_panel_init() �ʱ�ȭ�� �гο� ���� ������. �г� ����� �⺻���� ���� �� frame�� �߰�. �гο� left,
	 * right, chapter�гε��� �����س���, setVisible ���
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
	 * init() lecture, summary, quiz, game, test �г� frame�� �߰� Visible�� ���� Ŭ��������
	 * false�� ������ ��
	 * 
	 * ���� lecture�� �߰���.
	 */

	public void init() {

		this.frame.getContentPane().add(lecPanel.get_lecture_panel());
		this.frame.getContentPane().add(quizpanel.get_quiz_panel());
	}

	/*
	 * ch_click() chapter 1,2,3 ������ �� �۵��ϴ� �޼ҵ� ������ �����ؼ� ���� �޼���� ���� �� ������.
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
	 * lecture_click(Chapter_Panel ch_panel) chapter ��ư ���� �� ������ �����г� �� lecture
	 * ��ư �۵� ch_panel �Ķ���� ���� ���� 1,2,3�� ���� ���� sub_1,2�� �޼���� �� �� ������ �ڵ尡 ª�� ������
	 * ���� ����.
	 * 
	 */

	public void lecture_click(Chapter_Panel ch_panel) {

		ch_panel.sub_1.get_lecture_btn().addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				// ��� ���� �Ұ�
				if (e.getSource() == ch_panel.sub_1.get_lecture_btn()) {
					lecPanel.get_lecture_panel().setVisible(true);
					main_panel.setVisible(false);
				}
			}
		});
		ch_panel.sub_2.get_lecture_btn().addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				// ��� ���� �Ұ�
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
				// ��� ���� �Ұ�
				if (e.getSource() == ch_panel.sub_1.get_quiz_btn()) {
					quizpanel.get_quiz_panel().setVisible(true);
					main_panel.setVisible(false);
				}
			}
		});
		ch_panel.sub_2.get_quiz_btn().addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				// ��� ���� �Ұ�
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