package pl.take.akademiki;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Prowadzacy {

	@Id
	@GeneratedValue
	@Column(name = "prowadzacy_id")
	int id_pro;
	String nazwisko;
	String imie;
	String katedra;
	
	@OneToMany(mappedBy="prowadzacy",fetch = FetchType.EAGER)
	List<Funkcje> funkcje;
	
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
	public int getId_pro() {
		return id_pro;
	}
	public void setId_pro(int id_pro) {
		this.id_pro = id_pro;
	}
	public List<Funkcje> getFunkcje() {
		return funkcje;
	}
	public void setFunkcje(List<Funkcje> funkcje) {
		this.funkcje = funkcje;
	}
	
	public boolean addFunkcja(Funkcje value)
	{
		for(Funkcje funkcja:funkcje)
		{
			if(funkcja.id_f==value.id_f)
			{
				return false;
			}
		}
		funkcje.add(value);
		return true;
	}
	
	public boolean removeFunkcja(Funkcje value)
	{
		return funkcje.remove(value);
	}
	
	public ProwadzacyDTO toDTO() {
		ProwadzacyDTO dto = new ProwadzacyDTO();
        dto.setImie(imie);
        dto.setNazwisko(nazwisko);
        dto.setId_pro(id_pro);
        dto.setKatedra(katedra);

        return dto;
    }
	
}
