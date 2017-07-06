package com.example.lmohamed.recyclerview.data;

import java.util.UUID;

public class LandmarkListItem extends ListItem{
    private UUID id;
    private String name;
    private String address;
    private String email;
    private String latLong;
    private int colorImage;

    public LandmarkListItem(String itemName, String itemAddress, String itemLatLong, String itemEmail, int itemImage) {
        super(itemName, itemAddress, itemLatLong, itemEmail, itemImage);
        name = itemName;
        address = itemAddress;
        email = itemEmail;
        latLong = itemLatLong;
        colorImage = itemImage;
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
