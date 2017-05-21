package GUIng;

import javax.swing.*;
/* Right_Main_Panel class
 * 용도 : 초기화면 중 오른쪽 패널 생성
 * 
 * 
 * */
public class Right_Main_Panel {
	Base_element bs_elem = new Base_element();

	private JPanel right_panel; // 오른쪽 패널 
	private JPanel information_panel; //유저 정보를 담을 패널
	private JLabel myInformation; // 상단 My Information 라벨
	private JLabel imsiImg; //임시로 만들어둠

	public Right_Main_Panel() {
		var_init();
		right_panel_init();
		information_panel();
		myInformation_init();
		imsiImg_init();
	}

	public void var_init() {
		this.right_panel = new JPanel();
		this.information_panel = new JPanel();
		this.myInformation = new JLabel();
		this.imsiImg = new JLabel();
	}

	public void right_panel_init() {
		this.right_panel.setBounds(405, 325, 315, 605);
		this.right_panel.setBackground(bs_elem.get_Color());
		this.right_panel.setLayout(null);
	}

	public void information_panel() {
		this.information_panel.setBounds(12, 86, 288, 509);
		this.information_panel.setLayout(null);

	}

	public void myInformation_init() {
		this.myInformation.setHorizontalAlignment(SwingConstants.CENTER);
		this.myInformation.setBounds(0, 0, 315, 55);
		this.myInformation.setIcon(new ImageIcon(GUI.class.getResource("/Image/lectureindexSub.png")));
		
	}

	public void imsiImg_init() {
		this.imsiImg.setIcon(new ImageIcon(GUI.class.getResource("/Image/메인에있을거.png")));
		this.imsiImg.setBounds(80, 162, 136, 156);

	}
	
	public void add_right_panel(){
		information_panel.add(this.imsiImg);
		right_panel.add(this.myInformation);
		right_panel.add(this.information_panel);
	}
	
	
	public JPanel get_right_panel(){
		this.add_right_panel();
		return this.right_panel;
	}

}
