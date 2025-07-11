// Main.java (in com.donateconnect.main)
package com.donateconnect.main;


import com.donateconnect.service.*;
import com.model.Donor;
import com.model.NGORepresentative;
import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DonationManager donationManager = new DonationManager();
    private static final RequestManager requestManager = new RequestManager();

    public static void main(String[] args) {
        System.out.println("\n Welcome to DonateConnect - Community Donation System \n");
        boolean running = true;

        while (running) {
            System.out.println("Main Menu:");
            System.out.println("1. Donor");
            System.out.println("2. NGO Representative");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1": handleDonorMenu(); break;
                case "2": handleNGOMenu(); break;
                case "3":
                    running = false;
                    System.out.println("Thank you for using DonateConnect. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please select 1, 2, or 3.");
            }
        }

        scanner.close();
    }

    private static void handleDonorMenu() {
        System.out.print("Enter Donor Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Donor Email: ");
        String email = scanner.nextLine();
        Donor donor = new Donor(UUID.randomUUID().toString(), name, email);

        while (true) {
            System.out.println("\n--- Donor Menu ---");
            System.out.println("1. Add Donation");
            System.out.println("2. View My Donations");
            System.out.println("3. Back to Main Menu");
            System.out.print("Choose: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1": donationManager.addDonationInteractive(scanner, donor); break;
                case "2": donationManager.viewDonationsByDonor(donor); break;
                case "3": return;
                default: System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void handleNGOMenu() {
        System.out.print("Enter NGO Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter NGO Email: ");
        String email = scanner.nextLine();
        NGORepresentative ngo = new NGORepresentative(UUID.randomUUID().toString(), name, email);

        while (true) {
            System.out.println("\n--- NGO Menu ---");
            System.out.println("1. View Available Items");
            System.out.println("2. Request Item by ID");
            System.out.println("3. View My Requests");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choose: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1": donationManager.viewAvailableItems(); break;
                case "2": requestManager.requestItemInteractive(scanner, ngo, donationManager); break;
                case "3": requestManager.viewRequestsByNGO(ngo); break;
                case "4": return;
                default: System.out.println("Invalid option. Try again.");
            }
        }
    }
}
