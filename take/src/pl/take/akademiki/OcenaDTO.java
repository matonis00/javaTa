package pl.take.akademiki;

public class OcenaDTO {
	 int id;	
	 int wartosc;
	 int ECTS;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	public Ocena fromDTO() {
		Ocena child = new Ocena();
        child.setECTS(ECTS);
        child.setWartosc(wartosc);
        return child;
    }
	
}
