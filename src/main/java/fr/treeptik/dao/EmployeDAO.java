package fr.treeptik.dao;

import java.util.List;

import fr.treeptik.model.Employe;

public interface EmployeDAO {

	Employe creerUpdate (Employe employe);
	void supprimer (Employe employe);
	List<Employe> lister();
	Employe findById(Integer id);
	
}
