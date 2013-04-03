package fr.treeptik.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fr.treeptik.model.Employe;

public class EmployeValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) { // appelée à la création du validator par le controller qui valide la classe de l'objet a controler
		return Employe.class.equals(arg0); // return True quand on passe une voiture
	}

	@Override
	public void validate(Object employe, Errors errors) { //pour valider l'objet

		Employe c = (Employe) employe;
		
		if(c.getName().equalsIgnoreCase(c.getAdresse())){
			errors.rejectValue("adresse","error.employe.adresseEqualName","erreur saisie addresse"); // "adresses" correspond au nom de l'erreur qu'on devra recup pour afficher dans .jsp
			// le dernier string est le message d'erreur par défaut s'il trouve pas le code error
			// le code error doit etre defini dans un fichier de properties
		}
		
	}
	
	
	
	
}
