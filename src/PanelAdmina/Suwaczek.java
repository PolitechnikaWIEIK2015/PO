package PanelAdmina;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Suwaczek extends JSlider implements ChangeListener{
	
	int value;
	
	Suwaczek(){
		super(JSlider.VERTICAL,-50,100,22);
		addChangeListener(this);
        
        //Turn on labels at major tick marks.
 
		setMajorTickSpacing(30);
		setMinorTickSpacing(1);
		setPaintTicks(true);
		setPaintLabels(true);
		setBorder(
                BorderFactory.createEmptyBorder(0,0,10,0));
        Font font = new Font("Serif", Font.ITALIC, 15);
        setFont(font);
	}
	
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource();
        if (!source.getValueIsAdjusting()) {
            value = (int)source.getValue();
                            }
        }


}
