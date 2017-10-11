package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Salle {
	protected final IntegerProperty num_Salle;
	protected final StringProperty nom_Salle;
	protected final IntegerProperty nb_Places;

	public Salle(){
		this(0,null,0);
	}

	public Salle(int num_Salle,String nom_Salle, int nb_Places) {
		this.num_Salle = new SimpleIntegerProperty(num_Salle);
		this.nom_Salle = new SimpleStringProperty(nom_Salle);
		this.nb_Places = new SimpleIntegerProperty(nb_Places);
		}


	public int getNum_Salle() {
		return num_Salle.get();
	}


	public void setNum_Salle(int num_Salle) {
		this.num_Salle.set(num_Salle);
	}

	public IntegerProperty num_SalleProperty() {
		return num_Salle;
	}


	public String getNom_Salle() {
		return this.nom_Salle.get();
	}

	public void setNom_Salle(String nom_Salle) {
		this.nom_Salle.set(nom_Salle);
	}

	public StringProperty nom_SalleProperty() {
		return nom_Salle;
	}


	public int getNb_Places() {
		return nb_Places.get();
	}


	public void setNb_Places(int nb_Places) {
		this.nb_Places.set(nb_Places);
	}

	public IntegerProperty nb_PlacesProperty() {
		return nb_Places;
	}

}
