package OknoAdmina;

import java.text.SimpleDateFormat;
import java.util.Date;

import java_sql.*;

public class Controller {

	public enum Mode {
		DZIEN, NOC, LATO,

	}

	// do zmiany
	public int tempdzien=23;
	public int tempnoc=17;
	private int Id;
	public final int OFF = 0;
	public final int ON = 1;
	private Przekaznik relay;
	private Czujnik sensor;
//	private Alarm Alert;
	private Mode tryb;
	private int alarm;

	Controller(int Id) {
		sensor = new Czujnik();
		sensor.setStanMax(45);
		sensor.setStanMin(5);
		relay = new Przekaznik();
		tryb = Mode.DZIEN;
		alarm = 0;
		this.Id = Id;
	}

	public void update(boolean stan, int value) {
		if(stan){
			sensor.setStan(value);
		}
		
//		if (alarm == ON) {
//			if (relay.getStan() != OFF) {
//				relay.setStan(OFF);
//				makeZdarzenie();
//			}
//
//		} else 
		{
			if (sensor.getStan() < sensor.getStanMin()
					|| sensor.getStan() > sensor.getStanMax()){
				alarm = ON;
				makeAlarm();
			}
			else {
				if(alarm == ON)
					alarm = OFF; 
				switch (tryb) {
				case DZIEN:
					if (sensor.getStan() < tempdzien) {
						if (relay.getStan() != ON) {
							relay.setStan(ON);
							makeZdarzenie();
						}
					}else{
						if(relay.getStan() != OFF){
							relay.setStan(OFF);
							makeZdarzenie();
						}
					}
					break;

				case LATO:
					if(relay.getStan() != OFF){
						relay.setStan(OFF);
						makeZdarzenie();
					}
					break;

				case NOC:
					if (sensor.getStan() < tempnoc) {
						if (relay.getStan() != ON) {
							relay.setStan(ON);
							makeZdarzenie();
						}
					}else{
						if(relay.getStan() != OFF){
							relay.setStan(OFF);
							makeZdarzenie();
						}
					}

					break;
				default:
					break;
				}
			}
		}

	}

	private void makeAlarm() {
		SimpleDateFormat simpleDateHere = new SimpleDateFormat(
				"yyyy-MM-dd kk:mm:ss (Z)");
		System.out.println("!!!ALARM!!! elementu Sterujacego " + Id + " " + simpleDateHere.format(new Date()));

	}

	private void makeZdarzenie() {
		SimpleDateFormat simpleDateHere = new SimpleDateFormat(
				"yyyy-MM-dd kk:mm:ss (Z)");
		System.out.println("Zmiana stanu na elemencie sterującym "+ Id + " Na stan " + relay.getStan() + " " + simpleDateHere.format(new Date()));

	}
}
