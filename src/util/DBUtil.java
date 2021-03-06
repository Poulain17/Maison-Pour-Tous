package util;

import com.sun.rowset.CachedRowSetImpl;

import java.sql.*;
 
/**
 * Created by Hubert
 */
public class DBUtil {
	
    //Declare JDBC Driver
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
 
    //Connection
    private static Connection conn = null;
 
   
    private static final String connStr = "jdbc:mysql://localhost:3306/maisonpourtous";
   
     
    //Connect to DB
    public static void dbConnect() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //Setting Oracle JDBC Driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur #1002 : Votre MySql JDBC est introuvable !");
            e.printStackTrace();
            throw e;
        }
 
        System.out.println("Connection Reussie");
 
        //Establish the Mysql Connection using Connection String
        try {
            conn = DriverManager.getConnection(connStr,"root","");
        } catch (SQLException e) {
            System.out.println("Erreur #1001 : Echec de la connection" + e);
            e.printStackTrace();
            throw e;
        }
    }
 
    //Close Connection
    public static void dbDisconnect() throws SQLException {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (Exception e){
           throw e;
        }
    }
 
    //DB Execute Query Operation
    public static ResultSet dbExecuteQuery(String queryStmt) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //Declare statement, resultSet and CachedResultSet as null
        Statement stmt = null;
        ResultSet resultSet = null;
        CachedRowSetImpl crs = null;
        try {
            //Connect to DB (Establish Oracle Connection)
            dbConnect();
            System.out.println("Select statement: " + queryStmt + "\n");
 
            //Create statement
            stmt = conn.createStatement();
 
            //Execute select (query) operation
            resultSet = stmt.executeQuery(queryStmt);
 
            //We are using CachedRowSet
            crs = new CachedRowSetImpl();
            crs.populate(resultSet);
            
        } catch (SQLException e) {
            System.out.println("Erreur #1004 : Probl�me rencontr� lors de l'execution de l'operation 'ExecuteQuery' : " + e);
            throw e;
        } finally {
            if (resultSet != null) {
                //Close resultSet
                resultSet.close();
            }
            if (stmt != null) {
                //Close Statement
                stmt.close();
            }
            //Close connection
            dbDisconnect();
        }
        //Return CachedRowSet
        return crs;
    }
 
    //DB Execute Update (For Update/Insert/Delete) Operation
    public static void dbExecuteUpdate(String sqlStmt) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //Declare statement as null
        Statement stmt = null;
        try {
            //Connect to DB (Establish Oracle Connection)
            dbConnect();
            //Create Statement
            stmt = conn.createStatement();
            //Run executeUpdate operation with given sql statement
            stmt.executeUpdate(sqlStmt);
        } catch (SQLException e) {
            System.out.println("Erreur #1005 : Probl�me rencontr� lors de l'execution de l'operation 'ExecuteUpdate' :  " + e);
            throw e;
        } finally {
            if (stmt != null) {
                //Close statement
                stmt.close();
            }
            //Close connection
            dbDisconnect();
        }
    }
}