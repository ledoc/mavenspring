package fr.treeptik.dao;

import java.util.List;

import fr.treeptik.model.Voiture;

public interface VoitureDAO {

	
	Voiture creerUpdate (Voiture voiture);
	void supprimer (Voiture voiture);
	List<Voiture> lister();
	Voiture findById(Integer id);
	
}
