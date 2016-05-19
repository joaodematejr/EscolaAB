package dao;

import java.util.List;

import javax.persistence.Query;//ACESSAR O PERSISTENCE
import entity.Perfil;//ACESSAR A CLASSE PERFIL
import entity.Estado;//ACESSAR A CLASSE ESTADO
import entity.Sexo;//ACESSAR A CLASSE SEXO
import entity.Cliente;//ACESSAR A CLASSE CLIENTE

public class ClienteDAO extends DAO {// METODO PUBLIC
	public void salvar(Cliente cliente) {// MEDOTO QUE SALVA E RETORNA UM VALOR
		getEM().merge(cliente);// METODO PARA ATUALIZAR INSTANCIA
	}

	public Cliente buscarPorId(Long id) {// METODO PUBLIC DEIXA VISIVEL A CLASSE
		return getEM().find(Cliente.class, id);// MEDOTO QUE RETORNA UM VALOR
	}

	public List<Cliente> listarClientes() {// MEDOTO PUBLIC, LISTAR CLIENTE
											// DENTRO DA CLASSE CLIENTE
		Query query = getEM().createQuery("From Cliente", Cliente.class);//
		return query.getResultList();// RETURN VALOR
	}

	public void excluir(Long id) {// METODO PUBLIC, DELETAR CLIENTE
		Cliente cliente = getEM().getReference(Cliente.class, id);
		getEM().remove(cliente);
	}

	public List<Cliente> listarProfessores() {
		Query query = getEM().createQuery("From Cliente u Where u.perfil",
				Cliente.class);
		query.setParameter("perfil", Perfil.PROFESSOR);
		return query.getResultList();
	}
}
