package fr.treeptik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.dao.EmployeDAO;
import fr.treeptik.model.Employe;

@Service
public class EmployeService {

	@Autowired
	private EmployeDAO employeDAO;
	
	@Transactional
	public Employe creerUpdate(Employe employe){
		return employeDAO.creerUpdate(employe);
	}
	
	@Transactional
	public void supprimer(Employe employe){
		 employeDAO.supprimer(employe);
	}
	
	@Transactional
	public List<Employe> lister(){
		return employeDAO.lister();
	}
	
	public Employe findById(Integer id){
		return employeDAO.findById(id);
	}
	
}
