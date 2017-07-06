package com.example.lmohamed.recyclerview.data;

import com.example.lmohamed.recyclerview.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;


public class FakeDataSource implements DataSourceInterface{

    private static final int sizeOfCollection = 10;

    // IDs
    private final UUID randomId = UUID.randomUUID();

    // Random People
    private final String[] personNames = {
            "Nancie Minger",
            "Kenisha Smelcer",
            "Monroe Leonard",
            "Shane Sang",
    };

    private final String[] personAddresses = {
            "615 Green Lake Rd. \n" +
                    "Thornton, CO 80241",
            "9883 Beaver Ridge Ave. \n" +
                    "Langhorne, PA 19047",
            "5 S. Yukon Avenue \n" +
                    "Port Chester, NY 10573",
            "342 N. Ridgewood Court \n" +
                    "Smithtown, NY 11787"
    };

    // Random Businesses
    private final String[] businessNames = {
            "The Happy Lime Print Design Company",
            "Plain Turtle Shoe",
            "The Piping Toaster Couriers Company",
            "The Deep Baboon Web Design Company",
    };

    private final String[] businessAddresses = {
            "87 East Crescent Dr. \n" +
                "East Meadow, NY 11554",
            "49 Oak Valley St. \n" +
                "Lakeville, MN 55044",
            "9558 Wood St.  \n" +
                    "Goshen, IN 46526",
            "385 Cardinal Court \n" +
                    "Sandusky, OH 44870"
    };

    private final String[] businessPhones = {
            "202-555-0127",
            "202-555-0126",
            "202-555-0152",
            "202-555-0139"
    };

    // Random Landmarks
    private final String[] landmarkNames = {
            "Giza Pyramid and the Great Sphinx ",
            "Taj Mahal",
            "Stonehenge",
            "Angkor Wat",
    };

    private final String[] landmarkAddresses = {
            "Agra, Uttar Pradesh, India ",
            "Cairo, Egypt",
            "Wiltshire county, UK",
            "Siem Reap, Cambodia"
    };

    private final String[] landmarkLatLongs = {
            "61.138677 -149.75042",
            "61.148304 -149.786868",
            "61.14538 -149.802503",
            "61.144079 -149.790486"
    };

    private final String[] landmarkEmail = {
            "mthurn@live.com",
            "jguyer@aol.com",
            "miyop@icloud.com",
            "crandall@sbcglobal.net"
    };


    private final int[] colors = {
            R.color.RED,
            R.color.BLUE,
            R.color.GREEN,
            R.color.YELLOW
    };


    public FakeDataSource() {
    }

    /**
     * Creates a list of ListItems.
     *
     * @return A list of semi-random ListItems for testing purposes
     */
    @Override
    public List<ListItem> getListOfData() {
        ArrayList<ListItem> listOfData = new ArrayList<>();
        Random random = new Random();
        //make 12 semi-random items
        for (int i = 0; i < sizeOfCollection; i++) {
            //these will be 0, 1, 2, or 3
            int randOne = random.nextInt(4);
            int randTwo = random.nextInt(4);
            int randThree = random.nextInt(4);
            int randFour = random.nextInt(4);

            //creates a semi-random ListItem of Person
            PersonListItem personItem = new PersonListItem(
                    personNames[randOne],
                    personAddresses[randTwo],
                    colors[randThree]
            );
            //Add it to our collection (list)
            listOfData.add(personItem);

            //creates a semi-random ListItem of Business
            BusinessListItem businessItem = new BusinessListItem(
                    businessNames[randOne],
                    businessAddresses[randTwo],
                    businessPhones[randThree],
                    colors[randFour]
            );
            //Add it to our collection (list)
            listOfData.add(businessItem);

            //creates a semi-random ListItem of Business
            LandmarkListItem landmarkItem = new LandmarkListItem(
                    landmarkNames[randOne],
                    landmarkAddresses[randTwo],
                    landmarkLatLongs[randThree],
                    landmarkEmail[randFour],
                    colors[randFour]
            );
            //Add it to our collection (list)
            listOfData.add(landmarkItem);

        }

        return listOfData;
    }
}
