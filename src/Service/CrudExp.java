/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.Expert;
import Entities.Sinistre;
import connexiondb.ConnexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.activation.DataSource;

/**
 *
 * @author may islem
 */
public class CrudExp implements ISinistre <Expert>{

    private ConnexionDB cnx;
    private Statement ste;
   
    private PreparedStatement pste;
    private ResultSet Rs;
    
    public CrudExp() {
     cnx= ConnexionDB.getinstance();
    }
    public List<Expert> afficherr(){
        ObservableList<Expert> oblist = FXCollections.observableArrayList();
            String requete5= "SELECT * FROM expert";
            
           
 try {
            Statement st =cnx.getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete5);
            while(rs.next()){
                oblist.add(new Expert(rs.getString("nomExpert"),rs.getString("prenomExpert"),rs.getString("compteRendu"),rs.getString("disponibilité"),rs.getString("localisation")));
                
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
            
          return oblist;
      }

    public void insert ( Expert e) {
        try {
            String requete="insert into expert (nomExpert,prenomExpert,compteRendu,disponibilité,localisation) values ('"+e.getNomExpert()+e.getPrenomExpert()+e.getCompteRendu()+e.getDisponibilité()+e.getLocalisation()+"')";
            ste=cnx.getCnx().createStatement();
            ste.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(CrudExp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     public void ajouter_Expert(Expert e) {
         try {
            String requete="insert into expert (nomExpert,prenomExpert,compteRendu,disponibilité,localisation) values (?,?,?,?,?)";
             pste=cnx.getCnx().prepareStatement(requete);
            // pste.setInt(1, e.getIdExpert());
             pste.setString(1, e.getNomExpert());
             pste.setString(2, e.getPrenomExpert());
             pste.setString(3, e.getCompteRendu());
             pste.setString(4, e.getDisponibilité());
             pste.setString(5, e.getLocalisation());
             pste.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CrudExp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public List<Expert> findAll() {
        List<Expert> listeExperts = new ArrayList<>();

        String requete = "select idExpert,"
                + "nomExpert"
                + "prenomExpert"
                + "compteRendu"
                + "disponibilité"
                + "localisation"
                 ;
        try {
            ste = cnx.getCnx().createStatement();
            Rs = ste.executeQuery(requete);

            while (Rs.next()) {
                Expert p = new Expert();

               // p.setIdExpert(Rs.getInt(1));
                p.setNomExpert(Rs.getString(1));
                p.setPrenomExpert(Rs.getString(2));
                p.setCompteRendu(Rs.getString(3));
                p.setDisponibilité(Rs.getString(4));
                p.setLocalisation(Rs.getString(5));
              
                

                listeExperts.add(p);
            }
            return listeExperts;
        } catch (SQLException ex) {
            System.out.println("SQL Error: " + ex);
            return null;
        }
    }
     @Override
  
     public List<Expert> getall() {
        String requete= "select * from expert";
          List<Expert> O = new ArrayList<>();
        try {

            ste= cnx.getCnx().createStatement();
           Rs=ste.executeQuery(requete);
        
        System.out.println(Rs);

           
           while( Rs.next())

           {O.add(new Expert(
                   
                   //Rs.getInt("idExpert"),
                   Rs.getString("nomExpert"),
                   Rs.getString("prenomExpert"),
                   Rs.getString("compteRendu"),
                   Rs.getString("disponibilité"),
                   Rs.getString("localisation") ))
           ;}

        } catch (SQLException ex) {
                            System.out.println("Error insert");
            Logger.getLogger(CrudExp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return O;
    } /*
      public void EditExp (Expert e, int id) {
          */    public void EditExp (int id,String nom ) throws SQLException
   {
       String request="UPDATE expert SET nomExpert ='"+nom +"' WHERE idExpert ='"+id+"';";
               
               
             pste = cnx.getCnx().prepareStatement(request);
             pste.executeUpdate();
            
        
   }
/*
        String req = "UPDATE expert SET nomExpert`=?,`prenomExpert`=?,`compteRendu`=?,`disponibilité`=?,`localisation`=? WHERE idExpert=?";

        try {
            pste = cnx.getCnx().prepareStatement(req);
            pste.setInt(1, e.getIdExpert());
            pste.setString(2, e.getNomExpert());
            pste.setString(3, e.getPrenomExpert());
            pste.setString(4, e.getCompteRendu());
            pste.setString(5,e.getDisponibilité());
            pste.setString(6, e.getLocalisation());
            
            
            pste.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error update");
            Logger.getLogger(CrudSin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
     public void delete(Expert s) {
       try
       {
           String query="DELETE FROM expert WHERE idExpert=?";
           PreparedStatement st = cnx.getCnx().prepareStatement(query);
           st.setInt(1, s.getIdExpert());
           st.executeUpdate();
           
       }catch(SQLException ex)
       {
           Logger.getLogger(CrudExp.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    @Override
    public void Insert(Expert t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Expert t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     }
     
    

    /*@Override
     public void Insert(Expert t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     }

    @Override
     public void Delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     }

    @Override
     public void update(Expert t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     }

     @Override
     public List<Expert> getall() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     }

    */
