package fr.treeptik.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Commande implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CommandeKey commandeKey;

	private String dateDebutCommande;
	private String dateFinCommande;

	public Commande() {
		super();
	}

	public Commande(CommandeKey commandeKey, String dateDebutCommande,
			String dateFinCommande) {
		super();
		this.commandeKey = commandeKey;
		this.dateDebutCommande = dateDebutCommande;
		this.dateFinCommande = dateFinCommande;
	}


	public CommandeKey getCommandeKey() {
		return commandeKey;
	}

	public void setCommandeKey(CommandeKey commandeKey) {
		this.commandeKey = commandeKey;
	}

	public String getDateDebutCommande() {
		return dateDebutCommande;
	}

	public void setDateDebutCommande(String dateDebutCommande) {
		this.dateDebutCommande = dateDebutCommande;
	}

	public String getDateFinCommande() {
		return dateFinCommande;
	}

	public void setDateFinCommande(String dateFinCommande) {
		this.dateFinCommande = dateFinCommande;
	}
	
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((commandeKey == null) ? 0 : commandeKey.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commande other = (Commande) obj;
		if (commandeKey == null) {
			if (other.commandeKey != null)
				return false;
		} else if (!commandeKey.equals(other.commandeKey))
			return false;
		return true;
	}


}
