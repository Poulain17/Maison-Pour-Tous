package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.DBUtil;

public class AdherentDAO {

	/////////////////////// Rechercher un Adherent \\\\\\\\\\\\\\\\\\\\\\\

	/**
	 * 
	 * Rechercher un Adherent
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */

	public static Adherent searchAdherent (int empId) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		//Declare a SELECT statement

		String selectStmt ="SELECT * FROM adherent WHERE Num_Adherent="+empId;


		//Execute SELECT statement
		try {
			//Get ResultSet from dbExecuteQuery method
			ResultSet rsEmp = DBUtil.dbExecuteQuery(selectStmt);

			//Send ResultSet to the getRepresentantFromResultSet method and get employee object
			Adherent adherent = getAdherentFromResultSet(rsEmp);

			//Return representant object
			return adherent;
		} catch (SQLException e) {
			System.out.println("While searching an Adherent with " + empId + " id, an error occurred: " + e);
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


	private static Adherent getAdherentFromResultSet(ResultSet rs) throws SQLException
	{
		Adherent adherent = null;
		if (rs.next()) {
			adherent = new Adherent();
			adherent.setNum_Adherent(rs.getInt("num_Adherent"));
			adherent.setNom_Adherent(rs.getString("nom_Adherent"));
			adherent.setPrenom_Adherent(rs.getString("prenom_Adherent"));
			adherent.setAdresse_Adherent(rs.getString("add_Adherent"));

		}
		return adherent;
	}


	//////////////////////Rechercher un adherent depuis la liste\\\\\\\\\\\\\\\\\\\\\\\

	/**
	 * 
	 * Rechercher un adherent depuis la liste
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */


	public static ObservableList<Adherent> searchAdherent () throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

		//Déclarer une instruction SELECT
		String selectStmt = "SELECT * FROM adherent";

		//Exécuter l'instruction SELECT
		try {
			//Obtenir ResultSet à partir de la méthode dbExecuteQuery
			ResultSet rsEmps = DBUtil.dbExecuteQuery(selectStmt);

			//Envoyer ResultSet à la méthode getAdherentList et obtenir un objet adhérent
			ObservableList<Adherent> empList = getAdherentList(rsEmps);

			//Retourner l'objet adhérent
			return empList;
		} catch (SQLException e) {
			System.out.println("SQL select operation has been failed: " + e);
			//Return exception
			throw e;
		}
	}


	//////////////////////Obtenir un adhérent depuis la liste Adhérent\\\\\\\\\\\\\\\\\\\\\\\

	/**
	 * Obtenir un adhérent depuis la liste Adhérent
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */


	private static ObservableList<Adherent> getAdherentList(ResultSet rs) throws SQLException, ClassNotFoundException {
		//Déclarer une liste observable qui comprend des objets adhérents
		ObservableList<Adherent> empList = FXCollections.observableArrayList();
		Adherent adherent = null;
		while (rs.next()) {

			adherent = new Adherent();
			adherent.setNum_Adherent(rs.getInt("num_Adherent"));
			adherent.setNom_Adherent(rs.getString("nom_Adherent"));
			adherent.setPrenom_Adherent(rs.getString("prenom_Adherent"));
			adherent.setAdresse_Adherent(rs.getString("add_Adherent"));

			empList.add(adherent);
		}
		//return empList (ObservableList of adherent)
		return empList;
	}

	//////////////////////Supprimer un adhérent\\\\\\\\\\\\\\\\\\\\\\\

	/**
	 * Supprimer un adhérent
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */

	public static void deleteAdherentWithId (int empId) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		//Declare a DELETE statement
		String updateStmt =
				" DELETE adherent from adherent WHERE adherent.num_Adherent ='"+ empId +"'";


		//Execute UPDATE operation
		try {
			DBUtil.dbExecuteUpdate(updateStmt);
		} catch (SQLException e) {
			System.out.print("Error occurred while DELETE Operation: " + updateStmt + "\n" + e);
			throw e;
		}
	}


	//////////////////////Ajouter un adhérent\\\\\\\\\\\\\\\\\\\\\\\

	/**
	 * Ajouter un adhérent
	 * @param num_Adherent
	 * @param nom_Adherent
	 * @param prenom_Adherent
	 * @param add_Adherent
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ParseException
	 */


	public static void insertAdherent (int num_Adherent, String nom_Adherent,String prenom_Adherent,String add_Adherent  ) 
			throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, ParseException {

		String updateStmt2 = "INSERT INTO adherent (`num_Adherent`, `nom_Adherent`, `prenom_Adherent`, `add_Adherent`) VALUES ('"+num_Adherent+"', '"+nom_Adherent+"', '"+prenom_Adherent+"','"+add_Adherent+"')";           
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
	 * @param NUMADHERENT
	 * @param NOMADHERENT
	 * @param PRENOMADHERENT
	 * @param ADRESSEADHERENT
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ParseException
	 */

	public static void modifAdherent (int num_Adherent, String nom_Adherent,String prenom_Adherent,String add_Adherent ) 
			throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, ParseException {

		//Declare an UPDATE statement

		String updateStmt1 =
				"UPDATE adherent"
						+ " SET adherent.nom_Adherent='"+nom_Adherent+"',adherent.prenom_Adherent='"+prenom_Adherent+"',adherent.add_Adherent='"+add_Adherent+"',"
						+ " WHERE adherent.num_Adherent="+num_Adherent+"";



		try {
			DBUtil.dbExecuteUpdate(updateStmt1);

		} catch (SQLException e) {
			System.out.print("Error occurred while INSERT Operation: " + updateStmt1 + "\n" + e);
			throw e;
		}

	}

}
