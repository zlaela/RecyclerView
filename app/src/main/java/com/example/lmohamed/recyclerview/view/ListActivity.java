package com.example.lmohamed.recyclerview.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import com.example.lmohamed.recyclerview.data.FakeDataSource;
import com.example.lmohamed.recyclerview.data.LandmarkListItem;
import com.example.lmohamed.recyclerview.R;
import com.example.lmohamed.recyclerview.data.BusinessListItem;
import com.example.lmohamed.recyclerview.data.ListItem;
import com.example.lmohamed.recyclerview.logic.Controller;

/**
 * List Activity is responsible for
 * - Coordinating the User Interface
 * - Relaying Click events to the Controller
 * - Starting a Detail Activity
 */
public class ListActivity extends AppCompatActivity implements ViewInterface {

    private static final String EXTRA_ITEM_ID = "EXTRA_ITEM_ID";
    private static final String EXTRA_ITEM_NAME = "EXTRA_ITEM_NAME";
    private static final String EXTRA_ITEM_ADDRESS = "EXTRA_ITEM_ADDRESS";
    private static final String EXTRA_ITEM_PHONE = "EXTRA_ITEM_PHONE";
    private static final String EXTRA_ITEM_EMAIL = "EXTRA_ITEM_EMAIL";
    private static final String EXTRA_ITEM_LATLONG = "EXTRA_ITEM_LATLONG";
    private static final String EXTRA_COLOR = "EXTRA_COLOR";

    private List<ListItem> listOfData;

    private LayoutInflater layoutInflater;
    private RecyclerView recyclerView;
    private CustomAdapter adapter;

    private Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = (RecyclerView) findViewById(R.id.rv_list_activity);
        layoutInflater = getLayoutInflater();

        controller = new Controller(this, new FakeDataSource());

        // Floating Action Button
        FloatingActionButton actionButton = (FloatingActionButton)findViewById(R.id.action_button);
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: make actionButton show submenus, hook them up to add items by type
                Snackbar.make(view, "Do something", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    /** Launch each list item's DetailActivity **/
    @Override
    public void startDetailActivity(String itemName, String itemAddress, String itemPhone, String itemLatLong, String itemEmail, int colorResource){
        Intent i = new Intent(this, ItemDetail.class);

        i.putExtra(EXTRA_ITEM_NAME, itemName);
        i.putExtra(EXTRA_ITEM_ADDRESS, itemAddress);
        i.putExtra(EXTRA_ITEM_PHONE, itemPhone);
        i.putExtra(EXTRA_ITEM_EMAIL, itemEmail);
        i.putExtra(EXTRA_ITEM_LATLONG, itemLatLong);
        i.putExtra(EXTRA_COLOR, colorResource);

        startActivity(i);
    }

    /**
     * In order to make sure things execute in the proper order, we have our Controller tell the
     * View when to set up it's stuff.
     * @param listOfData is the fake data generated
     */
    @Override
    public void setUpAdapterAndView(List<ListItem> listOfData) {
        this.listOfData = listOfData;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomAdapter();
        recyclerView.setAdapter(adapter);
    }

    private class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {//6

        private final int BUSINESS = 0;
        private final int LANDMARK = 1;
        private final int PERSON = 2;

        @Override
        public int getItemViewType(int position) {
            ListItem i = listOfData.get(position);
            if (i instanceof BusinessListItem) {
                return BUSINESS;
            }
            if (i instanceof LandmarkListItem){
                return LANDMARK;
            }
            else{
                return PERSON;
            }
        }

        /**
         * Inflates a new View depending on the ViewTpe and then creates/returns a new
         * ViewHolder object.
         */
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

            RecyclerView.ViewHolder viewHolder;

            View itemView = layoutInflater.inflate(R.layout.item_list_card, viewGroup, false);

            switch (viewType){
                case BUSINESS:
                    // attach business items
                    View businessImage = layoutInflater.inflate(R.layout.item_list_card, viewGroup, false);
                    viewHolder = new BusinessViewHolder(itemView);
                    break;
                case LANDMARK:
                    // inflate the landmark layout
                    View landmarkView = layoutInflater.inflate(R.layout.item_list_card, viewGroup, false);
                    viewHolder = new LandmarkViewHolder(itemView);
                    break;
                case PERSON:
                    // inflate the person layout
                    View personView  = layoutInflater.inflate(R.layout.item_list_card, viewGroup, false);
                    viewHolder = new PersonViewHolder(itemView);
                    break;
                default:
                    View defaultView = layoutInflater.inflate(R.layout.item_default, viewGroup, false);
                    viewHolder = new DefaultViewHolder(defaultView);
                    break;
            }
            return viewHolder;
        }

        /**
         * This method "Binds" or assigns Data (from listOfData) to each View (ViewHolder).
         * @param viewHolder The current ViewHolder instance for a given position
         * @param position The current position of the ViewHolder we are Binding to, based upon
         *                 our (listOfData). So for the second ViewHolder we create, we'll bind data
         *                 from the second Item in listOfData.
         */
        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
            //11. and now the ViewHolder data
            int viewType = getItemViewType(position);
            switch (viewType){
                case BUSINESS:
                    BusinessViewHolder businessViewHolder = (BusinessViewHolder) viewHolder;
                    configureBusinessViewHolder(businessViewHolder, position);
                    break;
                case LANDMARK:
                    LandmarkViewHolder landmarkViewHolder = (LandmarkViewHolder) viewHolder;
                    configureLandmarkViewHolder(landmarkViewHolder, position);
                    break;
                case PERSON:
                    PersonViewHolder personViewHolder = (PersonViewHolder) viewHolder;
                    configurePersonViewHolder(personViewHolder, position);
                    break;
                default:
                    DefaultViewHolder defaultViewHolder = (DefaultViewHolder) viewHolder;
                    configureDefaultViewHolder(defaultViewHolder, position);
            }
        }

