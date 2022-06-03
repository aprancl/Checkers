/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import main.FXMain;

/**
 * FXML Controller class
 *
 * @author anthonyprancl
 */
public class MainFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //main.FXMain.getRoot().getChildrenUnmodifiable().remove(pc_00);

    }

    @FXML
    protected void openBoardStage(ActionEvent event) {

        try {
            // creating a reference to the data within the fxml 
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/FXMLs/BoardFXML.fxml"));
            Parent root = loader.load();

            // set the scene with the initialized root 
            main.FXMain.getBoardStage().setScene(new Scene(root));
            // show stage
            main.FXMain.getBoardStage().show();

        } catch (IOException ex) { // IOException is a checked exception and must be handled
            System.out.println(ex);
        }

    }

    // method overloading 
    protected void openBoardStage(Stage newBoardStage) {

        try {
            // creating a reference to the data within the fxml 
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/FXMLs/BoardFXML.fxml"));
            Parent root = loader.load();

            // set the scene with the initialized root 
            newBoardStage.setScene(new Scene(root));
            // show stage
            newBoardStage.show();

        } catch (IOException ex) { // IOException is a checked exception and must be handled
            System.out.println(ex);
        }
    }

    @FXML
    private void endApplication(ActionEvent event) {
        System.exit(0);

    }

}
