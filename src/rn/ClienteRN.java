package rn;

import java.util.List;

import dao.ClienteDAO;
import entity.Cliente;

public class ClienteRN {
	private ClienteDAO dao;

	public ClienteRN() {
		dao = new ClienteDAO();
	}

	public void salvar(Cliente cliente) {
		dao.salvar(cliente);
	}

	public Cliente buscarPorId(Long id) {
		return dao.buscarPorId(id);
	}

	public List<Cliente> listarClientes() {
		return dao.listarClientes();
	}

	public void excluir(Long id) {
		dao.excluir(id);
	}

	public List<Cliente> listarProfessores() {
		return dao.listarProfessores();
	}
}
