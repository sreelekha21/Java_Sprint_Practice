package com.model;



public class Request {
    private NGORepresentative ngo;
    private Item item;

    public Request(NGORepresentative ngo, Item item) {
        this.ngo = ngo;
        this.item = item;
    }

    public NGORepresentative getNgo() {
        return ngo;
    }

    public Item getItem() {
        return item;
    }

    @Override
    public String toString() {
        return "NGO: " + ngo.getName() + " → Item: " + item.toString();
    }
}
