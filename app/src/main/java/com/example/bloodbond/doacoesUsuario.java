package com.example.bloodbond;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class doacoesUsuario  extends Fragment {
    private ArrayAdapter adapter;

    @Override
    @SuppressWarnings("unchecked")
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_doacoes_usuario, container, false);

        TextView nome = (TextView) view.findViewById(R.id.nome);
        TextView peso = (TextView) view.findViewById(R.id.peso);
        TextView altura = (TextView) view.findViewById(R.id.altura);
        TextView  tipo = (TextView) view.findViewById(R.id.tipo);
        TextView qtd = (TextView) view.findViewById(R.id. qtd);
        Button doar = (Button) view.findViewById(R.id.doar);

        ListView listView;

        listView = (ListView) view.findViewById(R.id.listDoacoes);

        ArrayList<Instituicao> arr = new ArrayList<>();
        adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, arr);
        listView.setAdapter(adapter);

        DatabaseManager.getInstance().getListaInstituicoes(arr, adapter);

        return view;
    }


}