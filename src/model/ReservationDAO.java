package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.DBUtil;

public class ReservationDAO {
	//*******************************
	  //SELECT an representation
	  //*******************************
		
	  public static Reservation searchReservation (int empId) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
	      //Declare a SELECT statement
	     
	      String selectStmt ="SELECT * FROM reservation WHERE num_Resa="+empId;
	     

	      //Execute SELECT statement
	      try {
	          //Get ResultSet from dbExecuteQuery method
	          ResultSet rsEmp = DBUtil.dbExecuteQuery(selectStmt);

	          //Send ResultSet to the getRepresentantFromResultSet method and get employee object
	          Reservation reservation = getReservationFromResultSet(rsEmp);

	          //Return representant object
	          return reservation;
	      } catch (SQLException e) {
	          System.out.println("While searching an reservation with " + empId + " id, an error occurred: " + e);
	          //Return exception
	          throw e;
	      }
	  }
	  
	   //*******************************
	  //Use ResultSet from DB as parameter and set reservation Object's attributes and return reservation object.
	  //*******************************
	  
	  
	  private static Reservation getReservationFromResultSet(ResultSet rs) throws SQLException
	  {
		  Reservation reservation = null;
	      if (rs.next()) {
	    	  reservation = new Reservation();
	    	  reservation.setnum_Resa(rs.getInt("num_Resa"));
	    	  reservation.setnum_Adherent(rs.getInt("num_Adherent"));
	    	  reservation.setnum_Representation(rs.getInt("num_Representation"));
	    	  reservation.setnb_Personne(rs.getInt("nb_Personne"));
	    	  reservation.setdate_Resa(rs.getDate("date_Resa"));
	        
	      }
	      return reservation;
	  }

	  //*******************************
	  //SELECT Reservation
	  //*******************************
	  
	  public static ObservableList<Reservation> searchReservation () throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
	      //Declare a SELECT statement
	      String selectStmt = "SELECT * FROM reservation";

	      //Execute SELECT statement
	      try {
	          //Get ResultSet from dbExecuteQuery method
	          ResultSet rsEmps = DBUtil.dbExecuteQuery(selectStmt);

	          //Send ResultSet to the getRepresentationList method and get employee object
	          ObservableList<Reservation> empList = getReservationList(rsEmps);

	          //Return Reservation object
	          return empList;
	      } catch (SQLException e) {
	          System.out.println("SQL select operation has been failed: " + e);
	          //Return exception
	          throw e;
	      }
	  }
	  
	  //*******************************
	  //Select * from Reservation operation
	  //*******************************
	  
	  private static ObservableList<Reservation> getReservationList(ResultSet rs) throws SQLException, ClassNotFoundException {
	      //Declare a observable List which comprises of Representation objects
	      ObservableList<Reservation> empList = FXCollections.observableArrayList();
	      Reservation reservation = null;
	      while (rs.next()) {
	    	  reservation = new Reservation();
	    	  reservation.setnum_Resa(rs.getInt("num_Resa"));
	    	  reservation.setnum_Adherent(rs.getInt("num_Adherent"));
	    	  reservation.setnum_Representation(rs.getInt("num_Representation"));
	    	  reservation.setnb_Personne(rs.getInt("nb_Personne"));
	    	  reservation.setdate_Resa(rs.getDate("date_Resa"));
	      
	          empList.add(reservation);
	      }
	      //return empList (ObservableList of representation)
	      return empList;
	  }
	   
	    //*************************************
	    //DELETE an reservation
	    //*************************************
	    public static void deleteReservationWithId (int empId) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
	        //Declare a DELETE statement
	        String updateStmt =
	                " DELETE reservation from reservation WHERE reservation.num_Resa ='"+ empId +"'";
	                       
	 
	        //Execute UPDATE operation
	        try {
	            DBUtil.dbExecuteUpdate(updateStmt);
	        } catch (SQLException e) {
	            System.out.print("Error occurred while DELETE Operation: " + updateStmt + "\n" + e);
	            throw e;
	        }
	    }
	  

	   //*************************************
	    //INSERT an reservation
	    //*************************************
	    
	    public static void insertReservation (int num_Resa, int num_Adherent,int num_Representation,int nb_Personne ,String date_Resa) 
	    		throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, ParseException {
	        
	        String updateStmt2 = "INSERT INTO reservation (`num_Resa`, `num_Adherent`, `num_Representation`, `nb_Personnes`, `date_Resa`) VALUES (NULL, '"+num_Adherent+"', '"+num_Representation+"','"+nb_Personne+"','"+date_Resa+"')";           
	        //Execute INSERT operation
	        try {
	            DBUtil.dbExecuteUpdate(updateStmt2);
	        } catch (SQLException e) {
	            System.out.print("Error occurred while INSERT Operation: " + updateStmt2+ "\n" + e);
	            throw e;
	        }
	        
	    }
	    //*************************************
	    //Edit an reservation
	    //*************************************
	    
	    public static void modifReservation (int num_Resa, int num_Adherent,int num_Representation,int nb_Personne ,Date date_Resa) 
	    		throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, ParseException {
	       
	    	//Declare an UPDATE statement
	       
	        String updateStmt1 =
	        		"UPDATE reservation"
	        		+ " SET reservation.num_Adherent='"+num_Adherent+"',reservation.num_Representation='"+num_Representation+"',reservation.nb_Personne='"+nb_Personne+"',reservation.date_Resa='"+date_Resa+"',"
	        				+ " WHERE reservation.num_Resa="+num_Resa+"";
	        
	        
	      
	        try {
	            DBUtil.dbExecuteUpdate(updateStmt1);
	          
	        } catch (SQLException e) {
	            System.out.print("Error occurred while INSERT Operation: " + updateStmt1 + "\n" + e);
	            throw e;
	        }
	        
	    }
	 
	}
