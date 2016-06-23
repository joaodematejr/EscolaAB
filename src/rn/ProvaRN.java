package rn;

import java.sql.SQLException;
import java.util.List;


import dao.ProvaDAO;
import entity.Prova;


public class ProvaRN {
	private ProvaDAO dao;

	public ProvaRN() {
		dao = new ProvaDAO();
	}

	public List<Prova> listar() {
		return dao.listar();
	}

	public void salvar(Prova prova) throws IllegalArgumentException, Exception {
		if(prova.getProfessor() == null){
			throw new IllegalArgumentException("Por favor escolha um PROFESSOR");
		}
		if(!prova.getProfessor().getPerfil().equals(entity.Perfil.PROFESSOR)){
			throw new IllegalArgumentException("Por favor escolha um PROFESSOR");
		}
		
		try{
			dao.salvar(prova);
		}catch (SQLException e) {
			throw new Exception("ERRO NA TRANSFERENCIA DE DADOS "
					+ "o banco de dados. Contate o administrador do site.");
		}
	}

	public Prova buscarPorId(Long id) {
		return dao.buscarPorId(id);
	}

	public void excluir(Long id) {
		dao.excluir(id);
	}
}


