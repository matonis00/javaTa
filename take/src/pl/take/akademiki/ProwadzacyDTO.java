package pl.take.akademiki;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class ProwadzacyDTO {
	
	private int id_pro;
	private String nazwisko;
	private String imie;
	private String katedra;
	
	
	public int getId_pro() {
		return id_pro;
	}
	public void setId_pro(int id_pro) {
		this.id_pro = id_pro;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getKatedra() {
		return katedra;
	}
	public void setKatedra(String katedra) {
		this.katedra = katedra;
	}
	
	public Prowadzacy fromDTO() {
		Prowadzacy child = new Prowadzacy();
        child.setImie(imie);
        child.setNazwisko(nazwisko);
        child.setKatedra(katedra);
        return child;
    }
}
