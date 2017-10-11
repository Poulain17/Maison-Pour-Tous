package application;

import java.io.IOException;
import java.sql.SQLException;


import model.Adherent;
import model.ClientReservation;
import model.Representation;
import view.representationController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;



public class MainApp extends Application {
	
	
	private static Stage primaryStage;
	private static AnchorPane rootLayout;
	protected static ObservableList<Adherent> adherentData = FXCollections.observableArrayList();
	protected static ObservableList<Representation> representationData = FXCollections.observableArrayList();
	protected static ObservableList<ClientReservation> clientReservationData = FXCollections.observableArrayList();
	
	
	 public MainApp() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
	 }
	 
	 //************************************************************************************
	 //Returns the data as an observable list of Adherent,Representation 
	 //************************************************************************
	 public ObservableList<Adherent> getAdherentData() {
	        return adherentData;
	    }
	    public ObservableList<Representation> getRepresentationData() {
	        return representationData;
	    }
	    public ObservableList<ClientReservation> getClientReservationData() {
	        return clientReservationData;
	    }
	    
	    
	    //************************************************************************************
		 //Returns the data as an observable list of Adherent,Representation 
		 //************************************************************************
		 public void SetAdherentData(Adherent adherent) {
		         adherentData.add(adherent);
		    }
		    public void SetRepresentationData(Representation representation) {
		          representationData.add(representation);
		    }  
		    public void SetClientReservationData(ClientReservation clientReservation) {
		    	clientReservationData.add(clientReservation);
		    }  
	    

	@Override
	public void start(Stage primaryStage) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Spectacles");
		initBaseLogicielFrame();
		//RepresentationsView();
	}
		
		public void initBaseLogicielFrame() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
			try{
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(MainApp.class.getResource("/View/representation.fxml"));
				rootLayout = (AnchorPane) loader.load();

				Scene scene = new Scene(rootLayout);
				primaryStage.setScene(scene);
				primaryStage.show();

				//test
				representationController controller = loader.getController();
				controller.setMainApp(new MainApp());
			}
			catch(IOException e){
				e.printStackTrace();}}
		
	

	/*private static void SpectacleView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("view/representation.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
 
	}*/
	/*public static void RepresentationsView() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("view/representation.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
		BorderPane representation = loader.load();
		mainLayout.setCenter(representation);
		
		 representationController controller = loader.getController();
	    controller.setMainApp(new MainApp());
		
	}*/
		
	 /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    public static void main(String[] args) {
		launch(args);
	}
}
