package fr.treeptik.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class CommandeKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JoinColumn(name = "client_ID")
	@ManyToOne
	private Client client;

	@JoinColumn(name = "voiture_ID")
	@ManyToOne()
	private Voiture voiture;


	public CommandeKey() {
		super();
	}




	public CommandeKey(Client client, Voiture voiture) {
		super();
		this.client = client;
		this.voiture = voiture;
	}




	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Voiture getVoiture() {
		return voiture;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((voiture == null) ? 0 : voiture.hashCode());
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
		CommandeKey other = (CommandeKey) obj;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (voiture == null) {
			if (other.voiture != null)
				return false;
		} else if (!voiture.equals(other.voiture))
			return false;
		return true;
	}




	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CommandeKey [client=");
		builder.append(client);
		builder.append(", voiture=");
		builder.append(voiture);
		builder.append("]");
		return builder.toString();
	}

}
