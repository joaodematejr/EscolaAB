package dao;

import entity.Documento;
import java.util.List;

import javax.persistence.Query;

import entity.Documento;

public class DocumentoDAO extends DAO {
	public void salvar(Documento documento) {
		getEM().merge(documento);
	}

	public List<Documento> listarDocumentoPorCliente(Long idCliente) {
		Query query = getEM().createQuery(
				"From Documento i Where i.cliente.id = :idCliente ",
				Documento.class);
		query.setParameter("idCliente", idCliente);
		return query.getResultList();
	}

	public Documento buscarDocumentoPorId(Long idDocumento) {
		return getEM().find(Documento.class, idDocumento);

	}

	public void excluir(Documento documento) {
		getEM().remove(documento);

	}
}
