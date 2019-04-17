/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexiondb;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author may islem
 */
public class ConnexionDB {

    /**
     * @param args the command line arguments
     */
    private  String url="jdbc:mysql://127.0.0.1:3306/pid";
    private  String login="root";    
    private  String pwd= "";
    public  Connection cnx;
    private static ConnexionDB con;

    
    private ConnexionDB() {
        
        try {
            cnx =DriverManager.getConnection(url, login, pwd);
                System.out.println("Connected");
            
// TODO code application logic here
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionDB.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    }

    public Connection getCnx() {
        return cnx;
    }
    
    public static ConnexionDB getinstance(){
    if (con==null)
    con= new ConnexionDB();  
        
    return con;
    }
    /*1) Rendre le constructeur private
    2) implementer une methode qui retuorene le meme type de retour de la classe getinstance()
    */

}

