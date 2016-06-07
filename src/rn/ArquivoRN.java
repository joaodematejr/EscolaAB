package rn;

import java.util.List;
import dao.ArquivoDAO;
import entity.Documento;

public class ArquivoRN {
	private ArquivoDAO dao;

	public ArquivoRN() {
		dao = new ArquivoDAO();
	}

	public void adicionar(Documento docu) {
		dao.salvar(docu);
	}

	public List<Documento> listarDocumentoPorTurma(Long idTurma) {
		return dao.listarDocumentoPorTurma(idTurma);
	}

	public Documento buscarDocumentoPorID(Long idDocumento) {
		return dao.buscarDocumentoPorId(idDocumento);
	}

	public void excluir(Documento documento) {
		dao.excluir(documento);
	}
}
