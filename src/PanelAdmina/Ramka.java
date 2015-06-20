package PanelAdmina;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JSlider;

import java.awt.FlowLayout;


public class Ramka extends JFrame{

	public Ramka(){
		super("Panel Admina");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(100, 100);
		setSize(700, 270);
		setLayout(new FlowLayout());
		
		setVisible(true);

		for(int i=0; i<10; i++)
			add(new Suwaczek());
		
		
	}
}
