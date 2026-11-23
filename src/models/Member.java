package models;

import java.util.ArrayList;

/**
 * Member
 * Represents a member inside the VR Center.
 * 
 * OOP Concepts used:
 * Aggregation: A member "has" reservations.
 * Cloning: clone() creates a duplicate member.
 */


public class Member implements Cloneable {

    private static int counter = 1000;   // ID generator counter
    private int memberID;                // Unique member ID
    private String name;                 // Member's name
    private ArrayList<Reservation> reservations = new ArrayList<>(); // All reservations for this member
                                          

    /**
     * Constructor
     * Creates a new member and assigns an auto-generated ID.
     */
    public Member(String name) {
        this.memberID = counter++;
        this.name = name;
    }

   
    public int getMemberID() { return memberID; }
    public String getName() { return name; }
    public ArrayList<Reservation> getReservations() { return reservations; }

    
    
    /**
     * addReservation()
     * Adds a new reservation to the member.
     */
    
    public void addReservation(Reservation r) {
        reservations.add(r);
    }

    /**
     * clone()
     * Creates a copy of the member object.
     */
    
    @Override
    public Object clone() {
        return new Member(this.name + " (clone)");
    }

   
    @Override
    public String toString() {
        return "Member: " + name + " (ID: " + memberID + ")";
    }
}
