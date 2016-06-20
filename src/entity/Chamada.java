package entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import entity.Chamada;
import entity.Perfil;
import entity.Cliente;

@Entity
public class Chamada {
	@Id
	@GeneratedValue
	private Long id;
	private Date data;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
