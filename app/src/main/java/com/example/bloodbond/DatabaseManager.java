package com.example.bloodbond;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;

public class DatabaseManager {

    private static DatabaseManager instance;

    private FirebaseDatabase database;

    private DatabaseManager(android.content.Context context) {

        FirebaseApp.initializeApp(context);
        this.database = FirebaseDatabase.getInstance();

    }

    // Returns the static instance of this script.
    public static DatabaseManager getInstance() {
        return instance;
    }

    // Initializes the database manager.
    static void Initialize(android.content.Context context) {

        if(instance == null)
            DatabaseManager.instance = new DatabaseManager(context);
    }

}
