package com.example.lmohamed.recyclerview.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.lmohamed.recyclerview.R;

/**
 * This Activity simply displays Data from a ListItem in a "Detailed" View.
 */

public class PersonDetailActivity extends AppCompatActivity {

    private static final String EXTRA_ITEM_ID = "EXTRA_ITEM_ID";
    private static final String EXTRA_ITEM_NAME = "EXTRA_ITEM_NAME";
    private static final String EXTRA_ITEM_ADDRESS = "EXTRA_ITEM_ADDRESS";
    private static final String EXTRA_COLOR = "EXTRA_COLOR";

    private TextView mPersonName;
    private TextView mPersonAddress;
    private View mPersonImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_detail);

        Intent i = getIntent();
        String personNameExtra = i.getStringExtra(EXTRA_ITEM_NAME);
        String personAddressExtra = i.getStringExtra(EXTRA_ITEM_ADDRESS);
        int colorResourceExtra = i.getIntExtra(EXTRA_COLOR, 0);

        mPersonName = (TextView) findViewById(R.id.detail_person_name);
        mPersonName.setText(personNameExtra);

        mPersonAddress = (TextView) findViewById(R.id.detail_person_address);
        mPersonAddress.setText(personAddressExtra);

        mPersonImage = findViewById(R.id.detail_person_image);
        mPersonImage.setBackgroundColor(
                ContextCompat.getColor(this,
                        colorResourceExtra));
    }
}
