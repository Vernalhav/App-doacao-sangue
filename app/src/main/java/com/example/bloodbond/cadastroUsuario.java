package com.example.bloodbond;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class cadastroUsuario extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_cadastro_usuario, container, false);

        TextView tv = view.findViewById(R.id.editText);
        //tv.setText("CADASTRO USUARIO");

        return view;
    }
}
