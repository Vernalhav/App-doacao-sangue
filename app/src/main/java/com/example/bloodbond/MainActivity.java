package com.example.bloodbond;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Intent cadastrar, perfil;
    EditText emailTV, passwordTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Initializes the database.
        DatabaseManager.Initialize(this);

        Button cadastro = (Button) findViewById(R.id.botaoCadastro);

        emailTV = (EditText) findViewById(R.id.inputEmail);
        passwordTv = (EditText) findViewById(R.id.inputPassword);

        cadastro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Register();
            }
        });

        Button entrar = (Button) findViewById(R.id.button);

        entrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Login();
            }
        });

    }

    /**
     * Goes to the login screen.
     */
    private void Register() {

        cadastrar = new Intent(this, telaCadastro.class);
        startActivity(cadastrar);

    }

    /**
     * Attempts to login to the account who's email and password have been passed on the EditTexts.
     */
    private void Login() { DatabaseManager.getInstance().LoginAsAccount(emailTV.getText().toString(), passwordTv.getText().toString()); }

    /**
     * Go to a profile screen, that has been logged onto.
     * @param profile The profile that was logged onto.
     */
    public void GoToProfile(Cadastro profile) {

        // Adds the logged account data to the intent.
        if(profile.getRegisterType() == 0)
            perfil = new Intent(this, mainUsuario.class);
        else
            perfil = new Intent(this, mainInstituicao.class);

        perfil.putExtra("login", profile);

        // Goes to the login window.
        startActivity(perfil);
    }
}