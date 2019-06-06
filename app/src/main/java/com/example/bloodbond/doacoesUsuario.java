package com.example.bloodbond;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class doacoesUsuario  extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_doacoes_usuario, container, false);

        TextView nome = (TextView) view.findViewById(R.id.nome);
        TextView peso = (TextView) view.findViewById(R.id.peso);
        TextView altura = (TextView) view.findViewById(R.id.altura);
        TextView  tipo = (TextView) view.findViewById(R.id.tipo);
        TextView qtd = (TextView) view.findViewById(R.id. qtd);
        Button doar = (Button) view.findViewById(R.id.doar);

        return view;
    }
}
