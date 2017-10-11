package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.DBUtil;

public class SpectacleDAO {
	 //*******************************
	  //SELECT a Spectacle
	  //*******************************
		
	  public static Spectacle searchSpectacle (int empId) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
	      //Declare a SELECT statement
	     
	      String selectStmt ="SELECT * FROM spectacle WHERE num_Spectacle="+empId;
	     

	      //Execute SELECT statement
	      try {
	          //Get ResultSet from dbExecuteQuery method
	          ResultSet rsEmp = DBUtil.dbExecuteQuery(selectStmt);

	          //Send ResultSet to the getSpectacleFromResultSet method and get spectacle object
	          Spectacle spectacle = getSpectacleFromResultSet(rsEmp);

	          //Return spectacle object
	          return spectacle;
	      } catch (SQLException e) {
	          System.out.println("While searching an salle with " + empId + " id, an error occurred: " + e);
	          //Return exception
	          throw e;
	      }
	  }
	  
	   //*******************************
	  //Use ResultSet from DB as parameter and set spectacle Object's attributes and return spectacle object.
	  //*******************************
	  
	  
	  private static Spectacle getSpectacleFromResultSet(ResultSet rs) throws SQLException
	  {
		  Spectacle spectacle = null;
	      if (rs.next()) {
	    	  spectacle = new Spectacle();
	    	  spectacle.setNum_Spectacle(rs.getInt("num_Spectacle"));
	    	  spectacle.setNom_Spectacle(rs.getString("nom_Spectacle"));
	    	  spectacle.setGenre(rs.getString("genre"));
	    	  spectacle.setDuree(rs.getInt("duree"));
	        
	      }
	      return spectacle;
	  }

	  //*******************************
	  //SELECT spectacle
	  //*******************************
	  
	  public static ObservableList<Spectacle> searchSpectacle () throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
	      //Declare a SELECT statement
	      String selectStmt = "SELECT * FROM spectacle";

	      //Execute SELECT statement
	      try {
	          //Get ResultSet from dbExecuteQuery method
	          ResultSet rsEmps = DBUtil.dbExecuteQuery(selectStmt);

	          //Send ResultSet to the getSpectacleList method and get Spectacle object
	          ObservableList<Spectacle> empList = getSpectacleList(rsEmps);

	          //Return Spectacle object
	          return empList;
	      } catch (SQLException e) {
	          System.out.println("SQL select operation has been failed: " + e);
	          //Return exception
	          throw e;
	      }
	  }
	  
	  //*******************************
	  //Select * from Spectacle operation
	  //*******************************
	  
	  private static ObservableList<Spectacle> getSpectacleList(ResultSet rs) throws SQLException, ClassNotFoundException {
	      //Declare a observable List which comprises of Spectacle objects
	      ObservableList<Spectacle> empList = FXCollections.observableArrayList();
	      Spectacle spectacle = null;
	      while (rs.next()) {
	    	  spectacle = new Spectacle();
	    	  spectacle.setNum_Spectacle(rs.getInt("num_Spectacle"));
	    	  spectacle.setNom_Spectacle(rs.getString("nom_Spectacle"));
	    	  spectacle.setGenre(rs.getString("genre"));
	    	  spectacle.setDuree(rs.getInt("duree"));
	        
	      
	          empList.add(spectacle);
	      }
	      //return empList (ObservableList of spectacle)
	      return empList;
	  }
	   
	    //*************************************
	    //DELETE an spectacle
	    //*************************************
	    public static void deleteSpectacleWithId (int empId) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
	        //Declare a DELETE statement
	        String updateStmt =
	                " DELETE spectacle from spectacle WHERE spectacle.num_Spectacle ='"+ empId +"'";
	                       
	 
	        //Execute UPDATE operation
	        try {
	            DBUtil.dbExecuteUpdate(updateStmt);
	        } catch (SQLException e) {
	            System.out.print("Error occurred while DELETE Operation: " + updateStmt + "\n" + e);
	            throw e;
	        }
	    }
	  

	   //*************************************
	    //INSERT an spectacle
	    //*************************************
	    
	    public static void insertSpectacle (int num_Spectacle,String nom_Spectacle,String genre,int duree ) 
	    		throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, ParseException {
	        
	        String updateStmt2 = "INSERT INTO salle (`num_Spectacle`, `nom_Spectacle`,`genre`, `duree`) VALUES ('"+num_Spectacle+"', '"+nom_Spectacle+"','"+genre+"', '"+duree+"')";           
	        //Execute INSERT operation
	        try {
	            DBUtil.dbExecuteUpdate(updateStmt2);
	        } catch (SQLException e) {
	            System.out.print("Error occurred while INSERT Operation: " + updateStmt2+ "\n" + e);
	            throw e;
	        }
	        
	    }
	    //*************************************
	    //Edit an spectacle
	    //*************************************
	    
	    public static void modifSpectacle (int num_Spectacle,String nom_Spectacle,String genre,int duree  ) 
	    		throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, ParseException {
	       
	    	//Declare an UPDATE statement
	       
	        String updateStmt1 =
	        		"UPDATE spectacle"
	        		+ " SET spectacle.nom_Spectacle='"+nom_Spectacle+"',spectacle.genre='"+genre+"',spectacle.duree='"+duree+"',"
	        				+ " WHERE spectacle.num_Spectacle="+num_Spectacle+"";
	        
	        
	      
	        try {
	            DBUtil.dbExecuteUpdate(updateStmt1);
	          
	        } catch (SQLException e) {
	            System.out.print("Error occurred while INSERT Operation: " + updateStmt1 + "\n" + e);
	            throw e;
	        }
	        
	    }
	 
	}
