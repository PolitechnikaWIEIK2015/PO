package gui;

import java_sql.Alarm;
import java_sql.Java_sql;
import java_sql.Zdarzenia;

import javax.swing.Timer;
import javax.swing.table.TableModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.TimerTask;

public class OknoGlowne extends javax.swing.JFrame implements ActionListener{

    public final static int TWO_SECONDS = 2000;
    private javax.swing.JComboBox ComboBoxLogi;
    private javax.swing.JPanel JPanelBudynek;
    private javax.swing.JPanel JPanelLogi;
    private javax.swing.JPanel JPanelWartosci;
    private javax.swing.JTable TabelaLogiAktualne;
    private javax.swing.JLabel LabelTAktualne;
    private javax.swing.JLabel LabelTZadane;
    private javax.swing.JScrollPane ScrollPaneLogiAktualne;
    private javax.swing.JScrollPane ScrollPaneLogiZadane;
    private javax.swing.JScrollPane ScrollPaneTabelaWartosci;
    private javax.swing.JTable TabelaLogiTAktualne;
    private javax.swing.JTable TabelaWartosci;
    private javax.swing.JLabel bg_image;
    private javax.swing.JLabel temp_aktualne_etykiety[] = new javax.swing.JLabel[8];
    private Helper element;
    private Helper element1;
    private Helper element2;
    private Helper element3;
    private Helper element4;
    private Helper element5;
    private Helper element6;
    private Helper element7;
    Helper[] tabElem;
    Timer timer;
    int delay;
    
    static float wartosci_temp_aktualne[] = new float[8];
    
    public OknoGlowne() {
    	initComponents();
    	delay = 5900;
        //Set up a timer that calls this object's action handler.
        timer = new Timer(delay, this);
        timer.setInitialDelay(delay); //We pause animation twice per cycle
                                          //by restarting the timer
        timer.setCoalesce(true);
        timer.setDelay(delay);
        timer.start();

    }
    
