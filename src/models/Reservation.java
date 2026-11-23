package models;

/**
 * Reservation
 * - Represents a reservation made by a member for a specific game.
 */


public class Reservation {

    private static int counter = 1;   

    private int reservationID;       // Unique reservation ID
    private Member member;           // Member who made the reservation
    private Game game;               // Game reserved
    private String status;           // Reservation status can be: "Active" or "Completed".

    
    
    public Reservation(Member member, Game game) {
        this.reservationID = counter++;
        this.member = member;
        this.game = game;
        this.status = "Active";   
    }

   
    public int getReservationID() { return reservationID; }
    public Member getMember() { return member; }
    public Game getGame() { return game; }
    public String getStatus() { return status; }

    // Updates the reservation status 
    public void setStatus(String s) {
        this.status = s;
    }

    
    @Override
    public String toString() {
        return "Reservation #" + reservationID +
               " | Game: " + game.getTitle() +
               " | Status: " + status;
    }
}
