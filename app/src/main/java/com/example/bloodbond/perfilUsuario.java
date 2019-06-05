package com.example.bloodbond;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class perfilUsuario extends AppCompatActivity {

    Button doar, historico;
    TextView nome, peso, altura, tipo, qtd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);
        nome = (TextView) findViewById(R.id.nome);
        peso = (TextView) findViewById(R.id.peso);
        altura = (TextView) findViewById(R.id.altura);
        tipo = (TextView) findViewById(R.id.tipo);
        qtd = (TextView) findViewById(R.id.qtd);
        doar = (Button) findViewById(R.id.doar);
        historico = (Button) findViewById(R.id.historico);
    }
    //TODO setar os textview com os dados dos usuarios
}
