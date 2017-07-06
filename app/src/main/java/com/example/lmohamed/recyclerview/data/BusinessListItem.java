package com.example.lmohamed.recyclerview.data;

import java.util.UUID;

public class BusinessListItem extends ListItem {
    private UUID id;
    private String name;
    private String address;
    private String phone;
    private int colorImage;

    /*It's common for an "Item" to have a unique Id for storing an a Database
    private String uniqueIdentifier;*/

    public BusinessListItem (String itemName, String itemAddress, String itemPhone, int itemImage) {
        super(itemName, itemAddress, itemPhone, itemImage);
        name = itemName;
        address = itemAddress;
        phone = itemPhone;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getColorImage() {
        return colorImage;
    }

    public void setColorImage(int colorImage) {
        this.colorImage = colorImage;
    }

}
