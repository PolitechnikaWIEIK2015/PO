package OknoAdmina;

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import java.awt.GridLayout;
import javax.swing.JSlider;
//import java.awt.CardLayout;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
//import java.awt.FlowLayout;
//import javax.swing.JScrollBar;
//import javax.swing.SwingConstants;
//import javax.swing.JLabel;
import javax.swing.JTextField;
//import javax.swing.JSeparator;
import javax.swing.JCheckBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import java.awt.Color;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;

public class Panelik extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JSlider slider;
	private JSlider slider_1;
	private JSlider slider_2;
	private JSlider slider_3;
	private JSlider slider_4;
	private JSlider slider_5;
	private JCheckBox chckbxCzujnik;
	private JCheckBox chckbxCzujnik_1;
	private JCheckBox chckbxCzujnik_4;
	private JCheckBox chckbxCzujnik_3;
	private JCheckBox chckbxCzujnik_2;
	private JCheckBox chckbxCzujnik_5;
	private Controller elementSterujacy;
	private Controller elementSterujacy1;
	private Controller elementSterujacy2;
	private Controller elementSterujacy3;
	private Controller elementSterujacy4;
	private Controller elementSterujacy5;
	private Controller elementSterujacy6;
	private Controller elementSterujacy7;
	private JSlider slider_7;
	private JSlider slider_6;
	private JCheckBox checkBox;
	private JCheckBox checkBox_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Panelik frame = new Panelik();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Panelik() {
		
		elementSterujacy = new Controller(1);
		elementSterujacy1 = new Controller(2);
		elementSterujacy2 = new Controller(3);
		elementSterujacy3 = new Controller(4);
		elementSterujacy4 = new Controller(5);
		elementSterujacy5 = new Controller(6);
		elementSterujacy6 = new Controller(7);
		elementSterujacy7 = new Controller(8);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Panel Administracyjny");
		setSize(500, 350);
		setForeground(Color.DARK_GRAY);
		setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		
		
		slider = new JSlider();
		slider.setValue(elementSterujacy.getactualna());
		slider.setEnabled(elementSterujacy.getStateSensor());
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(slider.getValueIsAdjusting())
				textField.setText(Integer.toString(slider.getValue()));
			}
		});
		slider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int wartosc;
				wartosc = slider.getValue();
				if(chckbxCzujnik.isSelected()){
					elementSterujacy.update(chckbxCzujnik.isSelected(),slider.getValue());
					textField.setText(Integer.toString(wartosc));
				}
				else
					;
			
			}
		});
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMinorTickSpacing(1);
		slider.setMinimum(-50);
		slider.setBounds(12, 12, 200, 27);
		getContentPane().add(slider);
		
		slider_1 = new JSlider();
		slider_1.setValue(elementSterujacy1.getactualna());
		slider_1.setEnabled(elementSterujacy1.getStateSensor());
		slider_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(slider_1.getValueIsAdjusting())
				textField_1.setText(Integer.toString(slider_1.getValue()));
			}
		});
		slider_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int wartosc;
				wartosc = slider_1.getValue();
				if(chckbxCzujnik_1.isSelected()){
					elementSterujacy1.update(chckbxCzujnik_1.isSelected(),slider_1.getValue());
					textField_1.setText(Integer.toString(wartosc));
				}
				else
					;
			
			}
		});
		slider_1.setSnapToTicks(true);
		slider_1.setPaintTicks(true);
		slider_1.setPaintLabels(true);
		slider_1.setMinorTickSpacing(1);
		slider_1.setMinimum(-50);
		slider_1.setBounds(12, 51, 200, 27);
		getContentPane().add(slider_1);
		
		slider_2 = new JSlider();
		slider_2.setValue(elementSterujacy2.getactualna());
		slider_2.setEnabled(elementSterujacy2.getStateSensor());
		slider_2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(slider_2.getValueIsAdjusting())
				textField_2.setText(Integer.toString(slider_2.getValue()));
			}
		});
		slider_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int wartosc;
				wartosc = slider_2.getValue();
				if(chckbxCzujnik_2.isSelected()){
					textField_2.setText(Integer.toString(wartosc));
					elementSterujacy2.update(chckbxCzujnik_2.isSelected(),slider_2.getValue());
				}
				else
					;
			
			}
		});
		slider_2.setSnapToTicks(true);
		slider_2.setPaintTicks(true);
		slider_2.setPaintLabels(true);
		slider_2.setMinorTickSpacing(1);
		slider_2.setMinimum(-50);
		slider_2.setBounds(12, 86, 200, 27);
		getContentPane().add(slider_2);
		
		slider_3 = new JSlider();
		slider_3.setValue(elementSterujacy3.getactualna());
		slider_3.setEnabled(elementSterujacy3.getStateSensor());
		slider_3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(slider_3.getValueIsAdjusting())
				textField_3.setText(Integer.toString(slider_3.getValue()));
			}
		});
		slider_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int wartosc;
				wartosc = slider_3.getValue();
				if(chckbxCzujnik_3.isSelected()){
					textField_3.setText(Integer.toString(wartosc));
					elementSterujacy3.update(chckbxCzujnik_3.isSelected(),slider_3.getValue());
					}
				else
					;
			
			}
		});
		slider_3.setSnapToTicks(true);
		slider_3.setPaintTicks(true);
		slider_3.setPaintLabels(true);
		slider_3.setMinorTickSpacing(1);
		slider_3.setMinimum(-50);
		slider_3.setBounds(12, 120, 200, 27);
		getContentPane().add(slider_3);
		
		slider_4 = new JSlider();
		slider_4.setValue(elementSterujacy4.getactualna());
		slider_4.setEnabled(elementSterujacy4.getStateSensor());
		slider_4.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(slider_4.getValueIsAdjusting())
				textField_4.setText(Integer.toString(slider_4.getValue()));
			}
		});
		slider_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int wartosc;
				wartosc = slider_4.getValue();
				if(chckbxCzujnik_4.isSelected()){
					textField_4.setText(Integer.toString(wartosc));
					elementSterujacy4.update(chckbxCzujnik_4.isSelected(),slider_4.getValue());}
				else
					;
			
			}
		});
		slider_4.setSnapToTicks(true);
		slider_4.setPaintTicks(true);
		slider_4.setPaintLabels(true);
		slider_4.setMinorTickSpacing(1);
		slider_4.setMinimum(-50);
		slider_4.setBounds(12, 153, 200, 27);
		getContentPane().add(slider_4);
		
		slider_5 = new JSlider();
		slider_5.setValue(elementSterujacy5.getactualna());
		slider_5.setEnabled(elementSterujacy5.getStateSensor());
		slider_5.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(slider_5.getValueIsAdjusting())
				textField_5.setText(Integer.toString(slider_5.getValue()));
			}
		});
		slider_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int wartosc;
				wartosc = slider_5.getValue();
				if(chckbxCzujnik_5.isSelected()){
					textField_5.setText(Integer.toString(wartosc));
					elementSterujacy5.update(chckbxCzujnik_5.isSelected(),slider_5.getValue());}
				else
					;
			
			}
		});
		slider_5.setSnapToTicks(true);
		slider_5.setPaintTicks(true);
		slider_5.setPaintLabels(true);
		slider_5.setMinorTickSpacing(1);
		slider_5.setMinimum(-50);
		slider_5.setBounds(12, 188, 200, 27);
		getContentPane().add(slider_5);
		
		chckbxCzujnik_5 = new JCheckBox(elementSterujacy5.getNazwaSensor());
		chckbxCzujnik_5.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(chckbxCzujnik_5.isSelected()){
					slider_5.setEnabled(true);
					elementSterujacy5.updateStateSensor(true);
					System.out.println("start " + elementSterujacy5.getNazwaSensor() );
					//textField.setText(Integer.toString(slider.getValue()));
					}
				else{
					slider_5.setEnabled(false);
					elementSterujacy5.updateStateSensor(false);
					textField_5.setText("OFF");}
			}
		});
		chckbxCzujnik_5.setSelected(elementSterujacy5.getStateSensor());
		chckbxCzujnik_5.setBounds(220, 180, 129, 23);
		getContentPane().add(chckbxCzujnik_5);
		
		chckbxCzujnik_1 = new JCheckBox(elementSterujacy4.getNazwaSensor());
		chckbxCzujnik_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(chckbxCzujnik_1.isSelected()){
					elementSterujacy4.updateStateSensor(true);
					slider_4.setEnabled(true);
					//textField.setText(Integer.toString(slider.getValue()));
					}
				else{
					elementSterujacy4.updateStateSensor(false);
					slider_4.setEnabled(false);
					textField_4.setText("OFF");}
			}
		});
		chckbxCzujnik_1.setSelected(elementSterujacy4.getStateSensor());
		chckbxCzujnik_1.setBounds(220, 149, 129, 23);
		getContentPane().add(chckbxCzujnik_1);
		
		chckbxCzujnik_4 = new JCheckBox(elementSterujacy3.getNazwaSensor());
		chckbxCzujnik_4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(chckbxCzujnik_4.isSelected()){
					elementSterujacy3.updateStateSensor(true);
					slider_3.setEnabled(true);
					//textField.setText(Integer.toString(slider.getValue()));
					}
				else{
					elementSterujacy3.updateStateSensor(false);
					slider_3.setEnabled(false);
					textField_3.setText("OFF");}
			}
		});
		chckbxCzujnik_4.setSelected(elementSterujacy3.getStateSensor());
		chckbxCzujnik_4.setBounds(220, 116, 129, 23);
		getContentPane().add(chckbxCzujnik_4);
		
		chckbxCzujnik_3 = new JCheckBox(elementSterujacy2.getNazwaSensor());
		chckbxCzujnik_3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(chckbxCzujnik_3.isSelected()){
					elementSterujacy2.updateStateSensor(true);
					slider_2.setEnabled(true);
					//textField.setText(Integer.toString(slider.getValue()));
					}
				else{
					elementSterujacy2.updateStateSensor(false);
					slider_2.setEnabled(false);
					textField_2.setText("OFF");}
			}
		});
		chckbxCzujnik_3.setSelected(elementSterujacy2.getStateSensor());
		chckbxCzujnik_3.setBounds(220, 82, 129, 23);
		getContentPane().add(chckbxCzujnik_3);
		
		chckbxCzujnik_2 = new JCheckBox(elementSterujacy1.getNazwaSensor());
		chckbxCzujnik_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(chckbxCzujnik_2.isSelected()){
					elementSterujacy1.updateStateSensor(true);
					slider_1.setEnabled(true);
					//textField.setText(Integer.toString(slider.getValue()));
					}
				else{
					elementSterujacy1.updateStateSensor(false);
					slider_1.setEnabled(false);
					textField_1.setText("OFF");}
			}
		});
		chckbxCzujnik_2.setSelected(elementSterujacy.getStateSensor());
		chckbxCzujnik_2.setBounds(220, 43, 129, 23);
		getContentPane().add(chckbxCzujnik_2);
		
		chckbxCzujnik = new JCheckBox(elementSterujacy.getNazwaSensor());
		chckbxCzujnik.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(chckbxCzujnik.isSelected()){
					elementSterujacy.updateStateSensor(true);
					slider.setEnabled(true);
					//textField.setText(Integer.toString(slider.getValue()));
					}
				else{
					elementSterujacy.updateStateSensor(false);
					slider.setEnabled(false);
					textField.setText("OFF");}
			}
		});
		chckbxCzujnik.setSelected(elementSterujacy.getStateSensor());
		chckbxCzujnik.setBounds(220, 12, 129, 23);
		getContentPane().add(chckbxCzujnik);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(359, 12, 114, 23);
		getContentPane().add(textField);
		textField.setColumns(10);
		textField.setText(Integer.toString(slider.getValue()));
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(359, 37, 114, 23);
		getContentPane().add(textField_1);
		textField_1.setText(Integer.toString(slider_1.getValue()));
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(359, 72, 114, 23);
		getContentPane().add(textField_2);
		textField_2.setText(Integer.toString(slider_2.getValue()));
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(359, 106, 114, 23);
		getContentPane().add(textField_3);
		textField_3.setText(Integer.toString(slider_3.getValue()));
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(359, 139, 114, 23);
		getContentPane().add(textField_4);
		textField_4.setText(Integer.toString(slider_4.getValue()));
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(359, 174, 114, 23);
		getContentPane().add(textField_5);
		textField_5.setText(Integer.toString(slider_5.getValue()));
		
		slider_6 = new JSlider();
		slider_6.setValue(elementSterujacy6.getactualna());
		slider_6.setEnabled(elementSterujacy6.getStateSensor());
		slider_6.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(slider_6.getValueIsAdjusting())
				textField_6.setText(Integer.toString(slider_6.getValue()));
			}
		});
		slider_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int wartosc;
				wartosc = slider_6.getValue();
				if(checkBox_1.isSelected()){
					textField_6.setText(Integer.toString(wartosc));
					elementSterujacy6.update(checkBox_1.isSelected(),slider_6.getValue());}
				else
					;
			
			}
		});
		slider_6.setSnapToTicks(true);
		slider_6.setPaintTicks(true);
		slider_6.setPaintLabels(true);
		slider_6.setMinorTickSpacing(1);
		slider_6.setMinimum(-50);
		slider_6.setBounds(12, 226, 200, 27);
		getContentPane().add(slider_6);
		
		slider_7 = new JSlider();
		slider_7.setValue(elementSterujacy7.getactualna());
		slider_7.setEnabled(elementSterujacy7.getStateSensor());
		slider_7.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(slider_7.getValueIsAdjusting())
				textField_7.setText(Integer.toString(slider_7.getValue()));
			}
		});
		slider_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int wartosc;
				wartosc = slider_7.getValue();
				if(checkBox.isSelected()){
					textField_7.setText(Integer.toString(wartosc));
					elementSterujacy7.update(checkBox.isSelected(),slider_7.getValue());}
				else
					;
			
			}
		});
		slider_7.setSnapToTicks(true);
		slider_7.setPaintTicks(true);
		slider_7.setPaintLabels(true);
		slider_7.setMinorTickSpacing(1);
		slider_7.setMinimum(-50);
		slider_7.setBounds(12, 261, 200, 27);
		getContentPane().add(slider_7);
		
		checkBox = new JCheckBox(elementSterujacy7.getNazwaSensor());
		checkBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(checkBox.isSelected()){
					elementSterujacy7.updateStateSensor(true);
					slider_7.setEnabled(true);
					//textField.setText(Integer.toString(slider.getValue()));
					}
				else{
					elementSterujacy7.updateStateSensor(false);
					slider_7.setEnabled(false);
					textField_7.setText("OFF");}
			}
		});
		checkBox.setSelected(elementSterujacy7.getStateSensor());
		checkBox.setBounds(220, 253, 129, 23);
		getContentPane().add(checkBox);
		
		checkBox_1 = new JCheckBox(elementSterujacy6.getNazwaSensor());
		checkBox_1.setEnabled(elementSterujacy6.getStateSensor());
		checkBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(checkBox_1.isSelected()){
					elementSterujacy6.updateStateSensor(true);
					slider_6.setEnabled(true);
					//textField.setText(Integer.toString(slider.getValue()));
					}
				else{
					elementSterujacy6.updateStateSensor(false);
					slider_6.setEnabled(false);
					textField_6.setText("OFF");}
			}
		});
		checkBox_1.setBounds(220, 222, 129, 23);
		getContentPane().add(checkBox_1);
		
		textField_6 = new JTextField();
		textField_6.setText(Integer.toString(slider_6.getValue()));
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(359, 212, 114, 23);
		getContentPane().add(textField_6);

		
		textField_7 = new JTextField();
		textField_7.setText(Integer.toString(slider_7.getValue()));
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(359, 247, 114, 23);
		getContentPane().add(textField_7);

		
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{getContentPane(), slider, slider_1, slider_2, slider_3, slider_4, slider_5, chckbxCzujnik_5, chckbxCzujnik_1, chckbxCzujnik_4, chckbxCzujnik_3, chckbxCzujnik_2, chckbxCzujnik, textField, textField_1, textField_2, textField_3, textField_4, textField_5}));
	}
}
