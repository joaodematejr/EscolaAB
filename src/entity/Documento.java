package entity;

import java.sql.Date;

public class Documento {
	private Long id;
	private Date dataPostagem;
	private Date dataEntregar;
	private String professor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataPostagem() {
		return dataPostagem;
	}

	public void setDataPostagem(Date dataPostagem) {
		this.dataPostagem = dataPostagem;
	}

	public Date getDataEntregar() {
		return dataEntregar;
	}

	public void setDataEntregar(Date dataEntregar) {
		this.dataEntregar = dataEntregar;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

}
