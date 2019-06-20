package com.example.bloodbond;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class perfilInstituicao  extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_perfil_instituicao, container, false);

        TextView nome, endereco, necessidades, arrecadamento;

        nome = (TextView) view.findViewById(R.id.nome);
        endereco = (TextView) view.findViewById(R.id.endereco);
        necessidades = (TextView) view.findViewById(R.id.necessidades);
        arrecadamento = (TextView) view.findViewById(R.id.arrecadamento);

        return view;
    }
    //TODO setar os textview com os dados das instiuicoes
}
