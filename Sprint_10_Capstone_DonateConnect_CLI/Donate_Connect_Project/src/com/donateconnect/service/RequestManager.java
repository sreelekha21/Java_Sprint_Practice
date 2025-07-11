// RequestManager.java (in com.donateconnect.service)
package com.donateconnect.service;


import com.model.Item;
import com.model.NGORepresentative;
import com.model.Request;


import java.util.*;

public class RequestManager {
    private List<Request> requests = new ArrayList<>();

    public void requestItem(NGORepresentative ngo, Item item) {
        if (item.getStatus() == com.model.enums.Status.AVAILABLE) {
            item.setStatus(com.model.enums.Status.REQUESTED);
            Request request = new Request(ngo, item);
            ngo.addRequest(request);
            requests.add(request);
            System.out.println(" Request placed successfully.");
        } else {
            System.out.println("Item is not available for request.");
        }
    }

    public void requestItemInteractive(Scanner scanner, NGORepresentative ngo, DonationManager donationManager) {
        System.out.print("Enter Item ID to request: ");
        String itemId = scanner.nextLine();
        Item item = donationManager.findItemById(itemId);

        if (item == null) {
            System.out.println(" Item not found.");
            return;
        }

        requestItem(ngo, item);
    }

    public void viewRequestsByNGO(NGORepresentative ngo) {
        System.out.println("\n Your Requests:");
        for (Request r : requests) {
            if (r.getNgo().getUserId().equals(ngo.getUserId())) {
                System.out.println(r);
            }
        }
    }

    public List<Request> getAllRequests() {
        return requests;
    }
}


