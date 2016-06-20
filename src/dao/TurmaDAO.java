package dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;//ACESSAR O PERSISTENCE
import entity.Perfil;//ACESSAR A CLASSE PERFIL
import entity.Turma;//ACESSAR A CLASSE TURMA

public class TurmaDAO extends DAO {

	public List<Turma> listar() {
		Query query = getEM().createQuery("From Turma", Turma.class);
		return query.getResultList();
	}

	public void salvar(Turma turma) throws SQLException {
		getEM().merge(turma);
	}

	public Turma buscarPorId(Long id) {
		return getEM().find(Turma.class, id);
	}

	public void excluir(Long id) {
		Turma turma = getEM().getReference(Turma.class, id);
		getEM().remove(turma);
	}
}