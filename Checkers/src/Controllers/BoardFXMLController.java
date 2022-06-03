/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.*;

/**
 * FXML Controller class
 *
 * @author anthonyprancl
 */
public class BoardFXMLController extends MainFXMLController implements Initializable {

    @FXML
    private ImageView sq_00 = new ImageView();
    @FXML
    private ImageView sq_02 = new ImageView();
    @FXML
    private ImageView sq_11 = new ImageView();
    @FXML
    private ImageView sq_20 = new ImageView();
    @FXML
    private ImageView sq_13 = new ImageView();
    @FXML
    private ImageView sq_22 = new ImageView();
    @FXML
    private ImageView sq_04 = new ImageView();
    @FXML
    private ImageView sq_24 = new ImageView();
    @FXML
    private ImageView sq_15 = new ImageView();
    @FXML
    private ImageView sq_06 = new ImageView();
    @FXML
    private ImageView sq_26 = new ImageView();
    @FXML
    private ImageView sq_17 = new ImageView();
    @FXML
    private ImageView sq_31 = new ImageView();
    @FXML
    private ImageView sq_33 = new ImageView();
    @FXML
    private ImageView sq_35 = new ImageView();
    @FXML
    private ImageView sq_37 = new ImageView();
    @FXML
    private ImageView sq_40 = new ImageView();
    @FXML
    private ImageView sq_42 = new ImageView();
    @FXML
    private ImageView sq_44 = new ImageView();
    @FXML
    private ImageView sq_46 = new ImageView();
    @FXML
    private ImageView sq_51 = new ImageView();
    @FXML
    private ImageView sq_60 = new ImageView();
    @FXML
    private ImageView sq_71 = new ImageView();
    @FXML
    private ImageView sq_53 = new ImageView();
    @FXML
    private ImageView sq_73 = new ImageView();
    @FXML
    private ImageView sq_64 = new ImageView();
    @FXML
    private ImageView sq_55 = new ImageView();
    @FXML
    private ImageView sq_66 = new ImageView();
    @FXML
    private ImageView sq_75 = new ImageView();
    @FXML
    private ImageView sq_77 = new ImageView();
    @FXML
    private ImageView sq_57 = new ImageView();
    @FXML
    private ImageView sq_62 = new ImageView();

    ImageView[] board = {sq_00, sq_02, sq_04, sq_06, sq_11, sq_13, sq_15, sq_17, sq_20, sq_22, sq_24, sq_26, sq_31, sq_33, sq_35, sq_37, sq_40, sq_42, sq_44, sq_46, sq_51, sq_53, sq_55, sq_57, sq_60, sq_62, sq_64, sq_66, sq_71, sq_73, sq_75, sq_77};
    Queue<Piece> hand = new LinkedList<>();
    Image placeHolder = new Image("/resources/Green_Dot.jpg");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // delete image 
        // pc_xx.setImage(null);

    }

    @FXML
    private void closeBoard(ActionEvent event) {
        main.FXMain.getBoardStage().close();
    }

    @FXML
    private void resetGame(ActionEvent event) {
        main.FXMain.getBoardStage().close();

        // initialize the previously null stage 
        Stage newBoardStage = new Stage();
        // basic setup
        newBoardStage.setTitle("Game");
        newBoardStage.setAlwaysOnTop(true);
        newBoardStage.setResizable(false);
        // stop user from tampering with main stage when this one is oppened
        newBoardStage.initModality(Modality.APPLICATION_MODAL);

        super.openBoardStage(newBoardStage); //      <- come back 

        // the newly (all those after the first) made stage doesn't seem to have access to the methods that I have been using in the previous 
    }

    @FXML
    private void pickUpPiece(MouseEvent event) {

        // prevents this method from being called twice by differentiating from place piece
        if (event.getButton() == MouseButton.PRIMARY) {
            return;
        }

        // get the square that was clicked + make new piece object
        ImageView square = (ImageView) event.getSource();

        Piece pc = new Piece(square.getImage(), square.getId());
        System.out.println(pc.toString());

        hand.add(pc);

        square.setImage(placeHolder);
        //sq_00.setImage(null);
    }

    @FXML
    private void placePiece(MouseEvent event) {

        // prevents this method from being called twice by differentiating from pick up piece
        if (event.getButton() == MouseButton.SECONDARY) {
            return;
        }

        // get the square that the mouse cicked and place the piece
        ImageView destinationSquare = (ImageView) event.getSource();

        Piece pc = hand.remove();
        pc.setMoveSquare(destinationSquare.getId());
        System.out.println(pc.toString());

        try {
            removeTakenPieces(pc);
        } catch (Exception ex) {
            ex.printStackTrace();

        }

        destinationSquare.setImage(pc.getTeam()); // the the previsoulsy picked up piece

//        hand.clear();
        //sq_02.setImage(img);
    }

    private boolean isImageEqual(Image firstImage, Image secondImage) {

        // Prevent `NullPointerException`
        if (firstImage != null && secondImage == null) {
            return false;
        }
        if (firstImage == null) {
            return secondImage == null;
        }

        // Compare images size
        if (firstImage.getWidth() != secondImage.getWidth()) {
            return false;
        }
        if (firstImage.getHeight() != secondImage.getHeight()) {
            return false;
        }

        // Compare images color
        for (int x = 0; x < firstImage.getWidth(); x++) {
            for (int y = 0; y < firstImage.getHeight(); y++) {
                int firstArgb = firstImage.getPixelReader().getArgb(x, y);
                int secondArgb = secondImage.getPixelReader().getArgb(x, y);

                if (firstArgb != secondArgb) {
                    return false;
                }
            }
        }

        return true;
    }

    public void removeTakenPieces(Piece pc) {
        //get coordinate for each start and destination squares
        int sX = Integer.parseInt("" + pc.getStartSquare().charAt(4));
        int sY = Integer.parseInt("" + pc.getStartSquare().charAt(3));
        int dX = Integer.parseInt("" + pc.getMoveSquare().charAt(4));
        int dY = Integer.parseInt("" + pc.getMoveSquare().charAt(3));

        int[] s_sqr = {sX, sY};// not needing these
        int[] d_sqr = {dX, dY};

        // generate id of the square that we want to remove 
        int rX = Math.abs(sX - dX) + 1;
        int rY = Math.abs(sY - dY) + 1;

        if (rX <= 2) { // in the case that a piece isnt taken
            return;
        }

        String rSqrID = "sq_" + rX + rY;

        // find square with this generated ID
        for (ImageView square : board) {

            System.out.println(square.getId()); //test < why id null?
            System.out.println(rSqrID);
            
            
            if (square.getId().equals(rSqrID)) {
                square.setImage(placeHolder);
            }

        }

        //main.FXMain.getBoardStage().getIcons().rem
    }

}
