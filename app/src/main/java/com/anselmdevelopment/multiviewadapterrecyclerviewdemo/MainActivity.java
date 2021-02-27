package com.anselmdevelopment.multiviewadapterrecyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Create a recyclerview object
    private RecyclerView contactsRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactsRecView = findViewById(R.id.contactsRecView);

        // Create a new ArrayList called "contacts"
        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Jake", "jake@protonmail.com", "https://github.com/android/sunflower/blob/main/screenshots/phone_plant_detail.png"));
        contacts.add(new Contact("Henry", "henry@gmail.com", "https://github.com/android/sunflower/blob/main/screenshots/phone_plant_detail.png"));
        contacts.add(new Contact("George", "george@criptext.com", "https://github.com/android/sunflower/blob/main/screenshots/phone_plant_detail.png"));
        contacts.add(new Contact("James", "james@gmail.com", "https://github.com/android/sunflower/blob/main/screenshots/phone_plant_detail.png"));
        contacts.add(new Contact("Zach", "zach@yahoo.com", "https://github.com/android/sunflower/blob/main/screenshots/phone_plant_detail.png"));

        // Create a new adapter
        ContactsRecViewAdapter adapter = new ContactsRecViewAdapter(this);
        // Put the arraylist into the adapter
        adapter.setContacts(contacts);

        contactsRecView.setAdapter(adapter);
        contactsRecView.setLayoutManager(new LinearLayoutManager(this));

        // If you want a horizontal layout
//        contactsRecView.setLayoutManager(new LinearLayoutManager(this,
//                LinearLayoutManager.HORIZONTAL, false));

        // If you want a grid layout
//        contactsRecView.setLayoutManager(new GridLayoutManager(this, 2));
    }
}