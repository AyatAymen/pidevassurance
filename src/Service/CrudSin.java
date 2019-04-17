/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
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


/**
 *
 * @author may islem
 */
public class CrudSin implements ISinistre <Sinistre>{

    private ConnexionDB cnx;
    
    ObservableList<Sinistre> oblist = FXCollections.observableArrayList();
   
    
    
    public CrudSin() {
     cnx= ConnexionDB.getinstance();
    }

    /*public void insert ( Sinistre t) {
        try {
            String requete="insert into sinistres ( idClient,idExpert,idAssureur,dateSinistre,dateDepot,compteRendu,lieuSinistre,description) values ('"+t.getCompteRendu()+t.getDescription()+t.getLieuSinistre()+t.getDateDepot()+t.getDateSinistre()+t.getIdAssureur()+t.getIdClient()+t.getIdExpert()+t.getDescription()+"')";
            ste=cnx.getCnx().createStatement();
            Statement.setString(1, f.getMatricule());
            Statement.setString(2, f.getMarque());
            Statement.setString(3, f.getType());
            Statement.setString(4, f.getTypeAchat());
            Statement.setInt(5, f.getRIP());
            Statement.setString(6, f.getUsage());
            Statement.setInt(7, f.getPuissanceFiscale());
            Statement.setString(8, f.getAlimentation());
            Statement.setString(9, f.getPieceJointe());
            Statement.executeUpdate();
            System.out.println("added");
        } catch (SQLException ex) {
            Logger.getLogger(CrudSin.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
        
          }
    

  
      */
    public ObservableList<Sinistre> afficherr(){
       
      ObservableList<Sinistre> oblist = FXCollections.observableArrayList();
            String requete5= "SELECT * FROM sinistres";
            
           
 try {
            Statement st =cnx.getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete5);
            while(rs.next()){
                oblist.add(new Sinistre(rs.getInt("refSinistre"),rs.getString("idcontart"),rs.getString("type"),rs.getString("date"),rs.getString("lieu"),rs.getString("image"),rs.getString("statut"),rs.getString("email"),rs.getString("video"),rs.getString("description")));
                
                        
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
            
          return oblist;
      }
        public String afficher(int id){
       
      ArrayList oblist=new ArrayList();
            String requete5= "SELECT * FROM sinistres where idClient="+id;
            
           
 try {
            Statement st =cnx.getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete5);
            while(rs.next()){
              return  rs.getString("video");
                        
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
            
          return null;
      }
    public void ajouter_Sinistre(Sinistre t) {
 /*private int idClient;
  private int idExpert;
  private int idAssureur;
  private String dateSinistre;
  private String dateDepot;
  private String description;
  private String lieuSinistre;
  private String compteRendu; 
  private int refSinistre;*/
         try {
            String requete="insert into sinistres (idcontart,date,lieu,type,statut,email,image,video,description) values (?,?,?,?,?,?,?,?,?)";
             PreparedStatement statement = cnx.getCnx().prepareStatement(requete);
             
             statement.setString(1, t.getIdcontart());
             statement.setString(2, t.getDate());
             statement.setString(3, t.getLieu());
             statement.setString(4,t.getType());
             statement.setString(5, t.getStatut());
             statement.setString(6, t.getEmail());
             statement.setString(7, t.getImage());
             statement.setString(8, t.getVideo());
             statement.setString(9, t.getDescription());

             statement.executeUpdate();
            System.out.println("added");
        } catch (SQLException ex) {
            Logger.getLogger(CrudSin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
     public void delete(Sinistre s) {
       try
       {
           String query="DELETE FROM sinistres WHERE refSinistre=?";
           PreparedStatement st = cnx.getCnx().prepareStatement(query);
           st.setInt(1, s.getRefSinistre());
           st.executeUpdate();
           
       }catch(SQLException ex)
       {
           Logger.getLogger(CrudSin.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
     @Override
    public List<Sinistre> getall() {
        List<Sinistre> list = new ArrayList();
        try{
            String query = "SELECT * from sinistres";
            Statement st = cnx.getCnx().createStatement();
            ResultSet Rs = st.executeQuery(query);
            while(Rs.next())
            {
                Sinistre f = new Sinistre();
                f.setRefSinistre(Rs.getInt(1));
                f.setIdcontart(Rs.getString(2));
                f.setType(Rs.getString(3));
                f.setDate(Rs.getString(4));
                f.setLieu(Rs.getString(5));
                f.setImage(Rs.getString(6));
                f.setStatut(Rs.getString(7));
                //f.setImage(r.getBinaryStream(7));
                f.setEmail(Rs.getString(8));
                
                f.setVideo(Rs.getString(9));
                f.setDescription(Rs.getString(10));

                
                list.add(f);
            }
            
                
        }
        catch(SQLException ex)
       {
           Logger.getLogger(CrudSin.class.getName()).log(Level.SEVERE, null, ex);
       }
        return list;
}
   
    @Override
    public void update(Sinistre v)
    {
        String query="UPDATE sinistres SET date=?,email=?,description=?,lieu=? WHERE refSinistre=?";
        PreparedStatement statement;
        try {
            statement = cnx.getCnx().prepareStatement(query);
            
            statement.setString(1, v.getDate());
            statement.setString(2, v.getEmail());
           
            statement.setString(3, v.getDescription());
            statement.setString(4, v.getLieu());
            statement.setInt(5, v.getRefSinistre());
            
            
   
            System.out.println(statement);
            statement.executeUpdate();
            System.out.println("formulaire sinistre modifié");
            
        } catch (SQLException ex) {
            Logger.getLogger(CrudSin.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
       public boolean verifSinistre(Sinistre c) throws SQLException {
        boolean verif = false;
        System.out.println(c);
        Statement stm = (Statement) cnx.getCnx().createStatement();

        String req = ("select * from sinistres where refSinistre='" + c.getRefSinistre() + "' and idcontart='" + c.getIdcontart()+ "' and type='" + c.getType()+ "' and date='" + c.getDate()+ "' and lieu='" + c.getLieu()+ "' and dateDepot='" + c.getDateDepot()+ "' and description= '" + c.getDescription() + "' and lieuSinistre="+ c.getLieuSinistre() + "' and compteRendu = '"+c.getCompteRendu()+"'and video= '"+c.getVideo() );

        ResultSet res = stm.executeQuery(req);
        System.out.println(stm.toString());

        if (res.next()) {
            verif = true;
        }
        return verif;  
    }

    @Override
    public void Insert(Sinistre t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}

    
 


   
   

