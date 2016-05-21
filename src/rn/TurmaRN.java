package rn;

import java.util.List;

import dao.TurmaDAO;
import entity.Turma;

public class TurmaRN {
	private TurmaDAO dao;

	public TurmaRN() {
		dao = new TurmaDAO();
	}

	public void salvar(Turma turma) {
		dao.salvar(turma);
	}

	public Turma buscarPorId(Long id) {
		return dao.buscarPorId(id);
	}

	public List<Turma> listarTurmas() {
		return dao.listarTurma();
	}

	public void excluir(Long id) {
		dao.excluir(id);
	}

	public List<Turma> listarProfessores() {
		return dao.listarProfessores();
	}
}


