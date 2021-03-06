package dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import entity.Perfil;
import entity.Pergunta;

public class PerguntaDAO extends DAO {
	public void salvar(Pergunta pergunta) {
		getEM().merge(pergunta);
	}

	public Pergunta buscarPorId(Long id) {
		return getEM().find(Pergunta.class, id);
	}

	public List<Pergunta> listarPerguntas() {
		Query query = getEM().createQuery("From Pergunta", Pergunta.class);//
		return query.getResultList();
	}

	public void excluir(Long id) {
		Pergunta pergunta = getEM().getReference(Pergunta.class, id);
		getEM().remove(pergunta);
	}

	public Pergunta buscarPorEmail(String email) {
		Query query = getEM().createQuery("From Pergunta u Where u.email = :email", Pergunta.class);
		query.setParameter("email", email);

		try {
			return (Pergunta) query.getSingleResult();
		} catch (NoResultException exceptio) {
			return null;
		}
	}
}
