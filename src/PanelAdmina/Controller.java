package PanelAdmina;
import Device.* ;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Controller {
	public final int OFF = 0;
	public final int ON = 1;
	private Przekaznik relay;
	private Czujnik sensor;
	private int tryb;
	private int alarm;
	
	Controller(){
		sensor = new Czujnik();
		relay = new Przekaznik();
		tryb = 0;
		alarm = 0;
	}
	public void update(){
		if(alarm==ON){
			makeAlarm();
			if(relay.getStan()!= OFF){
				makeZdarzenie();
				relay.setStan(OFF);
			}
			
		}else{
			if(sensor.getStan()<sensor.getStanMin() || sensor.getStan()>sensor.getStanMax())
				alarm = ON;
			else{
				switch(tryb){
				case 0:
			
					break;
				case 1:
					break;
				case 2:
					break;
				case 3:
			
					break;
				default:
					break;
					}
			}
		}
		
	}
	private void makeAlarm(){
        SimpleDateFormat simpleDateHere = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss (Z)");
        System.out.println( "ALARM" + simpleDateHere.format(new Date()) );
		
	}
	
	private void makeZdarzenie(){
        SimpleDateFormat simpleDateHere = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss (Z)");
        System.out.println( "Zmiana stanu" + simpleDateHere.format(new Date()) );
		
	}
}
