package com.example.bloodbond;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

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
    public static String EmailToKey(String email) { return email.replaceAll("[^a-zA-Z0-9@]", ""); }

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
     * Tries to register a new account.
     * @param newRegister Account to be registered.
     */
    private void RegisterAccount(final Cadastro newRegister) {

        // Key to the account in Firebase.
        String key = "Cadastros/" + EmailToKey(newRegister.getEmail());

        // Gets a reference to the key.
        final DatabaseReference myRef = this.database.getReference(key);

        // Adds a listener to the key.
        databaseListener = myRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                // If the key does not exist registers the user.
                if(!dataSnapshot.exists()) {
                    Log.d("INSERINDO CADASTRO: ", "onDataChange: " + dataSnapshot + newRegister);
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
     * Updates an institution.
     * @param register Intitution to be updated.
     */
    public void UpdateInstitution(final Instituicao register) {

        Log.d("update", "Updating an account");

        // Key to the account in Firebase.
        String key = "Cadastros/" + EmailToKey(register.getEmail());

        // Gets a reference to the key.
        final DatabaseReference myRef = this.database.getReference("Cadastros").child(EmailToKey(register.getEmail())).child("qtSangue");

        // Adds a listener to the key.
        databaseListener = myRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                myRef.setValue(register.getQtSangue());
                Toast.makeText(mainActivity.getApplicationContext(), "Alterações salvas!", Toast.LENGTH_LONG).show();
                Log.d("Account_update", EmailToKey(register.getEmail()) + " updated!");

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
     * Updates a user.
     * @param register Intitution to be updated.
     */
    public void UpdateUser(final Pessoa register) {

        Log.d("update", "Updating an account");

        // Key to the account in Firebase.
        String key = "Cadastros/" + EmailToKey(register.getEmail());

        // Gets a reference to the key.
        final DatabaseReference myRef = this.database.getReference("Cadastros").child(EmailToKey(register.getEmail())).child("doacoesAgendadas");

        // Adds a listener to the key.
        databaseListener = myRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                myRef.setValue(register.getDoacoesAgendadas());
                Toast.makeText(mainActivity.getApplicationContext(), "Alterações salvas!", Toast.LENGTH_LONG).show();
                Log.d("Account_update", EmailToKey(register.getEmail()) + " updated!");


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
     * @param password Password to use.
     */
    public void LoginAsAccount(final String email, String password) {

        final String passMd5 = getMd5(password);

        if(passMd5 == null) {
            Toast.makeText(mainActivity.getApplicationContext(), "Erro de hashing!", Toast.LENGTH_LONG).show();
            return;
        }

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
                        Cadastro reg = dataSnapshot.getValue(Cadastro.class);

                        if(reg.getRegisterType() == 0)
                            reg = dataSnapshot.getValue(Pessoa.class);
                        else
                            reg = dataSnapshot.getValue(Instituicao.class);


                        // Verifies if the password is correct.
                        if (reg.getPassword().equals(passMd5)) {
                            Log.d("login_success", EmailToKey(email) + " logged in successfully! (" + reg.getRegisterType() + ")");
                            Toast.makeText(mainActivity.getApplicationContext(), "Logado com sucesso!", Toast.LENGTH_LONG).show();

                            myRef.removeEventListener(databaseListener);
                            mainActivity.GoToProfile(reg);

                        } else {
                            Log.d("wrong_password", EmailToKey(email) + " wrong password!");
                            Toast.makeText(mainActivity.getApplicationContext(), "Senha incorreta!", Toast.LENGTH_LONG).show();
                        }

                    } catch (Exception e) {

                        Log.e("login_exception", "Logging excepion!", e);
                        Toast.makeText(mainActivity.getApplicationContext(), "Erro no login!", Toast.LENGTH_LONG).show();

                    }

                } else { // If it does, gives out an error.
                    Log.d("doesnt_exists", "Account does not exist!");
                    Toast.makeText(mainActivity.getApplicationContext(), "Esse email não está cadastrado!", Toast.LENGTH_LONG).show();
                }

                // Removes the listener.
                myRef.removeEventListener(databaseListener);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("database_error", "Database error!");
                Toast.makeText(mainActivity.getApplicationContext(), "Erro na base de dados!", Toast.LENGTH_LONG).show();
            }
        });
    }

    /**
     * Provides an MD5 to be used for the account password.
     * @param input String to be hashed.
     * @return MD5 hash of the String.
     */
    public static String getMd5(String input)
    {
        try {

            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {

            return null;

        }
    }

    /**
     * Função que retorna
     * lista com todas as
     * instituições no banco
     * de dados
     * @return ArrayList com as instituições
     */
    public void getListaInstituicoes(final ArrayList lista, final BaseAdapter adapt){
        final DatabaseReference ref = this.database.getReference("Cadastros");
//        final ArrayList<Instituicao> lista = new ArrayList<Instituicao>();

        databaseListener = ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot cad : dataSnapshot.getChildren()){
                    Cadastro cadastro = cad.getValue(Cadastro.class);

                    if (cadastro.getRegisterType() == 1) lista.add(cad.getValue(Instituicao.class));
                }

                adapt.notifyDataSetChanged();
                ref.removeEventListener(databaseListener);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}