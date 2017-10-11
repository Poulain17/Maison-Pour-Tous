package model;

import java.util.Date;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Reservation {
	
	protected final IntegerProperty num_Resa;
	protected final IntegerProperty num_Adherent;
	protected final IntegerProperty num_Representation;
	protected final IntegerProperty nb_Personne;
	protected final ObjectProperty<Date> date_Resa;
	
	public Reservation(){
		this(0,0,0,0,null);
	}
	public Reservation(int num_Resa,int num_Adherent ,int num_Representation ,int  nb_Personne,Date date_Resa) {
        this.num_Resa = new SimpleIntegerProperty(num_Resa);
        this.num_Adherent = new SimpleIntegerProperty(num_Adherent);
        this.num_Representation = new SimpleIntegerProperty(num_Representation);
        this.nb_Personne =new SimpleIntegerProperty(nb_Personne);
        this.date_Resa = new SimpleObjectProperty<Date>(date_Resa);}
	 
    public int getnum_Resa() {
        return num_Representation.get();}

	public void setnum_Resa(int num_Representation) {
        this.num_Representation.set(num_Representation);}

    public IntegerProperty num_ResaProperty() {
        return num_Representation;}
	
    public int getnum_Adherent() {
        return num_Adherent.get();}

	public void setnum_Adherent(int num_Adherent) {
        this.num_Adherent.set(num_Adherent);}

    public IntegerProperty num_AdherentProperty() {
        return num_Adherent;}

    public int getnum_Representation() {
        return num_Representation.get();}

	public void setnum_Representation(int num_Representation) {
        this.num_Representation.set(num_Representation);}

    public IntegerProperty num_RepresentationProperty() {
        return num_Representation;}

    public int getnb_Personne() {
        return nb_Personne.get();}

	public void setnb_Personne(int nb_Personne) {
        this.nb_Personne.set(nb_Personne);}

    public IntegerProperty nb_PersonneProperty() {
        return nb_Personne;}

    public Date getdate_Resa() {
        return date_Resa.get();}

    public void setdate_Resa(Date date_Resa) {
        this.date_Resa.set(date_Resa);}

    public ObjectProperty<Date> date_ResaProperty() {
        return date_Resa;}

    
	
}


