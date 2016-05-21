package entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import entity.Turma;

@Entity
public class Turma {
	@Id
	@GeneratedValue
	private Long id;
	@Enumerated(EnumType.STRING)
	private Perfil perfil;
	private String nome;
	private Date termino;
	private Date inicio;



	public String getNome() {
		return nome;
	}






	public void setNome(String nome) {
		this.nome = nome;
	}






	public Long getId() {
		return id;
	}






	public Perfil getPerfil() {
		return perfil;
	}






	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}






	public void setId(Long id) {
		this.id = id;
	}





	public Date getInicio() {
		return inicio;
	}






	public void setInicio(Date inicio) {
		inicio = inicio;
	}






	public Date getTermino() {
		return termino;
	}






	public void setTermino(Date termino) {
		termino = termino;
	}






	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turma other = (Turma) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

