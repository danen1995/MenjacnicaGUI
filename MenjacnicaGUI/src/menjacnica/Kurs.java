package menjacnica;

import java.util.GregorianCalendar;

public class Kurs {
	private double prodajniKurs;
	private double kupovniKurs;
	private double srednjiKurs;
	GregorianCalendar datum;
	
	public double getProdajniKurs() {
		return prodajniKurs;
	}
	public void setProdajniKurs(double prodajniKurs) {
		if(prodajniKurs <=0){
			throw new RuntimeException("Prodajni kurs mora biti veci od 0");
		}this.prodajniKurs = prodajniKurs;
	}
	public double getKupovniKurs() {
		return kupovniKurs;
	}
	public void setKupovniKurs(double kupovniKurs) {
		if(kupovniKurs <=0){
			throw new RuntimeException("Kupovni kurs mora biti veci od 0");
			}
			this.kupovniKurs = kupovniKurs;
	}
	public double getSrednjiKurs() {
		return srednjiKurs;
	}
	public void setSrednjiKurs(double srednjiKurs) {
		if(srednjiKurs <=0){
			throw new RuntimeException("Srednji kurs mora biti veci od 0");
			}
		this.srednjiKurs = srednjiKurs;
	}
	public GregorianCalendar getDatum() {
		return datum;
	}
	public void setDatum(GregorianCalendar datum) {
		if(datum == null){
			throw new RuntimeException("Greska");
			}
		this.datum = datum;
	}
	@Override
	public String toString() {
		return "Kurs: ProdajniKurs je: " + prodajniKurs + ", KupovniKurs je: " + kupovniKurs + ", SrednjiKurs je: " + srednjiKurs
				+ ", Datum je: " + datum;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datum == null) ? 0 : datum.hashCode());
		long temp;
		temp = Double.doubleToLongBits(kupovniKurs);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(prodajniKurs);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(srednjiKurs);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
			if(obj != null && obj instanceof Kurs){
				Kurs kurs = (Kurs) obj;
				if(datum.compareTo(kurs.getDatum())==0
				&& prodajniKurs == kurs.getProdajniKurs()
				&& kupovniKurs == kurs.getKupovniKurs()
				&& srednjiKurs == kurs.getSrednjiKurs()){
					return true;
				}
			}
		return false;
	}
	
}
