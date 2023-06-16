package pl.take.akademiki;

public class OcenaPrzedmiotDTO {
	
	private OcenaDTO ocena;
	private PrzedmiotDTO przedmiot;
	
	public OcenaDTO getOcenaDTO() {
		return ocena;
	}
	public void setOcenaDTO(OcenaDTO ocenaDTO) {
		this.ocena = ocenaDTO;
	}
	public PrzedmiotDTO getPrzedmiotDTO() {
		return przedmiot;
	}
	public void setPrzedmiotDTO(PrzedmiotDTO przedmiotDTO) {
		this.przedmiot = przedmiotDTO;
	}

}
