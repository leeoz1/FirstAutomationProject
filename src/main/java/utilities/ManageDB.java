package utilities;

import java.sql.DriverManager;

public class ManageDB extends CommonOps{

/*
###########################################################################
Method name : openConnection
Method description : This method opens the connection to the DB server (initiated in CommonOps's startSession method).
Method parameters : String
Method return : N/A
###########################################################################
*/
    public static void openConnection(String dbUrl, String user, String password){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dbUrl, user, password);
            state = con.createStatement();
        } catch (Exception e) {
            System.out.println("Error occurred while connecting to DB, see details: " + e);
        }
    }

/*
###########################################################################
Method name : closeConnection
Method description : This method closes the connection from the DB server (initiated in CommonOps's closeSession method).
Method parameters : N/A
Method return : N/A
###########################################################################
*/

    public static void closeConnection(){
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Error occurred while close the DB, see details: " + e);
        }
    }
}
