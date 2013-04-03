package fr.treeptik.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.treeptik.model.Client;
import fr.treeptik.model.Commande;
import fr.treeptik.service.ClientService;
import fr.treeptik.service.CommandeService;
import fr.treeptik.validator.ClientValidator;

@Controller
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@Autowired
	private CommandeService commandeService;
	
	@RequestMapping(method=RequestMethod.GET,value="/saveclient.do")
	public ModelAndView showSaveForm(@RequestParam(required=false) Integer id){ // init les pages jsp
		
		Client client1=null;
		if(id==null){
			client1=new Client();
		}else{
			client1=clientService.findById(id);
		}
		
		return new ModelAndView("saveclient.jsp", "client", client1); // "voiture" correspond au commandName dans savevoiture.jsp
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/saveclient.do")
	public ModelAndView save(Client client, BindingResult result){ 
		// BindingResult permet de recevoir le resultat de la validation de la voiture
		
		ClientValidator clientValidator = new ClientValidator();
		clientValidator.validate(client, result);	//appeler le validator
		
		if (result.hasErrors()){
			return new ModelAndView("saveclient.jsp", "client", client); // on revient sur le formulaire
		}
		
		client = clientService.creerUpdate(client);
		
		Map<String, Object> params = new HashMap<>();
		params.put("newClient", client);
		params.put("clients", clientService.lister());
		
		return new ModelAndView("listclient.jsp", params);
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="/listclient.do")
	public ModelAndView list(){
		List<Client> clients = clientService.lister();
		return new ModelAndView("listclient.jsp","clients",clients);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/removeclient.do")
	public String remove(@RequestParam int id){
		Client client = new Client();
		client.setId(id);
		clientService.supprimer(client);
		return "redirect:/listclient.do";
	}
	
	/**
	 * 
	 * @param clientId
	 * @return liste des commandes d'un client
	 */
	@RequestMapping(method=RequestMethod.GET,value="/listcommandeparclient.do")
	public ModelAndView listcommande(@RequestParam int clientId){ // init les pages jsp
		
			List<Commande> commandes= commandeService.listerparclient(clientId);
		
		return new ModelAndView("listcommande.jsp", "commandes", commandes); 
	}
	
}
