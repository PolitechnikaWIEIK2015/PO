package java_sql;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class Java_sql extends Sql{
	
	        
	        private static final String url 		= "jdbc:mysql://localhost:3306/";	//adres plus port standardowy przy XAMP'ie
	        private static final String user 		= "root";							//urzytkownik, koniecznie admin
	        private static final String password	= "";								//haslo
	        private static final String dataBase 	= "systeminteligentnegobudynku";	//nazwa bazy danych
	        
	        protected static ResultSet res;
	        protected static PreparedStatement prep;
	        protected static Connection con;
	        protected static Statement stt;
	        
	        
public static void conection(){
	        try
	        {
	        	
	            Class.forName("com.mysql.jdbc.Driver").newInstance();
	            con = DriverManager.getConnection(url, user, password);	            
	            stt = con.createStatement();
	            stt.execute("USE " + dataBase);
 
	        }
	        catch (Exception e)
	        {
	    		// TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
public static void close()  
{

		try {
			//res.close();
			stt.close();
			//prep.close();
			con.close();
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
/*
 * @param question dowolne zapytanie do bazy danych, kompatybilne z MySQl
 * @return wynik zapytania
 */

public static ResultSet makeQuery(String question)
{
	
	try {
		res = prep.executeQuery(question);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return(res);
}

/*
 * @param typCzujnika typ czujnika ktory chcemy wprowadzic
 * @param nazwa nazwa czujnika do wprowadzenia
 * @param stan_minimalny minimalny stan jaki moze osiagnac wprowadzany czujnik
 * @param stan_maksymalny maksymalna wartosc czujnika
 * @return false jesli niema b�edu, tru w przypadku wystapienia
 * 
 */
public static boolean addCzujnik(int typCzujnika,String nazwa, int stan_minimalny, int stan_maksymalny) 
{
	boolean alarm = false;
	try {
		
		alarm = stt.execute("INSERT INTO `"+ dataBase +"`.`czujniki` (`id`, `nazwa`, `typ`, `stan_aktualny`, `stan_minimalny`, `stan_maksymalny`, `data`) VALUES (NULL, '"+ nazwa +"', '"+ typCzujnika +"', '"+ stan_minimalny +"', '"+ stan_minimalny +"', '"+ stan_maksymalny +"', NULL)");
		
	} catch (SQLException e) 
	{
		// TODO Auto-generated catch block
		alarm = true;
		e.printStackTrace();
	}
	return( alarm );
}

/*
 * @param id numer czujnika do aktualizacji
 * @param typCzujnika typ czujnika ktory chcemy wprowadzic
 * @param nazwa nazwa czujnika do wprowadzenia
 * @param stan_minimalny minimalny stan jaki moze osiagnac wprowadzany czujnik
 * @param stan_maksymalny maksymalna wartosc czujnika
 * @param stan_aktualny aktualny stan czujnika
 * @return false jesli niema b�edu, tru w przypadku wystapienia
 * 
 */
public static boolean updateCzujnik(int id, int typCzujnika,String nazwa, int stan_minimalny, int stan_maksymalny, int stan_aktualny) 
{
	boolean alarm = false;
	try {
		
		stt.execute("UPDATE`"+ dataBase +"`.`czujniki` SET id="+id+", nazwa="+nazwa+", typ="+typCzujnika+", stan_aktualny="+stan_aktualny+", stan_minimalny="+stan_minimalny+", stan_maksymalny="+stan_maksymalny+", data=NOW WHERE czujniki.id="+id+"" );
		
		
	} catch (SQLException e) 
	{
		// TODO Auto-generated catch block
		alarm = true;
		e.printStackTrace();
	}
	return( alarm );
}

/*
 * @param id numer czujnika do aktualizacji
 * @param stan_aktualny aktualny stan czujnika
 * @return false jesli niema b�edu, tru w przypadku wystapienia
 * 
 */
public static boolean updateCzujnikStanAktualny(int id, int stan_aktualny) 
{
	boolean alarm = false;
	try {
		
		stt.execute("UPDATE`"+ dataBase +"`.`czujniki` SET  stan_aktualny="+stan_aktualny+",data=NOW WHERE czujniki.id="+id+"" );
				
	} catch (SQLException e) 
	{
		alarm = true;
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return( alarm );
}

/*
 * @param nazwa nazwa czujnika do aktualizacji
 * @param stan_aktualny aktualny stan czujnika
 * @return false jesli niema b�edu, tru w przypadku wystapienia
 * 
 */
public static boolean updateCzujnikStanAktualny(String nazwa, int stan_aktualny) 
{
	boolean alarm = false;
	try {
		
		stt.execute("UPDATE`"+ dataBase +"`.`czujniki` SET  stan_aktualny="+stan_aktualny+",data=NOW WHERE czujniki.nazwa="+nazwa+"" );
				
	} catch (SQLException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return( alarm );
}
/*
 * @param id numer czujnika do usuniecia
 * @return false jesli niema b�edu, tru w przypadku wystapienia
 * 
 */
public static boolean deleteCzujnik(int id)
{
	boolean alarm = false;
	
	try {
		
		alarm = stt.execute("DELETE FROM `"+ dataBase +"`.`czujniki` WHERE `czujniki`.`id` = "+ id +"");
		
	} catch (SQLException e) {
		alarm = true;
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return(alarm);
}

/*
 * @param nazwa nazwa czujnika do usuniecia
 * @return false jesli niema b�edu, tru w przypadku wystapienia
 * 
 */
public static boolean deleteCzujnik(String nazwa)
{
	boolean alarm = false;
	
	try {
		
		alarm = stt.execute("DELETE FROM `"+ dataBase +"`.`czujniki` WHERE `czujniki`.`nazwa` = "+ nazwa +"");
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return(alarm);
}

/*
 * @param id numer czujnika do pobrania
 * @param czujnik obiekt ktory przybierze wartosci czujnika z bazy
 * @return false jesli niema b�edu, tru w przypadku wystapienia
 * 
 */
public static boolean getCzujnik(int id,Czujnik czujnik)
{
	boolean alarm = false;
	
	try {
		
		prep = con.prepareStatement("SELECT `id` FROM `czujniki` WHERE `czujniki`.`id` = "+ id +"");
		res = prep.executeQuery();
		if(res.next())
		{							//TODO: 	WAS ADDED NO TEST
		czujnik.setId(res.getInt("id")); 		// TODO:	erroor 
		}
		
		
	} catch (SQLException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return(alarm);	
}
/*
 * @return zwraca wszystkie czujniki z bazy z parametrami
 * 
 */
public static List<Czujnik> showCzujniki() {
    List<Czujnik> czujniki = new LinkedList<Czujnik>();
    try {
        ResultSet result = prep.executeQuery("SELECT * FROM `czujniki`");
        int id,typ,stan_aktualny,stan_minimalny,stan_maksymalny,data;
        String nazwa;
        while(result.next()) {
            id = result.getInt("id");
            nazwa = result.getString("nazwa");
            typ = result.getInt("typ");
            stan_aktualny = result.getInt("stan_aktualny");
            stan_minimalny = result.getInt("stan_minimalny");
            stan_maksymalny = result.getInt("stan_maksymalny");
            data = result.getInt("data");
            czujniki.add(new Czujnik( id,  typ,  nazwa,  stan_aktualny, stan_minimalny, stan_maksymalny, data));
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
    return czujniki;
}

/*
 * @param data data wystapienia alarmu
 * @param godzina godzina wystapienia alarmu
 * @param zrudlo zrudlo od ktorego pochdzi alarm
 * @param powod powod alarmu (examp stan minimalny przekroczony)
 * @return false jesli niema b�edu, tru w przypadku wystapienia
 * 
 */
public static boolean setAlarm(int data,int godzina,int zrodlo, int powod) 
{
	boolean al = true;
	try {
		
		stt.execute("INSERT INTO `"+ dataBase +"`.`alarmy` (`id`, `data_alarmu`, `godzina_alarmu`, `zrudlo`, `powod`) VALUES (NULL, '"+ data +"', '"+ godzina +"', '"+ zrodlo +"', '"+ powod +" )");

		
		al = false;
	} catch (SQLException e) 
	{
		al = true;
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return( al );
}
/*
 * @param id numer alarmu do usuniecia
 * @return false jesli niema b�edu, tru w przypadku wystapienia
 * 
 */
public static boolean deleteAlarm(int id)
{
	boolean alarm = false;
	
	try {
		
		alarm = stt.execute("DELETE FROM `"+ dataBase +"`.`alarmy` WHERE `alarmy`.`id` = "+ id +"");
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return(alarm);
}

/*
 * @param zrodlo zrudlo wedlug ktorego maja zostac usuniete alarmy
 * @return false jesli niema b�edu, tru w przypadku wystapienia
 * 
 */
public static boolean deleteAlarmy(int zrudlo)
{
	boolean alarm = false;
	
	try {
		
		alarm = stt.execute("DELETE FROM `"+ dataBase +"`.`alarmy` WHERE `alarmy`.`zrudlo` = "+ zrudlo +"");
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return(alarm);
}

/*
 * @param ilsoc ilsoc alamrow do wyslania z bazy
 * @param idCzujnika numer czujnika ktoryw wywolal zmiany
 * @return zwraca cala liste alarmow
 * 
 */
public static List<Alarm> showAlarmy(int ilosc, int idCzujnika) {
    List<Alarm> alarmy = new LinkedList<Alarm>();
    try {
        ResultSet result = prep.executeQuery("SELECT * FROM `alarmy` WHERE `alarmy`.`zrudlo` = "+ idCzujnika + " LIMIT "+ ilosc +"");
        int id,data_alarmu,godzina_alarmu,zrudlo,powod;
    
        while(result.next()) {
            id = result.getInt("id");
            data_alarmu = result.getInt("data_alarmu");
            godzina_alarmu = result.getInt("godzina_alarmu");
            zrudlo = result.getInt("zrudlo");
            powod = result.getInt("powod");
            alarmy.add(new Alarm(id,data_alarmu,godzina_alarmu,zrudlo,powod));
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
    return alarmy;
}

/*
 * @param id numer przekaznia do wprowadzenia
 * @param nazwa nazwa przekaznika do wprowadzenia
 * @param stan_aktualny aktualny stan czujnika
 * @param zrodloZmiany co wywolalo zmiane stanu przekaznika
 * @param dataZmiany data kiedy zostala zmiana wywolana
 * @return false jesli niema b�edu, tru w przypadku wystapienia
 * 
 */
public static boolean setPrzekaznik(int id, String nazwa, int stanActual,int zrudloZmiany,int dataZmiany) 
{
	boolean al = true;
	try {
		
		stt.execute("INSERT INTO `"+ dataBase +"`.`przekazniki` (`id`, `nazwa`, `stan_ac`, `data_zmiany`, `zrudlo_zmiany`) VALUES (NULL, '"+ nazwa +"', '"+ stanActual +"', '"+ zrudloZmiany +"', '"+ dataZmiany +" )");
		
		al = false;
	} catch (SQLException e) 
	{
		al = true;
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return( al );
}

/*
 * @param nazwa nazwa przekaznia do aktualizacji
 * @param stan_aktualny aktualny stan czujnika
 * @param zrodloZmiany co wywolalo zmiane stanu przekaznika
 * @return false jesli niema b�edu, tru w przypadku wystapienia
 * 
 */
public static boolean updatePrzekaznikStanAktualny(String nazwa, int stan_aktualny, int zrudloZmiany) 
{
	boolean alarm = false;
	try {
		
		stt.execute("UPDATE`"+ dataBase +"`.`przekazniki` SET  stan_ac="+stan_aktualny+",zrudlo_zmiany="+zrudloZmiany+",data_zmiany=NOW WHERE przekazniki.nazwa="+nazwa+"" );
				
	} catch (SQLException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return( alarm );
}
/*
 * @param id id przekaznia do aktualizacji
 * @param stan_aktualny aktualny stan czujnika
 * @param zrodloZmiany co wywolalo zmiane stanu przekaznika
 * @return false jesli niema b�edu, tru w przypadku wystapienia
 * 
 */
public static boolean updatePrzekaznikStanAktualny(int id, int stan_aktualny, int zrudloZmiany) 
{
	boolean alarm = false;
	try {
		
		stt.execute("UPDATE`"+ dataBase +"`.`przekazniki` SET  stan_ac="+stan_aktualny+",zrudlo_zmiany="+zrudloZmiany+",data_zmiany=NOW WHERE przekazniki.id="+id+"" );
				
	} catch (SQLException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return( alarm );
}
/*
 * @param id id przekaznia do usuneicia
 * @return false jesli niema b�edu, tru w przypadku wystapienia
 * 
 */
public static boolean deletePrzekaznik(int id)
{
	boolean alarm = false;
	
	try {
		
		alarm = stt.execute("DELETE FROM `"+ dataBase +"`.`przekazniki` WHERE `przekazniki`.`id` = "+ id +"");
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return(alarm);
}
/*
 * @param ilosc ilosc przekaznikow do wyslania z bazy
 * @return zwraca cala liste przekaznikow wraz z wszystkimi parametrami
 * 
 */
public static List<Przekaznik> showPrzekazniki(int ilosc, String nazwa) {
    List<Przekaznik> przekazniki = new LinkedList<Przekaznik>();
    try {
        ResultSet result = prep.executeQuery("SELECT * FROM `przekazniki` WHERE `przekazniki`.`nazwa` LIKE "+ nazwa + " LIMIT "+ ilosc +"");
        int refNo,stan_ac,data_zmiany,zrudlo_zmiany;
        String nazwy;
        while(result.next()) {
            refNo = result.getInt("id");
            nazwy = result.getString("nazwa");
            stan_ac = result.getInt("stan_ac");
            data_zmiany = result.getInt("data_zmiany");
            zrudlo_zmiany = result.getInt("zrudlo_zmiany");
            przekazniki.add(new Przekaznik(refNo,  nazwy,  stan_ac, data_zmiany, zrudlo_zmiany));
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
    return przekazniki;
}





public static int get_id_czujnik()
{
	return(id_czujnik);
}
public static String get_nazwa_czujnik()
{
	return(nazwa_czujnik);
}
public static int get_typ_czujnik()
{
	return(typ_czujnik);
}



/*
protected static int id_czujnik;
protected static String nazwa_czujnik;
protected static int typ_czujnik;
protected static int stanAc_czujnik;
protected static int stanMin_czujnik;
protected static int stanMax_czujnik;
protected static int data_czujnik;

protected static int id_przkaznik;
protected static String nazwa_przekaznik;
protected static int stanAc_przekaznik;
protected static int dataZmiany_przekaznik;
protected static int zrudloZmiany_przekaznik;

protected static int id_alarm;
protected static int powod_alarm;
protected static int zrudlo_alarm;
 */
}