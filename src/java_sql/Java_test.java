package java_sql;

import java.util.LinkedList;
import java.util.List;


/*
 * Klasa s³uzaca do testowania poprawnosci funkcjonowania poszczegolnych metod
 * "snadBox"
 * 
 * 
 */
import java.lang.System;
public class Java_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Java_sql.conection();

		Java_sql.addCzujnik(1,"swiatla_65",5,7); 
		System.out.println("tu jestem");
		//Java_sql.deleteCzujnik(1);
		
		//Czujnik czujnik = new Czujnik();
		//Java_sql.getCzujnik(4,czujnik);
		
//	    List<Alarm> alarmy =   Java_sql.showAlarmy(2,1);

	 

		Java_sql.close();
		
// test!!
		
		
	}

}
