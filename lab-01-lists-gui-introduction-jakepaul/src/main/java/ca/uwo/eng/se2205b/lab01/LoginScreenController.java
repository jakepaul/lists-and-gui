package ca.uwo.eng.se2205b.lab01;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * Created by jacob on 2017-02-03.
 */
public class LoginScreenController {
    
    @FXML private TextField usernameid;
    @FXML private PasswordField passwordField;
    @FXML private Text actiontarget;
    
    @FXML protected void handleSubmitButtonAction(ActionEvent event) {
        actiontarget.setText("Sign in button pressed");
    
        if (usernameid.getText().equals("admin") && (passwordField.getText().equals("hunter2"))) {
            actiontarget.setText("Success!");
            actiontarget.setFill(Color.GREEN);
        } else {
            actiontarget.setText("Failed to Authenticate");
            actiontarget.setFill(Color.RED);
        }
    }
    public void tryAgain(MouseEvent mouseEvent){
        actiontarget.setText("Authenticate");
        actiontarget.setFill(Color.BLACK);
    }
    
    
}
