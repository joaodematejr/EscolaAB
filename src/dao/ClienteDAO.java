package dao;

import java.util.List;

import javax.persistence.Query;
import entity.Perfil;
import entity.Cliente;

public class ClienteDAO extends DAO {
	public void salvar(Cliente cliente) {
		getEM().merge(cliente);
	}

	public Cliente buscarPorId(Long id) {
		return getEM().find(Cliente.class, id);
	}

	public List<Cliente> listarClientes() {
		Query query = getEM().createQuery("From Cliente", Cliente.class);
		return query.getResultList();
	}

	public void excluir(Long id) {
		Cliente cliente = getEM().getReference(Cliente.class, id);
		getEM().remove(cliente);
	}

	public List<Cliente> listarProfessores() {
		Query query = getEM().createQuery("From Cliente u Where u.perfil", Cliente.class);
		query.setParameter("perfil", Perfil.PROFESSOR);
		return query.getResultList();
	}
}
