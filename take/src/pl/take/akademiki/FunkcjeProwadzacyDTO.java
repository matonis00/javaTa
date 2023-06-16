package pl.take.akademiki;

public class FunkcjeProwadzacyDTO {
	
	private FunkcjeDTO funkcje;
	private ProwadzacyDTO prowadzacy;
	
	public FunkcjeDTO getFunkcje() {
		return funkcje;
	}
	public void setFunkcje(FunkcjeDTO funkcje) {
		this.funkcje = funkcje;
	}
	public ProwadzacyDTO getProwadzacy() {
		return prowadzacy;
	}
	public void setProwadzacy(ProwadzacyDTO prowadzacy) {
		this.prowadzacy = prowadzacy;
	}
	
}
