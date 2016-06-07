package dao;

import java.util.List;
import javax.persistence.Query;
import entity.Documento;

public class ArquivoDAO extends DAO {

	public void salvar(Documento doc) {
		getEM().merge(doc);
	}

	public List<Documento> listarDocumentoPorTurma(Long idTurma) {
		Query query = getEM().createQuery("From Documento i where i .turma.id = : idTurma", Documento.class);
		query.setParameter("idTurma", idTurma);
		return query.getResultList();
	}

	public Documento buscarDocumentoPorId(Long idDocumento) {
		return getEM().find(Documento.class, idDocumento);
	}

	public void excluir(Documento documento) {
		getEM().remove(documento);

	}

}
