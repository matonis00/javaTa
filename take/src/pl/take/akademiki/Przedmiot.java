package pl.take.akademiki;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Przedmiot {

	@Id
	@GeneratedValue
	@Column(name = "przedmiot_id")
	int id;
	String nazwa;
	
	@OneToMany(mappedBy = "przedmiot", fetch = FetchType.EAGER)
	Set<Ocena> oceny;
	
	@OneToMany(mappedBy = "przedmiot", fetch = FetchType.EAGER)
	Set<Funkcje> funkcje;
	
	
	
	public int getId()
	{
		return id;
	}
	
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public Set<Ocena> getOceny() {
		return oceny;
	}

	public void setOceny(Set<Ocena> oceny) {
		this.oceny = oceny;
	}
	public boolean addOceny(Ocena value)
	{
		for(Ocena ocena:oceny)
		{
			if(ocena.id==value.id)
			{
				return false;
			}
		}
		oceny.add(value);
		return true;
	}
	public boolean removeOcena(Ocena value)
	{
		return oceny.remove(value);
	}
	public PrzedmiotDTO toDTO() {
		PrzedmiotDTO dto = new PrzedmiotDTO();
        dto.setId(id);
        dto.setNazwa(nazwa);
        return dto;
    }

	public Set<Funkcje> getFunkcje() {
		return funkcje;
	}

	public void setFunkcje(Set<Funkcje> funkcje) {
		this.funkcje = funkcje;
	}
	
	public boolean addFunkcje(Funkcje value)
	{
		for(Funkcje funkcja:funkcje)
		{
			if(funkcja.getId_f()==value.getId_f())
			{
				return false;
			}
		}
		funkcje.add(value);
		return true;
	}
	public boolean removeFunkcje(Funkcje value)
	{
		return funkcje.remove(value);
	}
	
	
}
