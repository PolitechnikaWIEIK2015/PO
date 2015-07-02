package gui;

public class OGMain {

	private OknoGlowne OG;
	
	public OGMain()
	{
		OG = new OknoGlowne();
		OG.setVisible(true);
	}
	
	public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	OGMain Okno = new OGMain();
            }
        });
        
    }
}
