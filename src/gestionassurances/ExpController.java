/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionassurances;

import Entities.Expert;
import Service.CrudExp;
import connexiondb.ConnexionDB;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author may islem
 */
public class ExpController implements Initializable {





    @FXML
    private TableView<Expert> TableViewAffichage;

    @FXML
    private TableColumn<Expert, String> expert;

    @FXML
    private TableColumn<Expert, String> nom;

    @FXML
    private TableColumn<Expert, String> prenom;

    @FXML
    private TableColumn<Expert, String> compte;

    @FXML
    private TableColumn<Expert, String> dispo;

    @FXML
    private TableColumn<Expert, String> loc;

    @FXML
    private Button modifier;

    @FXML
    private Button supprimer;
    @FXML
            private  ConnexionDB cnx;
    private Statement s;
    private PreparedStatement pst;
        private ResultSet rs;
 @FXML
    public void supprimer()
    {
        CrudExp us = new CrudExp();
       if (TableViewAffichage.getSelectionModel().getSelectedItem() != null) 
       {
        Expert selectedUser = TableViewAffichage.getSelectionModel().getSelectedItem();
        us.delete(selectedUser);
        TableViewAffichage.getItems().setAll(us.getall());
       }
    }
    @FXML
     public void modifier ()
     {
         CrudExp us=new CrudExp();
         Expert updatedUser = TableViewAffichage.getSelectionModel().getSelectedItem();
         updatedUser.setIdExpert(Integer.valueOf(expert.getText()));
         updatedUser.setNomExpert(nom.getText());
         updatedUser.setPrenomExpert(prenom.getText());
         updatedUser.setCompteRendu(compte.getText());
         updatedUser.setDisponibilité(dispo.getText());
         updatedUser.setLocalisation(loc.getText());
         us.update(updatedUser);
         TableViewAffichage.getItems().setAll(us.getall());
         
       
     }
    

    /**
     * Initializes the controller class.
     */
     @Override
    public void initialize(URL url, ResourceBundle rb) {
      CrudExp pcrud= new CrudExp();
        
        ObservableList<Expert> s = (ObservableList<Expert>) pcrud.afficherr();
       
        
       
        
       //sinistre.setCellValueFactory(new PropertyValueFactory<>("refSinistre"));
          expert.setCellValueFactory(new PropertyValueFactory<>("idExpert"));
          nom.setCellValueFactory(new PropertyValueFactory<>("nomExpert"));
          prenom.setCellValueFactory(new PropertyValueFactory<>("prenomExpert"));
          compte.setCellValueFactory(new PropertyValueFactory<>("compteRendu"));
          dispo.setCellValueFactory(new PropertyValueFactory<>("disponibilité"));
          loc.setCellValueFactory(new PropertyValueFactory<>("localisation"));
          
        //id.setCellValueFactory( new PropertyValueFactory<>("id"));
      
        TableViewAffichage.setItems(s);

    }    
    
}
