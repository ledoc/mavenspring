package fr.treeptik.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.treeptik.dao.EmployeDAO;
import fr.treeptik.model.Employe;

@Repository
public class EmployeJPADAO implements EmployeDAO{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Employe creerUpdate(Employe employe) {
		return entityManager.merge(employe);
		 
	}

	@Override
	public void supprimer(Employe employe) {
		Query query = entityManager.createQuery("delete from Employe c where c.id=:id");
		query.setParameter("id", employe.getId());
		query.executeUpdate();		
	}

	@Override
	public List<Employe> lister() {
		TypedQuery<Employe> query = entityManager.createQuery("select c from Employe c", Employe.class);
		return query.getResultList();
	}

	@Override
	public Employe findById(Integer id) {
		return entityManager.find(Employe.class, id);
	}

}
