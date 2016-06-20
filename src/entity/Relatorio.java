package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "caixa_relatorios")
@Immutable
public class Relatorio {
	@Id
	@Column(name = "turma_id")
	private Long idTurma;
	private String contato;
	@Column(name = "clientes")
	private Integer qtdClientes;
	private Float total;
	private Date data;

	public Long getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(Long idTurma) {
		this.idTurma = idTurma;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public Integer getQtdClientes() {
		return qtdClientes;
	}

	public void setQtdClientes(Integer qtdClientes) {
		this.qtdClientes = qtdClientes;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
