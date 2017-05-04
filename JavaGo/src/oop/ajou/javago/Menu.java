package oop.ajou.javago;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Menu extends JFrame{
public Menu (){
		
		setTitle("JavaGO");//���� �׷� ���۽� â ���� ���� ���̴� ������ ���� ��
		setSize(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);//â�� ũ�� ����(����, ����)
		setResizable(false);//���α׷� ������ â�� ũ�⸦ �����Ҽ� ���� ���ִ³�
		setLocationRelativeTo(null);//����� ����â�� �� �߾ӿ� �߰� �� �Ѵ�.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ������ ���α׷� â�� �����ϸ� �ȿ� ���� �ǰ� �ִ� ��� ���α׷� ����
		setVisible(true);//���α׷�â�� �߰Բ� ���ش�.		
		/* ���� ���۸� �� ����ؼ� �̹����� �ҷ� �´�, �ż������� ���ۿ� �̹����� ��Ƽ� ����ϴ� ����̴�*/
		introBackground = new ImageIcon(Main.class.getResource("../images/background.png")).getImage();
		//main Ŭ������ ��ġ�� ������� �Ͽ� �̹��� ������ ��� �´��� �̹��� �ν��Ͻ��� �޾� introBackground�� �ʱ�ȭ �Ѵ�.
	}

	public void paint(Graphics g){//paint ��� �޼ҵ�� JFrame���� �����ϴ� ��յ� �޼ҵ��̴�
		screenImage =createImage(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);//750x1000 ��ŭ�� �̹����� ���� �Ŀ� screenImage�� �ʱ�ȭ ��Ű�ʹ�
		screenGraphics= screenImage.getGraphics();// screenImage��� ��ü�� getGraphics()�޼ҵ� �̿��Ͽ� �־� �ش�.
		screenDraw(screenGraphics); //screenDraw �� �̿��Ͽ� �׸���.
		g.drawImage(screenImage, 0,0, null);
	}
	
	public void screenDraw(Graphics g){
		g.drawImage(introBackground, 0, 0,null);
		this.repaint();
	}

}
