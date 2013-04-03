package fr.treeptik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.dao.CommandeDAO;
import fr.treeptik.model.Client;
import fr.treeptik.model.Commande;
import fr.treeptik.model.CommandeKey;
import fr.treeptik.model.Voiture;

@Service
public class CommandeService {

	@Autowired
	private CommandeDAO commandeDAO;
	
	@Transactional
	public Commande creerUpdate(Commande commande){
		return commandeDAO.creerUpdate(commande);
	}
	
	@Transactional
	public void supprimer(Commande commande){
		 commandeDAO.supprimer(commande);
	}
	
	@Transactional
	public List<Commande> lister(){
		return commandeDAO.lister();
	}
	
	@Transactional
	public List<Commande> listerparclient(int clientId){
		return commandeDAO.listerparclient(clientId);
	}
	
	@Transactional
	public List<Commande> listerparvoiture(int voitureId){
		return commandeDAO.listerparvoiture(voitureId);
	}
	
	@Transactional
	public Commande findById(Client client, Voiture voiture){
		return commandeDAO.findById(new CommandeKey(client, voiture));
	}
	
}
