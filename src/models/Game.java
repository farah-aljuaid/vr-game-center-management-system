package models;

import interfaces.Borrowable;

/**
 * Game (ABSTRACT CLASS)
 * - Represents any game inside the VR Center.
 */


public abstract class Game implements Borrowable {

    private int gameID;           // Unique ID for the game
    private String title;         // Game title
    private int duration;         // Game duration in minutes
    private boolean isAvailable = true;  // Game availability status

    
    
    public Game(int gameID, String title, int duration) {
        this.gameID = gameID;
        this.title = title;
        this.duration = duration;
    }

  
    public int getGameID() { return gameID; }
    public String getTitle() { return title; }
    public int getDuration() { return duration; }
    public boolean isAvailable() { return isAvailable; }

    
    /**
     * checkOut()
     * Called when a member reserves the game.
     * If the game is available, reserve it and change its status.
     */
    
    @Override
    public void checkOut() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(title + " has been checked out. Enjoy!");
        } else {
            System.out.println(title + " is currently not available.");
        }
    }

    
    /**
     * checkIn()
     * Called when a member finishes playing the game
     * Makes the game available again.
     */
    
    @Override
    public void checkIn() {
        isAvailable = true;
        System.out.println(title + " has been checked in | session completed.");
    }
}
