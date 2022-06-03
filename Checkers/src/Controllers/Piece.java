/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author anthonyprancl
 */
public class Piece {
    //data members
    private Image team;
    private String startSquare; // used to identify where the piece is at a given moment AKA between moves
    private String moveSquare;
    private boolean isKing;
    
    
    //Constructors
    
    public Piece(){
        isKing = false;
    }
    
    public Piece(Image team, String startSquare){
        this.team = team;
        this.startSquare = startSquare;
        isKing = false;
    }
    
//    public Piece(String team)
    
    // accessor and mutator methods 
   

    public Image getTeam() {
        return team;
    }

    public void setTeam(Image team) {
        this.team = team;
    }

    public String getStartSquare() {
        return startSquare;
    }

    public void setStartSquare(String startSquare) {
        this.startSquare = startSquare;
    }

    public String getMoveSquare() {
        return moveSquare;
    }

    public void setMoveSquare(String moveSquare) {
        this.moveSquare = moveSquare;
    }
    

//    public ImageView getSquare() {
//        return square;
//    }
//
//    public void setSquare(ImageView square) {
//        this.square = square;
//    }

    public boolean isIsKing() {
        return isKing;
    }

    public void setIsKing(boolean isKing) {
        this.isKing = isKing;
    }
    
    
    // other methods
    @Override
    public String toString(){
        
        String data = "";
        
        String[] img = team.getUrl().split("/");
        
        data += String.format("Image: %s\n", img[img.length - 1]);
        data += String.format("Start Square: %s\n", getStartSquare());
        data += String.format("Destination Square: %s\n", (getMoveSquare() == null) ? "none" : getMoveSquare());
        
        
        return data;
        
    }
    
}
