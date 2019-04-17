package gestionassurances;

import Entities.Expert;
import Service.CrudExp;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ExpertController {

    @FXML
    private JFXTextField expert;

    @FXML
    private JFXTextField nom;

    @FXML
    private JFXTextField prenom;

    @FXML
    private JFXTextField loc;

    @FXML
    private JFXTextArea compte;

    @FXML
    private Button annuler;

    @FXML
    private Button ajout;

    @FXML
    void Ajouter(MouseEvent event) throws IOException {
         Expert a=new Expert (nom.getText(),prenom.getText(),compte.getText(),"oui ou non",loc.getText());
    
        CrudExp   b = new CrudExp();
    b.insert(a); 

    }

    @FXML
    void Annuler(MouseEvent event) throws IOException {
        Parent p1 = FXMLLoader.load(getClass().getResource("expert.fxml"));
                Scene test1 = new Scene(p1);
                Stage App1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                App1.setScene(test1);
                App1.show();

    }

    void initData(double lat, double lon) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}