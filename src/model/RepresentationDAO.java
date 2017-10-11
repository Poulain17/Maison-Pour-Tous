package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.DBUtil;

public class RepresentationDAO {
	
		/////////////////////// Rechercher une representation \\\\\\\\\\\\\\\\\\\\\\\
	
	/**
	 * Rechercher une representation 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */

		
	  public static Representation searchRepresentation (int empId) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
	      //Declare a SELECT statement
	     
	      String selectStmt ="SELECT * FROM representation WHERE num_Representation="+empId;
	     

	      //Execute SELECT statement
	      try {
	          //Get ResultSet from dbExecuteQuery method
	          ResultSet rsEmp = DBUtil.dbExecuteQuery(selectStmt);

	          //Send ResultSet to the getRepresentantFromResultSet method and get employee object
	          Representation representation = getRepresentationFromResultSet(rsEmp);

	          //Return representant object
	          return representation;
	      } catch (SQLException e) {
	          System.out.println("While searching an representation with " + empId + " id, an error occurred: " + e);
	          //Return exception
	          throw e;
	      }
	  }
	  
	  
	  	/////////////////////// Utiliser ResultSet from DB \\\\\\\\\\\\\\\\\\\\\\\
	
	  /**
	   * Utiliser le ResultSet de la DB en tant que parametre et
	   * Definir les attributs de l'object Adherant et retourner cette object
	   * @throws SQLException
	   */
	  
	  
	  private static Representation getRepresentationFromResultSet(ResultSet rs) throws SQLException
	  {
		  Representation representation = null;
	      if (rs.next()) {
	    	  representation = new Representation();
	    	  representation.setNum_Representation(rs.getInt("num_Representation"));
	    	  representation.setNum_Spectacle(rs.getInt("num_Spectacle"));
	    	  representation.setNum_Salle(rs.getInt("num_Salle"));
	    	  representation.setDate_Representation(rs.getDate("date_Representation"));
	    	  representation.setTarif(rs.getDouble("Tarif"));
	        
	      }
	      return representation;
	  }

	  	//////////////////////Rechercher une representationdepuis la liste\\\\\\\\\\\\\\\\\\\\\\\
	  
	  /**
	   * Rechercher un adherent depuis la liste
	   * @throws SQLException
	   * @throws ClassNotFoundException
	   * @throws InstantiationException
	   * @throws IllegalAccessException
	   */
	  
	  public static ObservableList<Representation> searchRepresentation () throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
	      //Declare a SELECT statement
	      String selectStmt = "SELECT * FROM representation";

	    //Exécuter l'instruction SELECT
	      try {
	    	//Obtenir ResultSet à partir de la méthode dbExecuteQuery
	          ResultSet rsEmps = DBUtil.dbExecuteQuery(selectStmt);

	        //Envoyer ResultSet à la méthode getRepresentationList et obtenir un objet representation
	          ObservableList<Representation> empList = getRepresentationList(rsEmps);

	        //Retourner l'objet representation
	          return empList;
	      } catch (SQLException e) {
	          System.out.println("SQL select operation has been failed: " + e);
	          //Return exception
	          throw e;
	      }
	  }
	  
	  //////////////////////Obtenir une representation depuis la liste Representation\\\\\\\\\\\\\\\\\\\\\\\

	  /**
	   * Obtenir une representation depuis la liste Representation
	   * @throws SQLException
	   * @throws ClassNotFoundException
	   */
	  
	  private static ObservableList<Representation> getRepresentationList(ResultSet rs) throws SQLException, ClassNotFoundException {
	      //Declarer une observable List qui comprend des objet "Representation"
	      ObservableList<Representation> empList = FXCollections.observableArrayList();
	      Representation representation = null;
	      while (rs.next()) {
	    	  representation = new Representation();
	    	  representation.setNum_Representation(rs.getInt("num_Representation"));
	    	  representation.setNum_Spectacle(rs.getInt("num_Spectacle"));
	    	  representation.setNum_Salle(rs.getInt("num_Salle"));
	    	  representation.setDate_Representation(rs.getDate("date_Representation"));
	    	  representation.setTarif(rs.getDouble("Tarif"));
	      
	          empList.add(representation);
	      }
	      //return empList (ObservableList of representation)
	      return empList;
	  }

	  //////////////////////Supprimer une representation\\\\\\\\\\\\\\\\\\\\\\\

	  /**
	   * Supprimer une representation
	   * @throws SQLException
	   * @throws ClassNotFoundException
	   * @throws InstantiationException
	   * @throws IllegalAccessException
	   */
	    public static void deleteRepresentationWithId (int empId) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
	        //Declarer une instruction "DELETE"
	        String updateStmt =
	                " DELETE representation from representation WHERE representation.num_Representation ='"+ empId +"'";
	                       
	 
	        //Execute l'operation Mise à Jour
	        try {
	            DBUtil.dbExecuteUpdate(updateStmt);
	        } catch (SQLException e) {
	            System.out.print("Error occurred while DELETE Operation: " + updateStmt + "\n" + e);
	            throw e;
	        }
	    }
	  
	    //////////////////////Ajouter une representation\\\\\\\\\\\\\\\\\\\\\\\
	    
	    /**
	     * Ajouter une Representation
	     * @param num_Representation
	     * @param num_Spectacle
	     * @param num_Salle
	     * @param date_Representation
	     * @param Tarif
	     * @throws SQLException
	     * @throws ClassNotFoundException
	     * @throws InstantiationException
	     * @throws IllegalAccessException
	     * @throws ParseException
	     */
	    

	    
	    public static void insertRepresentation (int num_Representation, int num_Spectacle,int num_Salle,Date date_Representation,double Tarif ) 
	    		throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, ParseException {
	        
	        String updateStmt2 = "INSERT INTO representation (`num_Representation`, `num_Spectacle`, `num_Salle`, `date_Representation`, `Tarif`) VALUES ('"+num_Representation+"', '"+num_Spectacle+"', '"+num_Salle+"','"+date_Representation+"','"+Tarif+"')";           
	        //Exécuter l'opération INSERT
	        try {
	            DBUtil.dbExecuteUpdate(updateStmt2);
	        } catch (SQLException e) {
	            System.out.print("Error occurred while INSERT Operation: " + updateStmt2+ "\n" + e);
	            throw e;
	        }
	        
	    }
	    
	    //////////////////////Editer un adhérent\\\\\\\\\\\\\\\\\\\\\\\
	    
	    /**
	     * Editer un adhérent
	     * @param num_Representation
	     * @param num_Spectacle
	     * @param num_Salle
	     * @param date_Representation
	     * @param Tarif
	     * @throws SQLException
	     * @throws ClassNotFoundException
	     * @throws InstantiationException
	     * @throws IllegalAccessException
	     * @throws ParseException
	     */
	    
	    public static void modifRepresentation (int num_Representation, int num_Spectacle,int num_Salle,Date date_Representation,double Tarif ) 
	    		throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, ParseException {
	       
	    	//Declare an UPDATE statement
	       
	        String updateStmt1 =
	        		"UPDATE representation"
	        		+ " SET representation.num_Spectacle='"+num_Spectacle+"',representation.num_Salle='"+num_Salle+"',representation.date_Representation='"+date_Representation+"',representation.Tarif='"+Tarif+"',"
	        				+ " WHERE representation.num_Representation="+num_Representation+"";
	        
	        
	      
	        try {
	            DBUtil.dbExecuteUpdate(updateStmt1);
	          
	        } catch (SQLException e) {
	            System.out.print("Error occurred while INSERT Operation: " + updateStmt1 + "\n" + e);
	            throw e;
	        }
	        
	    }
	 
	}
