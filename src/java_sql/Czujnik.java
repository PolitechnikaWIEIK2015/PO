package java_sql;

public class Czujnik {

	private int id_czujnik;
	private String nazwa_czujnik;
	private int typ_czujnik;
	private int stanAc_czujnik;
	private int stanMin_czujnik;
	private int stanMax_czujnik;
	private int data_czujnik;
	
	public 		void 	setId			(int id) {
        this.id_czujnik = id;
    }
    public 		void 	setNazwa		(String nazwa) {
    	 this.nazwa_czujnik = nazwa;
    }
    public 		void 	setTyp			(int typ) {
        this.typ_czujnik = typ;
    }
    public 		void 	setStan			(int stan) {
        this.stanAc_czujnik = stan;
    }
    public 		void 	setStanMin		(int stanMinimalny) {
        this.stanMin_czujnik = stanMinimalny;
    }
    public 		void 	setStanMax		(int stanMaksymalny) {
        this.stanMax_czujnik = stanMaksymalny;
    }
    public 		void 	setData			(int dataDodania) {
        this.data_czujnik = dataDodania;
    }

    public 		int		getId			()
    {
    	return(this.id_czujnik);
    }
    public 		String	getNazwa		()
    {
    	return(this.nazwa_czujnik);
    }
    public 		int		getTyp			()
    {
    	return(this.typ_czujnik);
    }
    public 		int		getStan			()
    {
    	return(this.stanAc_czujnik);
    }
    public 		int		getStanMin		()
    {
    	return(this.stanMin_czujnik);
    }
    public 		int		getStanMax		()
    {
    	return(this.stanMax_czujnik);
    }
    public 		int		getData			()
    {
    	return(this.data_czujnik);
    }

    
    public Czujnik() {
        this.id_czujnik 		= 0;
    	this.typ_czujnik 		= 0;
        this.nazwa_czujnik 		= "";
        this.stanAc_czujnik 	= 0;
        this.stanMin_czujnik 	= 0;
        this.stanMax_czujnik 	= 0;
        this.data_czujnik 		= 0;
    	
    }
    public Czujnik(int id, int typ, String nazwa, int stanActual,int stanMin,int stanMax,int data) {
    	
        this.id_czujnik 		= id;
    	this.typ_czujnik 		= typ;
        this.nazwa_czujnik 		= nazwa;
        this.stanAc_czujnik 	= stanActual;
        this.stanMin_czujnik 	= stanMin;
        this.stanMax_czujnik 	= stanMax;
        this.data_czujnik 		= data;
    }
 
/*    @Override
    public String toString() {
        return "["+id_czujnik+"] - "+nazwa_czujnik+" - ["+id_czujnik+"] - ;
    }*/
}
