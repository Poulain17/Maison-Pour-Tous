package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.DBUtil;

public class ClientReservationDAO {
	//*******************************
	//SELECT an clientReservation
	//*******************************

	public static ClientReservation searchClientReservation (int empId) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

		String selectStmt ="SELECT representation.num_Representation, representation.num_Spectacle,representation.date_Representation, representation.tarif, spectacle.nom_Spectacle FROM representation, spectacle WHERE representation.num_Spectacle =spectacle.num_Spectacle AND representation.num_Representation="+empId;

		//Execute SELECT statement
		try {
			//Get ResultSet from dbExecuteQuery method
			ResultSet rsEmp = DBUtil.dbExecuteQuery(selectStmt);

			//Send ResultSet to the getClientReservationFromResultSet method and get employee object
			ClientReservation clientReservation = getClientReservationFromResultSet(rsEmp);

			//Return clientReservation object
			return clientReservation;
		} catch (SQLException e) {
			System.out.println("While searching an representation with " + empId + " id, an error occurred: " + e);
			//Return exception
			throw e;
		}
	}

	//*******************************
	//Use ResultSet from DB as parameter and set clientReservation Object's attributes and return clientReservation object.
	//*******************************


	private static ClientReservation getClientReservationFromResultSet(ResultSet rs) throws SQLException
	{
		ClientReservation clientReservation = null;
		if (rs.next()) {
			clientReservation = new ClientReservation();
			clientReservation.setnum_Representation(rs.getInt("num_Representation"));
			clientReservation.setnum_Spectacle(rs.getInt("num_Spectacle"));
			clientReservation.setTarif(rs.getDouble("tarif"));
			clientReservation.setnom_Spectacle(rs.getString("nom_Spectacle"));
			clientReservation.setdate_Representation(rs.getDate("date_Representation"));

		}
		return clientReservation;
	}

	//*******************************
	//SELECT ClientReservation
	//*******************************

	public static ObservableList<ClientReservation> searchClientReservation () throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		String selectStmt = "SELECT representation.num_Representation, representation.num_Spectacle,representation.date_Representation, representation.tarif, spectacle.nom_Spectacle FROM representation,spectacle WHERE representation.num_Spectacle =spectacle.num_Spectacle";

		//Execute SELECT statement
		try {
			//Get ResultSet from dbExecuteQuery method
			ResultSet rsEmps = DBUtil.dbExecuteQuery(selectStmt);

			//Send ResultSet to the getClientReservationList method and get employee object
			ObservableList<ClientReservation> empList = getClientReservationList(rsEmps);

			//Return Representation object
			return empList;
		} catch (SQLException e) {
			System.out.println("SQL select operation has been failed: " + e);
			//Return exception
			throw e;
		}
	}

	//*******************************
	//Select * from ClientReservation operation
	//*******************************

	private static ObservableList<ClientReservation> getClientReservationList(ResultSet rs) throws SQLException, ClassNotFoundException {
		//Declare a observable List which comprises of Representation objects
		ObservableList<ClientReservation> empList = FXCollections.observableArrayList();
		ClientReservation clientReservation = null;
		while (rs.next()) {
			clientReservation = new ClientReservation();
			clientReservation.setnum_Representation(rs.getInt("num_Representation"));
			clientReservation.setnum_Spectacle(rs.getInt("num_Spectacle"));
			clientReservation.setTarif(rs.getDouble("tarif"));
			clientReservation.setnom_Spectacle(rs.getString("nom_Spectacle"));
			clientReservation.setdate_Representation(rs.getDate("date_Representation"));

			empList.add(clientReservation);
		}
		//return empList (ObservableList of clientReservation)
		return empList;
	}





}


