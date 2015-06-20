package java_sql;

public class Alarm {

	private  int id_alarm;
	private  int data_alarm;
	private  int godzina_alarm;
	private  int powod_alarm;
	private  int zrudlo_alarm;
	
	
	public 		void 	setId		(int id) {
        this.id_alarm = id;
    }
    public 		void 	setData		(int data) {
        this.data_alarm = data;
    }
    public 		void 	setGodzina	(int godzina) {
        this.godzina_alarm = godzina;
    }
    public 		void 	setPowod	(int powod) {
        this.powod_alarm = powod;
    }
    public 		void 	setZrudlo	(int zrudlo) {
        this.zrudlo_alarm = zrudlo;
    }

	public 		int 	getId		()
	{
		return(this.id_alarm);
	}
	public 		int 	getDate		()
	{
		return(this.data_alarm);
	}
	public 		int 	getGodzina	()
	{
		return(this.godzina_alarm);
	}
	public 		int 	getPowod	()
	{
		return(this.powod_alarm);
	}
	public 		int 	getZrudlo	()
	{
		return(this.zrudlo_alarm);
	}
	
	
    public Alarm() {
        this.id_alarm 				= 0;
        this.data_alarm 			= 0;
        this.godzina_alarm 			= 0;
        this.zrudlo_alarm 			= 0;
        this.powod_alarm 			= 0;
    	
    }
    public Alarm(int id, int dataAlarmu, int godzinaAlarmu,int zrudloZmiany,int powodAlarmu) {
    	
        this.id_alarm 				= id;
        this.data_alarm 			= dataAlarmu;
        this.godzina_alarm 			= godzinaAlarmu;
        this.zrudlo_alarm 			= zrudloZmiany;
        this.powod_alarm 			= powodAlarmu;
    }
 
	
}
