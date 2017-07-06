package com.example.lmohamed.recyclerview.view;

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

public class BusinessDetailActivity extends AppCompatActivity {

    private static final String EXTRA_ITEM_ID = "EXTRA_ITEM_ID";
    private static final String EXTRA_ITEM_NAME = "EXTRA_ITEM_NAME";
    private static final String EXTRA_ITEM_ADDRESS = "EXTRA_ITEM_ADDRESS";
    private static final String EXTRA_ITEM_PHONE = "EXTRA_ITEM_PHONE";
    private static final String EXTRA_COLOR = "EXTRA_COLOR";

    private TextView mBusinessName;
    private TextView mBusinessAddress;
    private TextView mBusinessPhone;
    private View mBusinessImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_detail);

        Intent i = getIntent();
        String businessNameExtra = i.getStringExtra(EXTRA_ITEM_NAME);
        String businessAddressExtra = i.getStringExtra(EXTRA_ITEM_ADDRESS);
        String businessPhoneExtra = i.getStringExtra(EXTRA_ITEM_PHONE);
        int colorResourceExtra = i.getIntExtra(EXTRA_COLOR, 0);

        mBusinessName = (TextView) findViewById(R.id.detail_business_name);
        mBusinessName.setText(businessNameExtra);

        mBusinessAddress = (TextView) findViewById(R.id.detail_business_address);
        mBusinessAddress.setText(businessAddressExtra);

        mBusinessPhone = (TextView) findViewById(R.id.detail_business_phone);
        mBusinessPhone.setText(businessPhoneExtra);

        mBusinessImage = findViewById(R.id.detail_business_image);
        mBusinessImage.setBackgroundColor(
                ContextCompat.getColor(this,
                        colorResourceExtra));
    }
}
