package models;

import interfaces.Borrowable;

// Another type of game 
public class SpaceShooter extends Game implements Borrowable {

    public SpaceShooter(Integer gameID, String title, Integer duration) {
        super(gameID, title, duration);
    }

    @Override
    public void checkOut() {
        System.out.println(getTitle() + " has been checked out.");
    }

    @Override
    public void checkIn() {
        System.out.println(getTitle() + " has been checked in / completed.");
    }

    @Override
    public String toString() {
        return "Space Shooter Game: " + getTitle() + " (ID: " + getGameID() + ", Duration: " + getDuration() + " mins)";
    }
}
