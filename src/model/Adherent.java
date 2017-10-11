package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Adherent {
	protected final IntegerProperty num_Adherent;
	protected final StringProperty nom_Adherent;
	protected final StringProperty prenom_Adherent;
	protected final StringProperty adresse_Adherent;

	public Adherent(){
		this(null,null);
	}

	public Adherent(String nom_Adherent, String prenom_Adherent) {
		this.num_Adherent = new SimpleIntegerProperty();
		this.nom_Adherent = new SimpleStringProperty(nom_Adherent);
		this.prenom_Adherent = new SimpleStringProperty(prenom_Adherent);
		this.adresse_Adherent = new SimpleStringProperty();
	}
	public Adherent(int num_Adherent,String nom_Adherent, String prenom_Adherent,String adresse_Adherent) {
		this.num_Adherent = new SimpleIntegerProperty();
		this.nom_Adherent = new SimpleStringProperty(nom_Adherent);
		this.prenom_Adherent = new SimpleStringProperty(prenom_Adherent);
		this.adresse_Adherent = new SimpleStringProperty();
	}



	public int getNum_Adherent() {
		return num_Adherent.get();
	}


	public void setNum_Adherent(int num_Adherent) {
		this.num_Adherent.set(num_Adherent);
	}

	public IntegerProperty num_AdherentProperty() {
		return num_Adherent;
	}

	public String getNom_Adherent() {
		return this.nom_Adherent.get();
	}

	public void setNom_Adherent(String nom_Adherent) {
		this.nom_Adherent.set(nom_Adherent);
	}

	public StringProperty nnom_AdherentProperty() {
		return nom_Adherent;
	}

	public String getPrenom_Adherent() {
		return this.prenom_Adherent.get();
	}

	public void setPrenom_Adherent(String prenom_Adherent) {
		this.prenom_Adherent.set(prenom_Adherent);
	}

	public StringProperty prenom_AdherentProperty() {
		return prenom_Adherent;
	}


	public String getAdresse_Adherent() {
		return this.adresse_Adherent.get();
	}

	public void setAdresse_Adherent(String adresse_Adherent) {
		this.adresse_Adherent.set(adresse_Adherent);
	}

	public StringProperty adresse_AdherentProperty() {
		return adresse_Adherent;
	}


} //end Adherent
