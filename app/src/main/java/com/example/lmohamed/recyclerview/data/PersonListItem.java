package com.example.lmohamed.recyclerview.data;


import java.util.UUID;

public class PersonListItem extends ListItem {

    private UUID id;
    private String name;
    private String address;
    private int colorImage;


    public PersonListItem (String itemName, String itemAddress, int itemImage) {
        super(itemName, itemAddress, itemImage);
        name = itemName;
        address = itemAddress;
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

    public int getColorImage() {
        return colorImage;
    }

    public void setColorImage(int colorImage) {
        this.colorImage = colorImage;
    }
}
