package fr.treeptik.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.treeptik.dao.ClientDAO;
import fr.treeptik.model.Client;

@Repository
public class ClientJPADAO implements ClientDAO{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Client creerUpdate(Client client) {
		return entityManager.merge(client);
		 
	}

	@Override
	public void supprimer(Client client) {
		Query query = entityManager.createQuery("delete from Client c where c.id=:id");
		query.setParameter("id", client.getId());
		query.executeUpdate();		
	}

	@Override
	public List<Client> lister() {
		TypedQuery<Client> query = entityManager.createQuery("select c from Client c", Client.class);
		return query.getResultList();
	}

	@Override
	public Client findById(Integer id) {
		return entityManager.find(Client.class, id);
	}

}
