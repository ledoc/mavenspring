package fr.treeptik.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.treeptik.model.Client;
import fr.treeptik.model.Commande;
import fr.treeptik.model.CommandeKey;
import fr.treeptik.model.Voiture;
import fr.treeptik.service.ClientService;
import fr.treeptik.service.CommandeService;
import fr.treeptik.service.VoitureService;

@Controller
public class CommandeController {

	@Autowired
	private CommandeService commandeService;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private VoitureService voitureService;
	
	@RequestMapping(method=RequestMethod.GET,value="/savecommande.do")
	public ModelAndView showSaveForm(@RequestParam(required=false) Integer idClient, @RequestParam(required=false) Integer idVoiture){
		Commande commande=null;
		if((idClient==null) || (idVoiture==null)){
			commande=new Commande();
			CommandeKey commandeKey=new CommandeKey(new Client(), new Voiture());
			commande.setCommandeKey(commandeKey);

		}else{
			Client client = clientService.findById(idClient);
			Voiture voiture = voitureService.findById(idVoiture);
			commande=commandeService.findById(client, voiture);
		}
		
		List<Voiture> voitures = voitureService.lister();
		List<Client> clients = clientService.lister();
		
		Map<String, Object> params = new HashMap<>();
		params.put("commande", commande);
		params.put("voitures", voitures);
		params.put("clients", clients);
		return new ModelAndView("savecommande.jsp", params);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/savecommande.do")
	public ModelAndView save(@Valid Commande commande, BindingResult result) { // validation
																				// des
																				// chamos
																				// renseignés
		// BindingResult permet de recevoir le resultat de la validation de la
		// voiture

		if (result.hasErrors()) {
			return new ModelAndView("savecommande.jsp", "commande", commande); // on
																			// revient
																			// sur
																			// le
																			// formulaire
		}
		
		commandeService.creerUpdate(commande);

		Map<String, Object> params = new HashMap<>();
		params.put("commande", commande);
		params.put("commandes", commandeService.lister());

		return new ModelAndView("listcommande.jsp", params);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/listcommande.do")
	public ModelAndView list(){
		List<Commande> commandes = commandeService.lister();
		return new ModelAndView("listcommande.jsp","commandes",commandes);
	}

	@RequestMapping(method=RequestMethod.GET, value="/removecommande.do")
	public String remove(@RequestParam Integer clientId, @RequestParam Integer voitureId){
		Client client = clientService.findById(clientId);		
		Voiture voiture = voitureService.findById(voitureId);
		CommandeKey commandeKey = new CommandeKey();
		commandeKey.setClient(client);
		commandeKey.setVoiture(voiture);
		Commande commande= new Commande();
		commande.setCommandeKey(commandeKey);
		commandeService.supprimer(commande);
		return "redirect:/listcommande.do";
	}
	
}
