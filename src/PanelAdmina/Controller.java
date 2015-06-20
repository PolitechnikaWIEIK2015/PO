package PanelAdmina;

import java.text.SimpleDateFormat;
import java.util.Date;

import java_sql.*;

public class Controller {

	public enum Mode {
		DZIEN, NOC, LATO,

	}

	// do zmiany
	public int tempdzien;
	public int tempnoc;

	public final int OFF = 0;
	public final int ON = 1;
	private Przekaznik relay;
	private Czujnik sensor;
	private Mode tryb;
	private int alarm;

	Controller() {
		sensor = new Czujnik();
		relay = new Przekaznik();
		tryb = Mode.LATO;
		alarm = 0;
	}

	public void update() {
		if (alarm == ON) {
			makeAlarm();
			if (relay.getStan() != OFF) {
				makeZdarzenie();
				relay.setStan(OFF);
			}

		} else {
			if (sensor.getStan() < sensor.getStanMin()
					|| sensor.getStan() > sensor.getStanMax())
				alarm = ON;
			else {
				switch (tryb) {
				case DZIEN:
					if (sensor.getStan() < tempdzien) {
						if (relay.getStan() != ON) {
							makeZdarzenie();
							relay.setStan(ON);
						}
					}else{
						if(relay.getStan() != OFF){
							makeZdarzenie();
							relay.setStan(OFF);
						}
					}
					break;

				case LATO:
					if(relay.getStan() != OFF){
						makeZdarzenie();
						relay.setStan(OFF);
					}
					break;

				case NOC:
					if (sensor.getStan() < tempnoc) {
						if (relay.getStan() != ON) {
							makeZdarzenie();
							relay.setStan(ON);
						}
					}else{
						if(relay.getStan() != OFF){
							makeZdarzenie();
							relay.setStan(OFF);
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
		System.out.println("ALARM" + simpleDateHere.format(new Date()));

	}

	private void makeZdarzenie() {
		SimpleDateFormat simpleDateHere = new SimpleDateFormat(
				"yyyy-MM-dd kk:mm:ss (Z)");
		System.out.println("Zmiana stanu" + simpleDateHere.format(new Date()));

	}
}
