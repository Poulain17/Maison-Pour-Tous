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

public class Representation {
	protected final IntegerProperty num_Representation;
	protected final IntegerProperty num_Spectacle;
	protected final IntegerProperty num_Salle;
	protected final ObjectProperty<Date> date_Representation;
	protected final DoubleProperty Tarif;


	public Representation(){
		this(0,0);
	}
	public Representation(int num_Representation, int Tarif) {
		this.num_Representation = new SimpleIntegerProperty(num_Representation);
		this.num_Spectacle = new SimpleIntegerProperty();
		this.num_Salle =new SimpleIntegerProperty();
		this.date_Representation = new SimpleObjectProperty<Date>();
		this.Tarif = new SimpleDoubleProperty(Tarif);
	}
	public Representation(int num_Representation,int num_Spectacle ,int  num_Salle,Date date_Representation, Double Tarif) {
		this.num_Representation = new SimpleIntegerProperty(num_Representation);
		this.num_Spectacle = new SimpleIntegerProperty(num_Spectacle);
		this.num_Salle =new SimpleIntegerProperty(num_Salle);
		this.date_Representation = new SimpleObjectProperty<Date>(date_Representation);
		this.Tarif = new SimpleDoubleProperty(Tarif); }

	public int getnum_Representation() {
		return num_Representation.get();}

	public void setNum_Representation(int num_Representation) {
		this.num_Representation.set(num_Representation);}

	public IntegerProperty num_RepresentationProperty() {
		return num_Representation;}

	public int getNum_Spectacle() {
		return num_Spectacle.get();}

	public void setNum_Spectacle(int num_Spectacle) {
		this.num_Spectacle.set(num_Spectacle);}

	public IntegerProperty num_SpectacleProperty() {
		return num_Spectacle;}

	public int getNum_Salle() {
		return num_Salle.get();}

	public void setNum_Salle(int num_Salle) {
		this.num_Salle.set(num_Salle);}

	public IntegerProperty num_SalleProperty() {
		return num_Salle;}

	public Date getDate_Representation() {
		return date_Representation.get();}

	public void setDate_Representation(Date date_Representation) {
		this.date_Representation.set(date_Representation); }

	public ObjectProperty<Date> date_RepresentationProperty() {
		return date_Representation; }

	public double getTarif() {
		return Tarif.get();}

	public void setTarif(double Tarif) {
		this.Tarif.set(Tarif);}

	public DoubleProperty TarifProperty() {
		return Tarif;}

}
