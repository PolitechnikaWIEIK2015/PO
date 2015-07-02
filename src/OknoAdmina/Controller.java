package OknoAdmina;

import java.text.SimpleDateFormat;
import java.util.Date;

import java_sql.*;

public class Controller {

	public enum Mode {
		DZIEN, NOC, LATO,

	}

	// do zmiany
	public int tempdzien;
	public int tempnoc=17;
	public final int OFF = 0;
	public final int ON = 1;
	
	private int Id;
	private int name;

	private Przekaznik relay;
	private Czujnik sensor;
//	private Alarm Alert;
	private Mode tryb;
	private int alarm;

	Controller(int Id) {
		Java_sql.conection();
		
		sensor = new Czujnik();
		if(Java_sql.getCzujnik(Id, sensor))
			System.out.println("czujnik " + Id + "failed");
		System.out.println("czujnik " + sensor.getNazwa() );

		relay = new Przekaznik();
		
		
		tryb = Mode.DZIEN;
		alarm = 0;
		//this.Id = Id;
		Java_sql.close();
	}

	public void update(boolean stan, int value) {
		if(stan){
			this.updateSensor(value);
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
	
	public String getNazwaSensor(){
		return sensor.getNazwa();
	}
	
	public Boolean getStateSensor(){
		if(sensor.getState()==0)
			return false;
		else
			return true;
	}
	
	public void updateStateSensor(Boolean stan){
		if(stan)
			sensor.setState(1);
		else
			sensor.setState(0);
		
		Java_sql.conection();
		Java_sql.updateCzujnikStateAktualny(sensor.getId(), sensor.getState());
		Java_sql.close();
	}
	
	public void updateZadana(int zadana){
			sensor.setZadana(zadana);
		
		Java_sql.conection();
		Java_sql.updateCzujnikZadana(sensor.getId(), sensor.getZadana());
		Java_sql.close();
	}
	
	public void updateSensor(int odczyt){
		sensor.setZadana(odczyt);
	
	Java_sql.conection();
	Java_sql.updateCzujnikStanAktualny(sensor.getId(), sensor.getZadana());
	Java_sql.close();
}

	private void makeAlarm() {
		Java_sql.conection();
		
		SimpleDateFormat simpleDateHere = new SimpleDateFormat(
				"yyyy-MM-dd kk:mm:ss (Z)");
		System.out.println("!!!ALARM!!! elementu Sterujacego " + Id + " " + simpleDateHere.format(new Date()));

	}

	private void makeZdarzenie() {
		Java_sql.conection();
		
		
		SimpleDateFormat simpleDateHere = new SimpleDateFormat(
				"yyyy-MM-dd kk:mm:ss (Z)");
		System.out.println("Zmiana stanu na elemencie sterującym "+ Id + " Na stan " + relay.getStan() + " " + simpleDateHere.format(new Date()));

	}
}
