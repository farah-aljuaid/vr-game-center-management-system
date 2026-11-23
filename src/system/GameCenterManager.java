package system;

import java.util.ArrayList;
import models.Game;
import models.Member;
import models.Reservation;

/**
 * GameCenterManager
 * - Main controller class of the system.
 * - Stores lists of games and members.
 * - Handles registration, reservations, searching, and removal logic.
 */

public class GameCenterManager {

    private ArrayList<Game> availableGames = new ArrayList<>();   // All games
    private ArrayList<Member> members = new ArrayList<>();        // All members


    // GAME MANAGEMENT

    // Adds a new game to the system
    public void addGame(Game g) {
        availableGames.add(g);
    }

    // Finds a game using its ID
    public Game findGameByID(int id) {
        for (Game g : availableGames) {
            if (g.getGameID() == id) return g;
        }
        return null;
    }

    // Displays all available games
    public void displayGames() {
        System.out.println("\n--- Available Games List ---");
        System.out.println("ID\t|\tGame Title\t|\tDuration");
        System.out.println("-----------------------------------------------");

        for (Game g : availableGames) {
            System.out.println(
                g.getGameID() + "\t|\t" +
                g.getTitle() + "\t|\t" +
                g.getDuration() + " mins"
            );
        }
    }


    // MEMBER MANAGEMENT

    // Registers a new member
    public void registerMember(Member m) {
        members.add(m);
    }

    // Finds a member using their ID
    public Member findMemberByID(int id) {
        for (Member m : members) {
            if (m.getMemberID() == id) return m;
        }
        return null;
    }

    // Displays all members and their reservations
    public void displayMembers() {
        System.out.println("\n--- Registered Members ---");

        for (Member m : members) {
            System.out.println(m);

            if (m.getReservations().isEmpty()) {
                System.out.println("   (No reservations)");
            } else {
                for (Reservation r : m.getReservations()) {
                    System.out.println("   " + r);
                }
            }
        }
    }


    // RESERVATION MANAGEMENT

    // Creates a reservation between a member and a game
    public Reservation reserveGame(int memberID, int gameID) {

        Member m = findMemberByID(memberID);
        Game g = findGameByID(gameID);

        if (m == null || g == null) {
            System.out.println("Invalid member or game ID.");
            return null;
        }

        if (!g.isAvailable()) {
            System.out.println("Game is not available.");
            return null;
        }

        Reservation r = new Reservation(m, g);
        m.addReservation(r);   // Add reservation to member

        return r;
    }

    
    // REMOVE MEMBER

    // Removes a member only if they have no active reservations
    public void removeMember(int memberID) {

        Member m = findMemberByID(memberID);

        if (m == null) {
            System.out.println("Member not found");
            return;
        }

        // Block removal if member has an active reservation
        for (Reservation r : m.getReservations()) {
            if (r.getStatus().equalsIgnoreCase("Active")) {
                System.out.println("Cannot remove member: They have an Active reservation.");
                return;
            }
        }

        // Safe to remove
        members.remove(m);
        System.out.println("Member removed successfully.");
    }
}
