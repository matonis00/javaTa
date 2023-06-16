package pl.take.akademiki;

public class FunkcjeDTO {

	private int id_f;
	private String funkcja;
	
	public String getFunkcja() {
		return funkcja;
	}
	public void setFunkcja(String funkcja) {
		this.funkcja = funkcja;
	}
	public int getId_f() {
		return id_f;
	}
	public void setId_f(int id_f) {
		this.id_f = id_f;
	}
	
	public Funkcje fromDTO() {
		Funkcje child = new Funkcje();
		child.setFunkcja(funkcja);
        return child;
    }
}
