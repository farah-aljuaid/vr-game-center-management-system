package models;

import interfaces.Borrowable;


// Specific type of game that extends Game and implements Borrowable
public class CarRacingX extends Game implements Borrowable {

    public CarRacingX(Integer gameID, String title, Integer duration) {
        super(gameID, title, duration); 
    }

    
    
    // Called when the game starts
    @Override
    public void checkOut() {
        System.out.println(getTitle() + " has been checked out.");
    }

    // Called when the game ends
    @Override
    public void checkIn() {
        System.out.println(getTitle() + " has been checked in / completed.");
    }

    
    
    @Override
    public String toString() {
        return "Racing Game: " + getTitle() + " (ID: " + getGameID() + ", Duration: " + getDuration() + " mins)";
    }
}
