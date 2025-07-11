package com.model;

    public class Donation {
        private Donor donor;
        private Item item;

        public Donation(Donor donor, Item item) {
            this.donor = donor;
            this.item = item;
        }

        public Donor getDonor() {
            return donor;
        }

        public Item getItem() {
            return item;
        }

        @Override
        public String toString() {
            return "Donor: " + donor.getName() + " → Item: " + item.toString();
        }
    }


