
// DonationManager.java (in com.donateconnect.service)
package com.donateconnect.service;

import com.donateconnect.util.InputValidator;
import com.donateconnect.exception.InvalidInputException;
import com.model.Donation;
import com.model.Donor;
import com.model.Item;
import com.model.enums.Category;
import com.model.enums.Condition;
import com.model.enums.Status;

import java.util.*;

public class DonationManager {
    private List<Donation> donations = new ArrayList<>();

    public void addDonation(Donor donor, Item item) {
        Donation donation = new Donation(donor, item);
        donor.addDonation(donation);
        donations.add(donation);
        System.out.println(" Donation added successfully!");
    }

    public void viewDonationsByDonor(Donor donor) {
        System.out.println("\n Donation History:");
        for (Donation d : donations) {
            if (d.getDonor().getUserId().equals(donor.getUserId())) {
                System.out.println(d);
            }
        }
    }

    public void viewAvailableItems() {
        System.out.println("\n Available Items:");
        for (Donation d : donations) {
            if (d.getItem().getStatus() == Status.AVAILABLE) {
                System.out.println(d.getItem());
            }
        }
    }

    public void addDonationInteractive(Scanner scanner, Donor donor) {
        try {
            System.out.println("\n Add Donation:");
            System.out.print("Enter category (CLOTHES, BOOKS, TOYS, UTENSILS, FURNITURE, ELECTRONICS): ");
            String catInput = scanner.nextLine().toUpperCase();
            Category category = Category.valueOf(catInput);

            System.out.print("Enter item description: ");
            String description = scanner.nextLine();
            InputValidator.validateString(description);

            System.out.print("Enter item condition (NEW, GOOD, USED): ");
            String condInput = scanner.nextLine().toUpperCase();
            Condition condition = Condition.valueOf(condInput);

            System.out.print("Enter quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            InputValidator.validateQuantity(quantity);

            Item item = new Item(category, description, condition, quantity);
            addDonation(donor, item);

        } catch (InvalidInputException e) {
            System.out.println(" Input Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(" Invalid enum value. Please enter values as shown.");
        } catch (Exception e) {
            System.out.println(" Unexpected error: " + e.getMessage());
        }
    }

    public Item findItemById(String itemId) {
        for (Donation d : donations) {
            if (d.getItem().getItemId().equalsIgnoreCase(itemId)) {
                return d.getItem();
            }
        }
        return null;
    }

    public List<Donation> getAllDonations() {
        return donations;
    }
}
