package java_sql;

public class Zdarzenia {

	private int id;
	private int zrudlo;
	private boolean czyOdczytany; 
	
public void setZdarzenie(int zrudlo)
{
	this.zrudlo = zrudlo;
}
public void setZdarzenie(boolean czyOdczytany)
{
	this.czyOdczytany = czyOdczytany;
}


public Zdarzenia()
{
	this.id				 = 0;
	this.zrudlo			 = 0;
	this.czyOdczytany	 = false;
}

public Zdarzenia(int id, int zrudlo, boolean odczytany)
{
	this.id 			= id;
	this.zrudlo 		= zrudlo;
	this.czyOdczytany 	= odczytany;
}
}