    private void initComponents() {

    	JPanelBudynek = new javax.swing.JPanel();
        bg_image = new javax.swing.JLabel();
        JPanelWartosci = new javax.swing.JPanel();
        ScrollPaneTabelaWartosci = new javax.swing.JScrollPane();
        TabelaWartosci = new javax.swing.JTable();
        JPanelLogi = new javax.swing.JPanel();
        ScrollPaneLogiAktualne = new javax.swing.JScrollPane();
        TabelaLogiTAktualne = new javax.swing.JTable();
        ComboBoxLogi = new javax.swing.JComboBox();
        LabelTAktualne = new javax.swing.JLabel();
        LabelTZadane = new javax.swing.JLabel();
        ScrollPaneLogiZadane = new javax.swing.JScrollPane();
        TabelaLogiAktualne = new javax.swing.JTable();
        Helper[] tabElem = {element = new Helper(1),
        element1 = new Helper(2),
        element2 = new Helper(3),
        element3 = new Helper(4),
        element4 = new Helper(5),
        element5 = new Helper(6),
        element6 = new Helper(7),
        element7 = new Helper(8)};

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JPanelBudynek.setLayout(null);
        for(int i = 0; i<8; i++)
        {
        	float w = tabElem[i].sensor.getStan(); //potrzebna funkcja, ktora pobierze wartosc
        	String tekst = "Temp: "+(String.valueOf(w));
        	temp_aktualne_etykiety[i] = new javax.swing.JLabel(tekst);
        	JPanelBudynek.add(temp_aktualne_etykiety[i]);
        	temp_aktualne_etykiety[i].setSize(100, 30);
        }
        
        
        temp_aktualne_etykiety[0].setBounds(140, 100, 75, 20);
        temp_aktualne_etykiety[1].setBounds(120, 390, 75, 20);
        temp_aktualne_etykiety[2].setBounds(350, 240, 75, 20);
        temp_aktualne_etykiety[3].setBounds(390, 90, 75, 20);
        temp_aktualne_etykiety[4].setBounds(550, 90, 75, 20);
        temp_aktualne_etykiety[5].setBounds(530, 370, 75, 20);
        temp_aktualne_etykiety[6].setBounds(380, 370, 75, 20);
        temp_aktualne_etykiety[7].setBounds(560, 290, 75, 20);
        
        bg_image.setIcon(new javax.swing.ImageIcon("imgs/bg_img.jpg")); // NOI18N
        JPanelBudynek.add(bg_image);
        bg_image.setBounds(0, 0, 676, 498);
        
        TabelaWartosci.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Salon", tabElem[0].sensor.getStan(), tabElem[0].sensor.getZadana(), "Wylaczone"},
                {"Kuchnia", tabElem[1].sensor.getStan(), tabElem[1].sensor.getZadana(), "Wylaczone"},
                {"Korytarz", tabElem[2].sensor.getStan(), tabElem[2].sensor.getZadana(), "Wylaczone"},
                {"Sypialnia 1", tabElem[3].sensor.getStan(), tabElem[3].sensor.getZadana(), "Wylaczone"},
                {"Sypialnia 2", tabElem[4].sensor.getStan(), tabElem[4].sensor.getZadana(), "Wylaczone"},
                {"Sypialnia 3", tabElem[5].sensor.getStan(), tabElem[5].sensor.getZadana(), "Wylaczone"},
                {"£azienka", tabElem[6].sensor.getStan(), tabElem[6].sensor.getZadana(), "Wylaczone"},
                {"Pomieszczenie Gospodarcze", tabElem[7].sensor.getStan(), tabElem[7].sensor.getZadana(), "Wylaczone"}
            },
            new String [] {
                "Pomieszczenie", "Temperatura aktualna", "Temperatura zadana", "ród³o ogrzewania"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
            
        });
        ScrollPaneTabelaWartosci.setViewportView(TabelaWartosci);
        if (TabelaWartosci.getColumnModel().getColumnCount() > 0) {
            TabelaWartosci.getColumnModel().getColumn(0).setResizable(false);
            TabelaWartosci.getColumnModel().getColumn(1).setResizable(false);
            TabelaWartosci.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout JPanelWartosciLayout = new javax.swing.GroupLayout(JPanelWartosci);
        JPanelWartosci.setLayout(JPanelWartosciLayout);
        JPanelWartosciLayout.setHorizontalGroup(
            JPanelWartosciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelWartosciLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrollPaneTabelaWartosci, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
                .addContainerGap())
        );
        JPanelWartosciLayout.setVerticalGroup(
            JPanelWartosciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelWartosciLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrollPaneTabelaWartosci, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JPanelLogi.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Logi", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        Object wTLTA[][] = new Object[25][3];
        Object wTLTZ[][] = new Object[25][3];
        for (int x = 0; x<25; x++)
        	for (int y = 0; y<3; y++)
        	{
        		wTLTA[x][y] = null;
        		wTLTZ[x][y] = null;
        	}
        
        TabelaLogiTAktualne.setModel(new javax.swing.table.DefaultTableModel(wTLTA, new String [] {"Data", "Godzina", "Temperatura"})
        				{
        				Class[] types = new Class [] {
        						java.lang.String.class, java.lang.Float.class, java.lang.Float.class
        				};
        				
        				public boolean isCellEditable(int rowIndex, int columnIndex) {
            			return false;
        				}
        });
        ScrollPaneLogiAktualne.setViewportView(TabelaLogiTAktualne);
        ComboBoxLogi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Brak", "Salon", "Kuchnia", "Sypialnia 1", "Sypialnia 2", "Sypialnia 3", "Lazienka", "Pomieszczenie Gospodarcze" }));
        LabelTAktualne.setText("Temperatury aktualne");
        LabelTZadane.setText("Temperatury zadane");
        TabelaLogiAktualne.setModel(new javax.swing.table.DefaultTableModel(wTLTZ, new String [] {"Data", "Godzina", "Temperatura"})
            
        		{
				Class[] types = new Class [] {
						java.lang.String.class, java.lang.Float.class, java.lang.Float.class
				};
				
				public boolean isCellEditable(int rowIndex, int columnIndex) {
    			return false;
				}
});
        /*******dodawanie listenerow*******/
        TabelaWartosci.getModel().addTableModelListener(new TableModelListenerTWartosci());
        ComboBoxLogi.addActionListener(this);
        
        /**********ustawianie elementow********/
        ScrollPaneLogiZadane.setViewportView(TabelaLogiAktualne);

        javax.swing.GroupLayout JPanelLogiLayout = new javax.swing.GroupLayout(JPanelLogi);
        JPanelLogi.setLayout(JPanelLogiLayout);
        JPanelLogiLayout.setHorizontalGroup(
            JPanelLogiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelLogiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPanelLogiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelLogiLayout.createSequentialGroup()
                        .addComponent(ScrollPaneLogiAktualne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelLogiLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(JPanelLogiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JPanelLogiLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(LabelTAktualne))
                            .addComponent(ComboBoxLogi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(153, 153, 153))))
            .addGroup(JPanelLogiLayout.createSequentialGroup()
                .addGroup(JPanelLogiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelLogiLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ScrollPaneLogiZadane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPanelLogiLayout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(LabelTZadane)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JPanelLogiLayout.setVerticalGroup(
            JPanelLogiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelLogiLayout.createSequentialGroup()
                .addComponent(ComboBoxLogi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelTAktualne)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollPaneLogiAktualne, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelTZadane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ScrollPaneLogiZadane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(JPanelWartosci, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JPanelBudynek, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPanelLogi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JPanelBudynek, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JPanelWartosci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JPanelLogi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        
        setSize(1200, 705);
        setResizable(false);
        
    }
    

    	 

    
    /*********aktualizacja stanow zrodel ciepla*******/
     void aktualizuj_zc(){
    	 int[] w = new int[8];
    	 w[0] = element.relay.getStan();
    	 w[1] = element1.relay.getStan();
    	 w[2] = element2.relay.getStan();
    	 w[3] = element3.relay.getStan();
    	 w[4] = element4.relay.getStan();
    	 w[5] = element5.relay.getStan();
    	 w[6] = element6.relay.getStan();
    	 w[7] = element7.relay.getStan();
    	for (int i = 0; i<8; i++)
		{
//    		System.out.println(Integer.toString(tabElem[3].relay.getStan())); //odczyt: 0 - wyl, 1 - wl
    		if (w[i]==0)
    			TabelaWartosci.setValueAt("Wylaczone", i, 3);
    		else
    			TabelaWartosci.setValueAt("Wlaczone", i, 3);
		}
    }
    /**********aktualizacja temperatur********/
    void aktualizuj_temp_aktualne(){
    	wartosci_temp_aktualne[0] = element.sensor.getStan();
    	wartosci_temp_aktualne[1] = element1.sensor.getStan();
    	wartosci_temp_aktualne[2] = element2.sensor.getStan();
    	wartosci_temp_aktualne[3] = element3.sensor.getStan();
    	wartosci_temp_aktualne[4] = element4.sensor.getStan();
    	wartosci_temp_aktualne[5] = element5.sensor.getStan();
    	wartosci_temp_aktualne[6] = element6.sensor.getStan();
    	wartosci_temp_aktualne[7] = element7.sensor.getStan();
    	
		for (int i = 0; i<8; i++)
		{
			TabelaWartosci.setValueAt(wartosci_temp_aktualne[i], i, 1);
			temp_aktualne_etykiety[i].setText("Temp: "+wartosci_temp_aktualne[i]);
		}
	}
	/*********Wyswietlanie logow***********/
	public void actionPerformed(ActionEvent e) {
		timer.stop();
		if(e.getSource()==timer){

			
			
			element.update();
			element1.update();
			element2.update();
			element3.update();
			element4.update();
			element5.update();
			element6.update();
			element7.update();
			
			aktualizuj_temp_aktualne();
			aktualizuj_zc();
			
		}
		if(e.getSource()==ComboBoxLogi){
			javax.swing.JComboBox cb = (javax.swing.JComboBox)e.getSource();
			String pomieszczenie = (String)cb.getSelectedItem();
			System.out.println(pomieszczenie);
			wyswietl_logi(pomieszczenie);	
		}	
		timer.restart();
	}
	
	private String textLog(int log){
		String text;
		switch(log){
		case 1:
			text = "ALARM_Za_Niska_Temp";
			break;
		case 2:
			text = "ALARM_Za_Wysoka_Temp";
			break;
		case 3:
			text = "ALARM_Brak_Elem._Sterujacego";
			break;
		case 4:
			text = "Pomieszczenie_Nagrzane";
			break;
		case 5:
			text = "Dogrzanie_Pomieszczenia";
			break;
		case 6:
			text = "Zmiana Zadanej";
			break;
		default:
			text = "SystemFAULT";
				break;
		}
		return text;
	}
	
	private void wyswietl_logi(String pomieszczenie)
	{
		int w = -1;
		if(pomieszczenie.equals("Brak"))
			w = -1;
		else if(pomieszczenie.equals("Salon"))
			w = 0;
		else if(pomieszczenie.equals("Kuchnia"))
			w = 1;
		else if(pomieszczenie.equals("Korytarz"))
			w = 2;
		else if(pomieszczenie.equals("Sypialnia 1"))
			w = 3;
		else if(pomieszczenie.equals("Sypialnia 2"))
			w = 4;
		else if(pomieszczenie.equals("Sypialnia 3"))
			w = 5;
		else if(pomieszczenie.equals("Lazienka"))
			w = 6;
		else if(pomieszczenie.equals("Pomieszczenie Gospodarcze"))
			w = 7;
		Alarm printer = new Alarm();
		Zdarzenia event = new Zdarzenia();
		
		for (int i = 0; i<25; i++)
		{
			Java_sql.conection();
			Java_sql.getAlarmyData((element.alert.getId()-i), printer);
			Java_sql.getZdarzenie((element.event.getId()-i), event);
			Java_sql.close();
			
			TabelaLogiTAktualne.setValueAt(event.getDate(), i, 0);
			TabelaLogiTAktualne.setValueAt(textLog(event.getPowod()), i, 1);
			TabelaLogiTAktualne.setValueAt(event.getStan(), i, 2);

			
			TabelaLogiAktualne.setValueAt(printer.getDate(), i, 0);
			TabelaLogiAktualne.setValueAt(printer.getZrudlo(), i, 1);
			TabelaLogiAktualne.setValueAt(textLog(printer.getPowod()), i, 2);

			
		}
	}
}

/*******listener dla tabeli wartosci***********/
class TableModelListenerTWartosci implements TableModelListener{
	public void tableChanged(TableModelEvent e) {
		TableModel model = (TableModel)e.getSource();
		int row = e.getFirstRow();
		int column = e.getColumn();
		if(column == 2)
			{
				float nowa_wartosc_temp = (float)model.getValueAt(row, column);
					/*wywolanie funkcji zmiany temperatury zadanej w BD
					 * row: 0-7 - pomieszczenie
					 * nowa_wartosc_temp - nowa wartosc temperatury zadanej (float)
					 */	
				Helper updater = new Helper(row+1);
				
				updater.updateZadana((int)nowa_wartosc_temp);
			}
		}


}