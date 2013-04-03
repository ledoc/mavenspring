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

import fr.treeptik.model.Employe;
import fr.treeptik.service.EmployeService;
import fr.treeptik.validator.EmployeValidator;

@Controller
public class EmployeController {

	@Autowired
	private EmployeService employeService;
	
	@RequestMapping(method=RequestMethod.GET,value="/saveemploye.do")
	public ModelAndView showSaveForm(@RequestParam(required=false) Integer id){ // init les pages jsp
		
		Employe employe1=null;
		if(id==null){
			employe1=new Employe();
		}else{
			employe1=employeService.findById(id);
		}
		
		return new ModelAndView("saveemploye.jsp", "employe", employe1); // "voiture" correspond au commandName dans savevoiture.jsp
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/saveemploye.do")
	public ModelAndView save(Employe employe, BindingResult result){ 
		// BindingResult permet de recevoir le resultat de la validation de la voiture
		
		EmployeValidator employeValidator = new EmployeValidator();
		employeValidator.validate(employe, result);	//appeler le validator
		
		if (result.hasErrors()){
			return new ModelAndView("saveemploye.jsp", "employe", employe); // on revient sur le formulaire
		}
		
		employe = employeService.creerUpdate(employe);
		
		Map<String, Object> params = new HashMap<>();
		params.put("newEmploye", employe);
		params.put("employes", employeService.lister());
		
		return new ModelAndView("listemploye.jsp", params);
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="/listemploye.do")
	public ModelAndView list(){
		List<Employe> employes = employeService.lister();
		return new ModelAndView("listemploye.jsp","employes",employes);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/removeemploye.do")
	public String remove(@RequestParam int id){
		Employe employe = new Employe();
		employe.setId(id);
		employeService.supprimer(employe);
		return "redirect:/listemploye.do";
	}
	
}
