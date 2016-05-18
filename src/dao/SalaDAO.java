package dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;

import entity.Sala;

public class SalaDAO extends DAO {
	public List<Sala> listar() {
		Query query = getEM().createQuery("From Sala", Sala.class);
		return query.getResultList();
	}

	public void salvar(Sala sala) throws SQLException {
		getEM().merge(sala);
	}

	public Sala buscarPorId(Long id) {
		return getEM().find(Sala.class, id);
	}
}
