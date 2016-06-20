package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import entity.Relatorio;

public class RelatorioDAO extends DAO {
	public List<Relatorio> buscarPorPeriodo(Date inicio, Date fim) {
		Query query = getEM().createQuery("From Relatorio c" + " Where c.data between :inicio and :fim",
				Relatorio.class);

		query.setParameter("inicio", inicio);
		query.setParameter("fim", fim);

		return query.getResultList();
	}

}
