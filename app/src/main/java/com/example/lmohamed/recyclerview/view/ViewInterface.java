package com.example.lmohamed.recyclerview.view;

import java.util.List;
import java.util.UUID;

import com.example.lmohamed.recyclerview.data.ListItem;

/**
 * This Interface is the Contract which dictates how our View and Presenter can talk to each other.
 */

public interface ViewInterface {

    void startDetailActivity(String name, String address, String phone, String latlong, String email, int colorResource);

   /* void startBusinessDetailActivity(UUID itemId);
    void startLandmarkDetailActivity(UUID itemId);
    void startPersonDetailActivity(UUID itemId); */

    void setUpAdapterAndView(List<ListItem> listOfData);

}
