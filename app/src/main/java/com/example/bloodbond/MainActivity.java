package com.example.bloodbond;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Intent intent,perfil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button cadastro = (Button) findViewById(R.id.botaoCadastro);

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
                entrar();
            }
        });

    }

    void cadastro(){
        intent = new Intent(this, telaCadastro.class);
        startActivity(intent);
    }
    void entrar(){

        perfil = new Intent(this, mainUsuario.class);
        startActivity(perfil);
    }
    //TODO diferenciar instituicao e usuario na hora de entrar
}
