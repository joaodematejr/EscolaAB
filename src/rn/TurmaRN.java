package rn;

import java.sql.SQLException;
import java.util.List;


import dao.TurmaDAO;
import entity.Turma;
import sun.misc.Perf;

public class TurmaRN {
	private TurmaDAO dao;

	public TurmaRN() {
		dao = new TurmaDAO();
	}

	public List<Turma> listar() {
		return dao.listar();
	}

	public void salvar(Turma turma) throws IllegalArgumentException, Exception {
		if(turma.getProfessor() == null){
			throw new IllegalArgumentException("É preciso selecionar um Professor");
		}
		if(!turma.getProfessor().getPerfil().equals(entity.Perfil.PROFESSOR)){
			throw new IllegalArgumentException("É preciso selecionar um Professor");
		}
		
		try{
			dao.salvar(turma);
		}catch (SQLException e) {
			throw new Exception("Houve um erro na comunicação com "
					+ "o banco de dados. Contate o administrador do site.");
		}
	}

	public Turma buscarPorId(Long id) {
		return dao.buscarPorId(id);
	}

	public void excluir(Long id) {
		dao.excluir(id);
	}
}


