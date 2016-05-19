package dao;

import javax.persistence.EntityManager;

import commons.JpaUtil;

public abstract class DAO {

	public DAO() {
		super();
	}

	protected EntityManager getEM() {
		EntityManager em = JpaUtil.getEntityManager();
		return em;
	}

}