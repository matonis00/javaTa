package pl.take.akademiki;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Funkcje {
	
	@Id
	@GeneratedValue
	int id_f;
	String funkcja; 
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="prowadzacy_id")
	Prowadzacy prowadzacy;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="przedmiot_id")
	Przedmiot przedmiot;

	public int getId_f() {
		return id_f;
	}

	public void setId_f(int id_f) {
		this.id_f = id_f;
	}

	public String getFunkcja() {
		return funkcja;
	}

	public void setFunkcja(String funkcja) {
		this.funkcja = funkcja;
	}

	public Prowadzacy getProwadzacy() {
		return prowadzacy;
	}

	public void setProwadzacy(Prowadzacy prowadzacy) {
		this.prowadzacy = prowadzacy;
	}

	public Przedmiot getPrzedmiot() {
		return przedmiot;
	}

	public void setPrzedmiot(Przedmiot przedmiot) {
		this.przedmiot = przedmiot;
	}
	
	public FunkcjeDTO toDTO() {
		FunkcjeDTO dto = new FunkcjeDTO();
		dto.setId_f(id_f);
		dto.setFunkcja(funkcja);
        return dto;
    }
}
