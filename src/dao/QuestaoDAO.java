package dao;

import java.util.List;

import javax.persistence.Query;//ACESSAR O PERSISTENCE

import entity.Dificudade;//ACESSAR A CLASSE DIFICUDADE
import entity.Modalidade;
import entity.Professor;
import entity.Questao;//ACESSAR A CLASSE QUESTAO

public class QuestaoDAO extends DAO {// METODO PUBLIC
	
	public void salvar(Questao questao) {// MEDOTO QUE SALVA E RETORNA UM VALOR
		getEM().merge(questao);// METODO PARA ATUALIZAR INSTANCIA
	}

	public Questao buscarPorId(Long id) {// METODO PUBLIC DEIXA VISIVEL A CLASSE
		return getEM().find(Questao.class, id);// MEDOTO QUE RETORNA UM VALOR
	}

	public List<Questao> listarQuestoes() {// MEDOTO PUBLIC, LISTAR QUESTAO
											// DENTRO DA CLASSE CLIENTE
		Query query = getEM().createQuery("From Questao", Questao.class);//
		return query.getResultList();// RETURN VALOR
	}

	public void excluir(Long id) {// METODO PUBLIC, DELETAR QUESTAO
		Questao questao = getEM().getReference(Questao.class, id);
		getEM().remove(questao);
	}

	public List<Questao> listarProfessores() {
		Query query = getEM().createQuery("From Questao u Where u.dificuldade");
		query.setParameter("deificudade", Dificudade.PROFESSOR);
		
		return query.getResultList();
		
	}
	

}
	

	

	
	