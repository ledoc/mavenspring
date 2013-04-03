package fr.treeptik.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.treeptik.model.Voiture;
import fr.treeptik.service.VoitureService;

@Controller
public class VoitureController {

	@Autowired
	private VoitureService voitureService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	dateFormat.setLenient(false);
	binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	
	@RequestMapping(method = RequestMethod.GET, value = "/savevoiture.do")
	public ModelAndView showSaveForm(@RequestParam(required = false) Integer id) { // init
																					// les
																					// pages
		
		Voiture voiture = null;
		if (id == null) {
			voiture = new Voiture();
//			voiture.setVersion(new Date());
		} else {
			voiture = voitureService.findById(id);
		}
		
		
		

		return new ModelAndView("savevoiture.jsp","voiture", voiture); // "voiture"
																		// correspond
																		// au
																		// commandName
																		// dans
																		// savevoiture.jsp
	}

	@RequestMapping(method = RequestMethod.POST, value = "/savevoiture.do")
	public ModelAndView save(@Valid Voiture voiture, BindingResult result) { // validation
																				// des
																				// chamos
																				// renseignés
		// BindingResult permet de recevoir le resultat de la validation de la
		// voiture

		if (result.hasErrors()) {
			return new ModelAndView("savevoiture.jsp", "voiture", voiture); // on
																			// revient
																			// sur
																			// le
																			// formulaire
		}

		voitureService.creerUpdate(voiture);

		Map<String, Object> params = new HashMap<>();
		params.put("voiture", voiture);
		params.put("voitures", voitureService.lister());

		return new ModelAndView("listvoiture.jsp", params);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/listvoiture.do")
	public ModelAndView list() {
		List<Voiture> voitures = voitureService.lister();
		return new ModelAndView("listvoiture.jsp", "voitures", voitures);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/removevoiture.do")
	public String remove(@RequestParam int id) {
		Voiture voiture = new Voiture();
		voiture.setId(id);
		voitureService.supprimer(voiture);
		return "redirect:/listvoiture.do";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/recherchevoiture.do")
	public ModelAndView recherche() {
		Voiture voiture = new Voiture();
		Map<String, Object> params = new HashMap<>();
		params.put("voiture", voiture);
		params.put("voitures", voitureService.lister());
		return new ModelAndView("recherchervoiture.jsp", params);
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/recherchevoiture.do")
	public ModelAndView recherche( Voiture voiture) {
		List<Voiture> voitures2 = voitureService.lister();
		List<Voiture> voitures = new ArrayList<>();
		for (Voiture voiture1 : voitures2) {
			if(voiture1.getMarque().equalsIgnoreCase(voiture.getMarque() )|| voiture1.getModele().equalsIgnoreCase(voiture.getMarque())){
				voitures.add(voiture1);
			}
		}
		Map<String, Object> params = new HashMap<>();
		params.put("voiture", voiture);
		params.put("voitures", voitures);
		return new ModelAndView("recherchervoiture.jsp", params);
		
	}

}
