package view;







import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import application.MainApp;
import model.Adherent;
import model.AdherentDAO;
import model.ClientReservation;
import model.ClientReservationDAO;
import model.Representation;
import model.ReservationDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;


public class representationController {
	@FXML
    protected ComboBox<String> listAdherent;
	@FXML
	protected ComboBox<String> listRepresentation;
	@FXML
	protected TextField NombrePers;
    @FXML
    protected TextArea Total;

    
    // Reference to the main application.
    private MainApp mainApp;
    protected static ObservableList<Adherent> AdherentReservation = FXCollections.observableArrayList();
    protected static ObservableList<ClientReservation> ClientReservation = FXCollections.observableArrayList();
    
    public representationController() { }
    
    @FXML
    private void initialize() throws InstantiationException, IllegalAccessException {
    	Total.setEditable(false);
  
        }
       
    private void DetailsAdherent(String r) {
        if (r != null) {
        	
        	int adherentsel = (int) listAdherent.getSelectionModel().getSelectedIndex() ;
        
        } else {
            // adherent is null, remove all the text.
        	listAdherent.getItems().add("");}
        
        }//end initialize

   /* @FXML
   private void afficherTotal()  throws InstantiationException, IllegalAccessException {
    	int representationsel = (int) listRepresentation.getSelectionModel().getSelectedIndex() ;
    	int SelectRep = (int) listRepresentation.getSelectionModel().getSelectedIndex() ;
    	int nbPerson =0;
    	
    	
    	 nbPerson = Integer.parseInt(NombrePers.getText());
    	 double total = ClientReservation.get(SelectRep).getTarif()*nbPerson;
    	 String total2 = Double.toString(total);

        // Affichage du montant total dans le champ total de la fenetre
        
         Total.setText (total2) ;
    	
    }*/
    
   		@FXML
        private void DetailsRepresentation() throws InstantiationException, IllegalAccessException {
            	 int representationsel = (int) listRepresentation.getSelectionModel().getSelectedIndex() ;
            	 int nbpers1=0;
            	 String errorMessage = "";
                       
        if (NombrePers.getText() == null || NombrePers.getText().length() == 0) {
            errorMessage += "Le champ est vide!\n";
        } else {
            // try to parse  into an int.
            try {
                Integer.parseInt(NombrePers.getText());
            } catch (NumberFormatException e) {
                errorMessage += "nombre de personne non valide !\n";
            }
        }
         if (errorMessage.length() == 0) {
         nbpers1 = Integer.parseInt(NombrePers.getText());
         
         //Calcul du prix
         
           double total = ClientReservation.get(representationsel).getTarif()*nbpers1;
           String total1 = Double.toString(total);
                 
           // Affichage du montant total dans le champ total de la fenetre
           
           Total.setText (total1) ;
           
        } else {
            // Show the error message.

            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Champs invalide");
            alert.setHeaderText("Veuillez corriger les champs invalides");
            alert.setContentText(errorMessage);

            alert.showAndWait();}       
    }//end DetailsRepresentation
    
    /**
     * @param mainApp
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */
    public  void setMainApp(MainApp mainApp) throws InstantiationException, IllegalAccessException {
        this.mainApp = mainApp;
        mainApp.getPrimaryStage().setResizable(false);
       
       //Construction de la liste des adherents   
           try {
        	AdherentReservation.addAll(AdherentDAO.searchAdherent());
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();}
       
        for (int n=0;n<AdherentReservation.size();n++){
        listAdherent.getItems().add(AdherentReservation.get(n).getNom_Adherent()+ " "+AdherentReservation.get(n).getPrenom_Adherent());
       
        }for (int n=0;n<AdherentReservation.size();n++){
        	mainApp.SetAdherentData(new Adherent(AdherentReservation.get(n).getNum_Adherent(), AdherentReservation.get(n).getNom_Adherent(), AdherentReservation.get(n).getPrenom_Adherent(), AdherentReservation.get(n).getAdresse_Adherent()));
        }

        //Construction de la liste de Reservation des Adhérents
        try {
        	ClientReservation.addAll(ClientReservationDAO.searchClientReservation());
		} catch (ClassNotFoundException e) {	
			e.printStackTrace();
			
		} catch (SQLException e) {	
			e.printStackTrace();}
       
        for (int n=0;n<ClientReservation.size();n++)
        {listRepresentation.getItems().add(ClientReservation.get(n).getdate_Representation()+" "+ClientReservation.get(n).getnom_Spectacle());
        
        }for (int n=0;n<ClientReservation.size();n++)
        {mainApp.SetClientReservationData(new ClientReservation(ClientReservation.get(n).getnum_Representation(), ClientReservation.get(n).getnum_Spectacle(), ClientReservation.get(n).getnum_Salle(), ClientReservation.get(n).getTarif(), ClientReservation.get(n).getnom_Spectacle(),  ClientReservation.get(n).getdate_Representation()));
        }
} //end setMainApp
    
    
    
    @FXML
    private void valider() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, NumberFormatException, ParseException {
    	
    	   // recuperation du num_Adhérent
           int SelectAdherent = (int) listAdherent.getSelectionModel().getSelectedIndex() ;
           int SelectAdherent1= SelectAdherent+1;
           int SelectRep = (int) listRepresentation.getSelectionModel().getSelectedIndex() ;
           int Reservation = ClientReservation.get(SelectAdherent).getnum_Representation();
           int nbPerson=0;
           //Double tarif = (double)ClientReservation.get(selectAdherent).getnum_Representation();
           String errorMessage = "";
                       
        if (NombrePers.getText() == null || NombrePers.getText().length() == 0) {
            errorMessage += "Le champ est vide!\n";
        } else {
            try {
                Integer.parseInt(NombrePers.getText());
            } catch (NumberFormatException e) {
                errorMessage += "nombre de personne non valide (doit-etre un entier)!\n";}
        } //end Else
        
         if (errorMessage.length() == 0) {
        	 nbPerson = Integer.parseInt(NombrePers.getText());
        	 double total = ClientReservation.get(SelectRep).getTarif()*nbPerson;
        	 String total1 = Double.toString(total);
                 
        	 // Affichage du champTotal      
             Total.setText (total1) ;
        	 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        	 java.util.Date datejour =  new Date(); 
             String dateString = formatter.format(datejour);
        	 
        	 // Ajout des elements dans la table RESERVATION
              System.out.println("n°"+Reservation);
              ReservationDAO.insertReservation(1, SelectAdherent1, Reservation, nbPerson, dateString);
     
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Champs invalide");
            alert.setHeaderText("Veuillez corriger les champs invalides");
            alert.setContentText(errorMessage);

            alert.showAndWait();}  
    } //end valider

    /**
     * Closes the application.
     */
    @FXML
    private void handleExit() {
        System.exit(0);}

}//end MainApp
