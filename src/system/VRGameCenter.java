package system;

import java.util.Scanner;
import models.*;


public class VRGameCenter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GameCenterManager manager = new GameCenterManager();

        manager.addGame(new CarRacingX(101, "Car Racing Simulator", 20));
        manager.addGame(new SpaceShooter(102, "Space Shooter Galaxy", 25));

        boolean running = true;

        while (running) {

            printMenu();
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:  // Register Member
                    System.out.print("Enter your Name: ");
                    String name = scanner.nextLine();
                    Member newMember = new Member(name);
                    manager.registerMember(newMember);
                    System.out.println("Member registered with ID: " + newMember.getMemberID());
                    break;

                case 2:  // Display Games
                    manager.displayGames();
                    break;

                case 3:  // Reserve Game
                    System.out.print("Enter your Member ID: ");
                    int mID = Integer.parseInt(scanner.nextLine());
                    Member mem = manager.findMemberByID(mID);

                    if (mem == null) {
                        System.out.println("Member not found.");
                        break;
                    }

                    manager.displayGames();
                    System.out.print("\nEnter Game ID to reserve: ");
                    int gID = Integer.parseInt(scanner.nextLine());

                    Reservation r = manager.reserveGame(mID, gID);

                    if (r != null) {
                        System.out.println("\nReservation confirmed!");
                        System.out.println("Reserved Game: " + r.getGame().getTitle() +
                                           " (" + r.getGame().getDuration() + " mins)");
                        r.getGame().checkOut();
                    }
                    break;

                case 4:  // Display Members
                    manager.displayMembers();
                    break;

                case 5:  // Remove Member  (
                    System.out.print("Enter Member ID to remove: ");
                    int removeID = Integer.parseInt(scanner.nextLine());
                    manager.removeMember(removeID);   
                    break;

                case 6:  // Clone Member
                    System.out.print("Enter Member ID to clone: ");
                    int cloneID = Integer.parseInt(scanner.nextLine());
                    Member original = manager.findMemberByID(cloneID);

                    if (original != null) {
                        Member copy = (Member) original.clone();
                        manager.registerMember(copy);
                        System.out.println("Cloned member added with ID: " + copy.getMemberID());
                    } else {
                        System.out.println("Member not found.");
                    }
                    break;

                case 7:  // Exit
                    running = false;
                    break;

                case 8:  // Finish Game Session (Check-in)
                    System.out.print("Enter Member ID: ");
                    int checkID = Integer.parseInt(scanner.nextLine());
                    Member sessionMember = manager.findMemberByID(checkID);

                    if (sessionMember == null) {
                        System.out.println("Member not found.");
                        break;
                    }

                    if (sessionMember.getReservations().isEmpty()) {
                        System.out.println("No active reservations.");
                        break;
                    }

                    Reservation last = sessionMember
                                        .getReservations()
                                        .get(sessionMember.getReservations().size() - 1);

                    last.setStatus("Completed");
                    last.getGame().checkIn();
                    System.out.println("Reservation completed.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // Menu printer
    private static void printMenu() {
        System.out.println("\n========================================");
        System.out.println("       VR Challenge Center System");
        System.out.println("========================================\n");
        System.out.println("1) Register New Member");
        System.out.println("2) Display Available Games");
        System.out.println("3) Reserve Game");
        System.out.println("4) Display Members");
        System.out.println("5) Remove Member");
        System.out.println("6) Clone Member");
        System.out.println("7) Exit");
        System.out.println("8) Finish Game Session (Check-in)");
    }
}