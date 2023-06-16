package pl.take.akademiki;

public class OcenaStudentDTO {

	private OcenaDTO ocena;
	private StudentDTO student;
	
	public OcenaDTO getOcenaDTO() {
		return ocena;
	}
	public void setOcenaDTO(OcenaDTO ocenaDTO) {
		this.ocena = ocenaDTO;
	}
	public StudentDTO getStudentDTO() {
		return student;
	}
	public void setStudentDTO(StudentDTO studentDTO) {
		this.student = studentDTO;
	}

}
