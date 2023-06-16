package pl.take.akademiki;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student {

	@Id
	@GeneratedValue
	@Column(name = "student_id")
	int id;
	String imie;
	String nazwisko;
	String dataUr;
	@OneToMany(mappedBy="student",fetch = FetchType.EAGER)
	List<Ocena> oplaty;
	
	public int getId()
	{
		return id;
	}
	
	public List<Ocena> getOplaty()
	{
		return oplaty;
	}
	public void setOplaty(List<Ocena> value)
	{
		oplaty=value;
	}
	public boolean addOplata(Ocena value)
	{
		for(Ocena oplata:oplaty)
		{
			if(oplata.id==value.id)
			{
				return false;
			}
		}
		oplaty.add(value);
		return true;
	}
	public boolean removeOplata(Ocena value)
	{
		return oplaty.remove(value);
	}
	
	public void setImie(String value)
	{
		imie=value;
	}
	public String getImie()
	{
		return imie;
	}
	
	public void setNazwisko(String value)
	{
		nazwisko=value;
	}
	public String getNazwisko()
	{
		return nazwisko;
	}
	
	public void setDataUr(String value)
	{
		dataUr=value;
	}
	public String getDataUr()
	{
		return dataUr;
	}
	
	public StudentDTO toDTO() {
		StudentDTO dto = new StudentDTO();
        dto.setImie(imie);
        dto.setNazwisko(nazwisko);
        dto.setDataUr(dataUr);
        dto.setId(id);

        return dto;
    }
	
}
