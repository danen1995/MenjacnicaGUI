package menjacnica;

import java.util.GregorianCalendar;

public class Kurs {
	private double prodajniKurs;
	private double kupovniKurs;
	private double srednjiKurs;
	private String sifra, naziv, skraceniNaziv;
	
	
	public Kurs(double prodajniKurs, double kupovniKurs, double srednjiKurs, String sifra, String naziv,
			String skraceniNaziv) {
		super();
		this.prodajniKurs = prodajniKurs;
		this.kupovniKurs = kupovniKurs;
		this.srednjiKurs = srednjiKurs;
		this.sifra = sifra;
		this.naziv = naziv;
		this.skraceniNaziv = skraceniNaziv;
	}
	public Kurs() {
		// TODO Auto-generated constructor stub
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	@Override
	public String toString() {
		return "Sifra=" + sifra + ", Naziv=" +naziv + ", Prodajni kurs=" + prodajniKurs + ", Kupovni kurs=" + kupovniKurs + ", Srednji kurs=" + srednjiKurs
				+  ", Skraceni naziv=" + skraceniNaziv+"\n";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(kupovniKurs);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
		temp = Double.doubleToLongBits(prodajniKurs);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((sifra == null) ? 0 : sifra.hashCode());
		result = prime * result + ((skraceniNaziv == null) ? 0 : skraceniNaziv.hashCode());
		temp = Double.doubleToLongBits(srednjiKurs);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kurs other = (Kurs) obj;
		if (Double.doubleToLongBits(kupovniKurs) != Double.doubleToLongBits(other.kupovniKurs))
			return false;
		if (naziv == null) {
			if (other.naziv != null)
				return false;
		} else if (!naziv.equals(other.naziv))
			return false;
		if (Double.doubleToLongBits(prodajniKurs) != Double.doubleToLongBits(other.prodajniKurs))
			return false;
		if (sifra == null) {
			if (other.sifra != null)
				return false;
		} else if (!sifra.equals(other.sifra))
			return false;
		if (skraceniNaziv == null) {
			if (other.skraceniNaziv != null)
				return false;
		} else if (!skraceniNaziv.equals(other.skraceniNaziv))
			return false;
		if (Double.doubleToLongBits(srednjiKurs) != Double.doubleToLongBits(other.srednjiKurs))
			return false;
		return true;
	}
	public String getSkraceniNaziv() {
		return skraceniNaziv;
	}
	public void setSkraceniNaziv(String skraceniNaziv) {
		this.skraceniNaziv = skraceniNaziv;
	}
	public String getSifra() {
		return sifra;
	}
	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
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

	
}
