package com.example.bloodbond;

import android.util.Log;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import javax.security.auth.login.LoginException;

/**
 * Intermediates the interaction between the app and the database.
 */
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
     * Reference to the apps main activity.
     */
    private MainActivity mainActivity;

    /**
     * Current event listener being used for database.
     */
    private ValueEventListener databaseListener;

    /**
     * Constructor for the class.
     * @param mainActivity The main App activity.
     */
    private DatabaseManager(MainActivity mainActivity) {

        FirebaseApp.initializeApp(mainActivity.getApplicationContext());
        this.mainActivity = mainActivity;
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
     * @param mainActivity The main App activity.
     */
    static void Initialize(MainActivity mainActivity) {

        if(instance == null)
            DatabaseManager.instance = new DatabaseManager(mainActivity);
    }

    /**
     * Converts an email to a key for use with the database.
     * @param email Email to be converted.
     * @return Generated key.
     */
    private String EmailToKey(String email) { return email.replaceAll("[^a-zA-Z0-9@]", ""); }

    /**
     * Registers a new user to the database.
     * @param user Information for the new user to be registered.
     */
    public void RegisterUser (Pessoa user) { RegisterAccount(user); } // Wrapper function.

    /**
     * Registers a new institution to the database.
     * @param institution Information for the new institution to be registered.
     */
    public void RegisterInstitution (Instituicao institution) { RegisterAccount(institution); } // Wrapper function.

    /**
     * Tries to register a new user.
     * @param newRegister User to be registered.
     */
    private void RegisterAccount(final Cadastro newRegister) {

        // Key to the user in Firebase.
        String key = "Cadastros/" + EmailToKey(newRegister.getEmail());

        // Gets a reference to the key.
        final DatabaseReference myRef = this.database.getReference(key);

        // Adds a listener to the key.
        databaseListener = myRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                // If the key does not exist registers the user.
                if(!dataSnapshot.exists()) {

                    myRef.setValue(newRegister);
                    mainActivity.GoToProfile(newRegister);
                    Toast.makeText(mainActivity.getApplicationContext(), "Cadastro efetuado com sucesso!", Toast.LENGTH_LONG).show();
                    Log.d("User_add", EmailToKey(newRegister.getEmail()) + " to database!");

                } else { // If it does gives out an error.

                    Log.d("User_exists", "User already exists!");
                    Toast.makeText(mainActivity.getApplicationContext(), "Esse email já está cadastrado!", Toast.LENGTH_LONG).show();

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

    /**
     * Attempts to login as an account.
     * @param email Email to login.
     * @param password Password to use (PLEASE ENSURE THIS IS ALREADY HASHED).
     */
    public void LoginAsAccount(final String email, final String password) {

        // Key to the user in Firebase.
        String key = "Cadastros/" + EmailToKey(email);

        // Gets a reference to the key.
        final DatabaseReference myRef = this.database.getReference(key);

        // Adds a listener to the key.
        databaseListener = myRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                // If the key does not exist registers the user.
                if(dataSnapshot.exists()) {

                    try {

                        // Reads the received data to the correct format.
                        Cadastro reg;
                        try {

                            Pessoa pessoa = dataSnapshot.getValue(Pessoa.class);
                            reg = pessoa;

                        } catch (Exception e) {

                            Instituicao instituicao = dataSnapshot.getValue(Instituicao.class);
                            reg = instituicao;

                        }

                        // Verifies if the password is correct.
                        if (reg.getPassword().equals(password)) {
                            Log.d("login_success", EmailToKey(email) + " logged in successfully! (" + reg.getRegisterType() + ")");
                            Toast.makeText(mainActivity.getApplicationContext(), "Logado com sucesso!", Toast.LENGTH_LONG).show();

                            mainActivity.GoToProfile(reg);

                        } else {
                            Log.d("wrong_password", EmailToKey(email) + " wrong password!");
                            Toast.makeText(mainActivity.getApplicationContext(), "Senha incorreta!", Toast.LENGTH_LONG).show();
                        }

                    } catch (Exception e) {

                        Log.e("login_exception", "Logging excepion!", e);

                    }

                } else { // If it does gives out an error.
                    Toast.makeText(mainActivity.getApplicationContext(), "Esse email não está cadastrado!", Toast.LENGTH_LONG).show();
                    Log.d("doesnt_exists", "Account does not exist!");
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
}
