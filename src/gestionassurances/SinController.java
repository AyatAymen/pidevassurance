package gestionassurances;
import Entities.Expert;
import Entities.ObjectHolder;
import Service.CrudSin;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.Button;
import com.jfoenix.controls.JFXComboBox;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import Entities.Sinistre;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;


public class SinController implements Initializable {

    @FXML
    private JFXTextField datesini;
    @FXML
    private JFXTextField datedepo;
    @FXML
    private JFXTextField comptee;
    @FXML
    private JFXTextField lieuu;
    @FXML
    private JFXTextField reff;
    @FXML
    private  JFXTextField search;
@FXML
    private TableColumn<Sinistre, String > sinistre;
@FXML
    private TableColumn<Sinistre, String> datesin;
@FXML
    private TableColumn<Sinistre, String> datedep;
@FXML
    private TableColumn<Sinistre, String> assureur;
@FXML
    private TableColumn<Sinistre, String> expert;
@FXML
    private TableColumn<Sinistre, String> client;
@FXML
    private TableColumn<Sinistre, String> lieu;
@FXML
    private TableColumn<Sinistre, String> compte;
@FXML
    
    private TableView<Sinistre> TableViewAffichage;
@FXML
private Button modifier;
@FXML
private Button supprimer;

 //private String vvideo ;
   
    private Statement s;
    private PreparedStatement pst;
        private ResultSet rs;
    @FXML
    private JFXComboBox<Expert> experts;
    
    ObservableList<Sinistre> obsRr;
    
     ObservableList<Sinistre> oblist = FXCollections.observableArrayList();
 @FXML
    public void supprimer()
    {
        CrudSin us = new CrudSin();
       if (TableViewAffichage.getSelectionModel().getSelectedItem() != null) 
       {
        Sinistre selectedUser = TableViewAffichage.getSelectionModel().getSelectedItem();
        us.delete(selectedUser);
        TableViewAffichage.getItems().setAll(us.getall());
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
                  alert.setTitle("Suppression");
                  alert.setHeaderText("Votre Sinistre a été supprimé aver succés !");
                  alert.showAndWait();
        
       }
    }
    @FXML
     public void modifier ()
     {
         CrudSin us=new CrudSin() ;
         Sinistre updatedUser = TableViewAffichage.getSelectionModel().getSelectedItem();
         updatedUser.setRefSinistre(Integer.valueOf(sinistre.getText()));
         updatedUser.setIdClient(Integer.valueOf(client.getText()));
         updatedUser.setIdExpert(Integer.valueOf(expert.getText()));
         updatedUser.setIdAssureur(Integer.valueOf(assureur.getText()));
         updatedUser.setDateSinistre(datesin.getText());
         updatedUser.setDateDepot(datedep.getText());
         updatedUser.setLieuSinistre(lieu.getText());
         updatedUser.setCompteRendu(compte.getText());
         us.update(updatedUser);
         TableViewAffichage.getItems().setAll(us.getall());
         
       
     } 
    
  
        /*    public void EditSin (int id,int idd ) throws SQLException
   {
       String request="UPDATE sinistres SET idClient  ='"+idd +"' WHERE refSinistre ='"+id+"';";
               
               
             pst = cnx.getCnx().prepareStatement(request);
             pst.executeUpdate();
            
        
   }
   /* private void Modifier(MouseEvent event) throws IOException{
                   EditSin(client,sinistre);
             a=0;
     Parent p1 = FXMLLoader.load(getClass().getResource("sin.fxml"));
                Scene test1 = new Scene(p1);
                Stage App1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                App1.setScene(test1);
                App1.show(); 
    } */
    


     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      CrudSin pcrud= new CrudSin();
        
       ObservableList<Sinistre> so = (ObservableList<Sinistre>) pcrud.afficherr();
       
        
       
        System.out.println(so.get(2).getRefSinistre());
       sinistre.setCellValueFactory(new PropertyValueFactory<>("refSinistre"));
          datesin.setCellValueFactory(new PropertyValueFactory<>("dateSinistre"));
          datedep.setCellValueFactory(new PropertyValueFactory<>("dateDepot"));
          assureur.setCellValueFactory(new PropertyValueFactory<>("idAssureur"));
          expert.setCellValueFactory(new PropertyValueFactory<>("idExpert"));
          client.setCellValueFactory(new PropertyValueFactory<>("idClient"));
          lieu.setCellValueFactory(new PropertyValueFactory<>("lieuSinistre"));
          compte.setCellValueFactory(new PropertyValueFactory<>("compteRendu"));
          
