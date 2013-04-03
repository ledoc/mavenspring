package fr.treeptik.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.treeptik.dao.VoitureDAO;
import fr.treeptik.model.Voiture;

@Repository
public class VoitureJPADAO implements VoitureDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public Voiture creerUpdate(Voiture voiture) {
		entityManager.merge(voiture);
		return voiture;
	}

	@Override
	public void supprimer(Voiture voiture) {
		Query query = entityManager.createQuery("delete from Voiture v where v.id=:id");
		query.setParameter("id", voiture.getId());
		query.executeUpdate();
	}

	@Override
	public List<Voiture> lister() {
		TypedQuery<Voiture> query = entityManager.createQuery("select v from Voiture v", Voiture.class);
		return query.getResultList();
	}
	
	@Override
	public Voiture findById(Integer id){
		return entityManager.find(Voiture.class, id);
	}

}
