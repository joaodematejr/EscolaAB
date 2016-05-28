package dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;

import entity.Documento;

public class DocumentoDAO extends DAO {

	public List<Documento> listar() {
		Query query = getEM().createQuery("From Documento", Documento.class);
		return query.getResultList();
	}

	public void salvar(Documento documento) throws SQLException {
		getEM().merge(documento);
	}

	public void excluir(Long id) {
		Documento documento = getEM().getReference(Documento.class, id);
		getEM().remove(documento);

	}

	public Documento buscarPorId(Long id) {
		return getEM().find(Documento.class, id);
	}

}
