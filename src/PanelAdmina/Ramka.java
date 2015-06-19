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
		setSize(1000, 200);
		setLayout(new FlowLayout());
		

		add(new JButton("Przycisk 1"));
		add(new JButton("Przycisk 2"));
		add(new JButton("Przycisk 3"));
		setVisible(true);

		for(int i=0; i<10; i++)
			add(new JSlider(JSlider.VERTICAL,-50,100));
		
		
	}
}
