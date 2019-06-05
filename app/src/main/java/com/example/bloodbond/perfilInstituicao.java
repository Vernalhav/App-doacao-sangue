package com.example.bloodbond;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class perfilInstituicao extends AppCompatActivity {
    TextView nome, endereco, necessidades, arrecadamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_instituicao);
        nome = (TextView)findViewById(R.id.nome);
        endereco = (TextView)findViewById(R.id.endereco);
        necessidades = (TextView)findViewById(R.id.necessidades);
        arrecadamento = (TextView)findViewById(R.id.arrecadamento);
    }
    //TODO setar os textview com os dados das instiuicoes
}
