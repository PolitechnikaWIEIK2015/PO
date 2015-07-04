package gui;

import java.text.SimpleDateFormat;
import java.util.Date;

import java_sql.Alarm;
import java_sql.Czujnik;
import java_sql.Java_sql;
import java_sql.Przekaznik;
import java_sql.Zdarzenia;

public class Helper {
	public static final int ZMIANA = 6;
	public static final int TooHot = 4;
	public static final int TooCold = 5;
	public static final int OFF = 0;
	public static final int ON = 1;


	public int Id;
	public Alarm alert;
	public Zdarzenia event;
public Czujnik sensor;
public Przekaznik relay;

	Helper(int Id){
		this.Id = Id;
		Java_sql.conection();
		
		event = new Zdarzenia();
		if(Java_sql.getnewEvent(event))
			;
		
		alert = new Alarm();
		if(Java_sql.getnewAlarmy(alert))
			;
//			System.out.println("czujnik " + Id + "failed");
//		System.out.println("czujnik " + sensor.getNazwa() );
		
		sensor = new Czujnik();
		if(Java_sql.getCzujnik(Id, sensor))
			System.out.println("czujnik " + Id + "failed");
		System.out.println("czujnik " + sensor.getNazwa() );

		relay = new Przekaznik();
		if(Java_sql.getPrzekaznik(Id, relay))
			System.out.println("przekaünik " + Id + "failed");
		System.out.println("przekaünik " + relay.getNazwa() );
		
		Java_sql.close();
	}
	
	public void update(){
		Java_sql.conection();
		
		if(Java_sql.getCzujnik(Id, sensor))
			System.out.println("czujnik " + Id + "failed");
		System.out.println("czujnik " + sensor.getNazwa() );

		if(Java_sql.getPrzekaznik(Id, relay))
			System.out.println("przekaünik " + Id + "failed");
		System.out.println("przekaünik " + relay.getNazwa() );
		
		Java_sql.close();
	}
	

	
	public void updateZadana(int zadana){
		sensor.setZadana(zadana);
	
	Java_sql.conection();
	Java_sql.updateCzujnikZadana(sensor.getId(), sensor.getZadana());
	Java_sql.close();
	makeZdarzenie(ZMIANA);
	if (sensor.getStan() < sensor.getZadana()) {
		if (relay.getStan() != ON) {
			makeZdarzenie(TooCold);
		}
		updateRelay(ON);
	}else{
		if(relay.getStan() != OFF){
			makeZdarzenie(TooHot);
		}
		updateRelay(OFF);
	}
}
	
	private void makeZdarzenie(int zrodlo) {
		Java_sql.conection();
			Java_sql.setZdarzenie(sensor.getNazwa(), zrodlo , sensor.getZadana());
	
		Java_sql.close();
		SimpleDateFormat simpleDateHere = new SimpleDateFormat(
				"yyyy-MM-dd kk:mm:ss (Z)");
		System.out.println("Zmiana stanu na elemencie sterujƒÖcym "+ Id + " Na stan " + relay.getStan() + " " + simpleDateHere.format(new Date()));

	}
	
	private void updateRelay(int zamierzonystan){
		relay.setStan(zamierzonystan);
	
	Java_sql.conection();
	Java_sql.updatePrzekaznikStanAktualny(relay.getId(), relay.getStan());
	Java_sql.close();
}
	
	public void printer(){
		System.out.println(Java_sql.showAlarmy(10, 20, 2));
	}
	
}
