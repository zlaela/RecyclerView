package com.example.lmohamed.recyclerview.data;

import java.util.UUID;

/**
 * Parent template for list items, in case we want to add more in teh future
 */

public class ListItem {

    private UUID id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String latLong;
    private int colorImage;

    /*It's common for an "Item" to have a unique Id for storing an a Database
    private String uniqueIdentifier;*/

    public ListItem(String itemName, String itemAddress, int itemImage) {
        // PersonListItem
    }

    public ListItem(String itemName, String itemAddress, String itemPhone, int itemImage) {
        // BusinessListItem
    }

    public ListItem(String itemName, String itemAddress, String itemLatLong, String itemEmail, int itemImage) {
        // LandmarkListItem
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLatLong() {
        return latLong;
    }

    public void setLatLong(String latLong) {
        this.latLong = latLong;
    }

    public int getColorImage() {
        return colorImage;
    }

    public void setColorImage(int colorImage) {
        this.colorImage = colorImage;
    }

}
