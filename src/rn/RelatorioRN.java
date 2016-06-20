package rn;

import java.util.Date;
import java.util.List;

import dao.RelatorioDAO;
import entity.Relatorio;

public class RelatorioRN {
	private RelatorioDAO dao;

	public RelatorioRN() {
		dao = new RelatorioDAO();
	}

	public List<Relatorio> buscarPorPeriodo(Date inicio, Date fim) {
		return dao.buscarPorPeriodo(inicio, fim);
	}

}
