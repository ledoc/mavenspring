package fr.treeptik.dao;

import java.util.List;

import fr.treeptik.model.Client;

public interface ClientDAO {

	Client creerUpdate (Client client);
	void supprimer (Client client);
	List<Client> lister();
	Client findById(Integer id);
	
}
