package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import entity.Prova;
import entity.Pergunta;

@Entity
public class Prova {
	@Id
	@GeneratedValue
	private Long id;
	@Enumerated(EnumType.STRING)
	private Perfil perfil;
	private String nome;
	private Date termino;
	@ManyToOne
	private Cliente professor;
	@ManyToMany
	private List<Pergunta> perguntaProva;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getTermino() {
		return termino;
	}

	public void setTermino(Date termino) {
		this.termino = termino;
	}

	public Cliente getProfessor() {
		return professor;
	}

	public void setProfessor(Cliente professor) {
		this.professor = professor;
	}

	public List<Pergunta> getPerguntaProva() {
		return perguntaProva;
	}

	public void setPerguntaProva(List<Pergunta> perguntaProva) {
		this.perguntaProva = perguntaProva;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prova other = (Prova) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
