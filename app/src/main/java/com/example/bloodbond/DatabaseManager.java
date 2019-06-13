package com.example.bloodbond;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
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

    public boolean CreateUser(Pessoa newUser) {

        String path = "Cadastros/" + newUser.getEmail().replaceAll("[^a-zA-Z0-9@]", "").trim();

        DatabaseReference myRef = this.database.getReference(path);
        myRef.setValue(newUser);

        return true;
    }
/*
    public boolean CreateInstituition(Intituicao newInstitution) {

        return  true;
    }
*/
}
