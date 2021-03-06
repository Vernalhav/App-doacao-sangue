package com.example.bloodbond;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class historicoUsuario extends Fragment {
    ListView listView;
    private Pessoa pes;
    ArrayAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mainUsuario activity = (mainUsuario) getActivity();
        pes = activity.getUsuario();

        View view = inflater.inflate(R.layout.activity_historico_usuario, container, false);

        listView = (ListView)view.findViewById(R.id.listHist);

        ArrayList<Doacao> arr = pes.getDoacoesAgendadas();
        if (arr == null) return view;
        adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, arr);

        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return view;
    }

    public ArrayAdapter getAdapter(){
        return adapter;
    }

}
