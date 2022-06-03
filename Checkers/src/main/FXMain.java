/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package main;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;

/**
 *
 * @author anthonyprancl
 */
public class FXMain extends Application {
    
    private static Stage boardStage = null;
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("/FXMLs/MainFXML.fxml"));
        
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Checkers");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        // Call all stage creating methods in case of use.
        createBoardStage();
    } 
    
    
    //creation stages
    public void createBoardStage(){
        
        // initialize the previously null stage 
        boardStage = new Stage();
        // basic setup
        boardStage.setTitle("Game");
        boardStage.setAlwaysOnTop(true);
        boardStage.setResizable(false);
        // stop user from tampering with main stage when this one is oppened
        boardStage.initModality(Modality.APPLICATION_MODAL);
        
    }
    
    //Getters for stages
    public static Stage getBoardStage(){
        return boardStage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
    
  
}
