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

    private Instituicao inst;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mainInstituicao activity = (mainInstituicao)getActivity();
        inst = activity.getInstituicao();

        View view = inflater.inflate(R.layout.activity_perfil_instituicao, container, false);

        TextView nome, endereco, necessidades, arrecadamento;

        nome = (TextView) view.findViewById(R.id.nome);
        endereco = (TextView) view.findViewById(R.id.endereco);

        nome.setText(inst.getName());
        endereco.setText(inst.getEndereco());

        return view;
    }
    //TODO setar os textview com os dados das instiuicoes
 }
