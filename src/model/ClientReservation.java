package model;

import java.util.Date;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ClientReservation {
	
	protected final IntegerProperty num_Representation;
	protected final IntegerProperty num_Spectacle;
	protected final IntegerProperty num_Salle;
	protected final DoubleProperty Tarif;
	protected final StringProperty nom_Spectacle;
	protected final ObjectProperty<Date> date_Representation;
	
	
	public ClientReservation(){
		this(0,0,0,0,null,null);
	}
	
	public ClientReservation(int num_Representation,int num_Spectacle ,int  num_Salle,double  Tarif,String nom_Spectacle, Date date_Representation){
		    this.num_Representation = new SimpleIntegerProperty(num_Representation);
	        this.num_Spectacle = new SimpleIntegerProperty(num_Spectacle);
	        this.Tarif = new SimpleDoubleProperty(Tarif);
	        this.num_Salle = new SimpleIntegerProperty(num_Salle);
	        this.nom_Spectacle = new SimpleStringProperty(nom_Spectacle);
	        this.date_Representation = new SimpleObjectProperty<Date>(date_Representation);
	}

	 //**********************************************
   public int getnum_Salle() {
       return num_Salle.get();
   }


	public void setnum_Salle(int num_Salle) {
       this.num_Salle.set(num_Salle);
   }

   public IntegerProperty num_SalleProperty() {
       return num_Salle;
   }

	
	 //**********************************************
    public int getnum_Representation() {
        return num_Representation.get();
    }


	public void setnum_Representation(int num_Representation) {
        this.num_Representation.set(num_Representation);
    }

    public IntegerProperty num_RepresentationProperty() {
        return num_Representation;
    }

             //***************
	
    public int getnum_Spectacle() {
        return num_Spectacle.get();
    }


	public void setnum_Spectacle(int num_Spectacle) {
        this.num_Spectacle.set(num_Spectacle);
    }

    public IntegerProperty num_SpectacleProperty() {
        return num_Spectacle;
    }

    //***********
    public String getnom_Spectacle() {
        return this.nom_Spectacle.get();
    }
    
    public void setnom_Spectacle(String nom_Spectacle) {
        this.nom_Spectacle.set(nom_Spectacle);
    }

    public StringProperty nom_SpectacleProperty() {
        return nom_Spectacle;
    }
               //***********
    public Date getdate_Representation() {
        return date_Representation.get();
    }


    public void setdate_Representation(Date date_Representation) {
        this.date_Representation.set(date_Representation);
    }

    public ObjectProperty<Date> date_RepresentationProperty() {
        return date_Representation;
    }

	    
	   //******************************
    public double getTarif() {
        return Tarif.get();
    }


	public void setTarif(double d) {
        this.Tarif.set(d);
    }

    public DoubleProperty TarifProperty() {
        return Tarif;
    }
	   	    
    
	
}

	


