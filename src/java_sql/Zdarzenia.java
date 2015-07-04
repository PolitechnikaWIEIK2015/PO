package java_sql;

public class Zdarzenia {

	private int id;
	private String date;
	private String zrudlo;
	private int powod;
	private int stan;
	
//public void setZdarzenie(String zrudlo)
//{
//	this.zrudlo = zrudlo;
//}
//public void setZdarzenie(int stan)
//{
//	this.stan = stan;
//}


public Zdarzenia()
{
	this.id				 = 0;
	this.date 			="0";
	this.zrudlo			 = "0";
	this.powod			=0;
	this.stan	 		= 0;
}

public Zdarzenia(int id, String date, String zrudlo, int powod, int state)
{
	this.id 			= id;
	this.date			= date;
	this.zrudlo 		= zrudlo;
	this.stan 	= state;
	this.powod 	=powod;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getZrudlo() {
	return zrudlo;
}
public void setZrudlo(String zrudlo) {
	this.zrudlo = zrudlo;
}
public int getPowod() {
	return powod;
}
public void setPowod(int powod) {
	this.powod = powod;
}
public int getStan() {
	return stan;
}
public void setStan(int stan) {
	this.stan = stan;
}
}
