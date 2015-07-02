package gui;

import javax.swing.table.TableModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OknoGlowne extends javax.swing.JFrame implements ActionListener{

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
	
    static float wartosci_temp_aktualne[] = new float[8];
    private int wybor;
    
    public OknoGlowne() {
    	initComponents();
    }
     
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OknoGlowne().setVisible(true);
            }
        });
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
        wybor = 0;
        
        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JPanelBudynek.setLayout(null);
        for(int i = 0; i<8; i++)
        {
        	float w = 0; //potrzebna funkcja, ktora pobierze wartosc
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
                {"Salon", null, null, "Wylaczone"},
                {"Kuchnia", null, null, "Wylaczone"},
                {"Korytarz", null, null, "Wylaczone"},
                {"Sypialnia 1", null, null, "Wylaczone"},
                {"Sypialnia 2", null, null, "Wylaczone"},
                {"Sypialnia 3", null, null, "Wylaczone"},
                {"£azienka", null, null, "Wylaczone"},
                {"Pomieszczenie Gospodarcze", null, null, "Wylaczone"}
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

        TabelaLogiTAktualne.setModel(new javax.swing.table.DefaultTableModel(
        		 new Object [][] {
        	                {null, null, null},
        	                {null, null, null},
        	                {null, null, null},
        	                {null, null, null},
        	                {null, null, null},
        	                {null, null, null},
        	                {null, null, null},
        	                {null, null, null},
        	                {null, null, null},
        	                {null, null, null},
        	                {null, null, null},
        	                {null, null, null},
        	                {null, null, null},
        	                {null, null, null},
        	                {null, null, null},
        	                {null, null, null},
        	                {null, null, null},
        	                {null, null, null},
        	                {null, null, null},
        	                {null, null, null},
        	                {null, null, null},
        	                {null, null, null},
        	                {null, null, null},
        	                {null, null, null},
        	                {null, null, null}
        	            },
        	            new String [] {
        	                "Data", "Godzina", "Temperatura"
        		 })
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

        TabelaLogiAktualne.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Data", "Godzina", "Temperatura"
            }
        ));
        
        TabelaWartosci.getModel().addTableModelListener(new TableModelListenerTWartosci());
      //  ComboBoxLogi.addActionListener(arg0);
        
        
        
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
        
        pack();
    }
    
    void aktualizuj_temp_aktualne(){
		for (int i = 0; i<8; i++)
		{
			TabelaWartosci.setValueAt(wartosci_temp_aktualne[i], i, 2);
			temp_aktualne_etykiety[i].setText("Temp: "+wartosci_temp_aktualne[i]);
		}
	};
	
	public void actionPerformed(ActionEvent e) {
		javax.swing.JComboBox cb = (javax.swing.JComboBox)e.getSource();
		String pomieszczenie = (String)cb.getSelectedItem();
		wyswietl_logi(pomieszczenie);
		
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
		
		for (int i = 0; i<25; i++)
		{
			//Pobieranie daty, jaki format? String?
		//	TabelaLogiTAktualne.setValueAt(String, arg1, arg2);
			
		}
	}
}
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
    }
}
}
