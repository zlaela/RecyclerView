package com.example.lmohamed.recyclerview.logic;

import com.example.lmohamed.recyclerview.data.BusinessListItem;
import com.example.lmohamed.recyclerview.data.DataSourceInterface;
import com.example.lmohamed.recyclerview.data.LandmarkListItem;
import com.example.lmohamed.recyclerview.data.PersonListItem;
import com.example.lmohamed.recyclerview.view.ViewInterface;
import com.example.lmohamed.recyclerview.data.ListItem;

public class Controller {

    /*
    All that's going on with these Variables, is that we're talking to both ListActivity and
    FakeDataSource through Interfaces. This has many benefits, but I'd invite you to research
    "Code to an Interface" for a fairly clear example.
     */
    private ViewInterface view;


    private DataSourceInterface dataSource;

    /**
     * As soon as this object is created, it does a few things:
     * 1. Assigns Interfaces Variables so that it can talk to the DataSource and that Activity
     * 2. Tells the dataSource to fetch a List of ListItems.
     * 3. Tells the View to draw the fetched List of Data.
     * @param view
     * @param dataSource
     */
    public Controller(ViewInterface view, DataSourceInterface dataSource) {
        this.view = view;
        this.dataSource = dataSource;

        getListFromDataSource();
    }

    public void onListItemClick(ListItem selectedItem){

        view.startDetailActivity(

                selectedItem.getName(),
                selectedItem.getAddress(),
                selectedItem.getLatLong(),
                selectedItem.getEmail(),
                selectedItem.getPhone(),
                selectedItem.getColorImage()
        );
    }

    /**
     * In a real App, I would normally talk to this DataSource using RxJava 2. This is because most
     * calls to Services like a Database/Server should be executed on a seperate thread that the
     * mainThread (UI Thread). See my full projects for examples of this.
     */
    public void getListFromDataSource(){
        view.setUpAdapterAndView(
                dataSource.getListOfData()
        );
    }


}
