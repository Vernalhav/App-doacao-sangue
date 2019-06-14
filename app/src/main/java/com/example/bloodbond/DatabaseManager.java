package com.example.bloodbond;

import android.util.Log;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DatabaseManager {

    /**
     * Instance to this script.
     */
    private static DatabaseManager instance;

    /**
     * Firebase database reference.
     */
    private FirebaseDatabase database;

    /**
     * Current event listener being used for database.
     */
    private ValueEventListener databaseListener;

    /**
     * Constructor for the class.
     * @param context The application context to be used.
     */
    private DatabaseManager(android.content.Context context) {

        FirebaseApp.initializeApp(context);
        this.database = FirebaseDatabase.getInstance();

    }

    /**
     * Returns the instance of this script.
     * @return
     */
    public static DatabaseManager getInstance() {
        return instance;
    }

    /**
     * Initializes the database manager.
     * @param context The application context to be used.
     */
    static void Initialize(android.content.Context context) {

        if(instance == null)
            DatabaseManager.instance = new DatabaseManager(context);
    }

    /**
     * Converts an email to a key for use with the database.
     * @param email Email to be converted.
     * @return Generated key.
     */
    private String EmailToKey(String email) { return email.replaceAll("[^a-zA-Z0-9@]", ""); }

    /**
     * Tries to register a new user.
     * @param newUser User to be registered.
     */
    public void RegisterUser(final Pessoa newUser) {

        // Key to the user in Firebase.
        String key = "Cadastros/" + EmailToKey(newUser.getEmail());

        // Gets a reference to the key.
        final DatabaseReference myRef = this.database.getReference(key);

        // Adds a listener to the key.
        databaseListener = myRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                // If the key does not exist registers the user.
                if(!dataSnapshot.exists()) {
                    myRef.setValue(newUser);
                    Log.d("User_add", EmailToKey(newUser.getEmail()) + "to database!");
                } else { // If it does gives out an error.
                    Log.d("User_exists", "User already exists!");
                    // crash: Toast.makeText(MainActivity.getInstance(), "Esse email já está cadastrado!", Toast.LENGTH_LONG).show();
                }

                // Removes the listener.
                myRef.removeEventListener(databaseListener);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
    }
/*
    public boolean CreateInstituition(Intituicao newInstitution) {

        return  true;
    }
*/
}
