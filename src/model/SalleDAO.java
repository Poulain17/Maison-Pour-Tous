package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.DBUtil;

public class SalleDAO {
	 //*******************************
	  //SELECT a salle
	  //*******************************
		
	  public static Salle searchSalle (int empId) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
	      //Declare a SELECT statement
	     
	      String selectStmt ="SELECT * FROM salle WHERE num_Salle="+empId;
	     

	      //Execute SELECT statement
	      try {
	          //Get ResultSet from dbExecuteQuery method
	          ResultSet rsEmp = DBUtil.dbExecuteQuery(selectStmt);

	          //Send ResultSet to the getSalleFromResultSet method and get employee object
	          Salle salle = getSalleFromResultSet(rsEmp);

	          //Return salle object
	          return salle;
	      } catch (SQLException e) {
	          System.out.println("While searching an salle with " + empId + " id, an error occurred: " + e);
	          //Return exception
	          throw e;
	      }
	  }
	  
	   //*******************************
	  //Use ResultSet from DB as parameter and set salle Object's attributes and return salle object.
	  //*******************************
	  
	  
	  private static Salle getSalleFromResultSet(ResultSet rs) throws SQLException
	  {
		  Salle salle = null;
	      if (rs.next()) {
	    	  salle = new Salle();
	    	  salle.setNum_Salle(rs.getInt("num_Salle"));
	    	  salle.setNom_Salle(rs.getString("nom_Salle"));
	    	  salle.setNb_Places(rs.getInt("nb_Places"));
	        
	      }
	      return salle;
	  }

	  //*******************************
	  //SELECT salle
	  //*******************************
	  
	  public static ObservableList<Salle> searchSalle () throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
	      //Declare a SELECT statement
	      String selectStmt = "SELECT * FROM salle";

	      //Execute SELECT statement
	      try {
	          //Get ResultSet from dbExecuteQuery method
	          ResultSet rsEmps = DBUtil.dbExecuteQuery(selectStmt);

	          //Send ResultSet to the getSalleList method and get Salle object
	          ObservableList<Salle> empList = getSalleList(rsEmps);

	          //Return Salle object
	          return empList;
	      } catch (SQLException e) {
	          System.out.println("SQL select operation has been failed: " + e);
	          //Return exception
	          throw e;
	      }
	  }
	  
	  //*******************************
	  //Select * from Salle operation
	  //*******************************
	  
	  private static ObservableList<Salle> getSalleList(ResultSet rs) throws SQLException, ClassNotFoundException {
	      //Declare a observable List which comprises of Salle objects
	      ObservableList<Salle> empList = FXCollections.observableArrayList();
	      Salle salle = null;
	      while (rs.next()) {
	    	  salle = new Salle();
	    	  salle.setNum_Salle(rs.getInt("num_Salle"));
	    	  salle.setNom_Salle(rs.getString("nom_Salle"));
	    	  salle.setNb_Places(rs.getInt("nb_Places"));
	        
	      
	          empList.add(salle);
	      }
	      //return empList (ObservableList of salle)
	      return empList;
	  }
	   
	    //*************************************
	    //DELETE an salle
	    //*************************************
	    public static void deleteSalleWithId (int empId) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
	        //Declare a DELETE statement
	        String updateStmt =
	                " DELETE salle from salle WHERE salle.num_Salle ='"+ empId +"'";
	                       
	 
	        //Execute UPDATE operation
	        try {
	            DBUtil.dbExecuteUpdate(updateStmt);
	        } catch (SQLException e) {
	            System.out.print("Error occurred while DELETE Operation: " + updateStmt + "\n" + e);
	            throw e;
	        }
	    }
	  

	   //*************************************
	    //INSERT an salle
	    //*************************************
	    
	    public static void insertSalle (int num_Salle,String nom_Salle,int nb_Places ) 
	    		throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, ParseException {
	        
	        String updateStmt2 = "INSERT INTO salle (`num_Salle`, `nom_Salle`, `nb_Places`) VALUES ('"+num_Salle+"', '"+nom_Salle+"', '"+nb_Places+"')";           
	        //Execute INSERT operation
	        try {
	            DBUtil.dbExecuteUpdate(updateStmt2);
	        } catch (SQLException e) {
	            System.out.print("Error occurred while INSERT Operation: " + updateStmt2+ "\n" + e);
	            throw e;
	        }
	        
	    }
	    //*************************************
	    //Edit an salle
	    //*************************************
	    
	    public static void modifSalle (int num_Salle,String nom_Salle,int nb_Places) 
	    		throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, ParseException {
	       
	    	//Declare an UPDATE statement
	       
	        String updateStmt1 =
	        		"UPDATE salle"
	        		+ " SET salle.nom_Salle='"+nom_Salle+"',salle.nb_Places='"+nb_Places+"',"
	        				+ " WHERE salle.num_Salle="+num_Salle+"";
	        
	        
	      
	        try {
	            DBUtil.dbExecuteUpdate(updateStmt1);
	          
	        } catch (SQLException e) {
	            System.out.print("Error occurred while INSERT Operation: " + updateStmt1 + "\n" + e);
	            throw e;
	        }
	        
	    }
	 
	}
