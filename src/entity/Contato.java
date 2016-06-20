package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Contato {
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String telefone;
	private String email;
	@Enumerated(EnumType.STRING)
	private Motivo motivoContato;
	private String mensagem;

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Motivo getMotivoContato() {
		return motivoContato;
	}

	public void setMotivoContato(Motivo motivoContato) {
		this.motivoContato = motivoContato;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
