package fr.treeptik.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.treeptik.dao.CommandeDAO;
import fr.treeptik.model.Client;
import fr.treeptik.model.Commande;
import fr.treeptik.model.CommandeKey;
import fr.treeptik.model.Voiture;

@Repository
public class CommandeJPADAO implements CommandeDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Commande creerUpdate(Commande commande) {

		commande.getCommandeKey().setVoiture(entityManager.find(Voiture.class, commande.getCommandeKey().getVoiture().getId()));
		commande.getCommandeKey().setClient(entityManager.find(Client.class, commande.getCommandeKey().getClient().getId()));
		entityManager.persist(commande);
		Client client = entityManager.find(Client.class, commande.getCommandeKey().getClient().getId());
		client.getCommandes().add(commande);
		entityManager.merge(client);
		Voiture voiture = entityManager.find(Voiture.class, commande.getCommandeKey().getVoiture().getId());
		voiture.getCommandes().add(commande);
		entityManager.merge(voiture);
		return commande;
	}

	@Override
	public void supprimer(Commande commande) {
		Query query = entityManager.createQuery("delete from Commande c where c.commandeKey=:id1");
		query.setParameter("id1", commande.getCommandeKey());
		query.executeUpdate();
	}

	@Override
	public List<Commande> lister() {
		TypedQuery<Commande> query = entityManager.createQuery("select c from Commande c", Commande.class);
		return query.getResultList();
	}
	
	@Override
	public List<Commande> listerparclient(int clientId) {
		TypedQuery<Commande> query = entityManager.createQuery("select c from Commande c where c.commandeKey.client.id=:clientId", Commande.class);
		query.setParameter("clientId", clientId);
		return query.getResultList();
	}
	
	@Override
	public List<Commande> listerparvoiture(int voitureId) {
		TypedQuery<Commande> query = entityManager.createQuery("select c from Commande c where c.commandeKey.voiture.id=:voitureId", Commande.class);
		query.setParameter("voitureId", voitureId);
		return query.getResultList();
	}
	
	@Override
	public Commande findById(CommandeKey id) {
		Query query =entityManager.createQuery("select c from Commande c where c.id=:id");
		query.setParameter("id", id);
		return (Commande) query.getSingleResult();
	}

}
