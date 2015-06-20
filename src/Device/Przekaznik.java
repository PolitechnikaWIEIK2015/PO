package java_sql;

public class Przekaznik {
	
	private int id_przkaznik;
	private String nazwa_przekaznik;
	private int stanAc_przekaznik;
	private int dataZmiany_przekaznik;
	private int zrudloZmiany_przekaznik;

	
	public 		void 	setId			(int id) {
        this.id_przkaznik = id;
    }
    public 		void 	setNazwa		(String nazwa) {
    	 this.nazwa_przekaznik = nazwa;
    }
    public 		void 	setStan			(int stan) {
        this.stanAc_przekaznik = stan;
    }
    public 		void 	setData			(int dataDodania) {
        this.dataZmiany_przekaznik = dataDodania;
    }
    public 		void 	setZrudlo		(int zrudloZmiany) {
    	this.zrudloZmiany_przekaznik = zrudloZmiany;
    }

    public 		int		getId			()
    {
    	return(this.id_przkaznik);
    }
    public 		String	getNazwa		()
    {
    	return(this.nazwa_przekaznik);
    }
    public 		int		getStan			()
    {
    	return(this.stanAc_przekaznik);
    }
    public 		int		getData			()
    {
    	return(this.dataZmiany_przekaznik);
    }
    public 		int		getZrudlo		()
    {
    	return(this.zrudloZmiany_przekaznik);
    }
 
    
    public Przekaznik() {
        this.id_przkaznik 				= 0;
        this.nazwa_przekaznik 			= "";
        this.stanAc_przekaznik 			= 0;
        this.dataZmiany_przekaznik 		= 0;
        this.zrudloZmiany_przekaznik 	= 0;
    	
    }
    public Przekaznik(int id, String nazwa, int stanActual,int zrudloZmiany,int dataZmiany) {
    	
        this.id_przkaznik 				= id;
        this.nazwa_przekaznik 			= nazwa;
        this.stanAc_przekaznik 			= stanActual;
        this.zrudloZmiany_przekaznik 	= zrudloZmiany;
        this.dataZmiany_przekaznik 		= dataZmiany;
    }
 
	
}
