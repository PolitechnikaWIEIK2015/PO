package OknoAdmina;

import java.text.SimpleDateFormat;
import java.util.Date;

import java_sql.*;

public class Controller {

	public enum Mode {
		DZIEN, NOC, LATO,
	}

	public final int Alarm_min = 1;
	public final int Alarm_max = 2;
	public final int Alarm_BES = 3;
	public final int TooHot = 4;
	public final int TooCold = 5;


	public final int OFF = 0;
	public final int ON = 1;
	
	private int Id;
	private Przekaznik relay;
	private Czujnik sensor;

	private Mode tryb;
	private int alarm;

	Controller(int Id) {
		tryb = Mode.DZIEN;
		alarm = 0;
		
		Java_sql.conection();
		
		sensor = new Czujnik();
		if(Java_sql.getCzujnik(Id, sensor))
			System.out.println("czujnik " + Id + "failed");
		System.out.println("czujnik " + sensor.getNazwa() );

		relay = new Przekaznik();
		if(Java_sql.getPrzekaznik(Id, relay))
			System.out.println("przekaŸnik " + Id + "failed");
		System.out.println("przekaŸnik " + relay.getNazwa() );
		
		Java_sql.close();
		
		if(sensor.getState()>0)
			update(true, sensor.getStan());
		else
			update(false, sensor.getStan());

	}

	public void update(boolean stan, int value) {
		int alert = 0;
		if(stan){
			this.updateSensor(value);
			if (sensor.getStan() < sensor.getStanMin()){
				alert = Alarm_min;
			}else{
					if(sensor.getStan() > sensor.getStanMax()){
						alert = Alarm_max;
				}
			}

		}
		else{
			alert = Alarm_BES;
		}
		

			if(alert > 0){
				if(alert!=alarm){
					alarm = alert;
					makeAlarm(alarm);
				}
			}else {
				if(alarm == ON)
					alarm = OFF; 
				switch (this.tryb) {
				case DZIEN:
					if (sensor.getStan() > sensor.getZadana()) {
						if (relay.getStan() != ON) {
							updateRelay(ON);
							makeZdarzenie(TooCold);
						}
					}else{
						if(relay.getStan() != OFF){
							updateRelay(OFF);
							makeZdarzenie(TooHot);
						}
					}
					break;

				case LATO:
					if(relay.getStan() != OFF){
						updateRelay(OFF);
						makeZdarzenie(TooHot);
					}
					break;

				case NOC:
					if (sensor.getStan() < sensor.getZadana()) {
						if (relay.getStan() != ON) {
							updateRelay(ON);
							makeZdarzenie(TooCold);
						}
					}else{
						if(relay.getStan() != OFF){
							updateRelay(OFF);
							makeZdarzenie(TooHot);
						}
					}

					break;
				default:
					break;
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
	
	
	public void updateSensor(int odczyt){
		sensor.setZadana(odczyt);
	
	Java_sql.conection();
	Java_sql.updateCzujnikStanAktualny(sensor.getId(), sensor.getZadana());
	Java_sql.close();
}
	
	public void updateRelay(int zamierzonystan){
		relay.setStan(zamierzonystan);
	
	Java_sql.conection();
	Java_sql.updatePrzekaznikStanAktualny(relay.getId(), relay.getStan());
	Java_sql.close();
}

	private void makeAlarm(int zrodlo) {
		Java_sql.conection();
		Java_sql.setAlarm(sensor.getNazwa(), zrodlo);
		Java_sql.close();
		SimpleDateFormat simpleDateHere = new SimpleDateFormat(
				"yyyy-MM-dd kk:mm:ss (Z)");
		System.out.println("!!!ALARM!!! elementu Sterujacego " + Id + " " + simpleDateHere.format(new Date()));

	}

	private void makeZdarzenie(int zrodlo) {
		Java_sql.conection();
		if(zrodlo<6){
			Java_sql.setZdarzenie(relay.getNazwa(), zrodlo , relay.getStan());
		}else{
			Java_sql.setZdarzenie(sensor.getNazwa(), zrodlo , sensor.getStan());
		}
		
		Java_sql.close();
		SimpleDateFormat simpleDateHere = new SimpleDateFormat(
				"yyyy-MM-dd kk:mm:ss (Z)");
		System.out.println("Zmiana stanu na elemencie sterujÄ…cym "+ Id + " Na stan " + relay.getStan() + " " + simpleDateHere.format(new Date()));

	}
	
	public String powodZmiany(int zmiana){
		String Text;
		switch(zmiana){
		case 1:
			Text = "ALARM_Za_Niska_Temp";
			break;
		case 2:
			Text = "ALARM_Za_Wysoka_Temp";
			break;
		case 3:
			Text = "ALARM_Brak_Elem._Sterujacego";
			break;
		case 4:
			Text = "Pomieszczenie_Nagrzane";
			break;
		case 5:
			Text = "Dogrzanie_Pomieszczenia";
			break;
		default:
			Text = "SystemFAULT";
				break;
		}	
		return Text;
	}
	public int getactualna(){
		return sensor.getStan();
		}
	
	public int getzadana(){
		return sensor.getZadana();
	}
}
