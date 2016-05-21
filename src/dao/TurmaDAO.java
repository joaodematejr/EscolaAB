package dao;

import java.util.List;

import javax.persistence.Query;//ACESSAR O PERSISTENCE
import entity.Perfil;//ACESSAR A CLASSE PERFIL
import entity.Turma;//ACESSAR A CLASSE TURMA

public class TurmaDAO extends DAO {// METODO PUBLIC
	public void salvar(Turma turma) {// MEDOTO QUE SALVA E RETORNA UM VALOR
		getEM().merge(turma);// METODO PARA ATUALIZAR INSTANCIA
	}

	public Turma buscarPorId(Long id) {// METODO PUBLIC DEIXA VISIVEL A CLASSE
		return getEM().find(Turma.class, id);// MEDOTO QUE RETORNA UM VALOR
	}

	public List<Turma> listarTurma() {// MEDOTO PUBLIC, LISTAR TURMA
											// DENTRO DA CLASSE TURMA
		Query query = getEM().createQuery("From Turma", Turma.class);//
		return query.getResultList();// RETURN VALOR
	}

	public void excluir(Long id) {// METODO PUBLIC, DELETAR TURMA
		Turma turma = getEM().getReference(Turma.class, id);
		getEM().remove(turma);
	}

	public List<Turma> listarProfessores() {
		Query query = getEM().createQuery("From Turma u Where u.perfil",
				Turma.class);
		query.setParameter("perfil", Perfil.PROFESSOR);
		return query.getResultList();
	}
}
