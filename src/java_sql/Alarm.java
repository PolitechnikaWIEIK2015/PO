package java_sql;

public class Alarm {

	private  int id_alarm;
	private  String data_alarm;
	private  int powod_alarm;
	private  String zrudlo_alarm;
	
	
	public 		void 	setId		(int id) {
        this.id_alarm = id;
    }
    public 		void 	setData		(String data) {
        this.data_alarm = data;
    }

    public 		void 	setPowod	(int powod) {
        this.powod_alarm = powod;
    }
    public 		void 	setZrudlo	(String zrudlo) {
        this.zrudlo_alarm = zrudlo;
    }

	public 		int 	getId		()
	{
		return(this.id_alarm);
	}
	public 		String 	getDate		()
	{
		return(this.data_alarm);
	}

	public 		int 	getPowod	()
	{
		return(this.powod_alarm);
	}
	public 		String 	getZrudlo	()
	{
		return(this.zrudlo_alarm);
	}
	
	
    public Alarm() {
        this.id_alarm 				= 0;
        this.data_alarm 			= "0";
        this.zrudlo_alarm 			= "0";
        this.powod_alarm 			= 0;
    	
    }
    public Alarm(int id, String dataAlarmu, String zrudloZmiany,int powodAlarmu) {
    	
        this.id_alarm 				= id;
        this.data_alarm 			= dataAlarmu;
        this.zrudlo_alarm 			= zrudloZmiany;
        this.powod_alarm 			= powodAlarmu;
    }
 
	
}
