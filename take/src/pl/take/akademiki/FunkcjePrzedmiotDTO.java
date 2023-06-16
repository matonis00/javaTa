package pl.take.akademiki;

public class FunkcjePrzedmiotDTO {

	private FunkcjeDTO funkcje;
	private PrzedmiotDTO przedmiot;
	
	public PrzedmiotDTO getPrzedmiot() {
		return przedmiot;
	}
	public void setPrzedmiot(PrzedmiotDTO przedmiot) {
		this.przedmiot = przedmiot;
	}
	public FunkcjeDTO getFunkcje() {
		return funkcje;
	}
	public void setFunkcje(FunkcjeDTO funkcje) {
		this.funkcje = funkcje;
	}
}
