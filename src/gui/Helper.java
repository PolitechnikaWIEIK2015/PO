package gui;

import java_sql.Czujnik;
import java_sql.Java_sql;
import java_sql.Przekaznik;

public class Helper {
	public int Id;
public Czujnik sensor;
public Przekaznik relay;

	Helper(int Id){
		this.Id = Id;
		Java_sql.conection();
		
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
	
	public void updateZadana(int zadana){
		sensor.setZadana(zadana);
	
	Java_sql.conection();
	Java_sql.updateCzujnikZadana(sensor.getId(), sensor.getZadana());
	Java_sql.close();
}
	
}
