package GUIng;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Base_element implements ActionListener {
	private JLabel title_logo;
	private JButton main_exit_btn;
	private JButton sub_exit_btn;
	private Color background_color;
	private JPanel leg;
	private JPanel main_panel;
	private JPanel now_panel;
	
	public Base_element() {
		var_init();
		main_exit_init();
		sub_exit_init();
		title_init();
		background_color_init();
		
	}
	public void var_init(){
		this.title_logo = new JLabel();
		this.main_exit_btn = new JButton();
		this.sub_exit_btn=new JButton();
		this.leg=new JPanel();
	}

	public void title_init() {
		this.title_logo.setIcon(new ImageIcon(GUI.class.getResource("/Image/title_icon.png")));
		this.title_logo.setBounds(236, 50, 289, 234);

	}

	public void main_exit_init() {
		this.main_exit_btn.setIcon(new ImageIcon(GUI.class.getResource("/Image/exit_icon.png")));
		this.main_exit_btn.setBounds(665, 10, 55, 55);
		this.main_exit_btn.setFocusPainted(false);
		this.main_exit_btn.setContentAreaFilled(false);
		this.main_exit_btn.setBorderPainted(false);

		this.main_exit_btn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == main_exit_btn) {
					System.exit(0);
				}
			}
		});
	}
	
	
	public void set_main_panel(JPanel main_panel){
		this.main_panel = main_panel;
	}
	
	public void set_now_panel(JPanel now_panel){
		this.now_panel = now_panel;
	}
	
	
	public void background_color_init() {
		this.background_color = new Color(204, 204, 204);
	}
	public void sub_exit_init(){
		this.sub_exit_btn.setIcon(new ImageIcon(GUI.class.getResource("/Image/sub_exit_icon.png")));
		this.sub_exit_btn.setSize(35, 35);
		this.sub_exit_btn.setFocusPainted(false);
		this.sub_exit_btn.setContentAreaFilled(false);
		this.sub_exit_btn.setBorderPainted(false);
		
		this.sub_exit_btn.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == sub_exit_btn) {
					now_panel.setVisible(false);
					main_panel.setVisible(true);
				}
			}
		});
		
	}
	public void leg_init(int x,int y){
		this.leg.setVisible(true);
		this.leg.setLayout(null);
		this.leg.setBackground(Color.WHITE);
		this.leg.setBounds(x, y, 100, 40);	
		}
	public JLabel get_title_logo() {
		return this.title_logo;
	}

	public JButton get_main_exit_btn() {
		return this.main_exit_btn;
	}
	public JButton get_sub_exit_btn(){
		return this.sub_exit_btn;
	}
	public Color get_Color() {
		return this.background_color;
	}
	public JPanel get_leg_panel(){
		return this.leg;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}
