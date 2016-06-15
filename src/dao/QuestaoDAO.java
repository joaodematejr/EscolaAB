package dao;

import java.util.List;

import javax.persistence.Query;




import entity.Cliente;
import entity.Perfil;
import entity.Questao;
import entity.Turma;

public class QuestaoDAO extends DAO {// METODO PUBLIC
	public void salvar(Questao questao) {// MEDOTO QUE SALVA E RETORNA UM VALOR
		getEM().merge(questao);// METODO PARA ATUALIZAR INSTANCIA
	}

	public Questao buscarPorId(Long id) {// METODO PUBLIC DEIXA VISIVEL A CLASSE
		return getEM().find(Questao.class, id);// MEDOTO QUE RETORNA UM VALOR
	}


	public List<Questao> listarQuestoes() {
		Query query = getEM().createQuery("From Questao u Where u.perfil = :perfil", Questao.class);
		query.setParameter("perfil", Perfil.PROFESSOR);
		
		
		return query.getResultList();
		
	
	}
	

	public void excluir(Long id) {// METODO PUBLIC, DELETAR QUESTAO
		Questao questao = getEM().getReference(Questao.class, id);
		getEM().remove(questao);
	}

}


