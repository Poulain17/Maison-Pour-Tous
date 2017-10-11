package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Spectacle {
	protected final IntegerProperty num_Spectacle;
	protected final StringProperty nom_Spectacle;
	protected final StringProperty genre;
	protected final IntegerProperty duree;
	
	public Spectacle(){
		this(0,null,null,0);
	}
	
	public Spectacle(int num_Spectacle,String nom_Spectacle,String genre , int duree) {
	    this.num_Spectacle = new SimpleIntegerProperty(num_Spectacle);
        this.nom_Spectacle = new SimpleStringProperty(nom_Spectacle);
        this.genre = new SimpleStringProperty(genre);
        this.duree = new SimpleIntegerProperty(duree);
        
 }
	
	 //**********************************************
    public int getNumSpectacle() {
        return num_Spectacle.get();
    }


	public void setNum_Spectacle(int num_Spectacle) {
        this.num_Spectacle.set(num_Spectacle);
    }

    public IntegerProperty num_SpectacleProperty() {
        return num_Spectacle;
    }

        
	    //***********
	    public String getNom_Spectacle() {
	        return this.nom_Spectacle.get();
	    }
	    
	    public void setNom_Spectacle(String nom_Spectacle) {
	        this.nom_Spectacle.set(nom_Spectacle);
	    }

	    public StringProperty nom_SpectacleProperty() {
	        return nom_Spectacle;
	    }
	               //***********
	    
	    //**********************************************
	    public String getGenre() {
	        return this.genre.get();
	    }
	    
	    public void setGenre(String genre) {
	        this.genre.set(genre);
	    }

	    public StringProperty genreProperty() {
	        return genre;
	    }
	               //***********
	    public int getDuree() {
	        return duree.get();
	    }


		public void setDuree(int duree) {
	        this.duree.set(duree);
	    }

	    public IntegerProperty dureeProperty() {
	        return duree;
	    }

	             //***************
	   	
	

}