        /**
         * This method tells the Adapter determine how many ViewHolders it needs to create
         */
        @Override
        public int getItemCount() {
            return listOfData.size();
        }

        /**5.
         * Each ViewHolder contains Bindings to the Views we wish to populate with Data.
         */
        class DefaultViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            private TextView textView;
            private ViewGroup container;

            public DefaultViewHolder(View itemView) {
                super(itemView);
                this.textView = (TextView) itemView.findViewById(R.id.list_default_tv);
                this.container = (ViewGroup) itemView.findViewById(R.id.root_default_item);
                this.container.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "nooope",
                        Toast.LENGTH_LONG).show();
            }
        }
        class BusinessViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            private View image;
            private TextView name;
            private TextView address;
            private TextView phone;
            private ViewGroup container;

            public BusinessViewHolder(View itemView) {
                super(itemView);
                this.image = itemView.findViewById(R.id.list_business_image);
                this.name = (TextView) itemView.findViewById(R.id.list_business_name);
                this.address = (TextView) itemView.findViewById(R.id.list_business_address);
                this.phone = (TextView) itemView.findViewById(R.id.list_business_phone);

                this.image.setVisibility(View.VISIBLE);
                this.name.setVisibility(View.VISIBLE);
                this.phone.setVisibility(View.VISIBLE);

                this.container = (ViewGroup) itemView.findViewById(R.id.item_card);
                /*
                We can pass "this" as an Argument, because "this", which refers to the Current
                Instance of type CustomViewHolder currently conforms to (implements) the
                View.OnClickListener interface.
                 */
                this.container.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                //getAdapterPosition() get's an Integer based on which the position of the current
                //ViewHolder (this) in the Adapter. This is how we get the correct Data.
                ListItem listItem = listOfData.get(
                        this.getAdapterPosition()
                );

                controller.onListItemClick(
                        listItem
                );

            }
        }

        class LandmarkViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            private View image;
            private TextView name;
            private TextView address;
            private TextView latlong;
            private TextView email;
            private ViewGroup container;

            public LandmarkViewHolder(View itemView) {
                super(itemView);
                this.image = itemView.findViewById(R.id.list_landmark_image);
                this.name = (TextView) itemView.findViewById(R.id.list_landmark_name);
                this.address = (TextView) itemView.findViewById(R.id.list_landmark_address);
                this.latlong = (TextView) itemView.findViewById(R.id.list_landmark_latlong);
                this.email = (TextView) itemView.findViewById(R.id.list_landmark_email);

                this.image.setVisibility(View.VISIBLE);
                this.name.setVisibility(View.VISIBLE);
                this.address.setVisibility(View.VISIBLE);
                this.latlong.setVisibility(View.VISIBLE);
                this.email.setVisibility(View.VISIBLE);

                this.container = (ViewGroup) itemView.findViewById(R.id.item_card);

                this.container.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                ListItem listItem = listOfData.get(
                        this.getAdapterPosition()
                );

                controller.onListItemClick(
                        listItem
                );

            }
        }

        class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            private View image;
            private TextView name;
            private TextView address;
            private ViewGroup container;

            public PersonViewHolder(View itemView) {
                super(itemView);
                this.image = itemView.findViewById(R.id.list_person_image);
                this.name = (TextView) itemView.findViewById(R.id.list_person_name);
                this.address = (TextView) itemView.findViewById(R.id.list_person_address);

                this.image.setVisibility(View.VISIBLE);
                this.name.setVisibility(View.VISIBLE);
                this.address.setVisibility(View.VISIBLE);

                this.container = (ViewGroup) itemView.findViewById(R.id.item_card);

                this.container.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                ListItem listItem = listOfData.get(
                        this.getAdapterPosition()
                );

                controller.onListItemClick(
                    listItem
                );

            }
        }


        /** These populate the View after the data is bound to the View **/

        public void configureDefaultViewHolder(DefaultViewHolder defaultViewHolder, int position) {
            // fill in the view
            defaultViewHolder.textView.setText("Nothing to see here #" + (CharSequence) listOfData.get(position));
        }
        public void configureBusinessViewHolder(BusinessViewHolder businessViewHolder, int position){
            // fill in the views
            ListItem item = listOfData.get(position);
            businessViewHolder.image.setBackgroundResource(item.getColorImage());
            businessViewHolder.name.setText(item.getName());
            businessViewHolder.address.setText(item.getAddress());
            businessViewHolder.phone.setText(item.getPhone());
        }

        public void configureLandmarkViewHolder(LandmarkViewHolder landmarkViewHolder, int position){
            // fill in the views
            ListItem item = listOfData.get(position);
            landmarkViewHolder.image.setBackgroundResource(item.getColorImage());
            landmarkViewHolder.name.setText(item.getName());
            landmarkViewHolder.address.setText(item.getAddress());
            landmarkViewHolder.latlong.setText(item.getLatLong());
            landmarkViewHolder.email.setText(item.getEmail());
        }

        public void configurePersonViewHolder(PersonViewHolder personViewHolder, int position){
            // fill in the views
            ListItem item = listOfData.get(position);
            personViewHolder.image.setBackgroundResource(item.getColorImage());
            personViewHolder.name.setText(item.getName());
            personViewHolder.address.setText(item.getAddress());
        }

    }
}
