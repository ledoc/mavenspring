package fr.treeptik.dao;

import java.util.List;

import fr.treeptik.model.Commande;
import fr.treeptik.model.CommandeKey;

public interface CommandeDAO {
	
	Commande creerUpdate (Commande commande);
	void supprimer (Commande commande);
	List<Commande> lister();
	List<Commande> listerparclient(int clientId);
	List<Commande> listerparvoiture(int voitureId);
	Commande findById(CommandeKey id);

}
