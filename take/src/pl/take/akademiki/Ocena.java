package pl.take.akademiki;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Ocena {

	@Id
	@GeneratedValue
	int id;	
	int wartosc;
	int ECTS; 
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="student_id")
	Student student;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="przedmiot_id")
	Przedmiot przedmiot;
	
	public int getId()
	{
		return id;
	}
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getWartosc() {
		return wartosc;
	}

	public void setWartosc(int wartosc) {
		this.wartosc = wartosc;
	}

	public int getECTS() {
		return ECTS;
	}

	public void setECTS(int eCTS) {
		ECTS = eCTS;
	}
	
	
	public OcenaDTO toDTO() {
		OcenaDTO dto = new OcenaDTO();
        dto.setId(id);
        dto.setECTS(ECTS);
        dto.setWartosc(wartosc);
        return dto;
    }

	public Przedmiot getPrzedmiot() {
		return przedmiot;
	}

	public void setPrzedmiot(Przedmiot przedmiot) {
		this.przedmiot = przedmiot;
	}
	
}
