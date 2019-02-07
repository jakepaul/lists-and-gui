package ca.uwo.eng.se2205b.lab01;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * LoginScreen for completing the JavaFX
 */
public class LoginScreen extends Application {
    
    @Override
    public void start(Stage stage)throws Exception{
        
            Parent root = FXMLLoader.load(getClass().getResource("/LoginScreen.fxml"));
        
            Scene scene = new Scene(root, 300, 275);
        
            stage.setTitle("FXML Welcome");
            stage.setScene(scene);
            stage.show();
        
    }
    public static void main (String[] args){launch(args);}
}
