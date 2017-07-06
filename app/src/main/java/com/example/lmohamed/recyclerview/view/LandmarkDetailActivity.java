package com.example.lmohamed.recyclerview.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.lmohamed.recyclerview.R;

/**
 * 18.
 *
 * This Activity simply displays Data from a ListItem in a "Detailed" View.
 */

public class LandmarkDetailActivity extends AppCompatActivity {

    private static final String EXTRA_ITEM_ID = "EXTRA_ITEM_ID";
    private static final String EXTRA_ITEM_NAME = "EXTRA_ITEM_NAME";
    private static final String EXTRA_ITEM_ADDRESS = "EXTRA_ITEM_ADDRESS";
    private static final String EXTRA_ITEM_LATLONG = "EXTRA_ITEM_LATLONG";
    private static final String EXTRA_ITEM_EMAIL = "EXTRA_ITEM_EMAIL";
    private static final String EXTRA_COLOR = "EXTRA_COLOR";

    private TextView mLandmarkName;
    private TextView mLandmarkAddress;
    private TextView mLandmarkLatLong;
    private TextView mLandmarkEmail;
    private View mLandmarkImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landmark_detail);

        Intent i = getIntent();
        String landmarkNameExtra = i.getStringExtra(EXTRA_ITEM_NAME);
        String landmarkAddressExtra = i.getStringExtra(EXTRA_ITEM_ADDRESS);
        String landmarkLatLongExtra = i.getStringExtra(EXTRA_ITEM_LATLONG);
        String landmarkEmailExtra = i.getStringExtra(EXTRA_ITEM_EMAIL);
        int colorResourceExtra = i.getIntExtra(EXTRA_COLOR, 0);

        mLandmarkName = (TextView) findViewById(R.id.detail_landmark_name);
        mLandmarkName.setText(landmarkNameExtra);

        mLandmarkAddress = (TextView) findViewById(R.id.detail_landmark_address);
        mLandmarkAddress.setText(landmarkAddressExtra);

        mLandmarkLatLong = (TextView) findViewById(R.id.detail_landmark_latlong);
        mLandmarkLatLong.setText(landmarkLatLongExtra);

        mLandmarkEmail = (TextView) findViewById(R.id.detail_landmark_email);
        mLandmarkEmail.setText(landmarkEmailExtra);

        mLandmarkImage = findViewById(R.id.detail_landmark_image);
        mLandmarkImage.setBackgroundColor(
                ContextCompat.getColor(this,
                        colorResourceExtra));
    }
}
