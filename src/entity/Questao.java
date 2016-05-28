package entity;



import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import entity.Questao;

@Entity
public class  Questao{
	@Id
	@GeneratedValue
	private Long id;
	@Enumerated(EnumType.STRING)
	private Professor professor;
	@Enumerated(EnumType.STRING)
	private Dificudade dificudadeQuestao;
	@Enumerated(EnumType.STRING)
	private Modalidade modalidadeQuestao;
	private String assunto ;
	private String pergunta;
	private Estado resposta;
	private Date  datadaPergunta;
	private String comentario;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public Dificudade getDificudadeQuestao() {
		return dificudadeQuestao;
	}
	public void setDificudadeQuestao(Dificudade dificudadeQuestao) {
		this.dificudadeQuestao = dificudadeQuestao;
	}
	public Modalidade getModalidadeQuestao() {
		return modalidadeQuestao;
	}
	public void setModalidadeQuestao(Modalidade modalidadeQuestao) {
		this.modalidadeQuestao = modalidadeQuestao;
	}
	public Date getDatadaPergunta() {
		return datadaPergunta;
	}
	public void setDatadaPergunta(Date datadaPergunta) {
		this.datadaPergunta = datadaPergunta;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getPergunta() {
		return pergunta;
	}
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	public Estado getResposta() {
		return resposta;
	}
	public void setResposta(Estado resposta) {
		this.resposta = resposta;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
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
		Questao other = (Questao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}


	
