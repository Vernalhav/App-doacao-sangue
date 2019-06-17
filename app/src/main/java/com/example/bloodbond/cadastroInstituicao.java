package com.example.bloodbond;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class cadastroInstituicao extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_cadastro_instituicao, container, false);

        TextView tv = view.findViewById(R.id.editText);
        //tv.setText("CADASTRO INSTUICAO");

        Button btnCadastroUsuario = (Button)view.findViewById(R.id.button2);
        btnCadastroUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // TODO: Criar uma instancia da classe pessoa com os dados do novo usuario.
                Instituicao instituicao = new Instituicao("inst@inst.com", "admin", "Instituição A", "Lugar nenhum", 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8);

                // TODO: Descomentar função.
                DatabaseManager.getInstance().Register(instituicao);

            }
        });

        return view;
    }
}
