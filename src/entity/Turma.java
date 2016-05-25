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
import entity.Turma;

@Entity
public class Turma {
	@Id
	@GeneratedValue
	private Long id;
	@Enumerated(EnumType.STRING)
	private Perfil perfil;
	private String nome;
	private Date inicio;
	private Date termino;
	@ManyToOne
	private Cliente Professor;
	@ManyToMany
	private List<Cliente> clienteTurma;




	public Cliente getProfessor() {
		return Professor;
	}






	public void setProfessor(Cliente Professor) {
		this.Professor = Professor;
	}






	public void setClienteTurma(List<Cliente> clienteTurma) {
		this.clienteTurma = clienteTurma;
	}






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
		return getInicio();
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






	public void setClientesTurma(ArrayList<Cliente> arrayList) {
		// TODO Auto-generated method stub
		
	}






	public List<entity.Turma> getClienteTurma() {
		// TODO Auto-generated method stub
		return null;
	}

}
