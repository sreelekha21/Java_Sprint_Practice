package com.model;



import com.model.enums.Category;
import com.model.enums.Condition;
import com.model.enums.Status;

public class Item {
    private static int counter = 1;
    private String itemId;
    private Category category;
    private String description;
    private Condition condition;
    private int quantity;
    private Status status;

    public Item(Category category, String description, Condition condition, int quantity) {
        this.itemId = "ITEM" + (counter++);
        this.category = category;
        this.description = description;
        this.condition = condition;
        this.quantity = quantity;
        this.status = Status.AVAILABLE;
    }

    public String getItemId() {
        return itemId;
    }

    public Category getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public Condition getCondition() {
        return condition;
    }

    public int getQuantity() {
        return quantity;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("%s - %s (%s) - Qty: %d - Status: %s",
                itemId, category, condition, quantity, status);
    }
}