       //   li.setCellValueFactory(new PropertyValueFactory<>("compteRendu"));
        //id.setCellValueFactory( new PropertyValueFactory<>("id"));
      
        TableViewAffichage.setItems(so);
        
        
        TableViewAffichage.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                datesini.setText(TableViewAffichage.getSelectionModel().getSelectedItem().getDateSinistre());
                datedepo.setText(TableViewAffichage.getSelectionModel().getSelectedItem().getDateDepot());
                comptee.setText(TableViewAffichage.getSelectionModel().getSelectedItem().getCompteRendu());
                lieuu.setText(TableViewAffichage.getSelectionModel().getSelectedItem().getLieuSinistre());
                
                
                reff.setText(""+TableViewAffichage.getSelectionModel().getSelectedItem().getRefSinistre());
               // reff.setVisible(false);
                
               // TableViewAffichage.setItems(so);
            }
        });
        
        modifier.setOnAction(new EventHandler<ActionEvent>() {

          @Override
          public void handle(ActionEvent event) {
              if(datesini.getText().isEmpty() || datedepo.getText().isEmpty() || comptee.getText().isEmpty() || lieuu.getText().isEmpty()){
                  Alert alert = new Alert(Alert.AlertType.ERROR);
                  alert.setTitle("Erreur");
                  alert.setHeaderText("Vous devez remplir tous les champs");
                  alert.showAndWait();
              } else {
                  Sinistre s  = new Sinistre(Integer.parseInt(reff.getText()), datesini.getText(), datedepo.getText(),lieuu.getText() ,comptee.getText() );
                  System.out.println("C bon"+lieuu.getText());
                  CrudSin sc = new CrudSin();
                  sc.update(s);
                  oblist.stream().forEach(e-> {
                      if(e.getRefSinistre()== s.getRefSinistre()){
                          
                          e.setCompteRendu(s.getCompteRendu());
                          e.setDateDepot(s.getDateDepot());
                          e.setDateSinistre(s.getDateSinistre());
                          e.setDescription(s.getDescription());
                          e.setIdAssureur(s.getIdAssureur());
                          e.setIdClient(s.getIdClient());
                          e.setIdExpert(s.getIdExpert());
                          e.setLieuSinistre(s.getLieuSinistre());
                          e.setVideo(s.getVideo());
                          System.out.println("modif");
                      }
                  });
                  
                  ObservableList oblist = sc.afficherr();
                  TableViewAffichage.setItems(oblist);
                  Alert alert = new Alert(Alert.AlertType.INFORMATION);
                  alert.setTitle("Modification");
                  alert.setHeaderText("Votre Sinistre a été modifié avec succés !");
                  alert.showAndWait();
              }
              
              
          }
      });
        
        supprimer.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
            try {
                Sinistre s  = new Sinistre(Integer.parseInt(reff.getText()), datesini.getText(), datedepo.getText(),lieuu.getText() ,comptee.getText() );
                CrudSin cs = new CrudSin();
                if (cs.verifSinistre(s)) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erreur");
                    alert.setHeaderText("Contrat n'existe pas!!");
                    alert.showAndWait();
                } else {
                    cs.delete(s);
                    
                    
                    ObservableList<Sinistre> obs = cs.afficherr();
                    
                    
                    TableViewAffichage.setItems(obs);
                    
                    
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Suppression Contrat");
                    alert.setHeaderText("Votre contrat a été modifier avec succés !");
                    alert.showAndWait();
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(SinController.class.getName()).log(Level.SEVERE, null, ex);
            }
                    } 
        
    });
        
