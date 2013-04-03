package fr.treeptik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.dao.VoitureDAO;
import fr.treeptik.model.Voiture;

@Service
public class VoitureService {

	@Autowired
	private VoitureDAO voitureDAO;
	
	@Transactional
	public Voiture creerUpdate(Voiture voiture){
		return voitureDAO.creerUpdate(voiture);
	}
	
	@Transactional
	public void supprimer(Voiture voiture){
		 voitureDAO.supprimer(voiture);
	}
	
	@Transactional
	public List<Voiture> lister(){
		return voitureDAO.lister();
	}
	
	@Transactional
	public Voiture findById(Integer id){
		return voitureDAO.findById(id);
	}
	
}
