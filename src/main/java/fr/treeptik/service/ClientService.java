package fr.treeptik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.dao.ClientDAO;
import fr.treeptik.model.Client;

@Service
public class ClientService {

	@Autowired
	private ClientDAO clientDAO;
	
	@Transactional
	public Client creerUpdate(Client client){
		return clientDAO.creerUpdate(client);
	}
	
	@Transactional
	public void supprimer(Client client){
		 clientDAO.supprimer(client);
	}
	
	@Transactional
	public List<Client> lister(){
		return clientDAO.lister();
	}
	
	public Client findById(Integer id){
		return clientDAO.findById(id);
	}
	
}
