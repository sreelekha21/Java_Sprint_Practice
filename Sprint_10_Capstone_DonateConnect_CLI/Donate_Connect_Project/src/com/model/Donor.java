package com.model;

import java.util.ArrayList;
import java.util.List;

public class Donor extends User {
        private List<Donation> donations;

        public Donor(String userId, String name, String email) {
            super(userId, name, email);
            this.donations = new ArrayList<>();
        }

        public List<Donation> getDonations() {
            return donations;
        }

        public void addDonation(Donation donation) {
            donations.add(donation);
        }
    }


