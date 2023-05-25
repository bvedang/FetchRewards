package com.example.fetchrewardexercise;

import com.google.gson.annotations.SerializedName;

/**
 * Represents an item fetched from the server.
 * Implements Comparable to allow items to be sorted by "listId" and then by "name".
 */

public class Items implements Comparable<Items>{
    @SerializedName("id")
    private int id;

    @SerializedName("listId")
    private int listId;

    @SerializedName("name")
    private String name;

    // Getters and setters...

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Compares this item with the specified item for order.
     * Returns a negative integer, zero, or a positive integer as this item
     * is less than, equal to, or greater than the specified item.
     */

    @Override
    public int compareTo(Items item) {
        if (this.listId != item.listId) {
            return Integer.compare(this.listId, item.listId);
        } else if (this.name != null && item.name != null) {
            return this.name.compareTo(item.name);
        } else {
            return 0; // Return 0 if names are null or not comparable
        }
    }
}

