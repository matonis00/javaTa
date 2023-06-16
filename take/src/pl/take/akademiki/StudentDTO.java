package pl.take.akademiki;

public class StudentDTO {

	int id;
	String imie;
	String nazwisko;
	String dataUr;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public String getDataUr() {
		return dataUr;
	}
	public void setDataUr(String dataUr) {
		this.dataUr = dataUr;
	}
	
	public Student fromDTO() {
		Student child = new Student();
        child.setImie(imie);
        child.setNazwisko(nazwisko);
        child.setDataUr(dataUr);
        return child;
    }
	
	
}
