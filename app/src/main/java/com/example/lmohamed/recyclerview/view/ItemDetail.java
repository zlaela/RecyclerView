package com.example.lmohamed.recyclerview.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.lmohamed.recyclerview.R;

import static android.view.View.GONE;

/**
 * This Activity simply displays Data from a ListItem in a "Detailed" View.
 */

public class ItemDetail extends AppCompatActivity {

    private static final String EXTRA_ITEM_ID = "EXTRA_ITEM_ID";
    private static final String EXTRA_ITEM_NAME = "EXTRA_ITEM_NAME";
    private static final String EXTRA_ITEM_ADDRESS = "EXTRA_ITEM_ADDRESS";
    private static final String EXTRA_ITEM_PHONE = "EXTRA_ITEM_PHONE";
    private static final String EXTRA_ITEM_EMAIL = "EXTRA_ITEM_EMAIL";
    private static final String EXTRA_ITEM_LATLONG = "EXTRA_ITEM_LATLONG";
    private static final String EXTRA_COLOR = "EXTRA_COLOR";
    
    
    // Views
    private TextView mItemName;
    private TextView mItemAddress;
    private TextView mItemPhone;
    private TextView mItemEmail;
    private TextView mItemLatLong;
    private View mItemImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        Intent i = getIntent();
        String itemNameExtra = i.getStringExtra(EXTRA_ITEM_NAME);
        String itemAddressExtra = i.getStringExtra(EXTRA_ITEM_ADDRESS);
        String itemPhoneExtra = i.getStringExtra(EXTRA_ITEM_PHONE);
        String itemEmailExtra = i.getStringExtra(EXTRA_ITEM_EMAIL);
        String itemLatLongExtra = i.getStringExtra(EXTRA_ITEM_LATLONG);
        int colorResourceExtra = i.getIntExtra(EXTRA_COLOR, 0);

        mItemImage = findViewById(R.id.detail_item_image);
        mItemName = (TextView) findViewById(R.id.detail_item_name);
        mItemAddress = (TextView) findViewById(R.id.detail_item_address);
        mItemPhone = (TextView) findViewById(R.id.detail_item_phone);
        mItemEmail = (TextView) findViewById(R.id.detail_item_email);
        mItemLatLong = (TextView) findViewById(R.id.detail_item_latlong);



        mItemImage.setBackgroundColor(ContextCompat.getColor(this, colorResourceExtra));
        if(itemNameExtra != null) setupView(mItemName, itemNameExtra); else mItemName.setVisibility(GONE);
        if(itemNameExtra != null) setupView(mItemAddress, itemAddressExtra); else mItemAddress.setVisibility(GONE);
        if(itemPhoneExtra != null) setupView(mItemPhone, itemPhoneExtra); else mItemPhone.setVisibility(GONE);
        if(itemEmailExtra != null) setupView(mItemEmail, itemEmailExtra); else mItemEmail.setVisibility(GONE);
        if(itemLatLongExtra != null) setupView(mItemLatLong, itemLatLongExtra); else mItemLatLong.setVisibility(GONE);


    }

    private void setupView(TextView view, String extra){
        view.setText(extra);
    }
    
}