//        searchField= = new TextField();
//            search.setFont(Font.font("SanSerif", 10));
//            search.setPromptText("Search");
//            search.setMaxWidth(200);

            FilteredList<Sinistre> filteredData = new FilteredList<>(oblist, e -> true);
            ObservableList<Sinistre> filtered = TableViewAffichage.getItems();
            ObservableList<Sinistre> filterednew = FXCollections.observableArrayList();
                        System.out.println(filtered);

            
            search.setOnKeyReleased(e -> {
                try{
                String text=search.getText();
                for(Sinistre s: filtered){
                    if(!text.equals("")){
                    if(s.getLieuSinistre().startsWith(text)){
                        filterednew.clear();
                        filterednew.add(s);
                        TableViewAffichage.getItems().clear();
                        TableViewAffichage.getItems().addAll(filterednew);
                 
                    }
                    }else{
                        filterednew.clear();
                        System.out.println("cleaaar ");
                        //TableViewAffichage.getItems().clear();
                       // TableViewAffichage.getItems().addAll(filterednew);
                        System.out.println(filtered);
                        TableViewAffichage.setItems(filtered);

                    }
                }
                }catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
//                search.textProperty().addListener((observableValue, oldValue, newValue) -> {
//                    System.out.println(newValue);
//                    
//                    if (!newValue.isEmpty()) {
//                        List<Sinistre> obsRr = oblist.stream().filter((o) -> (o.getLieuSinistre().toLowerCase().contains(newValue.toLowerCase()))).collect((Collectors.toList()));
//                        obsRr.forEach(o -> {
//                            System.out.println("processed list, only even numbers: " + o);
//                        
//                        
//                        });
//                        ObservableList<Sinistre> sortedList = FXCollections.observableArrayList(obsRr);
//                        TableViewAffichage.setItems(sortedList);
//                        System.out.println(sortedList.size());
//                        System.out.println("afficha");
//                        TableViewAffichage.refresh();
//                                               
//                     
//                    }
//                  
//                    
//                    
//                    
//                    
//
//                    else {
//                        TableViewAffichage.setItems(oblist);
//                        System.out.println("++++++++++++++++++++++");
//                        TableViewAffichage.refresh();
//                    }
//
////                 
//                });

            });
            
        
        
        // 1. Wrap the ObservableList in a FilteredList (initially display all data).
//        FilteredList<Sinistre> filteredData = new FilteredList<>(oblist, p -> true);
//         search.setOnKeyReleased(p -> {
//        // 2. Set the filter Predicate whenever the filter changes.
//         search.textProperty().addListener((observableValue, oldValue, newValue) -> {
//
//            filteredData.setPredicate(person -> {
//                // If filter text is empty, display all persons.
//                if (newValue == null || newValue.isEmpty()) {
//                    return true;
//                }
//                
//                // Compare first name and last name of every person with filter text.
//                String lowerCaseFilter = newValue.toLowerCase();
//                                                    System.out.println("11111111");
//
//                System.out.println(lowerCaseFilter);
//                if (person.getLieuSinistre().toLowerCase().contains(lowerCaseFilter)) {
//                                    System.out.println("2222222");
//
//                                    System.out.println(lowerCaseFilter);
//
//                    return true; // Filter matches first name.
//                } 
//                                                    System.out.println("2222222");
//
//                return false; // Does not match.
//            });
//        });
//        
//        // 3. Wrap the FilteredList in a SortedList. 
//        SortedList<Sinistre> sortedData = new SortedList<>(filteredData);
//                                            System.out.println(sortedData);
//
//        // 4. Bind the SortedList comparator to the TableView comparator.
//        sortedData.comparatorProperty().bind(TableViewAffichage.comparatorProperty());
//        
//        // 5. Add sorted (and filtered) data to the table.
//        TableViewAffichage.setItems(sortedData);
//        
//        
//        
//      });
        
    }    

    
    /* private void vid(MouseEvent event) throws IOException {
        Sinistre recette = TableViewAffichage.getSelectionModel().getSelectedItem();
         vvideo = recette.getVideo();
     
        //ObjectHolder objectHolder=new ObjectHolder();
        ObjectHolder.getInstance().setVideor(vvideo);
        ObjectHolder.getInstance().getVideor();
       // ObjectHolder objj = new ObjectHolder();
      // ObjectHolder.getInstance().recette.getVideo();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("zaineb.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
                stage.setScene(new Scene(root));
                
                stage.getScene().setRoot(root);
                stage.show();
    }
  */
    @FXML
    private void vid(MouseEvent e) throws IOException {
        if (e.getClickCount()== 2 && !e.isConsumed()){
      
      Sinistre recette = TableViewAffichage.getSelectionModel().getSelectedItem();
        String vvideo = recette.getVideo();
        ObjectHolder.getInstance().setVideor(vvideo);
       // ObjectHolder objj = new ObjectHolder();
       // ObjectHolder.getInstance().recette.getVideo();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("zaineb.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
                stage.setScene(new Scene(root));
                
                stage.getScene().setRoot(root);
                stage.show();
        
        }
        
    }
}

