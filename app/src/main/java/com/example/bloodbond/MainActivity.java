package com.example.bloodbond;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Intent intent, perfil;
    EditText emailTV, passwordTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseManager.Initialize(this);

        Button cadastro = (Button) findViewById(R.id.botaoCadastro);

        emailTV = (EditText) findViewById(R.id.inputEmail);
        passwordTv = (EditText) findViewById(R.id.inputPassword);

        cadastro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                cadastro();
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


    void cadastro() {
        intent = new Intent(this, telaCadastro.class);
        startActivity(intent);
    }

    /**
     * Attempts to login to the account who's email and password have been passed on the EditTexts.
     */
    private void Login() { DatabaseManager.getInstance().LoginAsAccount(emailTV.getText().toString(), passwordTv.getText().toString()); }

    //TODO diferenciar instituicao e usuario na hora de entrar (Na função GoToProfile é só pegar profile.registerType, se for 0
    // é um Usuário, se for 1 é uma Instituição ~Cabral)
    /**
     * Go to a profile screen, that has been logged onto.
     * @param profile The profile that was logged onto.
     */
    public void GoToProfile(Cadastro profile) {

        perfil = new Intent(this, mainUsuario.class);
        startActivity(perfil);

    }


}
