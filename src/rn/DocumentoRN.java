package rn;

import java.sql.SQLException;
import java.util.List;

import dao.DocumentoDAO;
import entity.Documento;
import entity.Perfil;

public class DocumentoRN {
	private DocumentoDAO dao;

	public DocumentoRN() {
		dao = new DocumentoDAO();
	}

	public List<Documento> listar() {
		return dao.listar();

	}

	public void salvar(Documento documento) throws IllegalArgumentException, Exception {
		if (documento.getProfessor() == null) {
			throw new IllegalArgumentException("Precisa selecionar um Professor");
		}
		if (!documento.getProfessor().getPerfil().equals(Perfil.PROFESSOR)) {
			throw new IllegalArgumentException("Precisa selecionar um Professor");
		}
		try {
			dao.salvar(documento);
		} catch (SQLException e) {
			throw new Exception("Erro Erro " + "Contate o administrador do site.");
		}
	}

	public Documento buscarPorId(Long id) {
		return dao.buscarPorId(id);
	}

	public void excluir(Long id) {
		dao.excluir(id);
	}
}
