
package gestionassurances;

import Entities.ObjectHolder;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.stage.FileChooser;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author tourk
 */

public class MediaplayerController implements Initializable {
   @FXML
    private MediaPlayer mediaPlayer;
    private String filePath;
    @FXML
    private MediaView mediaView;
    @FXML
    private Button slowervideo;
    @FXML
    private Button slowvideo;
    @FXML
    private Button fastvideo;
    @FXML
    private Button fastervideo;
    @FXML
    private Button exitvideo;
    String v ;
      ObjectHolder objectHolder=new ObjectHolder();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
//            System.out.println(v);
            Media media = new Media("file:/C:/Users/ayata/Downloads/10000000_312710425975844_105815994034814976_n.mp4");
            mediaPlayer = new MediaPlayer(media);
            mediaView.setMediaPlayer(mediaPlayer);
            DoubleProperty width = mediaView.fitWidthProperty();
            DoubleProperty hight = mediaView.fitHeightProperty();
            width.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
            hight.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));
            mediaPlayer.play();
            
    }    
    @FXML
    private void hundleButtonAction(ActionEvent event) {
     /*  FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Select file (*.mp4)", "*.mp4");
        File file = fileChooser.showOpenDialog(null);
        filePath = file.toURI().toString();
        if (filePath != null){*/

        //}
        
        
    } 

     @FXML
    private void slowervideo(ActionEvent event) {
        mediaPlayer.setRate(.5);
    }

    @FXML
    private void slowvideo(ActionEvent event) {
        mediaPlayer.setRate(.75);
    }

    @FXML
    private void fastvideo(ActionEvent event) {
        mediaPlayer.setRate(1.5);
    }

    @FXML
    private void fastervideo(ActionEvent event) {
        mediaPlayer.setRate(2);
    }

    @FXML
    private void exitvideo(ActionEvent event) {
        System.exit(0);
        
    }

    @FXML
    private void playy(MouseEvent event) {
         mediaPlayer.play();
        mediaPlayer.setRate(1);
    }

    @FXML
    private void pausevideo(MouseEvent event) {
        mediaPlayer.pause();
    }

    
    @FXML
    private void stopv(MouseEvent event) {
         mediaPlayer.stop();
    }
    
}
