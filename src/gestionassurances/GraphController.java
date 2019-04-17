/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionassurances;

import Entities.ObjectHolder;
import Entities.Sinistre;
import Service.CrudSin;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
//import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import connexiondb.SendMail;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author may islem
 */
public class GraphController implements Initializable {

         @FXML
    private JFXTextField sinistre;

    @FXML
    private JFXTextField datesin;

    @FXML
    private JFXTextField datedep;

    @FXML
    private JFXTextField assureur;

    @FXML
    private JFXTextField expert;

    @FXML
    private JFXTextField client;

    @FXML
    private JFXTextField lieu;

    @FXML
    private JFXTextArea compte;

    @FXML
    private Button Envoyer;
   @FXML
    private ImageView ph;
    @FXML
    private Button ajout;
     @FXML
    private Button Annuler;
    @FXML
    private Button video;
    @FXML
    private Label viid;
    
 private String filePath;
    @FXML
            
       //  @SuppressWarnings("empty-statement")
    void envoi(MouseEvent event) throws IOException {
        
              
   Sinistre a=new Sinistre (Integer.parseInt(client.getText()),Integer.parseInt(expert.getText()),Integer.parseInt(assureur.getText()),datesin.getText(),datedep.getText(),"img",lieu.getText(),compte.getText(),viid.getText());
    
   CrudSin   b = new CrudSin();
    b.ajouter_Sinistre(a);
    
    /*
    Parent p1 = FXMLLoader.load(getClass().getResource("sin.fxml"));
                Scene test1 = new Scene(p1);
                Stage App1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                App1.setScene(test1);
                App1.show();
    /*
    private void AjouterEvent(ActionEvent event) throws IOException {
        
        LocalDate localDatedebut = datepickerdebut.getValue();
Instant instantdebut = Instant.from(localDatedebut.atStartOfDay(ZoneId.systemDefault()));
Date datedebut = Date.from(instantdebut);

java.sql.Date sqlStartDate = new java.sql.Date(datedebut.getTime()); 
LocalDate localDatefin = datepickerdebut.getValue();
Instant instantfin = Instant.from(localDatedebut.atStartOfDay(ZoneId.systemDefault()));
Date datefin = Date.from(instantfin);

java.sql.Date sqlendDate = new java.sql.Date(datefin.getTime()); 

        
            Manifestation P = new Manifestation(1,tfnom.getText(), textareadescription.getText(),"123",sqlStartDate,"1222",2,Integer.parseInt(tfnomclub.getText()),sqlendDate);
            
            manifestationservice pdb = new manifestationservice();
            
            pdb.ajouterManifestation(P);
            String secteur="";
            if(rbscientifique.isSelected())
                    {
                        secteur="Scientifique";
                    }
            if(rbculturel.isSelected())
            {
                        secteur="Culturel";
                    }
            Event e=new Event(1,tfnomorganisateur.getText(),secteur,1);
            EventService es= new EventService();
            es.ajouterEvent(e);
    */
    
    
            try {
    /*
                 Parent p1 = FXMLLoader.load(getClass().getResource("sin.fxml"));
                Scene test1 = new Scene(p1);
                Stage App1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                App1.setScene(test1);
                App1.show();
                /*FXMLLoader loader = new FXMLLoader(getClass().getResource("graph.fxml"));
                loader.setController(new GraphController());*/
                
               
                
                Parent root;
                root=FXMLLoader.load(getClass().getResource("sin.fxml"));
           Scene scene = new Scene(root);
                Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
              
               stage.setScene(scene);
               stage.show(); 
               SendMail.send("2050ayataymen@gmail.com", "Sinistre Ajouté","Un Formulaire d'ajout de votre sinistre a été ajouté !","pideves19@gmail.com", "123456789aA.");
          
                   
                       // CrudSin ss = new CrudSin() ; 
               
                  
                    }
                     
           
          
                       
                
            catch (IOException ex) {
                Logger.getLogger(GraphController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
     ;
    }
    
  
    @FXML
    
   void AjouterImage(MouseEvent event ) {
         
      FileChooser fc= new FileChooser();
     FileChooser.ExtensionFilter extFilterJPG = 
                    new FileChooser.ExtensionFilter("JPG files (*.JPG)", "*.JPG");
            FileChooser.ExtensionFilter extFilterjpg = 
                    new FileChooser.ExtensionFilter("jpg files (*.jpg)", "*.jpg");
            FileChooser.ExtensionFilter extFilterPNG = 
                    new FileChooser.ExtensionFilter("PNG files (*.PNG)", "*.PNG");
            FileChooser.ExtensionFilter extFilterpng = 
                    new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
            fc.getExtensionFilters()
                    .addAll(extFilterJPG, extFilterjpg, extFilterPNG, extFilterpng);
            
    File selectedFile= fc.showOpenDialog(null);
    
   
                BufferedImage bufferedImage;
    
      try {
          bufferedImage = ImageIO.read(selectedFile);  Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                ph.setImage(image);
      } catch (IOException ex) {
          Logger.getLogger(GraphController.class.getName()).log(Level.SEVERE, null, ex);
      
    } }
    


    /**
     * Initializes the controller class.
     */
    @FXML
    void Annuler (MouseEvent event) throws IOException
    {
         Parent p1 = FXMLLoader.load(getClass().getResource("graph.fxml"));
                Scene test1 = new Scene(p1);
                Stage App1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                App1.setScene(test1);
                App1.show();
    }
 /* @FXML
    private void video(MouseEvent event) throws IOException {
       Sinistre sin = table.getSelectionModel().getSelectedItem();
        String vvideo = sin.getVideo();
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

           
*/
    
    
     @Override
    public void initialize(URL location, ResourceBundle resources) {

        
 
        
        }

    @FXML
    private void cf(MouseEvent event) {
        
        
  FileChooser fc = new FileChooser();
        fc.setTitle("upload Image");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Select file (*.mp4)", "*.mp4"));
        File f = fc.showOpenDialog(null);
        filePath = f.toURI().toString();
        if (filePath != null) {
            
             viid.setText(filePath);
               TrayNotification tray = new TrayNotification();

//       aa.setImage(image);
                   String nom ="un sinistre a été ajouté" ;
                   String prenom = "il y'a quelques secondes" ;
                   
                   tray.setTray("Notification", nom +" "+prenom ,NotificationType.INFORMATION);
                   // tray.setT
                   tray.showAndDismiss(javafx.util.Duration.seconds(5));
    }
        else 
        {
               viid.setText("vide");
        }
    
    }
}
    

