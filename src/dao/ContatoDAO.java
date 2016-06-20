package dao;

import entity.Cliente;
import entity.Contato;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import entity.Motivo;
import entity.Contato;

public class ContatoDAO extends DAO {
	public void salvar(Contato contato) {
		getEM().merge(contato);
	}

	public Contato buscarPorId(Long id) {
		return getEM().find(Contato.class, id);
	}

	public void excluir(Long id) {
		Contato contato = getEM().getReference(Contato.class, id);
		getEM().remove(contato);
	}

	public List<Contato> listarContatos() {
		Query query = getEM().createQuery("From Contato", Contato.class);
		return query.getResultList();
	}

}
