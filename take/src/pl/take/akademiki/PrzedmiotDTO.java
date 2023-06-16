package pl.take.akademiki;

public class PrzedmiotDTO {
	 int id;
	 String nazwa;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	
	public Przedmiot fromDTO() {
		Przedmiot child = new Przedmiot();
        child.setNazwa(nazwa);
        return child;
    }
	
}
